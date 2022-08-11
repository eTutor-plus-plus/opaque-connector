
package connector.dto.opaque;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 *  class for result object
 */

@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class Results implements Serializable {
    private String actionSummary;

    private String answerLine;

    private int attempts;

    private String questionLine;

    private CustomResult[] customResults;

    @XmlElementWrapper(name = "scores")
    @XmlElement(name = "score")
    public Score[] scores;

    public Results(){
        actionSummary = "";
        answerLine = "";
        attempts = 0;
        questionLine = "";
        customResults = null;
        scores = new Score[1];;

    }

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
