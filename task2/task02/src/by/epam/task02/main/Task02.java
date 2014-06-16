/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task02;

import by.epam.task02.logic.Parser;
import by.epam.task02.entity.IComponent;
import by.epam.task02.logic.ICommand;
import by.epam.task02.logic.SortSentenceSize;
import by.epam.task02.logic.UniquePartSentence;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 *
 * @author Dima
 */
public class Task02 {
   // private static final Logger logger = Logger.getLogger(Task02.class);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuffer sb =new StringBuffer();
        try {
            BufferedReader in =new BufferedReader(new FileReader(new File("task2text.txt").getAbsoluteFile()));
            try{
                String s;
                while ((s = in.readLine()) != null) {                    
                    sb.append(s);
                    sb.append("\n");
                }
            }
        finally{
            in.close();
        }    
        } catch (IOException e) {
            logger.error(e);
        }
        String source = sb.toString();
                
        IComponent textComponent = Parser.parserText(source);
        
        ICommand sortSentenceSize = new SortSentenceSize();
        ICommand uniquePartSentence = new UniquePartSentence();
        
        System.out.println(textComponent.getContent());//оригинальный текст
        /*
          Вывести все предложения заданного текста  в порядке возрастания 
          количества слов в каждом из них.
         */
        System.out.println(sortSentenceSize.execute(textComponent).getContent());
        /*
          Найти такое слово в первом предложении, которого нет ни в одном из 
          остальных предложений.  
         */
        System.out.println(uniquePartSentence.execute(textComponent).getContent());
    }
    
}
