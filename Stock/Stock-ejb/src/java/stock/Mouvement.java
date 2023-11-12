package stock;

import classbean.PgConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Mouvement {
    private int idMouvement;
    private int idStock;
    private float prix_unitaire;
    private Timestamp dateMouvement;
    private String type;
    private float mouvement;
    private float prixMouvement;
    private float quantite;
    private float prixQuantite;
    
    
    public static Mouvement buildMouvement(String type, Timestamp date_mouvement, int id_stock, float prix_unitaire, float mouvement, float prix_u, float quantite){
        
        double prix_mouvement = (double) mouvement * (double) prix_u;
        double prix_quantite = (double) quantite * (double) prix_u;
        
        float pm = (float)prix_mouvement;
        float pq = (float)prix_quantite;
        Mouvement mv = new Mouvement(id_stock, prix_unitaire, date_mouvement, type, mouvement, pm, quantite, pq);
        return mv;
    }
    
    public static String insererMouvement(Mouvement mouvement) throws SQLException{
        try {
            Connection connection = StockConnection.connect();
            String query = "INSERT INTO mouvement (id_stock, prix_u, date_mouvement, type, mouvement, prix_mouvement, quantite, prix_quantite) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, mouvement.getIdStock());
                preparedStatement.setFloat(2, mouvement.getPrix_unitaire());
                preparedStatement.setTimestamp(3, mouvement.getDateMouvement());
                preparedStatement.setString(4, mouvement.getType());
                preparedStatement.setFloat(5, mouvement.getMouvement());
                preparedStatement.setFloat(6, mouvement.getPrixMouvement());
                preparedStatement.setFloat(7, mouvement.getQuantite());
                preparedStatement.setFloat(8, mouvement.getPrixQuantite());

                preparedStatement.executeUpdate();

                // Récupérer la clé générée (id_mouvement)
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        mouvement.setIdMouvement(generatedKeys.getInt(1));
                    }
                }
                connection.close();
                return preparedStatement.toString();
                
            }
            
            
        } catch (SQLException e) {
            return(e.getMessage());
            // Gérer les exceptions
        }
    }

    public static List<Mouvement> selectAllMouvement() throws SQLException {
        Connection connection = StockConnection.connect();
        List<Mouvement> listeMouvements = new ArrayList<>();
        try {
            String query = "SELECT * FROM mouvement";
            try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Mouvement mouvement = mapperResultSetVersMouvement(resultSet);
                    listeMouvements.add(mouvement);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les exceptions
        }
        connection.close();
        return listeMouvements;
    }

    private static Mouvement mapperResultSetVersMouvement(ResultSet resultSet) throws SQLException {
        Mouvement mouvement = new Mouvement();
        mouvement.setIdMouvement(resultSet.getInt("id_mouvement"));
        mouvement.setIdStock(resultSet.getInt("id_stock"));
        mouvement.setPrix_unitaire(resultSet.getFloat("prix_unitaire"));
        mouvement.setDateMouvement(resultSet.getTimestamp("date_mouvement"));
        mouvement.setType(resultSet.getString("type"));
        mouvement.setMouvement(resultSet.getFloat("mouvement"));
        mouvement.setPrixMouvement(resultSet.getFloat("prix_mouvement"));
        mouvement.setQuantite(resultSet.getFloat("quantite"));
        mouvement.setPrixQuantite(resultSet.getFloat("prix_quantite"));
        return mouvement;
    }

    
    public Mouvement() {
    }

    // Constructeur avec tous les champs
    public Mouvement(int idStock, float prix_unitaire, Timestamp dateMouvement, String type, float mouvement, float prixMouvement, float quantite, float prixQuantite) {
        this.idStock = idStock;
        this.prix_unitaire = prix_unitaire;
        this.dateMouvement = dateMouvement;
        this.type = type;
        this.mouvement = mouvement;
        this.prixMouvement = prixMouvement;
        this.quantite = quantite;
        this.prixQuantite = prixQuantite;
    }

    // Getters and Setters
    public int getIdMouvement() {
        return idMouvement;
    }

    public void setIdMouvement(int idMouvement) {
        this.idMouvement = idMouvement;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Timestamp getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(Timestamp dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMouvement() {
        return mouvement;
    }

    public void setMouvement(float mouvement) {
        this.mouvement = mouvement;
    }

    public float getPrixMouvement() {
        return prixMouvement;
    }

    public void setPrixMouvement(float prixMouvement) {
        this.prixMouvement = prixMouvement;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public float getPrixQuantite() {
        return prixQuantite;
    }

    public void setPrixQuantite(float prixQuantite) {
        this.prixQuantite = prixQuantite;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }
    
}
