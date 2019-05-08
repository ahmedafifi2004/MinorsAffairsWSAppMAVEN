package wsminorsaffairs.utilities;

import javax.persistence.Column;

import javax.xml.bind.annotation.XmlElement;

public class WSResponse {
    public WSResponse() {
        super();
    }
    @XmlElement(name="processExecutionTimestamp")
    private String processexecutiontimestamp;
    @XmlElement(name="processStatus")
    private String processstatus;
    @XmlElement(name="responseCode")
    private String responsecode;
    @XmlElement(name="responseMsgArb")
    private String responsemsgarb;
    @XmlElement(name="responseMsgEng")
    private String responsemsgeng;

    public void setProcessexecutiontimestamp(String processexecutiontimestamp) {
        this.processexecutiontimestamp = processexecutiontimestamp;
    }

    public String getProcessexecutiontimestamp() {
        return processexecutiontimestamp;
    }

    public void setProcessstatus(String processstatus) {
        this.processstatus = processstatus;
    }

    public String getProcessstatus() {
        return processstatus;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsemsgarb(String responsemsgarb) {
        this.responsemsgarb = responsemsgarb;
    }

    public String getResponsemsgarb() {
        return responsemsgarb;
    }

    public void setResponsemsgeng(String responsemsgeng) {
        this.responsemsgeng = responsemsgeng;
    }

    public String getResponsemsgeng() {
        return responsemsgeng;
    }


}
