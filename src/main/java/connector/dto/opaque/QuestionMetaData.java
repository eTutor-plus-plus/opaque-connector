package connector.dto.opaque;

/**
 * DTO class for created QuestionMetadata contained in QuestionMetaDataResponse sent to opaque
 */
public class QuestionMetaData {

    String questionMetadata;

    public String getQuestionMetadata() {
        return questionMetadata;
    }

    public void setQuestionMetadata(String value) {
        this.questionMetadata = value;
    }


}
