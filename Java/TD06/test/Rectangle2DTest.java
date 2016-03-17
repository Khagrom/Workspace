/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author p1513113
 */
public class Rectangle2DTest {
    
    public Rectangle2DTest() {
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
     * Test of surface method, of class Rectangle2D.
     */
    @Test
    public void testSurface() {
        System.out.println("surface");
        Rectangle2D instance = null;
        double expResult = 0.0;
        double result = instance.surface();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of perimetre method, of class Rectangle2D.
     */
    @Test
    public void testPerimetre() {
        System.out.println("perimetre");
        Rectangle2D instance = null;
        double expResult = 0.0;
        double result = instance.perimetre();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getS1 method, of class Rectangle2D.
     */
    @Test
    public void testGetS1() {
        System.out.println("getS1");
        Rectangle2D instance = null;
        Segment2D expResult = null;
        Segment2D result = instance.getS1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getS2 method, of class Rectangle2D.
     */
    @Test
    public void testGetS2() {
        System.out.println("getS2");
        Rectangle2D instance = null;
        Segment2D expResult = null;
        Segment2D result = instance.getS2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getS3 method, of class Rectangle2D.
     */
    @Test
    public void testGetS3() {
        System.out.println("getS3");
        Rectangle2D instance = null;
        Segment2D expResult = null;
        Segment2D result = instance.getS3();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getS4 method, of class Rectangle2D.
     */
    @Test
    public void testGetS4() {
        System.out.println("getS4");
        Rectangle2D instance = null;
        Segment2D expResult = null;
        Segment2D result = instance.getS4();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Rectangle2D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Rectangle2D instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Rectangle2D.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Rectangle2D instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deplace method, of class Rectangle2D.
     */
    @Test
    public void testDeplace() {
        System.out.println("deplace");
        double dx = 0.0;
        double dy = 0.0;
        Rectangle2D instance = null;
        instance.deplace(dx, dy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estIdentique method, of class Rectangle2D.
     */
    @Test
    public void testEstIdentique() {
        System.out.println("estIdentique");
        Object o = null;
        Rectangle2D instance = null;
        boolean expResult = false;
        boolean result = instance.estIdentique(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of affiche method, of class Rectangle2D.
     */
    @Test
    public void testAffiche() {
        System.out.println("affiche");
        Rectangle2D instance = null;
        instance.affiche();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class Rectangle2D.
     */
    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        Rectangle2D instance = null;
        Rectangle2D expResult = null;
        Rectangle2D result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
