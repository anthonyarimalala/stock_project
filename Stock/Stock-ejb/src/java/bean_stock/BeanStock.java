/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean_stock;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import stock.Mouvement;

/**
 *
 * @author PC
 */
@Stateless
@LocalBean
public class BeanStock implements BeanStockInterface{

    @Override
    public Mouvement buildMouvement(String type, Timestamp date_mouvement, int id_stock, float prix_unitaire, float mouvement, float prix_u, float quantite) {
        return Mouvement.buildMouvement(type, date_mouvement, id_stock, prix_unitaire, mouvement, prix_u, quantite);
    }

    @Override
    public String insererMouvement(Mouvement mouvement) throws SQLException {
        return Mouvement.insererMouvement(mouvement);
    }

    @Override
    public List<Mouvement> selectAllMouvement() throws SQLException {
        return Mouvement.selectAllMouvement();
    }
    
}
