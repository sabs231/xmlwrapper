/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

/**
 *
 * @author sabs231
 */
public class XMLWritter 
{
    private String fileName;
    
    public XMLWritter(String fn){
        this.fileName = fn;
    }
    
    
    public boolean writeXML(XML xml)
    {
        return (true);
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
