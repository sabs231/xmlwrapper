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
        System.out.println(name + "=\"" + value + "\"");
    }
    
    public List<Atribute> search(String s)
    {
        return null;
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
}
