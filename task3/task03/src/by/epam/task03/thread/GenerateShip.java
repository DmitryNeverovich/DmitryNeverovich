/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task03.thread;

import by.epam.task03.entity.Action;
import by.epam.task03.entity.Acvatory;
import by.epam.task03.entity.Ship;
import java.util.Random;
import org.apache.log4j.Logger;

/**
 *
 * @author Dima
 */
public class GenerateShip implements Runnable {

    private final static Logger logger = Logger.getLogger(GenerateShip.class);

    private Random rand;
    private Action[] action = Action.values();
    private Ship ship;
    private Acvatory acvatory;

    public GenerateShip(Acvatory acvatory) {
        this.acvatory = acvatory;
        rand = new Random();
    }

    @Override
    public void run() {
        try {
            int ID = 0;
            Action randomAction;
            int randomContainer;           
            logger.warn("Генератор караблей заработал");
            while (true) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }    
                
                randomAction = action[rand.nextInt(action.length)];
                randomContainer = rand.nextInt(100);
                ship = new Ship(ID, randomContainer, randomAction);
                acvatory.addShip(ship);
                ID++;
            }
        } catch (InterruptedException e) {
            logger.warn("Генератор караблей закончил работу");
        }
    }

}
