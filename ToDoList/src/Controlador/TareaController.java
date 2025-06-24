/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class TareaController implements ActionListener {

    private final Tarea tarea;
    private final TareaTools consulta;
    private final TareaForm vista;

    public TareaController(Tarea tarea, TareaTools consulta, TareaForm vista) {
        this.tarea = tarea;
        this.consulta = consulta;
        this.vista = vista;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnMarcar.addActionListener(this);
        this.vista.btnVer.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Formulario Tareas");
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            tarea.setTitulo(vista.txtTitulo.getText());
            tarea.setDescripcion(vista.txtDescripcion.getText());
            tarea.setCompletada(false);
            tarea.setFechaCreacion(LocalDateTime.now());
            if(consulta.registrar(tarea)){
            JOptionPane.showMessageDialog(null, "Registro con exito");
            limpiar();
            }else{
            JOptionPane.showMessageDialog(null, "No se pudo realizar registro");
            }

        }

    }

    public void verificarEstado(){

        return "modulo para verificar un estado de tarea";
    }
    
    //prueba comentario para commit sencillo
    
    public void limpiar(){
    vista.txtDescripcion.setText(null);
    vista.txtTitulo.setText(null);
    vista.txtStatus.setText(null);
    }

}
