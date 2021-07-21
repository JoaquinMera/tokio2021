package edu.it.entities;

import javax.persistence.*;

// @Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    public String id;
    public String nombre;
    public String apellido;
    public String domicilio;
    public String pais;
    public Integer salario;
    @Column(name="tipo_de_usuario")
    public TipoDeUsuario tipoDeUsuario;

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", pais=" + pais + ", salario=" + salario + ", tipoDeUsuario=" + tipoDeUsuario + '}';
    }
}
