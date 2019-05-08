package wsminorsaffairs.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import wsminorsaffairs.utilities.MyKey;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

@Entity
//@IdClass(MyKey.class)
@NamedQueries({ @NamedQuery(name = "VwGafmaDetail.findAll", query = "select o from VwGafmaDetail o"),
                 @NamedQuery(name = "VwGafmaDetail.findByQIDandMonth", query = "select o from VwGafmaDetail o where o.qid = :qid and o.issuemonth = :issuemonth")})
@Table(name = "VW_GAFMA_DETAIL")
public class VwGafmaDetail implements Serializable {
    private static final long serialVersionUID = -5227769679202315741L;
    private BigDecimal amount;
    @Column(length = 35)
    private String bnkname;
    @Temporal(TemporalType.DATE)
  //  @Id
    private Date coverperiodfrom;
    @Temporal(TemporalType.DATE)
   // @Id
    private Date coverperiodto;
    @Temporal(TemporalType.DATE)
    private Date exprdate;
    @Column(length = 131)
    private String fullname;
    @Column(length = 34)
    private String iban;
  //  @Id
    @Column(length = 7)
    private String issuemonth;
   // @Id
    @Column(length = 10)
    private String prdcode;
    @Column(length = 500)
    private String prdname;
  //  @Id
    private Long qid;
    @Column(length = 256)
    private String salexec;
    @Column(length = 19)
    private String status;
    @Temporal(TemporalType.DATE)
    private Date suspdate;
    @Column(length = 0)
    private String suspreason;
    @Id
    private BigDecimal id;

    public VwGafmaDetail() {
    }

    public VwGafmaDetail(BigDecimal amount, String bnkname, Date coverperiodfrom, Date coverperiodto, Date exprdate,
                         String fullname, String iban, String issuemonth, String prdcode, String prdname,
                         Long qid, String salexec, String status, Date suspdate, String suspreason) {
        this.amount = amount;
        this.bnkname = bnkname;
        this.coverperiodfrom = coverperiodfrom;
        this.coverperiodto = coverperiodto;
        this.exprdate = exprdate;
        this.fullname = fullname;
        this.iban = iban;
        this.issuemonth = issuemonth;
        this.prdcode = prdcode;
        this.prdname = prdname;
        this.qid = qid;
        this.salexec = salexec;
        this.status = status;
        this.suspdate = suspdate;
        this.suspreason = suspreason;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBnkname() {
        return bnkname;
    }

    public void setBnkname(String bnkname) {
        this.bnkname = bnkname;
    }

    public Date getCoverperiodfrom() {
        return coverperiodfrom;
    }

    public void setCoverperiodfrom(Date coverperiodfrom) {
        this.coverperiodfrom = coverperiodfrom;
    }

    public Date getCoverperiodto() {
        return coverperiodto;
    }

    public void setCoverperiodto(Date coverperiodto) {
        this.coverperiodto = coverperiodto;
    }

    public Date getExprdate() {
        return exprdate;
    }

    public void setExprdate(Date exprdate) {
        this.exprdate = exprdate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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

    public String getPrdname() {
        return prdname;
    }

    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public String getSalexec() {
        return salexec;
    }

    public void setSalexec(String salexec) {
        this.salexec = salexec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSuspdate() {
        return suspdate;
    }

    public void setSuspdate(Date suspdate) {
        this.suspdate = suspdate;
    }

    public String getSuspreason() {
        return suspreason;
    }

    public void setSuspreason(String suspreason) {
        this.suspreason = suspreason;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }
}
