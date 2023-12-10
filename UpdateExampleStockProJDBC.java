/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package modulostockprojdbc;

import java.sql.*;

public class UpdateExampleStockProJDBC {

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

            // Agregar comillas simples alrededor de los valores y corregir las columnas en VALUES
            statement.executeUpdate("UPDATE USUARIOS SET NOMBRE = 'Alex' WHERE NOMBRE = 'ABC'");

            rs = statement.executeQuery("SELECT * FROM USUARIOS");

            //Mover el bloque do-while dentro del bloque try
            rs.next();
            do {
                // Usar las columnas correctas en la impresión
                System.out.println(rs.getInt("ID") + ":" + rs.getString("NOMBRE") + ":" + rs.getString("PASSWORD"));
            } while (rs.next());

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}

