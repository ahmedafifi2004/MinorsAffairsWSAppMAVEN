package wsminorsaffairs.utilities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.AccessType;



public class MyKey implements Serializable {
   
    
    
    private String issuemonth;
    private String prdcode;
    
    private Long qid;
    private Date coverperiodfrom;
    private Date coverperiodto;

    public void setCoverperiodfrom(Date coverperiodfrom) {
        this.coverperiodfrom = coverperiodfrom;
    }

    public Date getCoverperiodfrom() {
        return coverperiodfrom;
    }

    public void setCoverperiodto(Date coverperiodto) {
        this.coverperiodto = coverperiodto;
    }

    public Date getCoverperiodto() {
        return coverperiodto;
    }


    public String getIssuemonth() {
        return issuemonth;
    }

    public void setIssuemonth(String issuemonth) {
        this.issuemonth = issuemonth;
    }

    public String getPrdcode() {
        return prdcode;
    }

    public void setPrdcode(String prdcode) {
        this.prdcode = prdcode;
    }
    
    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }
}