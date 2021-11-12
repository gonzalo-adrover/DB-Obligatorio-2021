package obligatorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
//    Cambiar solamente user, pass e IP del string URL de ser necesario
    private static Connection conn;
    private static final String driver = "org.postgresql.Driver";
    private static final String user = "postgres";
    private static final String pass = "1234";
    private static final String db = "Obligatorio";
    private static final String url = "jdbc:postgresql://localhost:5432/"+db+"";
    
    public Connect(){
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            
            // Connect?
            if(conn != null)
                System.out.println("Conexión establecida exitosamente");
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Conexión Fallida:\n\n"+ex);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
}
