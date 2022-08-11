package connector.dto.etutorpp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO class for received submissionresponse from etutor system
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmissionResponse {


    String submissionId;


    public SubmissionResponse() {
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

}
