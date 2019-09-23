package esi.atl5.balde_elbejjati_kayani.hornet.db;

import esi.alt5.balde_elbejjati_kayani.hornet.exception.DBException;
import esi.alt5.balde_elbejjati_kayani.hornet.persistance.dto.HornetDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Manage table hornet
 * @author balde El Bejjati Kayani
 */
public class HornetDB {
    
    /**
     * Insert information for all hornet.
     * @param hDTO
     * @throws DBException 
     */
     public static void insertHornet(HornetDTO hDTO) throws DBException {
         //@pbt throw SQLException c'est très bien. DBException inutile
        try {
            java.sql.Connection connexion = DbManager.createConnection();
            java.sql.PreparedStatement insert;
            insert = connexion.prepareStatement(
                    "Insert into Hornets(ID,Sex,RoleID) values(?,?,?)");
            insert.setInt(1, hDTO.getID());
            insert.setString(2, hDTO.getSex().toString());
            insert.setInt(3, hDTO.getRoleID());
            insert.execute();
        } catch (SQLException ex) {
            throw new DBException("Impossible insert values : " + ex.getMessage());
        }
    }
     
     /**
      * Deleted table hornet
      * @throws DBException 
      */
     public static void delete() throws DBException{
         java.sql.Statement stmt;
        try {
            //@pbt pg truncate et pas drop ?
            // soit la méthode s'appelle purge et tu truncate, 
            //soit delete et drop
            stmt = DbManager.createConnection().createStatement();
            stmt.execute("Truncate table Hornets");
        } catch (SQLException ex) {
            throw new DBException("Table don't delete" + ex.getMessage());
        }
    }
     
     /**
     * Show all Hornet.
     * @throws SQLException
     */
    public static  void selectAllTable() throws SQLException{
        try {
        java.sql.Connection connexion = DbManager.createConnection();
        java.sql.PreparedStatement select;
        select = connexion.prepareStatement("SELECT * FROM Hornets");
        ResultSet rs = select.executeQuery();
        System.out.println("==========ALL HORNETS============");
        while (rs.next()){
            System.out.println("[ID : "
                    + rs.getInt("ID")
                    +" ===SEX :" + rs.getString("SEX")
                    + " ===ROLEID : "+ rs.getInt("RoleID")+" ]");
        }
        System.out.println("================END================");
        System.out.println("");
    } catch (SQLException e){
            System.out.println(e.getMessage());
    }
    }

}
