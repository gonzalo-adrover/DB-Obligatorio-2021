package obligatorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import obligatorio.Entities.User;

public class ProductAdministrator {

    Connect conn;
    Connection reg;
    User user;

    private final String[] productFields = {"IdProducto", "Nombre", "Precio", "DescripcionProducto", "IdUsuario", "IdCategoria", "NombreCategoria", "Estado"};
    private final String SQL_QUERY_PRODUCTS = "\n\tSELECT * FROM \"Producto\" p \n\tLEFT JOIN \"Categoria\" c ON p.\"IdCategoria\" = c.\"IdCategoria\" \n\tWHERE (LOWER(\"Nombre\") ~ LOWER(\'%s\') OR LOWER(\"DescripcionProducto\") ~ LOWER(\'%s\')) AND (p.\"IdCategoria\" = \'%s\') \n\tORDER BY \"%s\"";
    private final String SQL_QUERY_PRODUCT = "\n\tSELECT * FROM \"Producto\" p \n\tLEFT JOIN \"Categoria\" c ON p.\"IdCategoria\" = c.\"IdCategoria\" \n\tWHERE \"IdProducto\" = %s";
    private final String SQL_QUERY_USER_PRODUCTS = "\n\tSELECT * FROM \"Producto\" p \n\tLEFT JOIN \"Categoria\" c ON p.\"IdCategoria\" = c.\"IdCategoria\" \n\tWHERE \"IdUsuario\" = %s AND \"Estado\" = 'True';";

    public ProductAdministrator() {
        this.initConnection();
    }

    private void initConnection() {
        this.conn = new Connect();
        this.reg = this.conn.getConnection();
    }

    public ResultSet ExecuteFetchProductsQuery(String titleQuery, String idCategoria, String columnName) throws SQLException {
        Statement statement = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = this.SQL_QUERY_PRODUCTS.formatted(titleQuery, titleQuery, idCategoria, columnName);
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }

    public ResultSet ExecuteFetchUserProductsQuery(String idUsuario) throws SQLException {
        Statement statement = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = this.SQL_QUERY_USER_PRODUCTS.formatted(idUsuario);
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }

    public ResultSet ExecuteFetchProductQuery(String idProducto) throws SQLException {
        Statement statement = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = this.SQL_QUERY_PRODUCT.formatted(idProducto);
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }

    public Object[] MapProduct(ResultSet resultSet) throws SQLException {
        return this.MapProductHelper(resultSet, this.productFields);
    }

    public Object[] MapProduct(ResultSet resultSet, String[] fields) throws SQLException {
        return this.MapProductHelper(resultSet, fields);
    }

    private Object[] MapProductHelper(ResultSet resultSet, String[] fields) throws SQLException {
        ArrayList<Object> productFieldsList = new ArrayList<>();
        for (String field : fields) {
            productFieldsList.add(resultSet.getString(field));
        }

        return productFieldsList.toArray();
    }
}
