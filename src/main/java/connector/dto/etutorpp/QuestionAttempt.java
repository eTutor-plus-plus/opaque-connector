package connector.dto.etutorpp;

public class QuestionAttempt {

    String answer;
    String instruction;
    int taskIdForDispatcher;
    String taskAssignmentTypeId;
    int maxPoints;
    String questionBaseUrl;

    public QuestionAttempt() {
    }

    public QuestionAttempt(String answer, String instruction, int taskIdForDispatcher, String taskAssignmentTypeId, int maxPoints, String questionBaseUrl) {
        this.answer = answer;
        this.instruction = instruction;
        this.taskIdForDispatcher = taskIdForDispatcher;
        this.taskAssignmentTypeId = taskAssignmentTypeId;
        this.maxPoints = maxPoints;
        this.questionBaseUrl = questionBaseUrl;
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
}
