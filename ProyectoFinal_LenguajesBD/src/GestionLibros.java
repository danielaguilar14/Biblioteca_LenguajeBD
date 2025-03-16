/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dagui
 */

import java.sql.*;
public class GestionLibros {

    public static void insertarLibro(int id, String titulo, String autor, String categoria, char disponible) {
        try (Connection conexion = ConexionOracle.conectar()) {
            CallableStatement stmt = conexion.prepareCall("{CALL sp_insertar_libro(?, ?, ?, ?, ?)}");
            stmt.setInt(1, id);
            stmt.setString(2, titulo);
            stmt.setString(3, autor);
            stmt.setString(4, categoria);
            stmt.setString(5, String.valueOf(disponible));

            stmt.execute();
            System.out.println("Libro agregado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar libro: " + e.getMessage());
        }
    }

    public static void consultarLibros() {
        try (Connection conexion = ConexionOracle.conectar()) {
            CallableStatement stmt = conexion.prepareCall("{CALL sp_consultar_libros}");
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error al consultar libros: " + e.getMessage());
        }
    }

    public static void actualizarLibro(int id, String titulo, String autor, String categoria, char disponible) {
        try (Connection conexion = ConexionOracle.conectar()) {
            CallableStatement stmt = conexion.prepareCall("{CALL sp_actualizar_libro(?, ?, ?, ?, ?)}");
            stmt.setInt(1, id);
            stmt.setString(2, titulo);
            stmt.setString(3, autor);
            stmt.setString(4, categoria);
            stmt.setString(5, String.valueOf(disponible));

            stmt.execute();
            System.out.println("Libro actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar libro: " + e.getMessage());
        }
    }

    public static void eliminarLibro(int id) {
        try (Connection conexion = ConexionOracle.conectar()) {
            CallableStatement stmt = conexion.prepareCall("{CALL sp_eliminar_libro(?)}");
            stmt.setInt(1, id);

            stmt.execute();
            System.out.println("Libro eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar libro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        insertarLibro(1, "Cien años de soledad", "Gabriel García Márquez", "Novela", 'S');
        consultarLibros();
        actualizarLibro(1, "Cien años de soledad", "Gabriel García Márquez", "Literatura", 'N');
        eliminarLibro(1);
    }
}
