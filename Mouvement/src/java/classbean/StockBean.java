/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classbean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import magasin.Stock;

/**
 *
 * @author PC
 */
public class StockBean {
    public static void update(Stock stock) throws SQLException {
        Connection connection = PgConnection.connect();
        String query = "UPDATE stock SET date_insert=?, id_article=?, id_magasin=?, prix_u=?, quantite=? WHERE id_stock=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setTimestamp(1, stock.getDateInsert());
            preparedStatement.setString(2, stock.getIdArticle());
            preparedStatement.setString(3, stock.getIdMagasin());
            preparedStatement.setFloat(4, stock.getPrixUnitaire());
            preparedStatement.setFloat(5, stock.getQuantite());
            preparedStatement.setInt(6, stock.getIdStock());

            preparedStatement.executeUpdate();
        }
        connection.close();
    }
    
    public static Stock select(int idStock) throws SQLException {
        Connection connection = PgConnection.connect();
        String query = "SELECT * FROM v_stock WHERE id_stock = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idStock);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    connection.close();
                    return mapResultSetToStock(resultSet);
                }
            }
        }
        return null; // Retourne null si aucune correspondance trouvée
    }
    
    public static List<Stock> selectAll() throws SQLException {
        Connection connection = PgConnection.connect();
        List<Stock> stocks = new ArrayList<>();
        String query = "SELECT * FROM v_stock";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                stocks.add(mapResultSetToStock(resultSet));
            }
        }
        connection.close();
        return stocks;
    }

    public static List<Stock> selectByArticleId(String idArticle) throws SQLException {
        Connection connection = PgConnection.connect();
        List<Stock> stocks = new ArrayList<>();
        String query = "SELECT * FROM v_stock WHERE id_article = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idArticle);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    stocks.add(mapResultSetToStock(resultSet));
                }
            }
        }
        connection.close();
        return stocks;
    }

    // (Autres méthodes existantes)

    // Méthode utilitaire pour mapper le résultat de la requête à un objet Stock
    private static Stock mapResultSetToStock(ResultSet resultSet) throws SQLException {
        int idStock = resultSet.getInt("id_stock");
        Timestamp dateInsert = resultSet.getTimestamp("date_insert");
        String idArticle = resultSet.getString("id_article");
        String idMagasin = resultSet.getString("id_magasin");
        float prixUnitaire = resultSet.getFloat("prix_u");
        float quantite = resultSet.getFloat("quantite");
        String article = resultSet.getString("article");
        String description = resultSet.getString("description");
        String famille = resultSet.getString("famille");
        String unite = resultSet.getString("unite");
        String type_sortie = resultSet.getString("type_sortie");
        String magasin = resultSet.getString("magasin");
        String emplacement = resultSet.getString("emplacement");

        return new Stock(idStock, dateInsert, idArticle, idMagasin, prixUnitaire, quantite, article, description, famille, unite, type_sortie, magasin, emplacement);
    }
}
