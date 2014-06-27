/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task03.thread;

import by.epam.task03.entity.Target;
import by.epam.task03.entity.Acvatory;
import by.epam.task03.entity.Ship;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import org.apache.log4j.Logger;

/**
 *
 * @author Dima
 */
public class GenerateShip implements Runnable {

    private final static Logger logger = Logger.getLogger(GenerateShip.class);

    private Random rand;
    private Target[] action = Target.values();
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
            Target randomAction;
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

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" + "rand=" + rand + ", action=" + action + ", ship=" + ship + ", acvatory=" + acvatory + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.rand);
        hash = 59 * hash + Arrays.deepHashCode(this.action);
        hash = 59 * hash + Objects.hashCode(this.ship);
        hash = 59 * hash + Objects.hashCode(this.acvatory);
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
        final GenerateShip other = (GenerateShip) obj;
        if (!Objects.equals(this.rand, other.rand)) {
            return false;
        }
        if (!Arrays.deepEquals(this.action, other.action)) {
            return false;
        }
        if (!Objects.equals(this.ship, other.ship)) {
            return false;
        }
        if (!Objects.equals(this.acvatory, other.acvatory)) {
            return false;
        }
        return true;
    }
    
}
