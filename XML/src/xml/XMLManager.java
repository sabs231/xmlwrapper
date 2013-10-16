/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.util.List;

/**
 *
 * @author sabs231
 */
public class XMLManager 
{
    private String fileName;
    private XML xml;
    
    public boolean createXML()
    {
        return (true);
    }
    
    public boolean loadXML()
    {
        return (true);
    }
    
    public boolean writeXML()
    {
        return (true);
    }
    
    public List<GenericTag> search(String s)
    {
        return (null);
    }
    
   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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

    /**
     * @return the xml
     */
    public XML getXml() {
        return xml;
    }

    /**
     * @param xml the xml to set
     */
    public void setXml(XML xml) {
        this.xml = xml;
    }

}
