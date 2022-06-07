package SOAPWebServiceConfig.java.Service;

import io.spring.guides.soap_qe.Engineinfo;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class EngineInfoService {

    Engineinfo result = new Engineinfo();

    @PostConstruct
    public void intitalize() {

        result.setEngineInfoResult("<engineinfo>\n" + "    <name>[Etutor++ Connector]</name>\n" + "</engineinfo>");
    }

    public Engineinfo getEngineResponse() {
        return result;
    }
}