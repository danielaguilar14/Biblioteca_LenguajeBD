/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dagui
 */
import java.sql.*;
public class GestionUsuarios {

    public static void insertarUsuario(int id, String nombre, String correo, String telefono, String rol) {
        try (Connection conexion = ConexionOracle.conectar()) {
            CallableStatement stmt = conexion.prepareCall("{CALL sp_insertar_usuario(?, ?, ?, ?, ?)}");
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, correo);
            stmt.setString(4, telefono);
            stmt.setString(5, rol);
            stmt.execute();
            System.out.println("Usuario agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }
}