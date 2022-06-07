package SOAPWebServiceConfig.java.io.spring.guides.soap_qe;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ProcessResponse", namespace = "http://om.open.ac.uk/")
public class ProcessResponse {

    public ProcessResponse() {
    }

    @XmlElement(required = true)

    ProcessReturn processReturn = new ProcessReturn();

    public ProcessReturn getProcessReturn() {
        return processReturn;
    }

    public void setProcessReturn(ProcessReturn processReturn) {
        this.processReturn = processReturn;
    }



}
