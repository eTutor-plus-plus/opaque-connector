package SOAPWebServiceConfig.java.Endpoint;

import SOAPWebServiceConfig.java.Service.QuestionStopService;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.StopRequest;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.StopResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.soap.SOAPException;

@Endpoint
public class QuestionStopEndpoint {
    @Autowired
    private QuestionStopService questionStopService = new QuestionStopService();

    @PayloadRoot(namespace = "http://om.open.ac.uk/",
            localPart = "stop" )

    @ResponsePayload
    public StopResponse stop(@RequestPayload StopRequest request) throws SOAPException {

        StopResponse response = new StopResponse();
        questionStopService.stopResponse();

        return response;
    }
}
