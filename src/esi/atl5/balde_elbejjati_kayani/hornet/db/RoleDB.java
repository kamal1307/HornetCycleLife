package esi.atl5.balde_elbejjati_kayani.hornet.db;

import esi.alt5.balde_elbejjati_kayani.hornet.exception.DBException;
import esi.alt5.balde_elbejjati_kayani.hornet.persistance.dto.RoleDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Manage table Role.
 * @author balde El Bejjati Kayani
 */
public class RoleDB {
    
    /**
     * added all information of role.
     * @param rDTO
     * @throws DBException 
     */
    public static void insertRole(RoleDTO rDTO) throws DBException {
        try {
            java.sql.Connection connexion = DbManager.createConnection();
            java.sql.PreparedStatement insert;

            insert = connexion.prepareStatement("Insert into Role(RoleID,RoleLib) values(?, ?)");
            insert.setInt(1, rDTO.getRoleID());
            insert.setString(2, rDTO.getRoleLib());
            
                        
            insert.execute();
        } catch (SQLException ex) {
            throw new DBException("Impossible insert values : " + ex.getMessage());
        }
    }
     /**
      * Deleted table role
      * @throws DBException 
      */
     public static void delete() throws DBException{
         java.sql.Statement stmt;
        try {
            stmt = DbManager.createConnection().createStatement();
            stmt.execute("Drop table Role");
        } catch (SQLException ex) {
            throw new DBException("Table don't delete" + ex.getMessage());
        }
    }
     
     /**
     * Show all role.
     * @throws SQLException
     */
    public static void selectAllTable() throws SQLException{
        try {
        java.sql.Connection connexion = DbManager.createConnection();
        java.sql.PreparedStatement select;
        select = connexion.prepareStatement("SELECT * FROM Role");
        ResultSet rs = select.executeQuery();
        System.out.println("==========ALL HORNET============");
        while (rs.next()){
            System.out.println("[RoleID : "+ rs.getInt("RoleID")+" ===Libelle :" + rs.getString("RoleLib")+ " ]");
        }
        System.out.println("===========END ============");
        System.out.println("");
    } catch (SQLException e){
            System.out.println(e.getMessage());
    }
    }
}
