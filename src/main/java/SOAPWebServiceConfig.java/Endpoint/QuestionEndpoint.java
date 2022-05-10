package SOAPWebServiceConfig.java.Endpoint;

import SOAPWebServiceConfig.java.Service.EngineInfoService;
import SOAPWebServiceConfig.java.Service.QuestionMetaService;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.GetQuestionMetadataRequest;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.GetQuestionMetadataResponse;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.QuestionMetaData;
import io.spring.guides.soap_qe.GetEngineInfoRequest;
import io.spring.guides.soap_qe.GetEngineInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import javax.xml.soap.*;

@Endpoint
public class QuestionEndpoint {

    @Autowired
    private EngineInfoService questionService;

    @PayloadRoot(namespace = "http://om.open.ac.uk/",
                localPart = "getEngineInfo")

    @ResponsePayload
    public GetEngineInfoResponse getEngineInfo(@RequestPayload GetEngineInfoRequest request) throws SOAPException {

        GetEngineInfoResponse response = new GetEngineInfoResponse();
        response.setGetEngineInfo(questionService.getEngineResponse());
        return response;
    }


}
