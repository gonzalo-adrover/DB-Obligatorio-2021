package obligatorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import obligatorio.Entities.User;

public class OfferAdministrator {

    Connect conn;
    Connection reg;

    public OfferAdministrator() {
        this.initConnection();
    }

    private void initConnection() {
        this.conn = new Connect();
        this.reg = this.conn.getConnection();
    }

    private final String SQL_INSERT_TRUEQUE = "INSERT INTO \"Trueque\" (\"IdTrueque\", \"IdUsuario\", \"Fecha\") \n\tVALUES (\'%s\', \'%s\', \'%s\') \n\tRETURNING *";
    private final String SQL_INSERT_TRUEQUE_EXTERNO = "INSERT INTO \"TruequeExterno\" (\"IdTrueque\", \"IdProducto\", \"PrecioUCUCoin\", \"Estado\") \n\tVALUES (\'%s\', \'%s\', %s, %s) \n\tRETURNING *";
    private final String SQL_INSERT_PRODUCTO_OFRECIDO = "INSERT INTO \"ProductoOfrecido\" (\"IdTrueque\", \"IdProducto\") \n\tVALUES (\'%s\', \'%s\')";

    private final String SQL_SELECT_MAX_ID = "SELECT \"IdTrueque\" \n\tFROM \"Trueque\" \n\tORDER BY \"IdTrueque\" DESC \n\tLIMIT 1";

    public void InsertOffer(String userId, String productId, String UCA, String[] offeredProducts) {
        try {
            String offerId = this.ExecuteInsertTruequeQuery(userId);
            this.ExecuteInsertTruequeExternoQuery(offerId, productId, UCA);
            this.ExecuteInsertProductoOfrecidoQuery(offerId, offeredProducts);
        } catch (SQLException ex) {
            Logger.getLogger(OfferAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String ExecuteInsertTruequeQuery(String userId) throws SQLException {
        Statement statement = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = this.SQL_INSERT_TRUEQUE.formatted(this.GetNextId(), userId, new Timestamp(System.currentTimeMillis()));
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();

        return resultSet.getString("IdTrueque");
    }

    private String GetNextId() throws SQLException {
        Statement statement = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = this.SQL_SELECT_MAX_ID;
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int lastId = Integer.parseInt(resultSet.getString("IdTrueque"));
        lastId++;
        
        return String.valueOf(lastId);
    }

    private void ExecuteInsertTruequeExternoQuery(String offerId, String productId, String UCA) throws SQLException {
        Statement statement = reg.createStatement();
        String sql = this.SQL_INSERT_TRUEQUE_EXTERNO.formatted(offerId, productId, UCA, false);
        statement.executeQuery(sql);
    }

    private void ExecuteInsertProductoOfrecidoQuery(String offerId, String[] productIds) throws SQLException {
        Statement statement = reg.createStatement();
        for (String productId : productIds) {
            String sql = this.SQL_INSERT_PRODUCTO_OFRECIDO.formatted(offerId, productId);
            statement.executeUpdate(sql);
        }
    }
}
