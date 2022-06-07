package SOAPWebServiceConfig.java.Endpoint;

import SOAPWebServiceConfig.java.Service.QuestionStartService;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.StartRequest;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.StartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.soap.SOAPException;
import java.io.IOException;
import java.net.URISyntaxException;


@Endpoint
public class QuestionStartEndpoint {

    @Autowired
    private QuestionStartService startService = new QuestionStartService();

    @PayloadRoot(namespace = "http://om.open.ac.uk/",
            localPart = "start")

    @ResponsePayload
    public StartResponse start(@RequestPayload StartRequest request) throws SOAPException, IOException, ClassNotFoundException, InterruptedException, URISyntaxException {



        StartResponse response = new StartResponse();
        response.setStartReturn(startService.getStartReturn(request));
        return response;
    }
}

