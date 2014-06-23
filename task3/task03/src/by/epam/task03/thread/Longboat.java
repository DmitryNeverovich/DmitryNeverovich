/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task03.thread;

import by.epam.task03.entity.Acvatory;
import by.epam.task03.entity.Moorage;
import by.epam.task03.entity.Port;
import by.epam.task03.entity.Ship;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.log4j.Logger;

/**
 *
 * @author Dima
 */
public class Longboat implements Runnable {
    private final static Logger logger = Logger.getLogger( Longboat.class ); 
    
    private Acvatory acvatory;
    private Lock lock;

    public Longboat(Acvatory acvatory) {
        this.acvatory = acvatory;
        lock = new ReentrantLock();
    }

    @Override
    public void run() {
        Port port = acvatory.getPort();
        logger.warn("Баркас заработал.");
        while (true) {
            Iterator<Moorage> iterator = port.getListMoorages().iterator();
            while (iterator.hasNext()) {
                Moorage moorage = iterator.next();
                if (moorage.isEmpty()) {
                    Ship ship = acvatory.getShip();
                    if (ship != null) {
                        moorage.moorShip(ship);
                        logger.trace("Корабль пришвартовался. Корабль: "+ship.getNumber());
                    }
                }
            }
        }
    }
}
