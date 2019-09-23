package esi.atl5.balde_elbejjati_kayani.hornet.db;

import esi.alt5.balde_elbejjati_kayani.hornet.exception.DBException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for create tables and commit manager
 *
 * @author balde El Bejjati Kayani
 */
public class DbManager {

    static final String DB_URL = "jdbc:derby:Projet;create=true";
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

    //  Database credentials
    private final String USER = "username";
    private final String PASS = "password";
    private static Connection conn = null;
    private static Statement stmt = null;

    /**
     *
     * @throws SQLException
     */
    public DbManager() throws SQLException {
        createConnection();
        createTable();
    }

    /**
     * Create a connection with database
     *
     * @return
     * @throws SQLException
     */
    public static Connection createConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL);
            //@pbt choisir si exception c'est e, ex ,except pour un peu de 
            // cohérence
        } catch (SQLException except) {
            //@pbt tu gères SQLException alors pq throws
            except.printStackTrace();
        }
        return conn;

    }

    //@pbt que testes-tu ? 
    /**
     * Ckeck if table existe
     *
     * @return true if tables existe
     * @throws Exception
     */
    public static boolean isExists() throws Exception {
        boolean exist = false;
        try {
            Class.forName(DRIVER);
            conn = createConnection();
            exist = (conn != null);
        } catch (ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return exist;
    }

    /**
     * Create a table for insert new account.
     *
     * @throws SQLException
     */
    public static void createTable() throws SQLException {

        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet result = metaData.getTables(null, null, "Hornet", null);

        if (!result.next()) {
            conn.createStatement().execute("DROP TABLE HORNETS");
            conn.createStatement().executeUpdate("Create TABLE Hornets (ID Integer "
                    + ", SEX varchar (1) not null, ROLEID Integer)");
            System.out.println("Table created successfully...");
        }

        result = metaData.getTables(null, null, "Role", null);
        if (!result.next()) {
            conn.createStatement().executeUpdate("CREATE TABLE Role (RoleID Integer "
                    + "UNIQUE, RoleLib varchar (25) not null)");
            System.out.println("Table created successfully...");
        }

        conn.createStatement().executeUpdate("ALTER TABLE Hornets ADD CONSTRAINT Hornet_FK" +
"Foreign Key (RoleID) REFERENCES Role (RoleID)");

    }

    /**
     * Start a transaction
     *
     * @throws esi.alt5.balde_elbejjati_kayani.hornet.exception.DBException
     */
    public static void startTransaction() throws DBException {
        try {
            createConnection().setAutoCommit(false);
        } catch (SQLException ex) {
            throw new DBException("Transaction failed: " + ex.getMessage());
        }
    }

    /**
     * Validate the current transaction
     *
     * @throws esi.alt5.balde_elbejjati_kayani.hornet.exception.DBException
     */
    public static void validateTransaction() throws DBException {
        try {
            createConnection().commit();
            createConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new DBException("Transaction failed: " + ex.getMessage());
        }
    }

    /**
     * Cancel the transaction
     *
     * @throws esi.alt5.balde_elbejjati_kayani.hornet.exception.DBException
     */
    public static void cancelTransaction() throws DBException {
        try {
            createConnection().rollback();
            createConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new DBException("Transaction failed: " + ex.getMessage());
        }
    }

}
