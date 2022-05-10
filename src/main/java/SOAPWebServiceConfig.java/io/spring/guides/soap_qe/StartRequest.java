package SOAPWebServiceConfig.java.io.spring.guides.soap_qe;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "start", namespace = "http://om.open.ac.uk/")
public class StartRequest {

    @XmlElement(required = true)
    protected String questionID;
    protected String questionVersion;
    protected String questionBaseURL;
    protected String[] initialParamNames;
    protected String[] initialParamValues;
    protected String[] cachedResources;


    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getQuestionVersion() {
        return questionVersion;
    }

    public void setQuestionVersion(String questionVersion) {
        this.questionVersion = questionVersion;
    }

    public String getQuestionBaseURL() {
        return questionBaseURL;
    }

    public void setQuestionBaseURL(String questionBaseURL) {
        this.questionBaseURL = questionBaseURL;
    }

    public String[] getInitialParamNames() {
        return initialParamNames;
    }

    public void setInitialParamNames(String[] initialParamNames) {
        this.initialParamNames = initialParamNames;
    }

    public String[] getInitialParamValues() {
        return initialParamValues;
    }

    public void setInitialParamValues(String[] initialParamValues) {
        this.initialParamValues = initialParamValues;
    }

    public String[] getCachedResources() {
        return cachedResources;
    }

    public void setCachedResources(String[] cachedResources) {
        this.cachedResources = cachedResources;
    }
}
