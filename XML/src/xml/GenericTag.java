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
    protected Atribute atributes[];

    
    public GenericTag()
    {
        type = "";
        value = "";
        atributes = new Atribute[10];
    }
    
    public GenericTag(String t, String v, Atribute ats[])
    {
        type = t;
        value = v;
        atributes = ats;
    }
    
    public boolean insertAtribute(Atribute at)
    {
        Atribute extra[];
        
        if (at == null)
        {
            System.err.println("Error: Atribute passed as parameter is NULL");
            return (false);
        }
        else if (atributes.length >= 10)
        {
            extra = new Atribute[atributes.length + 1];
            System.arraycopy(atributes, 0, extra, 0, atributes.length);
            extra[atributes.length] = at;
            atributes = extra;
            return (true);
        }
        else
        {
            for (int i = 0; i < atributes.length; i++)
            {
                if (atributes[i] == null)
                    atributes[i] = at;
            }
            return (true);
        }
    }
    
    public abstract GenericTag[] search(String s);
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
    public Atribute[] getAtributes() 
    {
        return atributes;
    }

    /**
     * @param atributes the atributes to set
     */
    public void setAtributes(Atribute atributes[]) 
    {
        this.atributes = atributes;
    }
}
