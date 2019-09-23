package esi.atl5.balde_elbejjati_kayani.hornet.mvc;

import esi.atl5.balde_elbejjati_kayani.hornet.model.Hornet;
import esi.atl5.balde_elbejjati_kayani.hornet.model.Season;
import esi.atl5.balde_elbejjati_kayani.hornet.model.Sexe;
import java.io.Serializable;

/**
 * State of Hornet.
 * @author Alpha,Mohamed,Kamal 
 */
public class HornetState implements Serializable{
    private Hornet hornet;
    private Season season;
    private int nbListeners;

    /** Creates a new instance of State */
    public HornetState() {
        this.season = Season.AUTUMN;
        this.hornet = new Hornet (Sexe.FEMALE,season);
        
    }
    /** Creates a new instance of State */
    public HornetState(Hornet hornet, Season season){
        this.hornet = hornet;
        this.season = season;
    }

    /**
     * return hornet
     */
    public Hornet getHornet() {
        return this.hornet;
    }

    /**
     * Set a hornet
     * @param hornet 
     */
    void setHornet(Hornet hornet) {
        this.hornet = hornet;
    }

    /**
     * return season
     */
    public Season getSeason() {
        return season;
    }

    /**
     * set a season
     */
    void setSeason(Season season) {
        this.season = season;
    }

    
    /**
     * retunr nbr of observer
     */
    public int getNbListeners() {
        return nbListeners;
    }

    /**
     * set nbr of observer
     */
    void setNbListeners(int nbListeners) {
        this.nbListeners = nbListeners;
    }
}
