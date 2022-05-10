//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2022.04.07 um 11:28:19 AM CEST 
//


package SOAPWebServiceConfig.java.io.spring.guides.soap_qe;
import  io.spring.guides.soap_qe.GetEngineInfoResponse;
import  io.spring.guides.soap_qe.GetEngineInfoRequest;
import  io.spring.guides.soap_qe.Engineinfo;


import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.spring.guides.soap_qe package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.spring.guides.soap_qe
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEngineInfoResponse }
     * 
     */
    public GetEngineInfoResponse createGetEngineInfoResponse() {
        return new GetEngineInfoResponse();
    }

    /**
     * Create an instance of {@link GetEngineInfoRequest }
     * 
     */
    public GetEngineInfoRequest createGetEngineInfoRequest() {
        return new GetEngineInfoRequest();
    }

    /**
     * Create an instance of {@link Engineinfo }
     * 
     */
    public Engineinfo createEngineinfo() {
        return new Engineinfo();
    }

}
