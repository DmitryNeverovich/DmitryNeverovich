/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.main;

import by.epam.task03.entity.Acvatory;
import by.epam.task03.entity.Port;
import by.epam.task03.entity.Ship;
import by.epam.task03.thread.Crane;
import by.epam.task03.thread.GenerateShip;
import by.epam.task03.thread.Longboat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Dima
 */
public class Task03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Port port = new Port(3);
        Acvatory acvatory = new Acvatory(port);
        
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(new GenerateShip(acvatory));
        ex.execute(new Longboat(acvatory));
        ex.execute(new Crane(port, port.getMoorage(0),0));
        ex.execute(new Crane(port, port.getMoorage(1),1));
        ex.execute(new Crane(port, port.getMoorage(2),2));        
        
        Thread.sleep(10000);
        
        ex.shutdown();
    }
    
}
