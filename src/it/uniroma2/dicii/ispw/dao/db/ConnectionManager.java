package it.uniroma2.dicii.ispw.dao.db;

import java.sql.*;

public class ConnectionManager {

    private static String USER = "ispw";
    private static String PASS = "ispw";
    private static String DB_URL = "jdbc:postgresql://localhost/ispw";
    private static String DRIVER_CLASS_NAME = "org.postgresql.Driver";

    // connectio pool
    private Connection connection = null;

    /**
     *
     * The inner-class LazyCointainer is loaded only at the first invocation of getInstance.
     * This activity results "thread-safe".
     * @author gulyx, andreeweb
     *
     */
    private static class LazyCointainer{
        public final static ConnectionManager sigletonInstance = new ConnectionManager();
    }

    protected ConnectionManager() {

        Connection conn = null;

        try {

            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Opened database successfully");

            this.connection = conn;

        } catch (Exception e) {

            e.printStackTrace();
            System.exit(1);

        }
    }

    public static final ConnectionManager getSingletonInstance() {
        return LazyCointainer.sigletonInstance;
    }

    public Connection getConnection(){
        return this.connection;
    }
}
