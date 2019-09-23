package esi.atl5.balde_elbejjati_kayani.hornet.mvc;

import esi.atl5.balde_elbejjati_kayani.hornet.model.Hornet;

/**
 * Interface for observable
 * @author Alpha,Mohamed,Kamal
 */
public interface HornetModel {

    /**
     * return state of model
     */
    HornetState getState();
    /**
     * add an observable
     */
    public void addHornetListener(HornetView add);
    /**
     * remove an observable
     */
    public void removeHornetListener(HornetView add);
    /**
     * next generation step
     */
    void play();
}
