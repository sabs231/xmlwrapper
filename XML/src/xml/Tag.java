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
public class Tag extends GenericTag 
{

    private LinkedList<Tag> sons;

    public Tag() {
        this.sons = new LinkedList<Tag>();
    }
    
    public boolean insert(Tag tag, int pos)
    {
        this.sons.add(pos, tag);
        return (true);
    }
    
    public boolean insertFirst(Tag tag)
    {
        this.sons.addFirst(tag);
        return (true);
    }
    
    public boolean insertLast(Tag tag)
    {
        this.sons.add(tag);
        return (true);
    }
    
    public boolean deleteTag(Tag tag)
    {
        this.sons.remove(tag);
        return (true);
    }
    
    public boolean deleteTag(int pos)
    {
        this.sons.remove(pos);
        return (true);
    }
    
    @Override
    public LinkedList search(String s) {
        LinkedList<GenericTag> matchedTags = new LinkedList<GenericTag>();
        ListIterator itr;
        Atribute tmpAtr;
        if(this.type.equals(s) || this.value.equals(s)){
            matchedTags.add(this);
        }else{
            // Search on the atributes
            itr = this.atributes.listIterator();
            while(itr.hasNext()){
                tmpAtr = (Atribute) itr.next();
                if(tmpAtr.search(s)){
                    matchedTags.add(this);
                    break;
		}
            }	
	}
        // Search recursively on the other tags
        itr = this.sons.listIterator();
        Tag tmpTag;
        while(itr.hasNext()){
            tmpTag = (Tag) itr.next();
            matchedTags.addAll(tmpTag.search(s));
        }
	return matchedTags;
    }

    @Override
    public void print() {
        System.out.print("<" + this.type);
	//Print All Attributes
        ListIterator itr = this.atributes.listIterator();
        Atribute tmpAtr;
        while(itr.hasNext()){
            tmpAtr = (Atribute) itr.next();
            tmpAtr.print();
        }
        if(this.value.isEmpty() && this.sons.size() == 0){
            System.out.println("/>");
        }else if(this.value.isEmpty() && this.sons.size() > 0){
            // Print Son Tags
            System.out.println(">");
            itr = this.sons.listIterator();
            Tag tmpTag;
            while(itr.hasNext()){
                tmpTag = (Tag) itr.next();
                tmpTag.print();
            }
            System.out.println("</" + this.type + ">");
        }else{
            // Print Value
            System.out.println(">"+this.value+"</" + this.type + ">");
        }
	
    }
    
    /**
     * @return the sons
     */
    public LinkedList<Tag> getSons() {
        return sons;
    }

    /**
     * @param sons the sons to set
     */
    public void setSons(LinkedList<Tag> sons) {
        this.sons = sons;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder()
                .append("<")
                .append(type);
        for (Atribute atribute : atributes)
        {
            sb.append(" ").append(atribute.toString());
        }
        sb.append(">").append('\n').append(value).append("\n");
        for (Tag son : sons)
        {
            sb.append(son.toString()).append("\n");
        }
        sb.append("</").append(type).append(">");
        return sb.toString();
    }
}
