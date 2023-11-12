
package magasin;

import java.sql.*;
import java.util.*;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

public class Stock {
    private int idStock;
    private Timestamp dateInsert;
    private String idArticle;
    private String idMagasin;
    private float prixUnitaire;
    private float quantite;
    private String article;
    private String description;
    private String famille;
    private String unite;
    private String type_sortie;
    private String magasin;
    private String emplacement;

    public Stock() {
    }

    public Stock(int idStock, Timestamp dateInsert, String idArticle, String idMagasin, float prixUnitaire, float quantite) {
        this.idStock = idStock;
        this.dateInsert = dateInsert;
        this.idArticle = idArticle;
        this.idMagasin = idMagasin;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
    }

    public Stock(int idStock, Timestamp dateInsert, String idArticle, String idMagasin, float prixUnitaire, float quantite, String article, String description, String famille, String unite, String type_sortie, String magasin, String emplacement) {
        this.idStock = idStock;
        this.dateInsert = dateInsert;
        this.idArticle = idArticle;
        this.idMagasin = idMagasin;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.article = article;
        this.description = description;
        this.famille = famille;
        this.unite = unite;
        this.type_sortie = type_sortie;
        this.magasin = magasin;
        this.emplacement = emplacement;
    }
    
    
    

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Timestamp getDateInsert() {
        return dateInsert;
    }

    public void setDateInsert(Timestamp dateInsert) {
        this.dateInsert = dateInsert;
    }

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public String getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(String idMagasin) {
        this.idMagasin = idMagasin;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public String getType_sortie() {
        return type_sortie;
    }

    public void setType_sortie(String type_sortie) {
        this.type_sortie = type_sortie;
    }

    public String getMagasin() {
        return magasin;
    }

    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }
    
    
    
    
}
