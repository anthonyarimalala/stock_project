
package bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Remote;
import magasin.Stock;


@Remote
public interface BeanInterface {
    List<Stock> selectAllStock() throws SQLException;
    Stock selectStock(int idStock) throws SQLException;
    Connection getConnection() throws SQLException;
}
