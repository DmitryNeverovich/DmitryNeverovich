/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task02.logic;

import by.epam.task02.entity.Block;
import by.epam.task02.entity.IComponent;
import by.epam.task02.entity.Sentence;
import by.epam.task02.entity.Text;
import by.epam.task02.entity.PartSentence;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dima
 */
public class Parser {
    private static final String SENTENCE_EXPRESSION = "[A-Z_0-9].*?(([\\w][.|\\n][\\n|\\s])|([\\:][\\n])|([\\w][\\n]))";
    private static final String PART_SENTENCE_EXPRESSION = "[\\S|]+";
    private static final String BLOCK_EXPRESSION = "((void)|(class)).+[\\{](.*\n+.*)+?[^\t]}";
    
    public static IComponent parserText (String source){        
        IComponent text = new Text();
        text.addAll(parserSentence(source));
        text.addAll(parserBlock(source));
      
        return text;
    }
        
    private static List<IComponent> parserPartSentence(String sentenceStr){
        List<IComponent> listPartSentence = new ArrayList();
        Pattern pPartSentence = Pattern.compile(PART_SENTENCE_EXPRESSION);
        Matcher mPartSentence = pPartSentence.matcher(sentenceStr);
        while(mPartSentence.find())
        {    
            listPartSentence.add(new PartSentence(mPartSentence.group(0)));
        }  
        return listPartSentence;
    }
    
    private static List<IComponent> parserSentence(String source){
        List<IComponent> listSentence = new ArrayList();
        Pattern pSentence= Pattern.compile(SENTENCE_EXPRESSION);
        Matcher mSentence = pSentence.matcher(source);
        
        IComponent sentence;
        while(mSentence.find())
        {    
            sentence = new Sentence();
            sentence.addAll(parserPartSentence(mSentence.group(0)));
            listSentence.add(sentence);
        }
        return listSentence;
    }
    private static List<IComponent> parserBlock(String source){
        List<IComponent> listBlock = new ArrayList();
        Pattern pBlock= Pattern.compile(BLOCK_EXPRESSION);
        Matcher mBlock = pBlock.matcher(source);
        while(mBlock.find())
        {    
            listBlock.add(new Block(mBlock.group(0)));
        }
        return listBlock;
    }
}
