/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class conexion {
     protected static Connection con;
    //declaramos los dadtos de conexion
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "barcelona11casa";
    private static final String url = "jdbc:mysql://localhost:3306/ferreteria? useUnicode=true&use"
            + " JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection conectar() {
        //reseteamos null a la conexion de la BD
        con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //conexion a la BD
            con = (Connection) DriverManager.getConnection(url, user, pass);
            //comprobacion
            if (con != null) {
                JOptionPane.showMessageDialog(null, "CONEXION EXITOSA!!");

            }
            //mensaje de error
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
        return con;
    }
    
}
