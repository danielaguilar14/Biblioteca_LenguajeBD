/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dagui
 */
import java.sql.*;

public class GestionReservas {

    public static void registrarReserva(int idReserva, int idUsuario, int idLibro, String fechaReserva) {
        try (Connection conexion = ConexionOracle.conectar()) {
            CallableStatement stmt = conexion.prepareCall("{CALL sp_insertar_reserva(?, ?, ?, ?)}");
            stmt.setInt(1, idReserva);
            stmt.setInt(2, idUsuario);
            stmt.setInt(3, idLibro);
            stmt.setString(4, fechaReserva);
            stmt.execute();
            System.out.println("Reserva registrada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar reserva: " + e.getMessage());
        }
    }
}