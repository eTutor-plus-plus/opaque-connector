package SOAPWebServiceConfig.java.Service;

import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.GetQuestionMetadataRequest;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.QuestionMetaData;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;


@Service
public class QuestionMetaService {

    private QuestionMetaData metaData = new QuestionMetaData();
    private String mark;

    @PostConstruct
    public void intitalize() {

        metaData.setQuestionMetadata("<questionmetadata> \n" + "  <scoring> \n" + "    <marks>0</marks> \n" + "  </scoring> \n" + "  <plainmode>yes</plainmode> \n" + "</questionmetadata> ");
    }


    public QuestionMetaData getMetaData(GetQuestionMetadataRequest request) throws IOException, URISyntaxException, InterruptedException {

        ConnectorService cs = new ConnectorService();

        mark = cs.getTaskMeta(request).getMaxPoints();

        metaData.setQuestionMetadata("<questionmetadata> \n" + "  <scoring> \n" + "    <marks>" + mark + "</marks> \n" + "  </scoring> \n" + "  <plainmode>yes<a/plainmode> \n" + "</questionmetadata> ");

        return metaData;
    }
}
