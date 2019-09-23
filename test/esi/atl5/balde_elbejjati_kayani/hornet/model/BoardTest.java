package esi.atl5.balde_elbejjati_kayani.hornet.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for Board class..
 * @author le_vif
 */
public class BoardTest {
    
   

    
  

    /**
     * Test if frelon change a dead frelon in alive frelon at one position.
     */
    @Test
    public void testChangeStatusAtPOS (){
        Board b = new Board(10, 15,Season.WINTER,Ratio.MEDIUM);
        Hornet f = b.getBoard_()[1][2];
        b.setAlive(new Position (1,2), true);
        boolean isAlive  = f.isALive();
        assertEquals (true, isAlive );
    }
    
    /**
     * Test if frelon change a dead frelon in alive frelon at one position.
     */
    @Test
    public void testGetFrelonAtPOS (){
        Board b = new Board(10, 15,Season.SUMMER,Ratio.MEDIUM);
        Hornet f = b.getBoard_()[1][2];
        Hornet f2 = b.getHornetAtPos(new Position (1,2));
        assertEquals(f2, f);
    }
    
    /**
     * Test if season is changed.
     */
    @Test
    public void testSetSaison (){
        Board b = new Board(10, 15,Season.SUMMER,Ratio.MEDIUM);
        b.setSeason(Season.SPRING);
        assertEquals(Season.SPRING,b.getSeason());
    }
    
   
    
}
