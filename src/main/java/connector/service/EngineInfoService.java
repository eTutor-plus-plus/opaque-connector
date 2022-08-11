package connector.service;

import connector.dto.opaque.Engineinfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Service for opaque connection monitoring
 */
@Service
public class EngineInfoService {

    Engineinfo result = new Engineinfo();

    @PostConstruct
    public void intitalize() {
        result.setEngineInfoResult("<engineinfo>\n" + "    <name> [Etutor++ Connector]</name>\n" + "</engineinfo>");
    }

    public Engineinfo getEngineResponse() {
        return result;
    }
}
