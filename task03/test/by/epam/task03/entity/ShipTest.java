/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

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
public class ShipTest {
    
    public ShipTest() {
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
     * Test of getTarget method, of class Ship.
     */
    @Test
    public void testGetTarget() {
        System.out.println("getTarget");
        Ship instance = new Ship(12, 1, Target.LOAD_PORT);
        Target expResult = Target.LOAD_PORT;
        Target result = instance.getTarget();
        assertEquals(expResult, result);
    }

    /**
     * Test of getContainer method, of class Ship.
     */
    @Test
    public void testGetContainer() {
        System.out.println("getContainer");
        Ship instance = new Ship(12, 1, Target.LOAD_PORT);
        int expResult = 1;
        int result = instance.getContainer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class Ship.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        Ship instance = new Ship(12, 1, Target.LOAD_PORT);
        int expResult = 12;
        int result = instance.getNumber();
        assertEquals(expResult, result);

    }

    /**
     * Test of loadShip method, of class Ship.
     */
    @Test
    public void testLoadShip() {
        System.out.println("loadShip");
        int addContainer = 0;
        Ship instance =  new Ship(12, 1, Target.LOAD_PORT);
        boolean expResult = true;
        boolean result = instance.loadShip(addContainer);
        assertEquals(expResult, result);
    }

    /**
     * Test of unloadShip method, of class Ship.
     */
    @Test
    public void testUnloadShip() {
        System.out.println("unloadShip");
        int removeContainer = 0;
        Ship instance = new Ship(12, 1, Target.LOAD_PORT);
        boolean expResult = true;
        boolean result = instance.unloadShip(removeContainer);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class Ship.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Ship instance = new Ship(12, 1, Target.LOAD_PORT);;
        int expResult = 200;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

}
