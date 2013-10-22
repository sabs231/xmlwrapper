/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.util.LinkedList;

/**
 *
 * @author sabs231
 */
public class XMLManager 
{
    private String fileName;
    private XML xml;
    
    public XMLManager() {
    }
    
    public boolean createXML()
    {
        this.xml = new XML();
        return (this.xml != null);
    }
    
    public boolean loadXML()
    {
        XMLReader xmlr = new XMLReader(this.fileName);
        this.xml = xmlr.readXML();
        return (this.xml != null);
    }
    
    public boolean writeXML()
    {
        XMLWritter xmlw = new XMLWritter(this.fileName);
        return (xmlw.writeXML(this.xml));
    }
    
    public LinkedList<GenericTag> search(String s)
    {
        LinkedList<GenericTag> searchedNodes = new LinkedList<GenericTag>();
        if(this.xml != null){
            searchedNodes.addAll(this.xml.search(s));
        }
        return searchedNodes;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XMLManager xmlm = new XMLManager();
        xmlm.setFileName("C:\\Users\\acamargob\\Documents\\GitHub\\xmlwrapper\\XML\\src\\note.xml");
        xmlm.loadXML();
        System.exit(0);
    }
    
}
