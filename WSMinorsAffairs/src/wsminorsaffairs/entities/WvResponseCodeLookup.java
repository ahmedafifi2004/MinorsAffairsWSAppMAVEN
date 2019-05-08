package wsminorsaffairs.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "WvResponseCodeLookup.findAll", query = "select o from WvResponseCodeLookup o"),
                @NamedQuery(name = "WvResponseCodeLookup.findByCode", query = "select o from WvResponseCodeLookup o where o.responsecode = :code")})
@Table(name = "WV_RESPONSE_CODE_LOOKUP")
public class WvResponseCodeLookup implements Serializable {
    private static final long serialVersionUID = -1933647746887942403L;
    @Id
    @Column(nullable = false, length = 8)
    private String responsecode;
    @Column(length = 100)
    private String responsemessagearb;
    @Column(length = 100)
    private String responsemessageeng;

    public WvResponseCodeLookup() {
    }

    public WvResponseCodeLookup(String responsecode, String responsemessagearb, String responsemessageeng) {
        this.responsecode = responsecode;
        this.responsemessagearb = responsemessagearb;
        this.responsemessageeng = responsemessageeng;
    }

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public String getResponsemessagearb() {
        return responsemessagearb;
    }

    public void setResponsemessagearb(String responsemessagearb) {
        this.responsemessagearb = responsemessagearb;
    }

    public String getResponsemessageeng() {
        return responsemessageeng;
    }

    public void setResponsemessageeng(String responsemessageeng) {
        this.responsemessageeng = responsemessageeng;
    }
}
