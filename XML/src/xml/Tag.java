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
public class Tag extends GenericTag 
{

    private List<Tag> sons;
    
    public boolean insert(Tag tag, int pos)
    {
        return (true);
    }
    
    public boolean insertFirst(Tag tag)
    {
        return (true);
    }
    
    public boolean insertLast(Tag tag)
    {
        return (true);
    }
    
    public boolean deleteTag(Tag tag)
    {
        return (true);
    }
    
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
     * @return the sons
     */
    public List<Tag> getSons() {
        return sons;
    }

    /**
     * @param sons the sons to set
     */
    public void setSons(List<Tag> sons) {
        this.sons = sons;
    }
}
