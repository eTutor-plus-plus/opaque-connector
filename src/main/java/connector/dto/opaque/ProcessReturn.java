
package connector.dto.opaque;

/**
 *  DTO class for created processReturn contained in processResponse sent to opaque
 */

public class ProcessReturn implements java.io.Serializable {
    private String CSS;

    private String XHTML;

    private String progressInfo;

    private boolean questionEnd;

    private Resource[] resources;

    private Results results;


    public ProcessReturn(String CSS, String XHTML, String progressInfo, boolean questionEnd, Resource[] resources, Results results) {

        this.CSS = CSS;
        this.XHTML = XHTML;
        this.progressInfo = progressInfo;
        this.questionEnd = questionEnd;
        this.resources = resources;
        this.results = results;
    }
    public ProcessReturn() {
        this.CSS = "";
        this.XHTML = "";
        this.progressInfo = "";
        this.questionEnd = false;
        this.resources = null;
        this.results = null;
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
