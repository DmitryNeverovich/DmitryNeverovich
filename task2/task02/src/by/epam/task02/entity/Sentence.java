/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task02.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Dima
 */
public class Sentence implements IComponent{
    private List<IComponent> partSentense;
    public Sentence() {
        partSentense = new ArrayList<IComponent>();
    }
    @Override
    public void add(IComponent component) {
        partSentense.add(component);
    }
    
    @Override
    public void addAll(Collection<IComponent> components) {
        partSentense.addAll(components);
    }

    @Override
    public void remove(int index) {
        partSentense.remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.partSentense);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sentence other = (Sentence) obj;
        if (!Objects.equals(this.partSentense, other.partSentense)) {
            return false;
        }
        return true;
    }

    public List<IComponent> getPartSentense() {
        return partSentense;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" + "partSentense=" + partSentense + '}';
    }

    @Override
    public String getContent() {
        StringBuilder str = new StringBuilder();
        for(IComponent component: partSentense){
            str.append(component.getContent());
        }
        return str.toString()+"\n";
    }
    
    @Override
    public Iterator<IComponent> getIterator() {
        return partSentense.iterator(); 
    }
    
}
