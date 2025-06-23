/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todolist;

import Controlador.TareaController;
import Modelo.Tarea;
import Modelo.TareaTools;
import Vista.TareaForm;

/**
 *
 * @author GP
 */
public class ToDoList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tarea tarea = new Tarea();
        TareaTools consulta = new TareaTools();
        TareaForm vista = new TareaForm();
        TareaController controlador = new TareaController(tarea,consulta,vista);
        
        controlador.iniciar();
        vista.setVisible(true);
        
        
    }
    
}
