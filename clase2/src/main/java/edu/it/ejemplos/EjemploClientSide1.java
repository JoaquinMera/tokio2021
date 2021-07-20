package edu.it.ejemplos;

import com.google.gson.Gson;
import edu.it.components.ConectorJPA;
import edu.it.entities.Usuario;
import javax.persistence.TypedQuery;

public class EjemploClientSide1 implements Runnable {

    private String toJson(Object o) {
        return new Gson().toJson(o);
    }

    @Override
    public void run() {
        var em = new ConectorJPA().getEntityManager();

        String query = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> tQuery = em.createQuery(query, Usuario.class);

        var optUsu = tQuery
                .getResultStream()
                //.peek(z -> System.out.println(z.nombre))
                //.map(this::toJson)
                .filter(z -> z.salario < 100)
                .findFirst();

        if (optUsu.isPresent()) {
            System.out.println(optUsu.get().nombre);
        }
        else {
            System.out.println("No hay nadie con ese salario");
        }
    }
}
