/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task02.text;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Dima
 */
public abstract class IComponent {
    public void add(IComponent component){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void remove(int index){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public String getContent(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void addAll(Collection<IComponent> components){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public Iterator<IComponent> getIterator(){        
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
