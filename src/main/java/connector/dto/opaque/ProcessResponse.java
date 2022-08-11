package connector.dto.opaque;

import javax.xml.bind.annotation.*;


/**
 *  class for process response sent to opaque
 */

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
