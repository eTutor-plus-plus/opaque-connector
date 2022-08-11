package connector.dto.opaque;

import javax.xml.bind.annotation.*;

/**
 *   class for questionMetaData request from opaque
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "getQuestionMetadata", namespace = "http://om.open.ac.uk/")

public class GetQuestionMetadataRequest {

    @XmlElement(required = true)
    protected String questionID;
    protected String questionVersion;
    protected String questionBaseURL;

    public String getQuestionID() {

        String etutorQuestionId = questionID.replace("_", "-");
        etutorQuestionId = etutorQuestionId.replace("moodle","");
        return etutorQuestionId;

    }

    public String getQuestionVersion() {
        return questionVersion;
    }

    public String getQuestionBaseURL() {
        return questionBaseURL;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public void setQuestionVersion(String questionVersion) {
        this.questionVersion = questionVersion;
    }

    public void setQuestionBaseURL(String questionBaseURL) {
        this.questionBaseURL = questionBaseURL;
    }
}
