package SOAPWebServiceConfig.java.Service;


import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.StartRequest;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.StartReturn;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class QuestionStartService {

    private StartReturn startReturn = new StartReturn();

    @PostConstruct
    public void intitalize(){

        startReturn.setXHTML("<p>Kein Angabetext</p>");
        startReturn.setQuestionSession("0");
    }

    public StartReturn getStartReturn(StartRequest request) throws IOException {


    URL url = new URL(request.getQuestionBaseURL() + "/api/tasks/assignments/13fbb392-2c6b-4242-bfd7-3167e4dbefbe");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    String readLine = null;
    con.setRequestMethod("GET");

        //NoType
        //UploadTask
        //SQLTask
        //RATask
        //XQueryTask
        //DatalogTask


    //Authentification on Etutor++
    String auth = "admin:admin";
    //TODO Authentifizierungsdaten in Datenbank verlegen
    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
    String authHeaderValue = "Basic " + new String(encodedAuth);
        con.setRequestProperty("Authorization", authHeaderValue);

    int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {

            response.append(readLine);
        } in .close();
        // to JSON
            //TODO getQuestionData
            JSONObject jobject = (JSONObject) JSONValue.parse(response.toString());
            String header = (String) jobject.get("header");
            String taskIdForDispatcher = (String) jobject.get("taskIdForDispatcher");
            String maxPoints = (String) jobject.get("maxPoints");
            String taskAssignmentTypeId = (String) jobject.get("taskAssignmentTypeId");
            String instruction = (String) jobject.get("instruction");

            //TODO - Verbindung über HTML Client zu SOAP Process
            //Rückgabe HTML Feedback
            // Check über Postman Aufbau von XML
            startReturn.setQuestionSession(getSubmissionID(request, taskAssignmentTypeId, taskIdForDispatcher, maxPoints));
            startReturn.setXHTML(
                    "<form action=\"http://localhost:8085/soapWS/process\" method=\"post\">"
                    + instruction  +
                    "<textarea   cols=\"30\"  > </textarea>"
                            +
   		        " <input type=\"submit\" id=\"submit\" value=\"Submit\" />" +
                            "</form> "
                    +
                            "<script> const button = document.getElementById('submit');\n" +
                            "button.addEventListener('click', async _ => {\n" +
                            "  try {     \n" +
                            "    const response = await fetch('http://localhost:8085/soapWS/process', {\n" +
                            "       method: 'post',\n" +
                            "       headers: {" +
                            "                   'Content-Type': 'text/xml'}," +

                            " body: {\n" +
                            "        // Your body\n" +
                            "      }\n" +
                            "    });\n" +
                            "    console.log('Completed!', response);\n" +
                            "  } catch(err) {\n" +
                            "    console.error(`Error: ${err}`);\n" +
                            "  }\n" +
                            "});</script>"

            );  } else {
        System.out.println("GET NOT WORKED - " + responseCode);
    }
        System.out.println(startReturn.getQuestionSession() + " , " + startReturn.getXHTML());
        return startReturn;
}


//TODO getSubmissionID
public String getSubmissionID(StartRequest request, String taskType, String exerciseId, String maxPoints) throws IOException {

    final String POST_PARAMS = "{\n" + "\"submissionId\": null,\r\n" +
            "    \"taskType\" : \"" + taskType +  "\",\r\n" +
            "    \"excersiceId\" : " + exerciseId +  " ,\r\n" +
            "    \"solution\" : \"" + "" +  "\",\r\n" +
            "    \"maxPoints\" : " + maxPoints +  "\n}";

    String submissionId = "";

    URL url = new URL(request.getQuestionBaseURL() + "/api/dispatcher/submission");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    String readLine = null;
    con.setRequestMethod("POST");

    //Authentification on Etutor++
    String auth = "admin:admin";
    //TODO Authentifizierungsdaten in Datenbank verlegen
    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
    String authHeaderValue = "Basic " + new String(encodedAuth);
    con.setRequestProperty("Authorization", authHeaderValue);
    con.setRequestProperty("Accept-Language", "application/json");
    con.setRequestProperty("Content-Type", "application/json");

    con.setDoOutput(true);
    OutputStream os = con.getOutputStream();
    os.write(POST_PARAMS.getBytes());
    os.flush();
    os.close();

    int responseCode = con.getResponseCode();


    if (responseCode == HttpURLConnection.HTTP_ACCEPTED) {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {

            response.append(readLine);
        } in .close();
        // to JSON
        JSONObject jobject = (JSONObject) JSONValue.parse(response.toString());
        submissionId = (String) jobject.get("submissionId");
        String taskIdForDispatcher = (String) jobject.get("taskIdForDispatcher");


    } else {
        System.out.println("GET NOT WORKED - " + responseCode);
    }

    return submissionId;
}

}
