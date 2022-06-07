package SOAPWebServiceConfig.java.Service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SubmissionResponse {

    //TODO Submission Response from Etutor

    String submissionId;

    @JsonIgnore
    Object links;

    public SubmissionResponse() {
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }
}
