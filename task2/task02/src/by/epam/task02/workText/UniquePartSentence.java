/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task02.workText;

import by.epam.task02.text.IComponent;
import by.epam.task02.text.Sentence;
import by.epam.task02.text.Text;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dima
 */
public class UniquePartSentence implements ICommand {

    @Override
    public IComponent execute(IComponent componentText) {
        Iterator<IComponent> iterator = componentText.getIterator();
        IComponent firstIComp = iterator.next(); 
        if (firstIComp instanceof Sentence) {
            Sentence firstSentence = (Sentence) firstIComp;
            List<IComponent> listPartSentence = firstSentence.getPartSentense();
            while (iterator.hasNext()) {
                IComponent sentenceIComponent = iterator.next();
                if (sentenceIComponent instanceof Sentence) {
                    Sentence sentence = (Sentence) sentenceIComponent;
                    listPartSentence.removeAll(sentence.getPartSentense());
                }
            }
        }
        return firstIComp;
    }

}
