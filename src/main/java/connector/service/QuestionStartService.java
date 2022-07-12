package connector.service;


import connector.dto.etutorpp.Task;
import connector.dto.opaque.StartRequest;
import connector.dto.opaque.StartReturn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URISyntaxException;
import java.util.UUID;


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
        //TODO Language Database erstellen
        startReturn.setXHTML(
                task.getInstruction() +
                        "<div class =\"answer\">" +
                        "<input type =\"hidden\"  name=\"%%IDPREFIX%%taskIdForDispatcher\" value =\" " + task.getTaskIdForDispatcher() + "\" />" +
                        "<input type =\"hidden\"  name=\"%%IDPREFIX%%taskAssignmentTypeId\" value =\" " + task.getTaskAssignmentTypeId() + "\" />" +
                        "<input type =\"hidden\"  name=\"%%IDPREFIX%%instruction\" value =\" " + task.getInstruction() + "\" />" +
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
