package wsminorsaffairs.utilities;

public class MinorsAffairsRequest {

    private String issuemonth;
    private Long qid;

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

    public MinorsAffairsRequest() {
        super();
    }
}
