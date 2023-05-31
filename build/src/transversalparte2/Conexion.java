/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transversalparte2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class Conexion {

    private static final String url = "jdbc:mysql://localhost/";
    private static final String usuario = "root";
    private static final String password = "";
    private static final String databaseName = "universidadulp_1";

    private static Connection connection;

    private Conexion() {

    }

    public static Connection getConexion() throws ClassNotFoundException {
        if (connection == null) {

            try {
                Class.forName("org.mariadb.jdbc.Driver");
                // Setup the connection with the DB
                connection = DriverManager.getConnection(url + databaseName + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + password);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la BD");
            } catch (ClassNotFoundException ex) {

                JOptionPane.showMessageDialog(null, "Error al cargar los Drivers");
            }
        }
        return connection;
    }
}
