package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {
    
    public static Connection cnx;
    
    public static void conectar() throws  Exception{
        InputStream inputStream = 
                Conexion.class.getClassLoader().getResourceAsStream("propiedades/db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String pwd = properties.getProperty("pwd");
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }        
//        return cnx;
    }
    
    public static void desconectar(){
        if (cnx==null){
            return;
        }
    }

    public static Connection getCnx() {
        return cnx;
    }

    public static void setCnx(Connection cnx) {
        Conexion.cnx = cnx;
    }
}
