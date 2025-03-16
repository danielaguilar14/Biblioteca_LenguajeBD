/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dagui
 */
import java.sql.*;

public class GestionReportes {

    public static void generarReporte(String tipoReporte) {
        try (Connection conexion = ConexionOracle.conectar()) {
            CallableStatement stmt = conexion.prepareCall("{CALL sp_generar_reporte(?)}");
            stmt.setString(1, tipoReporte);
            stmt.execute();
            System.out.println("Reporte generado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }
}
