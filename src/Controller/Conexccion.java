package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexccion {
    private Connection con = null;

    public  static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "sadavid2002");
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
        return con;
    }

}
