package edu.it.ejemplos;

import com.google.gson.Gson;
import java.util.*;
import static java.util.stream.Collectors.toList;

class Choffer {
    public String nombre;
    public Integer cantAccidentes;
    public Boolean leGustaSuTrabajo;

    public Choffer(String nombre, Integer cantAccidentes, Boolean leGustaSuTrabajo) {
        this.nombre = nombre;
        this.cantAccidentes = cantAccidentes;
        this.leGustaSuTrabajo = leGustaSuTrabajo;
    }
}

public class EjemploStream implements Runnable {
    public void run() {
        List<Choffer> choferes = new ArrayList<>();

        choferes.add(new Choffer("Ezequiel", 3, true));
        choferes.add(new Choffer("Milagros", 0, true));
        choferes.add(new Choffer("El pior de todos", 6, false));
        choferes.add(new Choffer("El responsable", 0, false));

        var filtros = choferes
                .stream()
                .filter(c -> c.nombre.startsWith("E"))
                .map(c -> new Gson().toJson(c))
                .collect(toList());

        for (String s : filtros) {
            System.out.println(s);
        }
    }
}
