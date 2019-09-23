package esi.alt5.balde_elbejjati_kayani.hornet.persistance.dto;

import esi.atl5.balde_elbejjati_kayani.hornet.model.Sexe;

/**
 * Class for tranfer data of/for table hornets
 * @author balde El Bejjati Kayani
 */
public class HornetDTO {
    //@pbt id roleId sex
    private int ID;
    private int RoleID;
    private Sexe sex;

    /**
     * Constructor of HonertDTO
     * @param ID
     * @param RoleID
     * @param sex 
     */
    public HornetDTO(int ID, int RoleID, Sexe sex) {
        this.ID = ID;
        this.RoleID = RoleID;
        this.sex = sex;
    }

    /**
     * Obtain id Hornet
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * Obtain role of hornet
     * @return
     */
    public int getRoleID() {
        return RoleID;
    }

    /**
     * Obtain sex of hornet
     * @return
     */
    public Sexe getSex() {
        return sex;
    }

    /**
     * Modify id of hornet
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Modify role Id of hornet
     * @param RoleID
     */
    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    /**
     * Modify sex of hornet
     * @param sex
     */
    public void setSex(Sexe sex) {
        this.sex = sex;
    }
    
    
    
    
    
    
}
