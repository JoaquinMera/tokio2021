package edu.it.ejemplos;

import com.github.javafaker.Faker;
import edu.it.components.ConectorJPA;

public class EjemploInsercion implements Runnable {
    public void run() {
        var em = new ConectorJPA().getEntityManager();

        Faker fkr = new Faker();
    }
}
