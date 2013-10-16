package xml;
import java.util.List;

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
    protected List<Atribute> atributes;

    
    public boolean insertAtribute(Atribute at)
    {
        return true;
    }
    
    public abstract List<GenericTag> search(String s);
    public abstract void print();
    public abstract int compareTo(GenericTag tag);
    
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
    public List<Atribute> getAtributes() 
    {
        return atributes;
    }

    /**
     * @param atributes the atributes to set
     */
    public void setAtributes(List<Atribute> atributes) 
    {
        this.atributes = atributes;
    }
}
