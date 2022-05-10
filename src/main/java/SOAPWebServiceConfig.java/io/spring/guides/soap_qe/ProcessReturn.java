/**
 * StartReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package SOAPWebServiceConfig.java.io.spring.guides.soap_qe;


import org.apache.tomcat.jni.Proc;

public class ProcessReturn implements java.io.Serializable {
    private String CSS;

    private String XHTML;

    private String progressInfo;

    private boolean questionEnd;

    private Resource[] resources;

    private Results results;

    public ProcessReturn(){};

    public ProcessReturn(String CSS, String XHTML, String progressInfo, boolean questionEnd, Resource[] resources, Results results) {

        this.CSS = CSS;
        this.XHTML = XHTML;
        this.progressInfo = progressInfo;
        this.questionEnd = questionEnd;
        this.resources = resources;
        this.results = results;
    }

    public String getCSS() {
        return CSS;
    }

    public void setCSS(String CSS) {
        this.CSS = CSS;
    }

    public String getXHTML() {
        return XHTML;
    }

    public void setXHTML(String XHTML) {
        this.XHTML = XHTML;
    }

    public String getProgressInfo() {
        return progressInfo;
    }

    public void setProgressInfo(String progressInfo) {
        this.progressInfo = progressInfo;
    }

    public boolean isQuestionEnd() {
        return questionEnd;
    }

    public void setQuestionEnd(boolean questionEnd) {
        this.questionEnd = questionEnd;
    }

    public Resource[] getResources() {
        return resources;
    }

    public void setResources(Resource[] resources) {
        this.resources = resources;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
