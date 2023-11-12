package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/stock_project";
    private static final String USER = "postgres";
    private static final String PASSWORD = "anthony";

    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connexion à la base de données établie.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    
}
