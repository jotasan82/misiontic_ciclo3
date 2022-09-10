package com.hibernate.introduction;

import com.hibernate.introduction.vista.MascotaVista;

public class App 
{
    public static void main( String[] args ){
        MascotaVista vista = new MascotaVista();
        vista.crearMascota();

        /*Crear objeto fablicante de sesiones
        SessionFactory factory = new Configuration().configure("cfg.xml").addAnnotatedClass(Mascota.class).buildSessionFactory();


        // Abrir sesión
        Session session = factory.openSession();

        //Preparar la sesión para realizar transacciones
        session.beginTransaction();

        //Generar transacciones...
        try {
            // CRUD

            /*****Create*****/
            /*Mascota mascota = new Mascota("Sasha", "Hernandez", "Perro", "Chandinez", 3, "Ninguna");
            session.persist(mascota);
            session.getTransaction().commit();*/

            /********READ*********/
            //Forma 01
            //Mascota mascota = session.find(Mascota.class, 1);
            //System.out.println(mascota);
            
            //Forma 02
            //Mascota mascota = session.byId(Mascota.class).load(3);
            //System.out.println(mascota);

            //Forma 03
            /*List<Mascota> mascotas = session.createQuery("from Mascota", Mascota.class).list();
            for (int i=0;i<mascotas.size();i++){
                System.out.println(mascotas.get(i));
            }*/

            //******UPDATE******
            /*Mascota mascota = session.find(Mascota.class, 3);
            mascota.setRaza("Pincher");
            mascota.setEdad(6);
            mascota.setObservacion("Problemas patas traseras");
            // Guardar cambios
            session.merge(mascota);
            session.getTransaction().commit();*/

            /*****DELETE*****/
            /*Mascota mascota = session.find(Mascota.class, 2 );
            session.remove(mascota);
            session.getTransaction().commit();

            

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cerrar sesión
        session.close();*/
    }
}
