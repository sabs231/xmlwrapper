/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

/**
 *
 * @author sabs231
 */
public class Atribute 
{
    private String name;
    private String value;
    
    public Atribute()
    {
        name = "";
        value = "";
    }
    
    public Atribute(String n, String v)
    {
        name = n;
        value = v;
    }
    
    public void print()
    {
        System.out.print(name + "=\"" + value + "\"");
    }
    
    public boolean search(String s)
    {
        if (s.compareTo(name) == 0)
            return (true);
        else if (s.compareTo(value) == 0)
            return (true);
        return (false);
    }

    /**
     * @return the name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) 
    {
        this.name = name;
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
    
    public String toString()
    {
        return name+"="+value;
    }
}
