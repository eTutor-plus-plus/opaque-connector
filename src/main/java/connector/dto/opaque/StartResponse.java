package connector.dto.opaque;

import javax.xml.bind.annotation.*;

/**
 *   class for process response sent to opaque
 */
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
