package SOAPWebServiceConfig.java.Service;

import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.ProcessReturn;
import SOAPWebServiceConfig.java.io.spring.guides.soap_qe.StartReturn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class QuestionProcessService {

    private ProcessReturn processReturn = new ProcessReturn();

    @PostConstruct
    public void intitalize(){

        processReturn.setXHTML("<p>In Process</p>");
        System.out.println("1");
    }
    // neue Submission ID muss überspeichert werden, da jeder Abgabe eigene ID zugewiesen wird
    public ProcessReturn getProcessReturn(){

        System.out.println("2");
        return processReturn;
    }

}
