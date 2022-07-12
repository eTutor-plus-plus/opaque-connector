/**
 * StartReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connector.dto.opaque;

public class StartReturn implements java.io.Serializable {
    private String CSS;

    private String XHTML;

    private String progressInfo;

    private String questionSession;

    private Resource[] resources;


    public StartReturn() {
        this.CSS = "";
        this.XHTML = "";
        this.progressInfo = "";
        this.questionSession = "";
        this.resources = null;
    }

    public StartReturn(
           String CSS,
           String XHTML,
           String progressInfo,
           String questionSession,
           Resource[] resources) {
           this.CSS = CSS;
           this.XHTML = XHTML;
           this.progressInfo = progressInfo;
           this.questionSession = questionSession;
           this.resources = resources;
    }


    /**
     * Gets the CSS value for this StartReturn.
     * 
     * @return CSS
     */
    public String getCSS() {
        return CSS;
    }


    /**
     * Sets the CSS value for this StartReturn.
     * 
     * @param CSS
     */
    public void setCSS(String CSS) {
        this.CSS = CSS;
    }


    /**
     * Gets the XHTML value for this StartReturn.
     * 
     * @return XHTML
     */
    public String getXHTML() {
        return XHTML;
    }


    /**
     * Sets the XHTML value for this StartReturn.
     * 
     * @param XHTML
     */
    public void setXHTML(String XHTML) {
        this.XHTML = XHTML;
    }


    /**
     * Gets the progressInfo value for this StartReturn.
     * 
     * @return progressInfo
     */
    public String getProgressInfo() {
        return progressInfo;
    }


    /**
     * Sets the progressInfo value for this StartReturn.
     * 
     * @param progressInfo
     */
    public void setProgressInfo(String progressInfo) {
        this.progressInfo = progressInfo;
    }


    /**
     * Gets the questionSession value for this StartReturn.
     * 
     * @return questionSession
     */
    public String getQuestionSession() {
        return questionSession;
    }


    /**
     * Sets the questionSession value for this StartReturn.
     * 
     * @param questionSession
     */
    public void setQuestionSession(String questionSession) {
        this.questionSession = questionSession;
    }


    /**
     * Gets the resources value for this StartReturn.
     * 
     * @return resources
     */
    public Resource[] getResources() {
        return resources;
    }


    /**
     * Sets the resources value for this StartReturn.
     * 
     * @param resources
     */
    public void setResources(Resource[] resources) {
        this.resources = resources;
    }

}
