package esi.atl5.balde_elbejjati_kayani.hornet.model;

import esi.atl5.balde_elbejjati_kayani.hornet.model.Position;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for Position class..
 * @author Mohamed Lb
 */
public class PositionTest {
    
    /**
     * Test if x is correct.
     */
    @Test
    public void PositionTestCas1() {
        Position p = new Position (2,4);
        assertEquals(2,p.getAbs());
    }
    
    /**
     * Test if y is correct.
     */
    @Test
    public void PositionTestCas2() {
        Position p = new Position (2,4);
        assertEquals(4,p.getOrd());
    }

    /**
     * Test if x is moved.
     */
    @Test
    public void testMoveCas1() {
        Position p = new Position (2,4);
        p.move(1, 5);
        assertEquals(3,p.getAbs());    
    }
    
    /**
     * Test if y is moved.
     */
    @Test
    public void testMoveCas2() {
        Position p = new Position (2,4);
        p.move(1, 5);
        assertEquals(9,p.getOrd());   
    }

  

}
