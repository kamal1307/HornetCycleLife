package esi.atl5.balde_elbejjati_kayani.hornet.model;

import esi.alt5.balde_elbejjati_kayani.hornet.business.FacadeDB;
import esi.alt5.balde_elbejjati_kayani.hornet.exception.BusinessException;
import esi.alt5.balde_elbejjati_kayani.hornet.exception.DBException;
import esi.alt5.balde_elbejjati_kayani.hornet.persistance.dto.HornetDTO;
import esi.atl5.balde_elbejjati_kayani.hornet.mvc.HornetModel;
import esi.atl5.balde_elbejjati_kayani.hornet.mvc.HornetState;
import esi.atl5.balde_elbejjati_kayani.hornet.mvc.HornetView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
//

/**
 * represente the facade of game
 *
 * @author Alpha,Mohamed,Kamal
 */
public class Game extends Observable implements HornetModel {

    private HornetState state;
    private Season season;
    private final Board aBoard;
    //@pbt pq pas private ? 
    List<HornetView> listeView;

    /**
     * constructor of game
     *
     * @param aBoard the board
     */
    public Game(Board aBoard) {
        this.aBoard = aBoard;
        this.listeView = new ArrayList<HornetView>();

    }

    /**
     * the method who manages birth, the survival and the death of a hornet
     */
    @Override
    public void play() {
        ArrayList<Position> hornetBorn = new ArrayList<>(), 
                hornetDeath = new ArrayList<>(), 
                hornetDeathToAlive = new ArrayList<>();
        for (int i = 0; i < aBoard.getColumn(); i++) {
            for (int j = 0; j < aBoard.getRow(); j++) {
                Position pos = new Position(i, j);
                Hornet fr = aBoard.getHornetAtPos(pos); //@pbt s/fr/currentHornet
                ArrayList<Position> voisinp = aBoard.getNeighbour(pos);
                if (fr == null) {
                    long nbv = voisinp
                            .stream()
                            .filter(e -> (aBoard.getHornetAtPos(e) != null 
                                    && aBoard.getHornetAtPos(e).isALive()))
                            .count();
                    if (nbv == 3 && aBoard.getSeason() != Season.WINTER) {
                        hornetBorn.add(pos);
                    }
                } else {
                    if (fr.isALive()) {
                        long nbv = voisinp
                                .stream()
                                .filter(e -> aBoard.getHornetAtPos(e) != null 
                                        && aBoard.getHornetAtPos(e).isALive())
                                .count();
                        //@pbt trop de ()
                        if (nbv != 2 && nbv != 3 
                                || aBoard.getSeason() == Season.WINTER 
                                || fr.getAge() > 5) {
                            hornetDeath.add(pos);
                        }
                    } else {
                        long nbv = voisinp
                                .stream()
                                .filter(e -> aBoard.getHornetAtPos(e) != null && aBoard.getHornetAtPos(e).isALive())
                                .count();
                        if (nbv == 3) {
                            hornetDeathToAlive.add(pos);
                        }
                    }
                }

            }
        }

        IncrementAge();
        notifyView();
        hornetDeath.forEach(p -> aBoard.setAlive(p, false));
        hornetBorn.forEach(n -> aBoard.putHornet(new Hornet(aBoard.getRandomSex(), aBoard.getSeason()), n));
        hornetDeathToAlive.forEach(x -> aBoard.setAlive(x, true));
        insertHornetDB();
//        try {
//            FacadeDB.selectHornet();
//        } catch (BusinessException | DBException ex) {
//            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
//        }
        setChanged();
        notifyObservers();
    }

    private void insertHornetDB() throws AssertionError {
        try {
//            FacadeDB.deleteHornet();
            for (int i = 0; i < aBoard.getColumn(); i++) {
                for (int j = 0; j < aBoard.getRow(); j++) {
                    if (aBoard.getHornetAtPos(new Position(i, j)) != null) {
                        int role = 0;
                        Role r = aBoard.getHornetAtPos(new Position(i, j)).getRole();
                        switch (r) {
                            case FACTORY:
                                role = 1;
                                break;
                            case FOUNDER:
                                role = 2;
                                break;
                            case COUPLING:
                                role = 3;
                                break;
                            default:
                                throw new AssertionError();
                        }
                        FacadeDB.insertHornet(new HornetDTO((i+1)*(j+1), role, aBoard.getHornetAtPos(new Position(i, j)).getSexe()));
                    }

                }
            }
            
        } catch (BusinessException | DBException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * method who changes the age of hornets
     */
    void IncrementAge() {
        for (int i = 0; i < aBoard.getColumn(); i++) {
            for (int j = 0; j < aBoard.getRow(); j++) {
                if (aBoard.getHornetAtPos(new Position(i, j)) != null) {
                    aBoard.setAge(new Position(i, j));
                }

            }
        }
    }
    

    public Board getaBoard() {
        return aBoard;
    }

    @Override
    public HornetState getState() {
        return this.state;
    }

    @Override
    public void addHornetListener(HornetView add) {
        this.listeView.add(add);
    }

    @Override
    public void removeHornetListener(HornetView add) {
        this.listeView.add(add);
        notifyView();
    }

    public void notifyView() {
        for (HornetView view : this.listeView) {
            view.update();
        }
    }

    /**
     * 
     * @return 
     */
    public int getNbAlive() {

        return aBoard.getNbAlive();
    }

}
