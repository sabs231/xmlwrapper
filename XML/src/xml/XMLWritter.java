/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            PrintWriter output = new PrintWriter(new FileWriter(fileName));
            output.println(xml.toString());
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLWritter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(XMLWritter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
        
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
