package wsminorsaffairs.utilities;

import java.math.BigDecimal;

import java.util.Date;

public class MinorsAffairsDetails {
    public MinorsAffairsDetails() {
        super();
    }
    
    private BigDecimal amount;
    
    private String bnkname;
    
    private String coverperiodfrom;
    
    private String coverperiodto;
    
    private String exprdate;
    
    private String fullname;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setBnkname(String bnkname) {
        this.bnkname = bnkname;
    }

    public String getBnkname() {
        return bnkname;
    }

    public void setCoverperiodfrom(String coverperiodfrom) {
        this.coverperiodfrom = coverperiodfrom;
    }

    public String getCoverperiodfrom() {
        return coverperiodfrom;
    }

    public void setCoverperiodto(String coverperiodto) {
        this.coverperiodto = coverperiodto;
    }

    public String getCoverperiodto() {
        return coverperiodto;
    }

    public void setExprdate(String exprdate) {
        this.exprdate = exprdate;
    }

    public String getExprdate() {
        return exprdate;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIssuemonth(String issuemonth) {
        this.issuemonth = issuemonth;
    }

    public String getIssuemonth() {
        return issuemonth;
    }

    public void setPrdcode(String prdcode) {
        this.prdcode = prdcode;
    }

    public String getPrdcode() {
        return prdcode;
    }

    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    public String getPrdname() {
        return prdname;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public Long getQid() {
        return qid;
    }

    public void setSalexec(String salexec) {
        this.salexec = salexec;
    }

    public String getSalexec() {
        return salexec;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setSuspdate(Date suspdate) {
        this.suspdate = suspdate;
    }

    public Date getSuspdate() {
        return suspdate;
    }

    public void setSuspreason(String suspreason) {
        this.suspreason = suspreason;
    }

    public String getSuspreason() {
        return suspreason;
    }

    private String iban;
    
    private String issuemonth;
    
    private String prdcode;
    
    private String prdname;
    
    private Long qid;
    
    private String salexec;
    
    private String status;
    
    private Date suspdate;
    
    private String suspreason;
}
