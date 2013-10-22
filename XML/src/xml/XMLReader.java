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
    private PushbackReader reader;

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
        
        if(strTag.charAt(1)=='?')
        {
            //Remove <? and ?>
            strTag = strTag.substring(2,strTag.lastIndexOf('?'));
            Declaration declaration = new Declaration();
            StringTokenizer st = new StringTokenizer(strTag," ");
            declaration.setValue(st.nextToken());
            while(st.hasMoreTokens())
            {
                StringTokenizer stAtribute = new StringTokenizer(st.nextToken(),"=");
                declaration.insertAtribute(new Atribute(stAtribute.nextToken(),stAtribute.nextToken()));
            }
            result.setDeclaration(declaration);
        }

        DTD newDTD = new DTD();
        strTag = readTag();
        while(strTag.charAt(1)=='!')
        {
            newDTD.setValue(strTag);
            result.addHeaderTags(newDTD);
            strTag = readTag();
        }
        
        do
        {
            if(!tagQueue.isEmpty()) strTag = readTag();
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

            //Try to add tag to its parent
            if(!tagQueue.isEmpty())
            {
                tagQueue.peekLast().insertLast(newTag);
            }
            else
            {
                result.setRoot(newTag);
            }
            
            if(strTag.charAt(strTag.length()-2)!='/')
            {
                //Only add to queue when the tag is not empty
                tagQueue.addLast(newTag);
            }
            
            strTag = readContent();
            newTag.setValue(strTag);
            
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
            reader = new PushbackReader(new FileReader(fileName));
        }
        catch (FileNotFoundException e)
        {
            System.err.print("File Not Found: " + e.getMessage());
        }
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
                if(character == '\r' || character == '\t' || character == '\n')
                {
                    continue;
                }
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
                if(character == '\r' || character == '\t' || character == '\n')
                {
                    continue;
                }
                if (character == '<')
                {
                    reader.unread(c);
                    break;
                }
                builder.append(character);
            }
        }
        catch(IOException e)
        {
            //Do something
        }
        return builder.toString();
    }
}