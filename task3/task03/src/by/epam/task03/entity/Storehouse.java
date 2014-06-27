/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

/**
 *
 * @author Dima
 */
public class Storehouse {
    
    private static final int MAX_CAPACITY = 10000;
    private int containers;
    
    public boolean addContainers(int containers){
       
        boolean complete = false;
        int futureContainers = this.containers + containers;
        if (futureContainers <= MAX_CAPACITY) {
            this.containers = futureContainers;
            complete = true;
        }
        return complete;
    }
    public boolean removeContainers(int containers){
        
        boolean complete = false;
        int futureContainers = this.containers - containers;
        if (futureContainers >= 0) {
            this.containers = futureContainers;
            complete = true;
        }
        return complete;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" + "containers=" + containers + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.containers;
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
        final Storehouse other = (Storehouse) obj;
        if (this.containers != other.containers) {
            return false;
        }
        return true;
    }
        
}
