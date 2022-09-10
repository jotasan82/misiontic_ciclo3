package com.hibernate.introduction.vista;

import java.util.List;

import javax.swing.JOptionPane;

import com.hibernate.introduction.controlador.MascotaControlador;

public class MascotaVista {
    private MascotaControlador controlador;

    public MascotaVista(){
        controlador = new MascotaControlador();
    }

    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
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
            mostrarMensaje("Mascota creada con éxito");
        } catch (Exception e) {
            mostrarMensaje("Por favor intente mas tarde");
        }   
    }

    public void consultarMascotaXid(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el identificador de la mascota"));
        try {
            String info = controlador.readById(id);
            mostrarMensaje(info);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Por favor intente mas tarde");
        }
    }

    public void consultarMascotasXapellido(){
        String apellido = JOptionPane.showInputDialog(null, "Por favor ingrese el apellido");
        try {
            List<String> mascotas = controlador.getByLastname(apellido);
            String info = "------------MASCOTAS------------\n";
            for(int i=0;i<mascotas.size();i++){
                info += mascotas.get(i);
            }
            mostrarMensaje(info);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Por favor intente mas tarde");
        }
    }
}
