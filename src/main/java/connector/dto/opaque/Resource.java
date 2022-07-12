/**
 * Resource.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connector.dto.opaque;

public class Resource implements java.io.Serializable {
    private byte[] content;

    private String encoding;

    private String filename;

    private String mimeType;

    public Resource() {
    }

    public Resource(
           byte[] content,
           String encoding,
           String filename,
           String mimeType) {
           this.content = content;
           this.encoding = encoding;
           this.filename = filename;
           this.mimeType = mimeType;
    }


    /**
     * Gets the content value for this Resource.
     * 
     * @return content
     */
    public byte[] getContent() {
        return content;
    }


    /**
     * Sets the content value for this Resource.
     * 
     * @param content
     */
    public void setContent(byte[] content) {
        this.content = content;
    }


    /**
     * Gets the encoding value for this Resource.
     * 
     * @return encoding
     */
    public String getEncoding() {
        return encoding;
    }


    /**
     * Sets the encoding value for this Resource.
     * 
     * @param encoding
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }


    /**
     * Gets the filename value for this Resource.
     * 
     * @return filename
     */
    public String getFilename() {
        return filename;
    }


    /**
     * Sets the filename value for this Resource.
     * 
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }


    /**
     * Gets the mimeType value for this Resource.
     * 
     * @return mimeType
     */
    public String getMimeType() {
        return mimeType;
    }


    /**
     * Sets the mimeType value for this Resource.
     * 
     * @param mimeType
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }



}
