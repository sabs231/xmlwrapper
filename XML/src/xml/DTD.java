/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author sabs231
 */
public class DTD extends GenericTag 
{
    private String version;
    
    public DTD()
    {
        super();
    }
    
    @Override
    public LinkedList search(String s) {
                LinkedList<GenericTag> matchedTags = new LinkedList<GenericTag>();
                Atribute tmpAtr;
		if(this.type.equals(s) || this.value.equals(s) || this.version.equals(s)){
			matchedTags.add(this);
		}else{
                    // Search on the atributes
                    ListIterator itr = this.atributes.listIterator();
                    while(itr.hasNext()){
                        tmpAtr = (Atribute) itr.next();
                        if(tmpAtr.search(s)){
                            matchedTags.add(this);
                            break;
			}
                    }
		
		}
		return matchedTags;
    }

    @Override
    public void print() {
        System.out.print("<!" + this.type + " " + this.version);
	//Print All Attributes
        ListIterator itr = this.atributes.listIterator();
        Atribute tmpAtr;
        while(itr.hasNext()){
            tmpAtr = (Atribute) itr.next();
            tmpAtr.print();
        }
	System.out.println(">");
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
