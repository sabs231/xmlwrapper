/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 *
 * @author sabs231
 */
public class XMLReader 
{
    private String fileName;
    private Deque<Tag> tagQueue;
    private BufferedReader reader;

    public XMLReader(String fn){
        this.fileName = fn;
        tagQueue = new ArrayDeque<Tag>();
    }
    
    public XML readXML()
    {
        XML result = new XML();
        String strTag;
        Tag newTag;
        openFile();
        strTag = readTag();
        Declaration declaration = new Declaration();
        //TODO: Separate Values
        
        declaration.setValue(strTag);
        result.setDeclaration(declaration);
        
        DTD newDTD = new DTD();
        strTag = readTag();
        while(strTag.charAt(1)=='!')
        {
            //TODO: Separate Values
            newDTD.setValue(strTag);
            result.addHeaderTags(newDTD);
        }
        
        do
        {
            strTag = readTag();
            //If closing tag
            if(strTag.charAt(1)=='/')
            {
                tagQueue.removeLast();
                continue;
            }
            
            newTag = new Tag();
            StringTokenizer st = new StringTokenizer(strTag," ");
            
            newTag.setType(st.nextToken());
            while(st.hasMoreTokens())
            {
                StringTokenizer stAtribute = new StringTokenizer(st.nextToken(),"=");
                newTag.insertAtribute(new Atribute(stAtribute.nextToken(),stAtribute.nextToken()));
            }

            strTag = readContent();
            newTag.setValue(strTag);
            //Try to add tag to its parent (won't work for the first tag)
            if(!tagQueue.isEmpty())
            {
                tagQueue.peekLast().insertLast(newTag);
            }
            
            if(strTag.charAt(strTag.length()-2)!='/')
            {
                //Only add to queue when the tag is not empty
                tagQueue.addLast(newTag);
            }
        }
        while(!tagQueue.isEmpty());
        return result;     
    }
    
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    private void openFile()
    {
        try
        {
        reader = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException e){}
        return;
    }
    
    private String readTag()
    {
        StringBuilder builder = new StringBuilder();
	int c = 0;
        char character;
        try
        {
            while((c = reader.read()) != -1) 
            {
                character = (char) c;
                builder.append(character);
                if (character == '>') break;
            }
        }
        catch(IOException e)
        {
            //Do something
        }
        return builder.toString();
    }
    
    private String readContent()
    {
        StringBuilder builder = new StringBuilder();
	int c = 0;
        char character;
        try
        {
            while((c = reader.read()) != -1) 
            {
                character = (char) c;
                builder.append(character);
                if (character == '<') break;
            }
        }
        catch(IOException e)
        {
            //Do something
        }
        return builder.toString();
    }
}