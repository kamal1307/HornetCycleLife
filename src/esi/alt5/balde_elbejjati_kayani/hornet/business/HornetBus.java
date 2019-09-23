package esi.alt5.balde_elbejjati_kayani.hornet.business;

import esi.alt5.balde_elbejjati_kayani.hornet.exception.BusinessException;
import esi.alt5.balde_elbejjati_kayani.hornet.exception.DBException;
import esi.alt5.balde_elbejjati_kayani.hornet.persistance.dto.HornetDTO;
import esi.atl5.balde_elbejjati_kayani.hornet.db.HornetDB;
import esi.atl5.balde_elbejjati_kayani.hornet.db.RoleDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class business of table hornets.
 * @author Balde El Bejjati Kayani
 */
public class HornetBus {
    
    /**
     * adding hornet in database.
     * @param hDTO
     * @throws BusinessException
     * @throws DBException 
     */
    static void insert(HornetDTO hDTO) throws BusinessException, DBException {
        try {
            HornetDB.insertHornet(hDTO);
        } catch (DBException ex) {
            throw new BusinessException(ex.getMessage());
        }
    }
    
    /**
     * Show table of hornet.
     * @throws BusinessException 
     */
    static void select() throws BusinessException{
        try {
            HornetDB.selectAllTable();
        } catch (SQLException ex) {
            Logger.getLogger(HornetBus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Delete table hornets.
     * @throws BusinessException 
     */
    static void delete() throws BusinessException {
        try {
            HornetDB.delete();
        } catch (DBException ex) {
            throw new BusinessException(ex.getMessage());
        }
    }
}
