package esi.alt5.balde_elbejjati_kayani.hornet.exception;

//@pbt exceptions inutiles (DTOException)

/**
 * Exception controller for package db.
 * @author balde El Bejjati Kayani
 */
public class DBException extends HornetException {
    
    /**
     * Default constructor
     */
    public DBException (){
        
    }
    
    /**
     * Make a message when error lunched
     * @param msg
     */
    public DBException (String msg){
        super (msg);
    }
}
