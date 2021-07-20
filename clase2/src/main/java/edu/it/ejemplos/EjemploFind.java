package edu.it.ejemplos;

import edu.it.components.ConectorJPA;
import edu.it.components.GeneradorUsuarios;
import edu.it.entities.Usuario;

public class EjemploFind implements Runnable {
    public void run() {
        var em = new ConectorJPA().getEntityManager();

        var usu = em.find(Usuario.class, "12345");

        if (usu == null) {
            System.out.println("No se encontro");
            return;
        }


        var usuario2 = GeneradorUsuarios.clonarUsuario(usu);

        System.out.println("voy a modificar el objeto");
        System.out.println(usuario2);

        var tx = em.getTransaction();
        tx.begin();
        usuario2.apellido = "Saracco";
        em.merge(usuario2);
        System.out.println(usuario2);
        tx.commit();
    }
}
