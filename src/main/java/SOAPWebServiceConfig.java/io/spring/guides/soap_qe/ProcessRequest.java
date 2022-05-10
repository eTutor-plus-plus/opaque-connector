package SOAPWebServiceConfig.java.io.spring.guides.soap_qe;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "process", namespace = "http://om.open.ac.uk/")
public class ProcessRequest {

    @XmlElement(required = true)
    protected String questionSession;
    protected String[] names;
    protected String[] values;

    public String getQuestionSession() {
        return questionSession;
    }

    public void setQuestionSession(String questionSession) {
        this.questionSession = questionSession;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
