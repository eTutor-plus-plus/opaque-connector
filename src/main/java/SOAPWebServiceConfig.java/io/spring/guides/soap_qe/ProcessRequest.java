package SOAPWebServiceConfig.java.io.spring.guides.soap_qe;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "process", namespace = "http://om.open.ac.uk/")
public class ProcessRequest {

    @XmlElement(required = true)
    protected String questionSession;
    @XmlElementWrapper(name = "names")
    @XmlElement(name = "item")
    protected String[] names;
    @XmlElementWrapper(name = "values")
    @XmlElement(name = "item")
    protected String[] values;

    public String getQuestionSession() {
        return questionSession;
    }

    public void setQuestionSession(String questionSession) {
        this.questionSession = questionSession;
    }



    public String[] getNames() {

        String[] convNames = new String[names.length];
        for (int i = 0; i < names.length; i++){
            convNames[i] = names[i].trim();
        }
        return convNames;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String[] getValues() {
        String[] convValues = new String[values.length];
        for (int i = 0; i < values.length; i++){
            convValues[i] = values[i].trim();
        }
        return convValues;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
