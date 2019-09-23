
package esi.atl5.balde_elbejjati_kayani.hornet.model;

/**
 *
 * @author User
 */
public enum Ratio {
    
    LOW(10),MEDIUM(5),HIGH(2);
    private final int value;

    private Ratio(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    
    
}
