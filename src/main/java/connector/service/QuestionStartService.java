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
    private static final String ETUTOR_BASE_URL = "//etutor.dke.uni-linz.ac.at/etutorpp/";
    private StartReturn startReturn = new StartReturn();
    private ConnectorService cs = new ConnectorService();

    @PostConstruct
    public void intitalize() {

        startReturn.setXHTML("<p>Kein Angabetext</p>");
        startReturn.setQuestionSession("0");
    }

    /**
     * Method to generate a HTML form for every quiz
     * @param request Moodle Opaque request with questionID and questionbaseurl
     * @return startReturn object which contains a HTML form
     * @throws IOException if no valid task found
     * @throws URISyntaxException if no valid uri
     * @throws InterruptedException
     */
    public StartReturn getStartReturn(StartRequest request) throws IOException, URISyntaxException, InterruptedException {

        Task task = cs.getTaskInfo(request);
        startReturn.setQuestionSession(UUID.randomUUID().toString());

        TaskGroup taskGroup;
        String taskGroupDescription = "";

        if (task.getTaskGroupId() != null && !task.getTaskGroupId().isEmpty()) {
            taskGroup = cs.getTaskGroup(request.getQuestionBaseURL(), task);

            //We have to add de link to the questionbase (etutor system)
            taskGroupDescription = taskGroup.getDescription().replace("\"","'" );
            taskGroupDescription = taskGroupDescription.replace("href='/","href='");
            taskGroupDescription = taskGroupDescription.replace("href='etutorpp","href='");
            taskGroupDescription = taskGroupDescription.replace("href='/","href='");
            taskGroupDescription = taskGroupDescription.replace("href='","href='" + ETUTOR_BASE_URL);
            taskGroupDescription = taskGroupDescription.replace("rel=\"noopener noreferrer\" target=\"_blank\"", "");
        }

        // Information is stored as key value pairs in moodle database and displayed as a HTML form in moodle
        // It's import do save this data, because it's needed at the process service later

        StringBuilder html = new StringBuilder();
        if (task.getTaskGroupId() != null && !task.getTaskGroupId().isEmpty()) {
            html.append("<p><strong>Gruppen-Beschreibung</strong></p>");
            html.append(taskGroupDescription);
            html.append("<p></p>");
        }
        html.append("<p><strong>Aufgabenstellung</strong></p>");
        html.append(task.getInstruction());
        html.append("<div class =\"answer\">");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%taskIdForDispatcher\" value =\" " + task.getTaskIdForDispatcher() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%taskAssignmentTypeId\" value =\" " + task.getTaskAssignmentTypeId() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%taskGroupDescription\" value =\" " + HtmlUtils.htmlEscape(taskGroupDescription) + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%instruction\" value =\" " + HtmlUtils.htmlEscape(task.getInstruction()) + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%maxPoints\" value =\" " + task.getMaxPoints() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%questionBaseUrl\" value =\"" + request.getQuestionBaseURL() + "\" />");
        html.append("<textarea class =\"queanswer\"   id=\"%%IDPREFIX%%answer\"  name=\"%%IDPREFIX%%answer\"> </textarea> </div>");
        html.append("<input type=\"submit\" id=\"%%IDPREFIX%%-submit\" name=\"%%IDPREFIX%%-submit\" class=\"submit btn btn-secondary\" value=\"Überprüfen\" />");

        startReturn.setXHTML(html.toString());


        startReturn.setCSS(
                ".que.opaque .formulation  {width: 100%; background-color: #e7f3f5;  padding: 0.5rem 1rem} " +
                        ".answer {width: 100%}" +
                        ".queanswer {width: 100%; height: 200px}"
        );

        return startReturn;
    }
}
