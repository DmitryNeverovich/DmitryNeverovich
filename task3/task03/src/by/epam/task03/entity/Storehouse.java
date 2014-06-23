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
    private static final int MAX_CAPACITY = 1000;
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
}
