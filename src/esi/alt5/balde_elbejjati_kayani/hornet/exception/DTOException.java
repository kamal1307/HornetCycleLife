package esi.alt5.balde_elbejjati_kayani.hornet.exception;

/**
 * Exception controller for package dto.
 * @author balde El Bejjati Kayani
 */
public class DTOException extends HornetException {

    /**
     * Default constructor
     */
    public DTOException (){
        
    }
    
    /**
     * Make a message when error lunched
     * @param msg
     */
    public DTOException (String msg){
        super (msg);
    }
}
