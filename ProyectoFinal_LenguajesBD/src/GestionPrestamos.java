/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dagui
 */

import java.sql.*;

public class GestionPrestamos {

    public static void registrarPrestamo(int idPrestamo, int idUsuario, int idLibro, String fechaPrestamo, String fechaDevolucion) {
        try (Connection conexion = ConexionOracle.conectar()) {
            CallableStatement stmt = conexion.prepareCall("{CALL sp_insertar_prestamo(?, ?, ?, ?, ?)}");
            stmt.setInt(1, idPrestamo);
            stmt.setInt(2, idUsuario);
            stmt.setInt(3, idLibro);
            stmt.setString(4, fechaPrestamo);
            stmt.setString(5, fechaDevolucion);
            stmt.execute();
            System.out.println("Prestamo registrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar prestamo: " + e.getMessage());
        }
    }
}