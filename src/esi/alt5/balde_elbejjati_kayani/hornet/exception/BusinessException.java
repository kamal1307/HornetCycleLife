package esi.alt5.balde_elbejjati_kayani.hornet.exception;

/**
 * Exception controller for package business.
 * @author balde El Bejjati Kayani
 */
public class BusinessException extends HornetException {

    /**
     * Default costructor
     */
    public BusinessException (){
        
    }
    
    /**
     * Make a message when error lunched
     * @param msg
     */
    public BusinessException (String msg){
        super (msg);
    }
}
