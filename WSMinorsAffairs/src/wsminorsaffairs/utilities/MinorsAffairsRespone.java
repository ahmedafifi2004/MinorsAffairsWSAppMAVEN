package wsminorsaffairs.utilities;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import wsminorsaffairs.utilities.WSResponse;

public class MinorsAffairsRespone  extends WSResponse{
    
    private BigDecimal totalAmount;
    private String issuemonth;

    public void setIssuemonth(String issuemonth) {
        this.issuemonth = issuemonth;
    }

    public String getIssuemonth() {
        return issuemonth;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public Long getQid() {
        return qid;
    }

    private Long qid;

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    private List<MinorsAffairsDetails> details;

    public void setDetails(List<MinorsAffairsDetails> details) {
        this.details = details;
    }

    public List<MinorsAffairsDetails> getDetails() {
        return details;
    }

    public MinorsAffairsRespone() {
        super();
    }
}
