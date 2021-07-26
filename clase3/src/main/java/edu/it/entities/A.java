package edu.it.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class A {
    @Id
    public String id;
    public String valor;

    public A(String id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public A() {
    }
}
