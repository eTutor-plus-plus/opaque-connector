package connector.dto.etutorpp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO class for received results from etutor system
 */

@JsonIgnoreProperties(ignoreUnknown = true)

public class EtutorResult {


    String submissionId;
    double points;
    double maxPoints;
    String result;

    public EtutorResult() {
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(double maxPoints) {
        this.maxPoints = maxPoints;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
