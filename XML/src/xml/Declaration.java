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
public class Declaration extends GenericTag 
{

    @Override
    public GenericTag[] search(String s) {
		GenericTag[] returnGenericTag = new GenericTag[1];
		if(this.type.equals(s)){
			returnGenericTag[0] = this;
			return returnGenericTag;
		}else{
			for (int i = 0; i < 10; i++) {
				if(this.atributes[i] && this.atributes[i].search(s)){
					returnGenericTag[0] = this;
					return returnGenericTag;
				}
			}
		}
		return null;
    }

    @Override
    public void print() {
        System.out.print("<?" + this.type);
		//Print All Attributes
		for (int i = 0; i < 10; i++) {
			atributes[i].print();
		}
		System.out.println("?>");
    }
    
}
