/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task03.entity;

import java.util.Objects;

/**
 *
 * @author Dima
 */
public class Ship {

    private static final int MAX_SIZE_CONTAINER = 200;
    private int number;
    private int container;
    private Target target;

    public Ship(int number, int container, Target target) {
        this.number = number;
        this.container = container;
        this.target = target;
    }

    public Target getTarget() {
        return target;
    }

    public int getContainer() {
        return container;
    }

    public int getNumber() {
        return number;
    }
    
    public boolean loadShip(int addContainer) {
        boolean complete = false;
        int futureContainer = container + addContainer;
        
        if (futureContainer <= MAX_SIZE_CONTAINER) {
            container = futureContainer;
            complete = true;
        } 
        return complete;
    }
    
    public boolean unloadShip(int removeContainer) {
        boolean complete = false;
        int futureContainer = container - removeContainer;
        
        if (futureContainer >= 0) {
            container = futureContainer;
            complete = true;
        } 
        return complete;
    }

    public int getSize() {
        return MAX_SIZE_CONTAINER;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" + "number=" + number + ", container=" + container + ", target=" + target + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.number;
        hash = 59 * hash + this.container;
        hash = 59 * hash + Objects.hashCode(this.target);
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
        final Ship other = (Ship) obj;
        if (this.number != other.number) {
            return false;
        }
        if (this.container != other.container) {
            return false;
        }
        if (this.target != other.target) {
            return false;
        }
        return true;
    }
    
    
    
}
