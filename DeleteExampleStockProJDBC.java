/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package modulostockprojdbc;

import java.sql.*;

public class DeleteExampleStockProJDBC {

    public static void main(String[] args) {

        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/bd_stockpro";
        Connection conexion;
        Statement statement;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();

            // Cambiado: Utilizar DELETE para eliminar un registro
            statement.executeUpdate("DELETE FROM USUARIOS WHERE NOMBRE = 'Alex'");

            rs = statement.executeQuery("SELECT * FROM USUARIOS");

            // Corrección: Mover el bloque do-while dentro del bloque try
            while (rs.next()) {
                // Corrección: Usar las columnas correctas en la impresión
                System.out.println(rs.getInt("ID") + ":" + rs.getString("NOMBRE") + ":" + rs.getString("PASSWORD"));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}


