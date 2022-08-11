package connector.service;

import connector.dto.opaque.GetQuestionMetadataRequest;
import connector.dto.opaque.StartRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import connector.dto.etutorpp.Task;
import connector.dto.etutorpp.EtutorResult;
import connector.dto.etutorpp.Submission;
import connector.dto.etutorpp.SubmissionResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 *   Service, which sends requests to etutor system
 */
public class ConnectorService {

    /**
     * Get Taskmetadata from etutor system
     * @param request from opaque to get the questionId
     * @return task object

     */
    public Task getTaskMeta(GetQuestionMetadataRequest request ) throws IOException, InterruptedException, URISyntaxException {

        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpRequest nRequest = HttpRequest.newBuilder()
                .uri(new URI(request.getQuestionBaseURL() +"/api/tasks/assignments/" + request.getQuestionID()))
                .version(HttpClient.Version.HTTP_1_1)
                .header("Authorization", getBasicAuthenticationHeader())
                .header("Content-Type", "text/plain")
                .header("Accept-Language", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(nRequest, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode()== 200) return objectMapper.readValue(response.body(), Task.class);
        throw new IOException("No valid task");

    }


    /**
     * Get Taskdata from etutor system
     * @param request from opaque to get the questionId
     * @return task object
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public Task getTaskInfo(StartRequest request ) throws IOException, InterruptedException, URISyntaxException {

        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpRequest nRequest = HttpRequest.newBuilder()
                .uri(new URI(request.getQuestionBaseURL() +"/api/tasks/assignments/" + request.getQuestionID()))
                .version(HttpClient.Version.HTTP_1_1)
                .header("Authorization", getBasicAuthenticationHeader())
                .header("Content-Type", "text/plain")
                .header("Accept-Language", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(nRequest, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode()== 200) return objectMapper.readValue(response.body(), Task.class);
        throw new IOException("No valid task");

    }

    /**
     * Send opaque submission to etutor system
     * @param questionBaseUrl link to questionbase / questionengine
     * @param submission submission object
     * @return etutorresult
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public EtutorResult sendSubmission(String questionBaseUrl, Submission submission ) throws IOException, InterruptedException, URISyntaxException {

        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        String submissionRequest = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(submission);

        HttpRequest nRequest = HttpRequest.newBuilder()
                .uri(new URI(questionBaseUrl + "/api/dispatcher/submission/" ))
                .version(HttpClient.Version.HTTP_1_1)
                .header("Authorization", getBasicAuthenticationHeader())
                .header("Content-Type", "application/json")
                .header("Accept-Language", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(submissionRequest))
                .build();

        HttpResponse<String> response = client.send(nRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode()== 200 || response.statusCode()== 202) {

            SubmissionResponse sResponse = objectMapper.readValue(response.body(), SubmissionResponse.class);

            return getResult(questionBaseUrl, sResponse.getSubmissionId());

        }

        else throw new IOException("No valid submission");

    }


    /**
     * Get submission from etutor system used by sendsubmission method
     * @param questionBaseUrl link to questionbase / questionengine
     * @param submissionId needed for locating the result
     * @return etutorresult
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public EtutorResult getResult(String questionBaseUrl, String submissionId ) throws IOException, InterruptedException, URISyntaxException {

        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpRequest nRequest = HttpRequest.newBuilder()
                .uri(new URI(questionBaseUrl + "/api/dispatcher/grading/" + submissionId))
                .version(HttpClient.Version.HTTP_1_1)
                .header("Authorization", getBasicAuthenticationHeader())
                .header("Content-Type", "text/plain")
                .header("Accept-Language", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(nRequest, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode()== 200) return objectMapper.readValue(response.body(), EtutorResult.class);
        throw new IOException("No valid result");

    }


    /**
     * Create AuthenticationHeader
     * @return
     */
    private static final String getBasicAuthenticationHeader() {
        String auth = "admin:admin";
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);
        return authHeaderValue;
    }



}
