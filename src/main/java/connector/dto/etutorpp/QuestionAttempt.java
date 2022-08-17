package connector.dto.etutorpp;

/**
 * DTO class for question attempts send to etutor system
 */
public class QuestionAttempt {

    String answer;


    String taskGroupDescription;
    String instruction;
    int taskIdForDispatcher;
    String taskAssignmentTypeId;
    int maxPoints;
    String questionBaseUrl;

    /**
     * Constructor
     */
    public QuestionAttempt() {
    }

    /**
     * Constructor
     * @param answer students answertext
     * @param instruction of the question
     * @param taskIdForDispatcher Id from the origin question in etutor system
     * @param taskAssignmentTypeId from the  question in etutor system
     * @param maxPoints reachable points
     * @param questionBaseUrl location of questionbase
     */


    public QuestionAttempt(String answer, String instruction, int taskIdForDispatcher, String taskAssignmentTypeId, int maxPoints, String questionBaseUrl, String taskGroupDescription) {
        this.answer = answer;
        this.instruction = instruction;
        this.taskIdForDispatcher = taskIdForDispatcher;
        this.taskAssignmentTypeId = taskAssignmentTypeId;
        this.maxPoints = maxPoints;
        this.questionBaseUrl = questionBaseUrl;
        this.taskGroupDescription = taskGroupDescription;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getTaskIdForDispatcher() {
        return taskIdForDispatcher;
    }

    public void setTaskIdForDispatcher(int taskIdForDispatcher) {
        this.taskIdForDispatcher = taskIdForDispatcher;
    }

    public String getTaskAssignmentTypeId() {
        return taskAssignmentTypeId;
    }

    public void setTaskAssignmentTypeId(String taskAssignmentTypeId) {
        this.taskAssignmentTypeId = taskAssignmentTypeId;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public String getQuestionBaseUrl() {
        return questionBaseUrl;
    }

    public void setQuestionBaseUrl(String questionBaseUrl) {
        this.questionBaseUrl = questionBaseUrl;
    }


    public String getTaskGroupDescription() {
        return taskGroupDescription;
    }

    public void setTaskGroupDescription(String taskGroupDescription) {
        this.taskGroupDescription = taskGroupDescription;
    }
}
