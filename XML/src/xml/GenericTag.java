package xml;
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sabs231
 */
public abstract class GenericTag 
{
    protected String type;
    protected String value;
    protected LinkedList<Atribute> atributes;

    
    public GenericTag()
    {
        type = "";
        value = "";
        atributes = new LinkedList<Atribute>();
    }
    
    public GenericTag(String t, String v, LinkedList ats)
    {
        type = t;
        value = v;
        atributes = ats;
    }
    
    public boolean insertAtribute(Atribute at){        
        if (at == null){
            System.err.println("Error: Atribute passed as parameter is NULL");
            return (false);
        }
        return (this.atributes.add(at));
    }
    
    public abstract LinkedList search(String s);
    public abstract void print();
    
    /**
     * @return the type
     */
    public String getType() 
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) 
    {
        this.type = type;
    }

    /**
     * @return the value
     */
    public String getValue() 
    {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) 
    {
        this.value = value;
    }

    /**
     * @return the atributes
     */
    public LinkedList getAtributes() 
    {
        return this.atributes;
    }

    /**
     * @param atributes the atributes to set
     */
    public void setAtributes(LinkedList atributes) 
    {
        this.atributes = atributes;
    }
}
