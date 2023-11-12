
package bean;

import classbean.PgConnection;
import classbean.StockBean;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import magasin.Stock;


@Stateless
@LocalBean
public class Bean implements BeanInterface{

    @Override
    public List<Stock> selectAllStock() throws SQLException {
        return StockBean.selectAll();
    }

    @Override
    public Stock selectStock(int idStock) throws SQLException {
        return StockBean.select(idStock);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return PgConnection.connect();
    }
    
}
