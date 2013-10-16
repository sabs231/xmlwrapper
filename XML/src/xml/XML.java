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
public class XML 
{
    private DTD headerTags;
    private Declaration declaration;
    private Tag root;
    
    public boolean delete(Tag tag)
    {
        return (true);
    }
    
    public void print()
    {
        
    }
    
    public List<GenericTag> search(String s)
    {
        return (null);
    }
    
    /**
     * @return the headerTags
     */
    public DTD getHeaderTags() {
        return headerTags;
    }

    /**
     * @param headerTags the headerTags to set
     */
    public void setHeaderTags(DTD headerTags) {
        this.headerTags = headerTags;
    }

    /**
     * @return the declaration
     */
    public Declaration getDeclaration() {
        return declaration;
    }

    /**
     * @param declaration the declaration to set
     */
    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    /**
     * @return the root
     */
    public Tag getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Tag root) {
        this.root = root;
    }
}
