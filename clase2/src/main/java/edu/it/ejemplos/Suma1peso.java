package edu.it.ejemplos;

import com.google.gson.Gson;
import edu.it.components.ConectorJPA;
import edu.it.entities.Usuario;
import static java.util.stream.Collectors.toList;
import javax.persistence.TypedQuery;

class ContieneUsuario {
    String json;
    Usuario u;

    public ContieneUsuario(String json, Usuario u) {
        this.json = json;
        this.u = u;
    }
}

class NombreSalario {
    String nombre;
    Integer salario;

    public NombreSalario(String nombre, Integer salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "NombreSalario{" + "nombre=" + nombre + ", salario=" + salario + '}';
    }
}

public class Suma1peso implements Runnable {
    public void run() {
        var em = new ConectorJPA().getEntityManager();

        String query = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> tQuery = em.createQuery(query, Usuario.class);

        var usus = tQuery
                .getResultStream()
                .filter(z -> z.salario > 105000)
                .filter(z -> z.salario < 108000)
                .map(z -> new ContieneUsuario(new Gson().toJson(z), z))
                .peek(z -> System.out.println(z.json))
                .map(z -> new NombreSalario(z.u.nombre, z.u.salario))
                .limit(3)
                .collect(toList());

        for (var usu : usus) {
            System.out.println(usu);        }

    }
}
