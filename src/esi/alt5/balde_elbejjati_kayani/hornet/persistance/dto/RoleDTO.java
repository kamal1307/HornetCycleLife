package esi.alt5.balde_elbejjati_kayani.hornet.persistance.dto;

/**
 * Class for tranfer data of/for table role.
 * @author balde El Bejjati Kayani
 */
public class RoleDTO {
    private int RoleID;
    private String RoleLib;

    /**
     * Constructor of RoleDTO
     * @param RoleID
     * @param RoleLib
     */
    public RoleDTO(int RoleID, String RoleLib) {
        this.RoleID = RoleID;
        this.RoleLib = RoleLib;
    }

    /**
     * Obtain roleID
     * @return
     */
    public int getRoleID() {
        return RoleID;
    }

    /**
     * Obtain libelle of roleID
     * @return
     */
    public String getRoleLib() {
        return RoleLib;
    }

    /**
     * Modify roleID
     * @param RoleID
     */
    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    /**
     * Modify libelle of roleID
     * @param RoleLib
     */
    public void setRoleLib(String RoleLib) {
        this.RoleLib = RoleLib;
    }
    
    
    
}
