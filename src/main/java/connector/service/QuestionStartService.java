package connector.service;


import connector.dto.etutorpp.Task;
import connector.dto.etutorpp.TaskGroup;
import connector.dto.opaque.StartRequest;
import connector.dto.opaque.StartReturn;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URISyntaxException;
import java.util.UUID;


/**
 * Service to initialize question at the start of an quiz
 */
@Service
public class QuestionStartService {

    private StartReturn startReturn = new StartReturn();
    private ConnectorService cs = new ConnectorService();

    @PostConstruct
    public void intitalize() {

        startReturn.setXHTML("<p>Kein Angabetext</p>");
        startReturn.setQuestionSession("0");
    }

    public StartReturn getStartReturn(StartRequest request) throws IOException, URISyntaxException, InterruptedException {

        Task task = cs.getTaskInfo(request);
        startReturn.setQuestionSession(UUID.randomUUID().toString());

        TaskGroup taskGroup;
        String taskGroupDescription = "";
        if (task.getTaskGroupId() != null && !task.getTaskGroupId().isEmpty()) {
            taskGroup = cs.getTaskGroup(request.getQuestionBaseURL(), task);

            //We have to add de link to the questionbase (etutor system)
            String tempTaskGroupDescription = taskGroup.getDescription().replace("href=\"/","href=\"" + request.getQuestionBaseURL() + "/" );
            taskGroupDescription = tempTaskGroupDescription.replace("rel=\"noopener noreferrer\" target=\"_blank\"", "");
        }

        startReturn.setXHTML(
                taskGroupDescription +
                task.getInstruction() +
                        "<div class =\"answer\">" +
                        "<input type =\"hidden\"  name=\"%%IDPREFIX%%taskIdForDispatcher\" value =\" " + task.getTaskIdForDispatcher() + "\" />" +
                        "<input type =\"hidden\"  name=\"%%IDPREFIX%%taskGroupDescription\" value =\"" + HtmlUtils.htmlEscape(taskGroupDescription) + "\" />" +
                        "<input type =\"hidden\"  name=\"%%IDPREFIX%%taskAssignmentTypeId\" value =\" " + task.getTaskAssignmentTypeId() + "\" />" +
                        "<input type =\"hidden\"  name=\"%%IDPREFIX%%instruction\" value =\" " + HtmlUtils.htmlEscape(task.getInstruction()) + "\" />" +
                        "<input type =\"hidden\"  name=\"%%IDPREFIX%%maxPoints\" value =\"" + task.getMaxPoints() + "\" />" +
                        "<input type =\"hidden\"  name=\"%%IDPREFIX%%questionBaseUrl\" value =\"" + request.getQuestionBaseURL() + "\" />" +
                        "<textarea class =\"queanswer\"   id=\"%%IDPREFIX%%answer\"  name=\"%%IDPREFIX%%answer\"> </textarea> </div>" +
                        "<input type=\"submit\" id=\"%%IDPREFIX%%-submit\" name=\"%%IDPREFIX%%-submit\" class=\"submit btn btn-secondary\" value=\"Überprüfen\" /> "

        );

        startReturn.setCSS(
                ".que.opaque .formulation  {width: 100%; background-color: #e7f3f5;  padding: 0.5rem 1rem} " +
                        ".answer {width: 100%}" +
                        ".queanswer {width: 100%; height: 200px}"
        );

        return startReturn;
    }
}
