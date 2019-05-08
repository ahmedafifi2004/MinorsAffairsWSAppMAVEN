package wsminorsaffairs;

import com.oracle.webservices.api.SchemaValidation;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import weblogic.wsee.jws.jaxws.owsm.SecurityPolicy;


import wsminorsaffairs.utilities.DataValidator;
import wsminorsaffairs.utilities.WSResponse;

import wsminorsaffairs.entities.VwGafmaDetail;
import wsminorsaffairs.entities.WvResponseCodeLookup;

import wsminorsaffairs.utilities.MinorsAffairsDetails;
import wsminorsaffairs.utilities.MinorsAffairsRequest;
import wsminorsaffairs.utilities.MinorsAffairsRespone;

@Stateless(name = "MinorsAffairsSessionEJB", mappedName = "MinorsAffairsWSApp-WSContractInfo-MinorsAffairsSessionEJB")
@TransactionManagement(TransactionManagementType.BEAN)
@SchemaValidation(enabled = true)
@WebService(name = "MinorsAffairsWebService", serviceName ="MinorsAffairsWebService", portName = "MinorsAffairsWebServicePort")
@SecurityPolicy(uri = "oracle/wss_username_token_service_policy")
@HandlerChain(file="handler-chain.xml")

public class MinorsAffairsService implements MinorsAffairsSessionEJBLocal {
    @Resource
    SessionContext sessionContext;

    @EJB
    MADBManagerEJBLocal maDBManagerBean;
    
    private static final Logger LOGGER = Logger.getLogger(MinorsAffairsService.class.getName());
    public MinorsAffairsService() {
    }

    @WebMethod
    public MinorsAffairsRespone getMainorsAffairsDetails(@WebParam(name = "mARequestInfo") MinorsAffairsRequest request){


        LOGGER.info("getMainorsAffairsDetails Method QID:" + request.getQid() + "  Issue month:"+request.getIssuemonth());
    MinorsAffairsRespone response=new MinorsAffairsRespone();
    
    
        if (!DataValidator.validateRequiredQueryData(request)) {
            generateResponse(response, "ADLSA003");
            return response;
        }
        /*   try{ */
        List<VwGafmaDetail> byQIDandMonth = maDBManagerBean.getVwGafmaDetailFindByQIDandMonth(request.getQid(), request.getIssuemonth());
        
   
        if(byQIDandMonth.size()>0){
        
        
        
        response.setTotalAmount(new BigDecimal("0"));
        List<MinorsAffairsDetails> details=new ArrayList<MinorsAffairsDetails>();
        
        MinorsAffairsDetails detail;
        
        SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");
        
        generateResponse(response, "ADLSA000");
        
        for(VwGafmaDetail re : byQIDandMonth){
            
            
            detail  =new MinorsAffairsDetails();
           
            detail.setAmount(re.getAmount());
            detail.setBnkname(re.getBnkname());
            
            detail.setAmount(re.getAmount());
            detail.setBnkname(re.getBnkname());
            if(re.getCoverperiodfrom() != null)
            detail.setCoverperiodfrom(sdfDate.format(re.getCoverperiodfrom()));
            if(re.getCoverperiodto() != null)
            detail.setCoverperiodto(sdfDate.format(re.getCoverperiodto()));
            if(re.getExprdate() != null)
            detail.setExprdate(sdfDate.format(re.getExprdate()));
            detail.setFullname(re.getFullname());
            detail.setIban(re.getIban());
            detail.setIssuemonth(re.getIssuemonth());
            detail.setPrdcode(re.getPrdcode());
            detail.setPrdname(re.getPrdname());
            detail.setStatus(re.getStatus());
            detail.setSuspreason(re.getSuspreason());
            detail.setSuspdate(re.getSuspdate());    
            detail.setQid(re.getQid());
            if(re.getAmount() != null)
            response.setTotalAmount(response.getTotalAmount().add(re.getAmount()));
            details.add(detail);
            
        }
        
       // response.setTotalAmount(total);
        response.setQid(request.getQid());
        response.setIssuemonth(request.getIssuemonth());
        response.setDetails(details);
      
        
        }else{
            generateResponse(response, "ADLSA001"); 
            
        }
        
        /*  }
        catch (Exception e){
            LOGGER.error("WebService Error: " + e.getMessage());
            generateResponse(response, "ADLSA002"); 
        } */
        return response;
    }
    
    
    @WebMethod(exclude = true)
    public void generateResponse(WSResponse response, String responseCode) {

        WvResponseCodeLookup messageDetail = maDBManagerBean.getWvResponseCodeLookupFindByCode(responseCode);

        response.setResponsecode(messageDetail.getResponsecode());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        response.setProcessexecutiontimestamp(dateFormat.format(date));
        response.setResponsemsgarb(messageDetail.getResponsemessagearb());
        response.setResponsemsgeng(messageDetail.getResponsemessageeng());
        if (responseCode.equalsIgnoreCase("ADLSA000"))
            response.setProcessstatus("0");
        else
            response.setProcessstatus("1");
    }

}
