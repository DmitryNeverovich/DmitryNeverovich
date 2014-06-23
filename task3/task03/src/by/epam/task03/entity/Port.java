/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task03.entity;

import by.epam.task03.thread.GenerateShip;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Dima
 */
public class Port {
    
    private Storehouse storehouse;
    private CopyOnWriteArrayList<Moorage> moorages;

    public Port(int numberMoorage) {
        storehouse = new Storehouse();
        moorages = new CopyOnWriteArrayList<Moorage>();
        for (int i = 0; i < numberMoorage; i++) {
            moorages.add(new Moorage(i));
        }   
    }
    
    public CopyOnWriteArrayList<Moorage> getListMoorages(){
        return moorages;
    }
    
    public Moorage getMoorage(int number){
        return moorages.get(number);
    }
    
    public boolean loadStorehouse(int conatiners){
        return storehouse.addContainers(conatiners);
    }
    
    public boolean unloadStorehouse(int conatiners){
        return storehouse.removeContainers(conatiners);
    }
 
}
