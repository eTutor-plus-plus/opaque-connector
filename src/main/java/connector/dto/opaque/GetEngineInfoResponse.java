//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2022.04.07 um 11:28:19 AM CEST 
//


package connector.dto.opaque;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="engineinfo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "engineinfo"
})
@XmlRootElement(name = "getEngineInfoResponse")
public class GetEngineInfoResponse  {

    @XmlElement(required = true)
    protected String engineinfo;


    /**
     * Ruft den Wert der getEngineInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Engineinfo }
     *     
     */
    public String getGetEngineInfo() {
        return engineinfo;
    }

    /**
     * Legt den Wert der getEngineInfoReturn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Engineinfo }
     *     
     */
    public void setGetEngineInfo(Engineinfo value) {
        this.engineinfo = value.getEngineInfoResult();
    }

}
