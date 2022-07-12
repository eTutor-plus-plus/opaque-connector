package connector.dto.etutorpp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class for a new task assignment.
 *
 * @author fne
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {


    private String taskIdForDispatcher;
    private String maxPoints;
    private String id;
    private String instruction;
    private String taskAssignmentTypeId;

    public Task() {
        this.taskIdForDispatcher = null;
        this.maxPoints = null;
        this.id = null;
        this.instruction = null;
        this.taskAssignmentTypeId = null;
    }

    public String getTaskIdForDispatcher() {
        return taskIdForDispatcher;
    }

    public void setTaskIdForDispatcher(String taskIdForDispatcher) {
        this.taskIdForDispatcher = taskIdForDispatcher;
    }

    public String getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(String maxPoints) {
        this.maxPoints = maxPoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getTaskAssignmentTypeId() {
        return taskAssignmentTypeId;
    }

    public void setTaskAssignmentTypeId(String taskAssignmentTypeId) {
        this.taskAssignmentTypeId = taskAssignmentTypeId;
    }
}