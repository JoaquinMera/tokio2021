package edu.it.ejemplos;

import edu.it.components.ConectorJPA;
import edu.it.components.GeneradorUsuarios;
import javax.persistence.EntityTransaction;

public class ProblemaPersist implements Runnable {
    public void run() {
        var em = new ConectorJPA().getEntityManager();

        // for (int x: new int[2]) {
            var usu = GeneradorUsuarios.generarUsuario();
            usu.id = "12345";
            System.out.println("Voy a insertar el objeto");
            System.out.println(usu);
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(usu);
            tx.commit();
        // }
    }
}
