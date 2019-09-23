package esi.alt5.balde_elbejjati_kayani.hornet.business;

import esi.alt5.balde_elbejjati_kayani.hornet.exception.BusinessException;
import esi.alt5.balde_elbejjati_kayani.hornet.exception.DBException;
import esi.alt5.balde_elbejjati_kayani.hornet.persistance.dto.HornetDTO;
import esi.alt5.balde_elbejjati_kayani.hornet.persistance.dto.RoleDTO;
import esi.atl5.balde_elbejjati_kayani.hornet.db.DbManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe facade for use DB.
 * @author Balde El Bejjati Kayani
 */
public class FacadeDB {
    
    /**
     * adding hornet in database.
     * @param hDTO
     * @throws BusinessException
     * @throws DBException
     */
    public static void insertHornet(HornetDTO hDTO) throws BusinessException, 
            DBException {
        try {
            DbManager.startTransaction();
            HornetBus.insert(hDTO);
            DbManager.validateTransaction();
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DbManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new BusinessException("Hornet don't added \n" + msg);
            }
        }
    } 
   
    /**
     * Show table of hornet.
     * @throws BusinessException
     * @throws DBException
     */
    public static void selectHornet() throws BusinessException, DBException {
        try {
            DbManager.startTransaction();
            HornetBus.select();
            DbManager.validateTransaction();
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DbManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new BusinessException("View don't available \n" + msg);
            }
        }
    }
   
    /**
     * Delete table hornets
     * @throws BusinessException
     * @throws DBException
     */
    public static void deleteHornet() throws BusinessException, DBException {

        try {
            DbManager.startTransaction();
            HornetBus.delete();
            DbManager.validateTransaction();
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DbManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new BusinessException("Table don't deleted \n" + msg);
            }
        }
    }
   
    /**
     * adding roles
     * @param rDTO
     * @throws BusinessException
     * @throws DBException
     */
    public static void insertRole(RoleDTO rDTO) throws BusinessException, DBException {
        try {
            DbManager.startTransaction();
            RoleBus.insert(rDTO);
            DbManager.validateTransaction();
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DbManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new BusinessException("Role don't added \n" + msg);
            }
        }
    } 
   
    /**
     * Show tabe of role
     * @throws BusinessException
    // * @throws DBException
     */
    public static void selectRole() throws BusinessException{ //, DBException {
        try {
            DbManager.startTransaction();
            RoleBus.select();
            DbManager.validateTransaction();
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DbManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new BusinessException("View don't avaible \n" + msg);
            }
        }
    }
   
    /**
     * Delete table role
     * @throws BusinessException
 //@pbt suppression trows DBException
     */
    public static void deleteRole() throws BusinessException {

        try {
            DbManager.startTransaction();
            RoleBus.delete();
            DbManager.validateTransaction();
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DbManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new BusinessException("Table don't deleted \n" + msg);
            }
        }
    }
   
    /**
     * Create table hornets and role if don't exists.
     * @throws SQLException
     * @throws Exception
     */
    public static void createTables () throws SQLException, Exception{
       Connection connexion = DbManager.createConnection();
       if (!DbManager.isExists()) {
           DbManager.createTable();
       }else{
           //@pbt pas sout ici
           System.out.println("Tables already exist");
       }
   }
   
    /**
     * Launch connection for database
     * @throws SQLException
     */
    public static void connexion () throws SQLException{
       DbManager.createConnection();
   }
}
