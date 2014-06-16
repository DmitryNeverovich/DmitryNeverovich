/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task02.entity;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Dima
 */
public interface IComponent {
    void add(IComponent component);
    void remove(int index);    
    String getContent();
    void addAll(Collection<IComponent> components);
    Iterator<IComponent> getIterator();
}
