package SOAPWebServiceConfig.java.Service;

import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.GetQuestionMetadataRequest;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.QuestionMetaData;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class QuestionMetaService {

    private QuestionMetaData metaData = new QuestionMetaData();
    private String mark;

    @PostConstruct
    public void intitalize(){

        mark = "0";

        metaData.setQuestionMetadata("<questionmetadata> \n" +
                "  <scoring> \n" +
                "    <marks>"+ mark + "</marks> \n" +
                "  </scoring> \n" +
                "  <plainmode>yes</plainmode> \n" +
                "</questionmetadata> ");
    }



    public QuestionMetaData getMetaData(GetQuestionMetadataRequest request) throws IOException {

        URL url = new URL(request.getQuestionBaseURL() + "/api/tasks/assignments/8f427b96-47d8-4e83-af4b-641b7e2702ef");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        String readLine = null;
        con.setRequestMethod("GET");

        //TODO - Authentification on Etutor++ sauber gestalten
        String auth = "admin:admin";
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
            //
            JSONObject jobject = (JSONObject) JSONValue.parse(response.toString());

            mark = (String) jobject.get("maxPoints");

            //TODO - XML in EngineInfo definieren. Funktion setMark hier ausführen
            metaData.setQuestionMetadata("<questionmetadata> \n" +
                    "  <scoring> \n" +
                    "    <marks>"+ mark + "</marks> \n" +
                    "  </scoring> \n" +
                    "  <plainmode>yes<a/plainmode> \n" +
                    "</questionmetadata> ");

        } else {
            System.out.println("GET NOT WORKED - " + responseCode);
        }

        return metaData;
    }
}
