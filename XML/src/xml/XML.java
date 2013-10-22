/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author sabs231
 */
public class XML 
{

    public XML() 
    {
        this.headerTags = new LinkedList<DTD>();
        this.declaration = new Declaration();
        this.root = new Tag();
    }
    
    private LinkedList<DTD> headerTags;
    private Declaration declaration;
    private Tag root;
    
    public boolean delete(Tag tag)
    {
        return this.root.deleteTag(tag);
    }
    
    public void print()
    {
        ListIterator itr;
        // Search recursively on HeaderTags
        itr = this.headerTags.listIterator();
        DTD tmpTag;
        while(itr.hasNext()){
            tmpTag = (DTD) itr.next();
            tmpTag.print();
        }
        // Print Declaration
        this.declaration.print();
        // Search on root node
        this.root.print();
    }
    
    public LinkedList<GenericTag> search(String s)
    {
        LinkedList<GenericTag> matchedTags = new LinkedList<GenericTag>();
        ListIterator itr;
        // Search on Declaration
        matchedTags.addAll(this.declaration.search(s));
        // Search recursively on HeaderTags
        itr = this.headerTags.listIterator();
        DTD tmpTag;
        while(itr.hasNext()){
            tmpTag = (DTD) itr.next();
            matchedTags.addAll(tmpTag.search(s));
        }
        // Search on root node
        matchedTags.addAll(this.root.search(s));
	return matchedTags;
    }
    
    /**
     * @return the headerTags
     */
    public LinkedList<DTD> getHeaderTags() {
        return headerTags;
    }

    /**
     * @param headerTags the headerTags to set
     */
    public void setHeaderTags(LinkedList<DTD> headerTags) {
        this.headerTags = headerTags;
    }
    
    public void addHeaderTags(DTD newTag)
    {
        this.headerTags.add(newTag);
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
