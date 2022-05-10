package SOAPWebServiceConfig.java.Service;

import io.spring.guides.soap_qe.Engineinfo;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class EngineInfoService {

    Engineinfo result = new Engineinfo();

    @PostConstruct
    public void intitalize(){

        result.setEngineInfoResult("<engineinfo>\n" +
                "    <name>[question engine]</name> ''<!-- Required -->''\n" +
                "    <usedmemory>['123 bytes' or '45 KB' or '67 MB']</usedmemory> ''<!-- Optional-->''\n" +
                "    <activesessions>[Number of question sessions active]</activesessions> ''<!-- Optional-->''\n" +
                "</engineinfo>");
    }

    public Engineinfo getEngineResponse() {
        return result;
    }
}
