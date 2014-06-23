/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Dima
 */
public class Acvatory {

    private static final int CAPACITY = 30;
    private BlockingQueue<Ship> queue;
    private Port port;

    public Acvatory(Port port) {
        queue = new ArrayBlockingQueue<Ship>(CAPACITY);
        this.port = port;
    }
    
    public boolean addShip(Ship ship){
       return queue.offer(ship);
    }

    public Ship getShip(){
        return queue.poll();
    }
        
    public Port getPort() {
        return port;
    }

}
