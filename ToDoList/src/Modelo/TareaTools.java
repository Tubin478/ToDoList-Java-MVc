/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;
public class TareaTools extends TareaDataBase {
   public boolean registrar(Tarea t){
       String consulta = "INSERT INTO tareas (titulo,descripcion,completada,fecha_creacion,fecha_completacion) VALUES (?,?,?,?,?)";
       Connection conexion = obtenerConexion();

   return true;
   } 
}
