
package esi.atl5.balde_elbejjati_kayani.hornet.model;

/**
 * represente sex of a hornet
 *@author Alpha,Mohamed,Kamal
 */
public enum Sexe {
    
    MALE ("M"),FEMALE("F");
    
    private String str ="";
    
    Sexe(String sexe){
        str = sexe;
    }
    
    public String toString (){
        
        return str;
    }
}
