/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task03.thread;

import by.epam.task03.entity.Moorage;
import by.epam.task03.entity.Port;
import by.epam.task03.entity.Ship;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.log4j.Logger;

/**
 *
 * @author Dima
 */
public class Crane implements Runnable {

    private final static Logger logger = Logger.getLogger(Crane.class);

    private Lock lock = new ReentrantLock();
    private Random rand;
    private Port port;
    private Moorage moorage;
    private int numberMoorage;

    public Crane(Port port, Moorage moorage, int numberMoorage) {
        rand = new Random();
        this.port = port;
        this.moorage = moorage;
        this.numberMoorage = numberMoorage;
    }

    @Override
    public void run() {
        logger.warn("Кран № " + moorage.getNumberMoorage() + " заработал.");
        Ship ship;
        while (true) {
            lock.lock();
            try {
                if (!moorage.isEmpty()) {
                    logger.warn("Кран № " + moorage.getNumberMoorage() + " корабль заблокирован.");
                    ship = moorage.getMoorShip();

                    switch (ship.getTarget()) {
                        case LOAD_PORT:
                            logger.warn("Загрузка корабля - " + ship.getNumber());
                            loadingShip(ship);
                            break;
                        case UNLOAD_PORT:
                            logger.warn("Разгрузка корабля - " + ship.getNumber());
                            unloadingShip(ship);
                            break;
                        case LOAD_SHIP_TO_SHIP:
                            logger.warn("Перегрузка корабль-корабль");
                            loadShipToShip(ship);
                            break;
                        case UNLOAD_SHIP_TO_SHIP:
                            logger.warn("Перегрузка корабль-корабль");
                            unloadShipToShip(ship);
                            break;
                    }
                    moorage.unmoorShip();

                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void loadingShip(Ship ship) {

        int loadShipContainer = ship.getSize() - ship.getContainer();

        if (port.unloadStorehouse(loadShipContainer) && ship.loadShip(loadShipContainer)) {
            //loading true
            logger.warn("Успешная загрузка корабля - " + ship.getNumber());
        } else {
            //loading false
            logger.error("Неуспешная загрузка корабля - " + ship.getNumber());
        }

    }

    private void unloadingShip(Ship ship) {

        if (port.loadStorehouse(ship.getContainer()) && ship.unloadShip(ship.getContainer())) {
            //unloading true
            logger.warn("Успешная разгрузка корабля - " + ship.getNumber());
            
        } else {
            //unloading false
            logger.error("Неуспешная разгрузка корабля - " + ship.getNumber());
        }
    }

    private void loadShipToShip(Ship ship) {

        int numberContainer = rand.nextInt(ship.getSize());
        int nextNumberMoorage = (numberMoorage + 1) % 3;
        
        if (!port.getMoorage(nextNumberMoorage).isEmpty()) {
       
            Ship shipOther = port.getMoorage(nextNumberMoorage).getMoorShip();
            if (shipOther.loadShip(numberContainer)) {
                logger.warn("Перегрузка на другой корабль успешно завершена.");
                ship.unloadShip(numberContainer);
            } else {
                logger.warn("Перегрузка на другой корабль невозможна, перегружаем в склад");
                port.loadStorehouse(numberContainer);
            }
            port.getMoorage(nextNumberMoorage).unmoorShip();
        }
    }

    private void unloadShipToShip(Ship ship) {

        int numberContainer = rand.nextInt(ship.getSize());
        int nextNumberMoorage = (numberMoorage + 1) % 3;
        
        if (!port.getMoorage(nextNumberMoorage).isEmpty()) {
            Ship shipOther = port.getMoorage(nextNumberMoorage).getMoorShip();
            if (shipOther.unloadShip(numberContainer)) {
                logger.warn("Перегрузка на другой корабль успешно завершена.");
                ship.loadShip(numberContainer);
            } else {
                logger.warn("Перегрузка на другой корабль невозможна, перегружаем в склад");
                port.loadStorehouse(numberContainer);
            }
            port.getMoorage(nextNumberMoorage).unmoorShip();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + "lock=" + lock + ", rand=" + rand + ", port=" + port + ", moorage=" + moorage + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.lock);
        hash = 59 * hash + Objects.hashCode(this.rand);
        hash = 59 * hash + Objects.hashCode(this.port);
        hash = 59 * hash + Objects.hashCode(this.moorage);
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
        final Crane other = (Crane) obj;
        if (!Objects.equals(this.lock, other.lock)) {
            return false;
        }
        if (!Objects.equals(this.rand, other.rand)) {
            return false;
        }
        if (!Objects.equals(this.port, other.port)) {
            return false;
        }
        if (!Objects.equals(this.moorage, other.moorage)) {
            return false;
        }
        return true;
    }

}
