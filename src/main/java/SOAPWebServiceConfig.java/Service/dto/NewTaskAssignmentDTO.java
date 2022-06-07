package SOAPWebServiceConfig.java.Service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for a new task assignment.
 *
 * @author fne
 */
public class NewTaskAssignmentDTO {

    //TODO Filtern

    @JsonIgnore
    private List<Object> learningGoalIds = new ArrayList<>();
    private String creator;
    private String header;

    private int uploadFileId;

    private String taskIdForDispatcher;
    private String sqlSolution;
    private String maxPoints;
    private String diagnoseLevelWeighting;
    private String xQuerySolution;
    private String xQueryXPathSorting;
    private String datalogSolution;
    private String datalogQuery;
    private String datalogUncheckedTerms;
    private String id;

    private String processingTime;

    private String taskDifficultyId;
    private String organisationUnit;

    private URL url;
    private String instruction;
    private boolean privateTask;

    private String taskAssignmentTypeId;

    private String taskGroupId;
    @JsonIgnore
    private Instant creationDate;
    private String internalCreator;

    public NewTaskAssignmentDTO() {
        this.learningGoalIds = null;
        this.creator = null;
        this.header = null;
        this.uploadFileId = 0;
        this.taskIdForDispatcher = null;
        this.sqlSolution = null;
        this.maxPoints = null;
        this.diagnoseLevelWeighting = null;
        this.xQuerySolution = null;
        this.xQueryXPathSorting = null;
        this.datalogSolution = null;
        this.datalogQuery = null;
        this.datalogUncheckedTerms = null;
        this.id = null;
        this.processingTime = null;
        this.taskDifficultyId = null;
        this.organisationUnit = null;
        this.url = null;
        this.instruction = null;
        this.privateTask = false;
        this.taskAssignmentTypeId = null;
        this.taskGroupId = null;
        this.creationDate = null;
        this.internalCreator = null;
    }

    public NewTaskAssignmentDTO(List<Object> learningGoalIds, String creator, String header, int uploadFileId, String taskIdForDispatcher, String sqlSolution, String maxPoints, String diagnoseLevelWeighting, String xQuerySolution, String xQueryXPathSorting, String datalogSolution, String datalogQuery, String datalogUncheckedTerms, String id, String processingTime, String taskDifficultyId, String organisationUnit, URL url, String instruction, boolean privateTask, String taskAssignmentTypeId, String taskGroupId) {
        this.learningGoalIds = learningGoalIds;
        this.creator = creator;
        this.header = header;
        this.uploadFileId = uploadFileId;
        this.taskIdForDispatcher = taskIdForDispatcher;
        this.sqlSolution = sqlSolution;
        this.maxPoints = maxPoints;
        this.diagnoseLevelWeighting = diagnoseLevelWeighting;
        this.xQuerySolution = xQuerySolution;
        this.xQueryXPathSorting = xQueryXPathSorting;
        this.datalogSolution = datalogSolution;
        this.datalogQuery = datalogQuery;
        this.datalogUncheckedTerms = datalogUncheckedTerms;
        this.id = id;
        this.processingTime = processingTime;
        this.taskDifficultyId = taskDifficultyId;
        this.organisationUnit = organisationUnit;
        this.url = url;
        this.instruction = instruction;
        this.privateTask = privateTask;
        this.taskAssignmentTypeId = taskAssignmentTypeId;
        this.taskGroupId = taskGroupId;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getInternalCreator() {
        return internalCreator;
    }

    public void setInternalCreator(String internalCreator) {
        this.internalCreator = internalCreator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the associated learning goals.
     *
     * @return the associated learning goals
     */
    public List<Object> getLearningGoalIds() {
        return learningGoalIds;
    }

    /**
     * Sets the associated learning goals.
     *
     * @param learningGoalIds the associated learning goals to set
     */
    public void setLearningGoalIds(List<Object> learningGoalIds) {
        this.learningGoalIds = learningGoalIds;
    }

    /**
     * Returns the creator.
     *
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the creator.
     *
     * @param creator the creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Returns the header.
     *
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * Sets the header.
     *
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Returns the task id for dispatcher.
     *
     * @return the task id for dispatcher
     */
    public String getTaskIdForDispatcher() {
        return taskIdForDispatcher;
    }

    /**
     * Sets the task id for dispatcher.
     *
     * @param taskIdForDispatcher task id for the dispatcher to set
     */
    public void setTaskIdForDispatcher(String taskIdForDispatcher) {
        this.taskIdForDispatcher = taskIdForDispatcher;
    }

    /**
     * Returns the solution for an SQL exercise
     * @return
     */
    public String getSqlSolution() {
        return sqlSolution;
    }

    /**
     * Sets the solution for an SQL exercise
     * @param sqlSolution
     */
    public void setSqlSolution(String sqlSolution) {
        this.sqlSolution = sqlSolution;
    }

    /**
     * Returns the maxPoints
     * @return the maxPoints
     */
    public String getMaxPoints() {
        return maxPoints;
    }

    /**
     * Sets the maxPoints
     * @param maxPoints the maxPoints
     */
    public void setMaxPoints(String maxPoints) {
        this.maxPoints = maxPoints;
    }
    /**
     * Returns the weighting for the diagnose level
     * @return the weighting
     */
    public String getDiagnoseLevelWeighting() {
        return diagnoseLevelWeighting;
    }
    /**
     * Sets the weighting for the diagnose level
     * @param diagnoseLevelWeighting
     */
    public void setDiagnoseLevelWeighting(String diagnoseLevelWeighting) {
        this.diagnoseLevelWeighting = diagnoseLevelWeighting;
    }

    /**
     * Returns the processing time.
     *
     * @return the processing time
     */
    public String getProcessingTime() {
        return processingTime;
    }


    /**
     * Sets the processing time.
     *
     * @param processingTime the processing time to set
     */
    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }

    /**
     * Returns the corresponding task difficulty id.
     *
     * @return the corresponding task difficulty id
     */
    public String getTaskDifficultyId() {
        return taskDifficultyId;
    }

    /**
     * Sets the task difficulty id.
     *
     * @param taskDifficultyId the task difficulty id to set
     */
    public void setTaskDifficultyId(String taskDifficultyId) {
        this.taskDifficultyId = taskDifficultyId;
    }

    /**
     * Returns the organisation unit.
     *
     * @return the organisation unit
     */
    public String getOrganisationUnit() {
        return organisationUnit;
    }

    /**
     * Sets the organisation unit.
     *
     * @param organisationUnit the organisation unit
     */
    public void setOrganisationUnit(String organisationUnit) {
        this.organisationUnit = organisationUnit;
    }

    /**
     * Returns the task's url.
     *
     * @return the task's url
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Sets the task's url.
     *
     * @param url the task's url to set
     */
    public void setUrl(URL url) {
        this.url = url;
    }

    /**
     * Returns the instructions.
     *
     * @return the instructions
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * Sets the instructions.
     *
     * @param instruction the instruction to set
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    /**
     * Returns whether the task is a private task or not.
     *
     * @return {@code} true if the task is a private task, otherwise {@code false}
     */
    public boolean isPrivateTask() {
        return privateTask;
    }

    /**
     * Sets whether the task is a private task or not.
     *
     * @param privateTask {@code} true if the task is a private task, otherwise {@code false}
     */
    public void setPrivateTask(boolean privateTask) {
        this.privateTask = privateTask;
    }

    /**
     * Returns the task assignment type id.
     *
     * @return the task assignment type id
     */
    public String getTaskAssignmentTypeId() {
        return taskAssignmentTypeId;
    }

    /**
     * Sets the task assignment type id.
     *
     * @param taskAssignmentTypeId the task assignment type id to seto
     */
    public void setTaskAssignmentTypeId(String taskAssignmentTypeId) {
        this.taskAssignmentTypeId = taskAssignmentTypeId;
    }

    /**
     * Returns the task group id.
     *
     * @return the task group id
     */
    public String getTaskGroupId() {
        return taskGroupId;
    }

    /**
     * Sets the task group id.
     *
     * @param taskGroupId the task group id to set
     */
    public void setTaskGroupId(String taskGroupId) {
        this.taskGroupId = taskGroupId;
    }

    public String getxQuerySolution() {
        return xQuerySolution;
    }

    public void setxQuerySolution(String xQuerySolution) {
        this.xQuerySolution = xQuerySolution;
    }

    public String getxQueryXPathSorting() {
        return xQueryXPathSorting;
    }

    public void setxQueryXPathSorting(String xQueryXPathSorting) {
        this.xQueryXPathSorting = xQueryXPathSorting;
    }

    public String getDatalogSolution() {
        return datalogSolution;
    }

    public void setDatalogSolution(String datalogSolution) {
        this.datalogSolution = datalogSolution;
    }

    public String getDatalogQuery() {
        return datalogQuery;
    }

    public void setDatalogQuery(String datalogQuery) {
        this.datalogQuery = datalogQuery;
    }

    public String getDatalogUncheckedTerms() {
        return datalogUncheckedTerms;
    }

    public void setDatalogUncheckedTerms(String datalogUncheckedTerms) {
        this.datalogUncheckedTerms = datalogUncheckedTerms;
    }

    public int getUploadFileId() {
        return uploadFileId;
    }

    public void setUploadFileId(int uploadFileId) {
        this.uploadFileId = uploadFileId;
    }
}
