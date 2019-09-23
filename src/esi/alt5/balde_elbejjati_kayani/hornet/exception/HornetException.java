package esi.alt5.balde_elbejjati_kayani.hornet.exception;

/**
 * Exception controller for all game.
 * @author balde El Bejjati Kayani
 */
public class HornetException extends Exception {

    /**
     *Default constructor
     */
    public HornetException() {

    }

    /**
     * Make a message when error lunched
     * @param msg
     */
    public HornetException(String msg) {
        super(msg);
    }
}
