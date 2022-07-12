package connector.endpoint;

import connector.service.EngineInfoService;
import connector.dto.opaque.GetEngineInfoRequest;
import connector.dto.opaque.GetEngineInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.soap.SOAPException;


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
