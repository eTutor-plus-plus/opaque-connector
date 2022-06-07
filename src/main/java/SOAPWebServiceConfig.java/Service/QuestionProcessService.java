package SOAPWebServiceConfig.java.Service;

import SOAPWebServiceConfig.java.Service.dto.*;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.*;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class QuestionProcessService {

    //TODO - Diagnoselevel in Config
    //TODO Exception handling

    private ConnectorService cs = new ConnectorService();

    @PostConstruct
    public void intitalize() {

    }

    public ProcessReturn getProcessReturn(ProcessRequest request) throws IOException, URISyntaxException, InterruptedException {

        ProcessReturn processReturn = new ProcessReturn();
        Results finalresult = new Results();
        ResultDTO gradingResult = new ResultDTO();
        QuestionAttemptDTO questionAttempt = new QuestionAttemptDTO();
        Score[] scores = new Score[1];
        SubmissionDTO submission = new SubmissionDTO();

        //Mapping der übergebenen Name- und Value Arrays
        String[] names = request.getNames();
        String[] values = request.getValues();

        //List vor checking names
        List<String> list = Arrays.asList(request.getNames());

        if (list.contains("-finish")) {
            processReturn.setProgressInfo("Finish");
            processReturn.setQuestionEnd(true);
            processReturn.setResults(finalresult);
            processReturn.setXHTML("<p>Finished</p>");
            return processReturn;
        }

        if (request.getNames() != null || request.getValues() != null) {
            Map<String, String> param = IntStream.range(0, names.length).boxed()
                    .collect(Collectors.toMap(i -> names[i], i -> values[i]));
            questionAttempt.setAnswer(param.get("answer"));
            questionAttempt.setInstruction(param.get("instruction"));
            questionAttempt.setTaskIdForDispatcher(Integer.parseInt(param.get("taskIdForDispatcher")));
            questionAttempt.setTaskAssignmentTypeId(param.get("taskAssignmentTypeId"));
            questionAttempt.setMaxPoints(Integer.parseInt(param.get("maxPoints")));
            questionAttempt.setQuestionBaseUrl(param.get("questionBaseUrl"));
        }

        if (questionAttempt.getAnswer() != null && !questionAttempt.getAnswer().isEmpty()) {

            Map<String, String> passedAttributes = new HashMap<>();
            passedAttributes.put("submission", questionAttempt.getAnswer());
            passedAttributes.put("action", "diagnose");
            passedAttributes.put("diagnoseLevel", "3");

            Map<String, String> passedParameters = new HashMap<>();
            passedParameters.put("exerciseID", Integer.toString(questionAttempt.getTaskIdForDispatcher()));

            submission.setExerciseId(questionAttempt.getTaskIdForDispatcher());
            submission.setMaxPoints(questionAttempt.getMaxPoints());
            submission.setTaskType(questionAttempt.getTaskAssignmentTypeId());
            submission.setPassedAttributes(passedAttributes);
            submission.setPassedParameters(passedParameters);

            gradingResult = cs.sendSubmission(questionAttempt.getQuestionBaseUrl(), submission);



            processReturn.setQuestionEnd(false);
            processReturn.setProgressInfo("Not completed");
            processReturn.setXHTML(createHtml(questionAttempt, true, true, true, gradingResult));

            if (list.contains("finish")) {
                if (gradingResult.getPoints() == 1) {
                    scores[0] = new Score(questionAttempt.getMaxPoints());
                } else scores[0] = new Score(0);

                finalresult.setScores(scores);
                finalresult.setAnswerLine(questionAttempt.getAnswer());
                finalresult.setQuestionLine(questionAttempt.getInstruction());
                processReturn.setQuestionEnd(true);
                processReturn.setResults(finalresult);
                processReturn.setXHTML(createHtml(questionAttempt, false, false, false, gradingResult));

            }

        } else if (questionAttempt.getAnswer() == null || questionAttempt.getAnswer().isEmpty()) {
            processReturn.setProgressInfo("Not finished");
            processReturn.setXHTML(createHtml(questionAttempt, true, true, false, gradingResult));

        }

        processReturn.setCSS(
                ".que.opaque .formulation  {width: 100%; background-color: #e7f3f5;  padding: 0.5rem 1rem} " +
                        ".answer {width: 100%}" +
                        ".queanswer {width: 100%; height: 200px}");

        return processReturn;
    }

    private String createHtml(QuestionAttemptDTO questionAttempt, boolean answer, boolean submit, boolean finish, ResultDTO result) {

        StringBuilder html = new StringBuilder();
        html.append(questionAttempt.getInstruction());
        html.append("<div class =\"answer\">");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%taskIdForDispatcher\" value =\" " + questionAttempt.getTaskIdForDispatcher() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%taskAssignmentTypeId\" value =\" " + questionAttempt.getTaskAssignmentTypeId() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%instruction\" value =\" " + questionAttempt.getInstruction() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%maxPoints\" value =\" " + questionAttempt.getMaxPoints() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%questionBaseUrl\" value =\"" + questionAttempt.getQuestionBaseUrl() + "\" />");

        if (answer) {
            html.append("<textarea class =\"queanswer\"   id=\"%%IDPREFIX%%answer\"  name=\"%%IDPREFIX%%answer\" value =\"" + questionAttempt.getAnswer() + " \">" + questionAttempt.getAnswer() + " </textarea> </div>");
        } else {
            html.append("<textarea class =\"queanswer\" disabled   id=\"%%IDPREFIX%%answer\"  name=\"%%IDPREFIX%%answer\" value =\"" + questionAttempt.getAnswer() + " \">" + questionAttempt.getAnswer() + " </textarea> </div> ");

        }

        if (submit) {
            html.append("<input type=\"submit\" id=\"%%IDPREFIX%%-submit\" class=\"submit btn btn-secondary\" name=\"%%IDPREFIX%%-submit\"  value=\"Überprüfen\" />");
        }

        if (finish) {
            html.append(" <input type=\"submit\" id=\"%%IDPREFIX%%finish\" class=\"btn btn-danger\" name=\"%%IDPREFIX%%finish\" value=\"Abgeben\"  />");
        }

        if (result.getResult() != null) {
            html.append("<div id=\"%%IDPREFIX%%-feedback\" name=\"%%IDPREFIX%%-feedback\"<p></p> <div class=\"outcome\">");
            html.append(result.getResult() + "</div>");
        }


        return html.toString();
    }

}
