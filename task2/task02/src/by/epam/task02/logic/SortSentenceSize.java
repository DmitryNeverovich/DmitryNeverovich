/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task02.logic;

import by.epam.task02.entity.IComponent;
import by.epam.task02.entity.Sentence;
import by.epam.task02.entity.Text;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Dima
 */
public class SortSentenceSize implements ICommand{

    @Override
    public IComponent execute(IComponent componentText) {
        IComponent sortedText = new Text();
        if (componentText instanceof Text) {
            Iterator<IComponent> iterator = componentText.getIterator();
            Map<Integer, IComponent> map = new TreeMap<Integer, IComponent>();
            while (iterator.hasNext()) {
                IComponent sentenceIComponent = iterator.next();
                if (sentenceIComponent instanceof Sentence) {
                    Sentence sentence = (Sentence) sentenceIComponent;
                    map.put(sentence.getPartSentense().size(), sentence);
                }
            }
            sortedText.addAll(map.values());
        }
        return sortedText;
    } 
}
