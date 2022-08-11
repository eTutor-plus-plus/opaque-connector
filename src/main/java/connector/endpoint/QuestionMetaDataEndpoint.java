package connector.endpoint;


import connector.service.QuestionMetaService;
import connector.dto.opaque.GetQuestionMetadataRequest;
import connector.dto.opaque.GetQuestionMetadataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import javax.xml.soap.*;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *   Endpoint, which is called from opaque to ask for questionMetaData
 */
@Endpoint
public class QuestionMetaDataEndpoint {

    @Autowired
    private QuestionMetaService questionMetaService;

    @PayloadRoot(namespace = "http://om.open.ac.uk/",
            localPart = "getQuestionMetadata")

    @ResponsePayload
    public GetQuestionMetadataResponse getQuestionMetadata(@RequestPayload GetQuestionMetadataRequest request) throws SOAPException, IOException, URISyntaxException, InterruptedException {


        GetQuestionMetadataResponse response = new GetQuestionMetadataResponse();
        response.setMetadata(questionMetaService.getMetaData(request));
        return response;
    }


}
