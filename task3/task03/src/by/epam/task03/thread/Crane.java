/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task03.thread;

import by.epam.task03.entity.Action;
import by.epam.task03.entity.Moorage;
import by.epam.task03.entity.Port;
import by.epam.task03.entity.Ship;
import java.util.Random;
import org.apache.log4j.Logger;

/**
 *
 * @author Dima
 */
public class Crane implements Runnable {

    private final static Logger logger = Logger.getLogger(Crane.class);

    private Random rand;
    private Port port;
    private Moorage moorage;

    public Crane(Port port, Moorage moorage) {
        rand = new Random();
        this.moorage = moorage;
        this.port = port;
    }

    @Override
    public void run() {
        Ship ship;
        while (true) {
            if (!moorage.isEmpty()) {
                logger.warn("Кран начал работать на причале номер:"+moorage.getNumberMoorage());
                ship = moorage.getMoorShip();
                int numberContainer = rand.nextInt();
                if (ship.getAction() == Action.LOADING) {
                    logger.warn("Загрузка корабля - "+ship.getNumber());
                    if (port.unloadStorehouse(numberContainer) && ship.loadShip(numberContainer)) {
                        //loading true
                        logger.warn("Успешная загрузка корабля - "+ship.getNumber());
                    } else {
                        //loading false
                        logger.warn("Неуспешная загрузка корабля - "+ship.getNumber());
                    }
                } else {
                    logger.warn("Разгрузка корабля - "+ship.getNumber());
                    if (port.loadStorehouse(numberContainer) && ship.unloadShip(numberContainer)) {
                        logger.warn("Успешная разгрузка корабля - "+ship.getNumber());
                        //unloading true
                    } else {
                        logger.warn("Неуспешная разгрузка корабля - "+ship.getNumber());
                        //unloading false
                    }
                }
                logger.warn("Корабль уплыл - "+ship.getNumber()+" с причала "+moorage.getNumberMoorage());
                moorage.unmoorShip();
                
            }

        }
    }

}
