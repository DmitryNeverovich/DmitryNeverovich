/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import by.epam.task03.thread.GenerateShip;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dima
 */
public class AcvatoryTest {
    private Port port;
    private Acvatory acvatory;
    private ExecutorService ex;
    
    public AcvatoryTest() {
        port = new Port(3);
        acvatory = new Acvatory(port);
        ex = Executors.newCachedThreadPool();
        ex.execute(new GenerateShip(acvatory));
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addShip method, of class Acvatory.
     */
    @Test
    public void testAddShip() {
        System.out.println("addShip");
        Ship ship = new Ship(1, 25, Target.LOAD_PORT);
        boolean expResult = true;
        boolean result = acvatory.addShip(ship);
        assertEquals(expResult, result);

    }

    /**
     * Test of getShip method, of class Acvatory.
     */
    @Test
    public void testGetShip() {
        System.out.println("getShip");
        Acvatory instance = acvatory;
        Class expResult = Ship.class;
        Class result = instance.getShip().getClass();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPort method, of class Acvatory.
     */
    @Test
    public void testGetPort() {
        System.out.println("getPort");
        Acvatory instance = acvatory;
        Class expResult = Port.class;
        Class result = instance.getPort().getClass();
        assertEquals(expResult, result);
    }
}
