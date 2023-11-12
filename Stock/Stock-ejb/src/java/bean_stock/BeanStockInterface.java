/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean_stock;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Remote;
import stock.Mouvement;

@Remote
public interface BeanStockInterface {
    Mouvement buildMouvement(String type, Timestamp date_mouvement, int id_stock, float prix_unitaire, float mouvement, float prix_u, float quantite);
    String insererMouvement(Mouvement mouvement) throws SQLException;
    List<Mouvement> selectAllMouvement() throws SQLException;
}
