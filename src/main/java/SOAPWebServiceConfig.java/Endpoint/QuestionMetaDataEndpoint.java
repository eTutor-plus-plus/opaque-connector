package SOAPWebServiceConfig.java.Endpoint;


import SOAPWebServiceConfig.java.Service.*;
import SOAPWebServiceConfig.java.Service.EngineInfoService;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import javax.xml.soap.*;
import java.io.IOException;

@Endpoint
public class QuestionMetaDataEndpoint {


    @Autowired
    private QuestionMetaService questionMetaService;

    @PayloadRoot(namespace = "http://om.open.ac.uk/",
            localPart = "getQuestionMetadata")

    @ResponsePayload
    public GetQuestionMetadataResponse getQuestionMetadata(@RequestPayload GetQuestionMetadataRequest request) throws SOAPException, IOException {


        GetQuestionMetadataResponse response = new GetQuestionMetadataResponse();
        response.setMetadata(questionMetaService.getMetaData(request));
        return response;
    }

    @Autowired
    private QuestionStartService startService = new QuestionStartService();

    @PayloadRoot(namespace = "http://om.open.ac.uk/",
            localPart = "start")

    @ResponsePayload
    public StartResponse start(@RequestPayload StartRequest request) throws SOAPException, IOException {

        StartResponse response = new StartResponse();
        response.setStartReturn(startService.getStartReturn(request));
        return response;
    }

    @Autowired
    private QuestionProcessService processService = new QuestionProcessService();

    @PayloadRoot(namespace = "http://om.open.ac.uk/",
            localPart = "process")

    @ResponsePayload
    public ProcessResponse process(@RequestPayload ProcessRequest request) throws SOAPException {

        ProcessResponse response = new ProcessResponse();
        response.setProcessReturn(processService.getProcessReturn());

        return response;
    }

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
