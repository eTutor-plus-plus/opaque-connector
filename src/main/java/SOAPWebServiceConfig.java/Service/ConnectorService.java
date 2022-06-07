package SOAPWebServiceConfig.java.Service;

import SOAPWebServiceConfig.java.Service.dto.*;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.GetQuestionMetadataRequest;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.StartRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class ConnectorService {


    //TODO - Authentifizierungsdaten in COnfigDatei

    public NewTaskAssignmentDTO getTaskMeta(GetQuestionMetadataRequest request ) throws IOException, InterruptedException, URISyntaxException {

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
        if (response.statusCode()== 200) return objectMapper.readValue(response.body(), NewTaskAssignmentDTO.class);
        throw new IOException("No valid task");

    }


    public NewTaskAssignmentDTO getTaskInfo(StartRequest request ) throws IOException, InterruptedException, URISyntaxException {

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
        if (response.statusCode()== 200) return objectMapper.readValue(response.body(), NewTaskAssignmentDTO.class);
        throw new IOException("No valid task");

    }

    public ResultDTO sendSubmission(String questionBaseUrl, SubmissionDTO submission ) throws IOException, InterruptedException, URISyntaxException {

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
        //TODO Exception Handling - no valid submission / no connection ...
        if (response.statusCode()== 200 || response.statusCode()== 202) {

            SubmissionResponse sResponse = objectMapper.readValue(response.body(), SubmissionResponse.class);

            return getResult(questionBaseUrl, sResponse.getSubmissionId());

        }

        else throw new IOException("No valid submission");

    }

    public ResultDTO getResult(String questionBaseUrl, String submissionId ) throws IOException, InterruptedException, URISyntaxException {

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
        if (response.statusCode()== 200) return objectMapper.readValue(response.body(), ResultDTO.class);
        throw new IOException("No valid result");

    }



    private static final String getBasicAuthenticationHeader() {
        String auth = "admin:admin";
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);
        return authHeaderValue;
    }



}
