package com.hibernate.introduction.vista;

import javax.swing.JOptionPane;

import com.hibernate.introduction.controlador.MascotaControlador;

public class MascotaVista {
    private MascotaControlador controlador;

    public MascotaVista(){
        controlador = new MascotaControlador();
    }

    public void crearMascota(){
        //Soliciar datos
        String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de la mascota: ");
        String apellido = JOptionPane.showInputDialog(null, "Ingrese apellido del Propietario: ");
        String tipoMascota = JOptionPane.showInputDialog(null, "Ingrese el tipo de mascota: ");
        String raza = JOptionPane.showInputDialog(null, "Ingrese la raza de la mascota: ");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad de la mascota: "));
        String observacion = JOptionPane.showInputDialog(null, "Ingrese las observaciones: ");

        //Enviar datos al controlador
        try {
            controlador.create(nombre, apellido, tipoMascota, raza, edad, observacion);
            JOptionPane.showMessageDialog(null, "Mascota creada con éxito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor intente mas tarde");
        }
        
    }
}
