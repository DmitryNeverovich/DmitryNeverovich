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
public class MoorageTest {
        
    private Port port;
    private Acvatory acvatory;
    private ExecutorService ex;
    
    public MoorageTest() {
        port = new Port(3);
        Acvatory acvatory = new Acvatory(port);
        
        ExecutorService ex = Executors.newCachedThreadPool();
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
     * Test of isEmpty method, of class Moorage.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Moorage instance = port.getMoorage(0);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of moorShip method, of class Moorage.
     */
    @Test
    public void testMoorShip() {
        System.out.println("moorShip");
        Ship ship = new Ship(1, 132, Target.LOAD_PORT);
        Moorage instance = port.getMoorage(0);
        boolean expResult = true;
        boolean result = instance.moorShip(ship);
        assertEquals(expResult, result);
    }

    /**
     * Test of unmoorShip method, of class Moorage.
     */
    @Test
    public void testUnmoorShip() {
        System.out.println("unmoorShip");
        Moorage instance = port.getMoorage(0);
        boolean expResult = false;
        boolean result = instance.unmoorShip();
        assertEquals(expResult, result);
    }
    
}
