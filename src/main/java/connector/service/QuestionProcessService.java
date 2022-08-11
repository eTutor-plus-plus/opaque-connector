package connector.service;

import connector.dto.etutorpp.QuestionAttempt;
import connector.dto.etutorpp.EtutorResult;
import connector.dto.etutorpp.Submission;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import connector.dto.opaque.ProcessRequest;
import connector.dto.opaque.ProcessReturn;
import connector.dto.opaque.Results;
import connector.dto.opaque.Score;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Service for processing questions
 */
@Service
public class QuestionProcessService {

    private ConnectorService cs = new ConnectorService();

    @PostConstruct
    public void intitalize() {

    }

    /**
     * Method for processing question
     * @param request contains answer infos
     * @return processReturn object contained in processResponse sent to opaque
     * @throws IOException
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    public ProcessReturn getProcessReturn(ProcessRequest request) throws IOException, URISyntaxException, InterruptedException {

        ProcessReturn processReturn = new ProcessReturn();
        Results finalresult = new Results();
        EtutorResult gradingResult = new EtutorResult();
        QuestionAttempt questionAttempt = new QuestionAttempt();
        Score[] scores = new Score[1];
        Submission submission = new Submission();

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
            passedAttributes.put("diagnoseLevel", "0");

            Map<String, String> passedParameters = new HashMap<>();

            submission.setExerciseId(questionAttempt.getTaskIdForDispatcher());
            submission.setMaxPoints(questionAttempt.getMaxPoints());
            submission.setTaskType(questionAttempt.getTaskAssignmentTypeId());
            submission.setPassedAttributes(passedAttributes);
            submission.setPassedParameters(passedParameters);

            gradingResult = cs.sendSubmission(questionAttempt.getQuestionBaseUrl(), submission);

            if (list.contains("finish")) {
                if (gradingResult.getPoints() == 1) {
                    scores[0] = new Score(questionAttempt.getMaxPoints());
                } else scores[0] = new Score(0);
                finalresult.setScores(scores);
                finalresult.setAnswerLine(questionAttempt.getAnswer());
                finalresult.setQuestionLine(questionAttempt.getInstruction());
                processReturn.setQuestionEnd(false);
                processReturn.setResults(finalresult);
                processReturn.setXHTML(createHtml(questionAttempt, false, false, false, gradingResult));

            }

            else {
                processReturn.setQuestionEnd(false);
                processReturn.setProgressInfo("Not complete");
                processReturn.setXHTML(createHtml(questionAttempt, true, true, true, gradingResult));

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

    /**
     * Method for creating the question UI
     * @param questionAttempt contains infos about the question
     * @param answer boolean if question has answer
     * @param submit boolean if question is submitted
     * @param finish boolean if question is already finished
     * @param result contains the feedback which should be displayed
     * @return
     */
    private String createHtml(QuestionAttempt questionAttempt, boolean answer, boolean submit, boolean finish, EtutorResult result) {

        StringBuilder html = new StringBuilder();
        html.append(questionAttempt.getInstruction());
        html.append("<div class =\"answer\">");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%taskIdForDispatcher\" value =\" " + questionAttempt.getTaskIdForDispatcher() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%taskAssignmentTypeId\" value =\" " + questionAttempt.getTaskAssignmentTypeId() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%instruction\" value =\" " + questionAttempt.getInstruction() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%maxPoints\" value =\" " + questionAttempt.getMaxPoints() + "\" />");
        html.append("<input type =\"hidden\"  name=\"%%IDPREFIX%%questionBaseUrl\" value =\"" + questionAttempt.getQuestionBaseUrl() + "\" />");

        if (answer == true) {
            html.append("<textarea class =\"queanswer\"   id=\"%%IDPREFIX%%answer\"  name=\"%%IDPREFIX%%answer\" value =\"" + questionAttempt.getAnswer() + " \">" + questionAttempt.getAnswer() + " </textarea> </div>");
        } else {
            html.append("<textarea class =\"queanswer\" disabled   id=\"%%IDPREFIX%%answer\"  name=\"%%IDPREFIX%%answer\" value =\"" + questionAttempt.getAnswer() + " \">" + questionAttempt.getAnswer() + " </textarea> </div> ");

        }
        html.append("<div>");

        if (submit == true) {
            html.append("<input type=\"submit\" id=\"%%IDPREFIX%%-submit\" class=\"submit btn btn-secondary\" name=\"%%IDPREFIX%%-submit\"  value=\"Überprüfen\" />");
        }


        if (finish == true) {
            html.append(" <input type=\"submit\"  id=\"%%IDPREFIX%%finish\" class=\"btn btn-danger\" name=\"%%IDPREFIX%%finish\" value=\"Abgeben\"  />");
        }


        html.append("</div>");

        if (result.getResult() != null) {
            html.append("<div id=\"%%IDPREFIX%%-feedback\" name=\"%%IDPREFIX%%-feedback\"<p></p> <div class=\"outcome\">");
            html.append(result.getResult() + "</div></div>");
        }


        return html.toString();
    }

}
