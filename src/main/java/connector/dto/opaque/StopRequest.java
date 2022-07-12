package connector.dto.opaque;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "stop", namespace = "http://om.open.ac.uk/")
public class StopRequest {

    @XmlElement(required = true)
    protected String questionSession;

    public String getQuestionSession() {
        return questionSession;
    }

    public void setQuestionSession(String questionSession) {
        this.questionSession = questionSession;
    }


}
