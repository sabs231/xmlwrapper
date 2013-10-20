/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

/**
 *
 * @author sabs231
 */
public class XMLReader 
{
    private String fileName;

    public XMLReader(String fn){
        this.fileName = fn;
    }
    
    public XML readXML()
    {
        return (null);
    }
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
}
