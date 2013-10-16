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
public class DTD extends GenericTag 
{

    private String version;
    
    @Override
    public List<GenericTag> search(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(GenericTag tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }
    
}
