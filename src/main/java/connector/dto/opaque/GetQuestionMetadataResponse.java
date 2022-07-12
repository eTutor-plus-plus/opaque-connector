package connector.dto.opaque;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "getQuestionMetadataResponse", namespace = "http://om.open.ac.uk/")
public class GetQuestionMetadataResponse {


    @XmlElement(required = true)
    protected String metadata;


    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(QuestionMetaData metadata) {
        this.metadata = metadata.getQuestionMetadata();
    }



}
