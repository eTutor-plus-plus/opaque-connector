/**
 * StartReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package SOAPWebServiceConfig.java.io.spring.guides.soap_qe;

public class Results implements java.io.Serializable {
    private String actionSummary;

    private String answerLine;

    private int attempts;

    private String questionLine;

    private CustomResult[] customResults;

    private Score[] scores;


    public Results(String actionSummary, String answerLine, int attempts, String questionLine, CustomResult[] customResults, Score[] scores) {
        this.actionSummary = actionSummary;
        this.answerLine = answerLine;
        this.attempts = attempts;
        this.questionLine = questionLine;
        this.customResults = customResults;
        this.scores = scores;
    }

    public String getActionSummary() {
        return actionSummary;
    }

    public void setActionSummary(String actionSummary) {
        this.actionSummary = actionSummary;
    }

    public String getAnswerLine() {
        return answerLine;
    }

    public void setAnswerLine(String answerLine) {
        this.answerLine = answerLine;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getQuestionLine() {
        return questionLine;
    }

    public void setQuestionLine(String questionLine) {
        this.questionLine = questionLine;
    }

    public CustomResult[] getCustomResults() {
        return customResults;
    }

    public void setCustomResults(CustomResult[] customResults) {
        this.customResults = customResults;
    }

    public Score[] getScores() {
        return scores;
    }

    public void setScores(Score[] scores) {
        this.scores = scores;
    }
}
