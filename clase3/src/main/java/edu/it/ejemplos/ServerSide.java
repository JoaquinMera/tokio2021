package edu.it.ejemplos;

import edu.it.components.ConectorJPA;
import edu.it.entities.Usuario;
import java.util.List;
import javax.persistence.TypedQuery;

public class ServerSide implements Runnable {
    public void run() {
        var em = new ConectorJPA().getEntityManager();

        String query = "SELECT u FROM Usuario u WHERE salario < :salarioParam";
        TypedQuery<Usuario> tQuery = em.createQuery(query, Usuario.class);
        tQuery.setParameter("salarioParam", 105000);

        List<Usuario> usuarios = tQuery.getResultList();
        for (Usuario u : usuarios) {
            System.out.print(u.nombre);
            System.out.println(":  " + u.salario);
        }
    }
}
