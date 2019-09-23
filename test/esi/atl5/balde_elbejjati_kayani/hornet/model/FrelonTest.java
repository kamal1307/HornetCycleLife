package esi.atl5.balde_elbejjati_kayani.hornet.model;

import esi.atl5.balde_elbejjati_kayani.hornet.model.Role;
import esi.atl5.balde_elbejjati_kayani.hornet.model.Hornet;
import esi.atl5.balde_elbejjati_kayani.hornet.model.Season;
import esi.atl5.balde_elbejjati_kayani.hornet.model.Sexe;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mohamed Lb
 */
public class FrelonTest {

    /**
     * Check if object is correct.
     */
    @Test
    public void FrelonTestCas1() {
        Hornet f = new Hornet(Sexe.FEMALE, Season.AUTUMN);
        assertEquals(Sexe.FEMALE, f.getSexe());
    }

    /**
     * Check if begining, frelon is alive.
     */
    @Test
    public void testEstVivant() {
        Hornet f = new Hornet(Sexe.FEMALE, Season.AUTUMN);
        assertTrue(f.isALive());
    }

    /**
     * Test if change state of life.
     */
    @Test
    public void testSetEstVivant() {
        Hornet f = new Hornet(Sexe.FEMALE, Season.AUTUMN);
        f.setAlive(false);
        assertFalse(f.isALive());
    }

    /**
     * Test if age of a frelon alive increment.
     */
    @Test
    public void testSetAge() {
        Hornet f = new Hornet(Sexe.FEMALE, Season.AUTUMN);
        f.setAge();
        assertEquals(1, f.getAge());
    }
    
    /**
     * Test if age of a frelon dead = -1.
     */
    @Test
    public void testSetAge2() {
        Hornet f = new Hornet(Sexe.FEMALE, Season.AUTUMN);
        f.setAlive(false);
        f.setAge();
        assertEquals(-1, f.getAge());
    }

    /**
     * Test if change state of sexe.
     */
    @Test
    public void testSetSexe() {
        Hornet f = new Hornet(Sexe.FEMALE, Season.AUTUMN);
        f.setSexe(Sexe.MALE);
        assertEquals(Sexe.MALE, f.getSexe());
    }

    /**
     * Test if change state of role.
     */
    @Test
    public void testSetRole() {
        Hornet f = new Hornet(Sexe.FEMALE, Season.AUTUMN);
        f.setRole(Role.FACTORY);
        assertEquals(Role.FACTORY, f.getRole());
    }

}
