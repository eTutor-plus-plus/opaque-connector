package SOAPWebServiceConfig.java.io.spring.guides.soap_qe;

import javax.xml.bind.annotation.*;


/**
 * <p>Java-Klasse für anonymous complex type.
 *
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType&gt;
 *  *   &lt;complexContent&gt;
 *  *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *  *       &lt;sequence&gt;
 *  *         &lt;element name="questionID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="questionVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="questionBaseURL" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *  *       &lt;/sequence&gt;
 *  *     &lt;/restriction&gt;
 *  *   &lt;/complexContent&gt;
 *  * &lt;/complexType&gt;
 * </pre>
 *
 *
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
        return questionID;
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
