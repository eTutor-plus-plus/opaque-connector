package connector.endpoint;

import connector.service.QuestionProcessService;
import connector.dto.opaque.ProcessRequest;
import connector.dto.opaque.ProcessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.soap.SOAPException;
import java.io.IOException;
import java.net.URISyntaxException;

@Endpoint
public class QuestionProcessEndpoint {

    @Autowired
    private QuestionProcessService processService = new QuestionProcessService();

    @PayloadRoot(namespace = "http://om.open.ac.uk/",
            localPart = "process")


    @ResponsePayload
    public ProcessResponse process(@RequestPayload ProcessRequest request) throws SOAPException, IOException, URISyntaxException, InterruptedException {

        ProcessResponse response = new ProcessResponse();
        response.setProcessReturn(processService.getProcessReturn(request));
        return response;
    }

}
