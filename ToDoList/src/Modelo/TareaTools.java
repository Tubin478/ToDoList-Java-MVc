/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;

public class TareaTools extends TareaDataBase {

    public boolean registrar(Tarea t) {
        String consulta = "INSERT INTO tareas (titulo,descripcion,completada,fecha_creacion,fecha_completacion) VALUES (?,?,?,?,?)";
        Connection conexion = obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, t.getTitulo());
            ps.setString(2, t.getDescripcion());
            ps.setBoolean(3, t.isCompletada());
            ps.setTimestamp(4, Timestamp.valueOf(t.getFechaCreacion()));
            ps.setTimestamp(5, t.getFechaCompletacion() != null ? Timestamp.valueOf(t.getFechaCompletacion()) : null);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al agregar tarea");
            System.out.println(e);
            return false;

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión");
                System.out.println(e);
            }
        }

        return true;
    }

    public boolean eliminar(Tarea t) {
        String consulta = "DELETE FROM tareas WHERE id";
        Connection conexion = obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, t.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al eliminar tarea");
            System.out.println(e);
            return false;

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión");
                System.out.println(e);
            }
        }

        return true;
    }
}
