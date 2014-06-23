/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task03.entity;

import java.util.Random;

/**
 *
 * @author Dima
 */
public class Ship {

    private static final int MAX_SIZE_CONTAINER = 200;
    private int number;
    private int container;
    private Action action;

    public Ship(int number, int conteiner, Action action) {
        this.number = number;
        this.container = container;
        this.action = action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
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

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" + "number=" + number + ", container=" + container + ", action=" + action + '}';
    }
    
    
    
}
