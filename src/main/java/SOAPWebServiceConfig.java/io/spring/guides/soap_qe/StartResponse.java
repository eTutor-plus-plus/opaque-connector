package SOAPWebServiceConfig.java.io.spring.guides.soap_qe;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "StartResponse", namespace = "http://om.open.ac.uk/")
public class StartResponse {
    @XmlElement(required = true)

    StartReturn startReturn = new StartReturn();

    public StartReturn getStartReturn() {
        return startReturn;
    }

    public void setStartReturn(StartReturn startReturn) {
        this.startReturn = startReturn;
    }
}
