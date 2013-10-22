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
public class Declaration extends GenericTag 
{

    public Declaration()
    {
        super();
    }
    
    @Override
    public LinkedList search(String s) {
                LinkedList<GenericTag> matchedTags = new LinkedList<GenericTag>();
                Atribute tmpAtr;
		if(this.type.equals(s) || this.value.equals(s)){
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
        System.out.print("<?" + this.type);
	//Print All Attributes
        ListIterator itr = this.atributes.listIterator();
        Atribute tmpAtr;
        while(itr.hasNext()){
            tmpAtr = (Atribute) itr.next();
            tmpAtr.print();
        }
	System.out.println("?>");
    }
    
}
