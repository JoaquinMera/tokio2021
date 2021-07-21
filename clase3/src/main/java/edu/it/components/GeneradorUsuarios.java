package edu.it.components;

import com.github.javafaker.Faker;
import edu.it.entities.TipoDeUsuario;
import edu.it.entities.Usuario;
import java.util.Random;
import java.util.UUID;

public class GeneradorUsuarios {
    public static Usuario generarUsuario() {
        var usu = new Usuario();

        Faker fkr = new Faker();

        usu.id = UUID.randomUUID().toString();
        usu.nombre = fkr.address().firstName();
        usu.apellido = fkr.address().lastName();
        usu.domicilio = fkr.address().streetName() + " " + fkr.address().streetAddressNumber();
        usu.pais = fkr.address().country();
        usu.salario = (new Random().nextInt(100) + 100) * 1000;
        usu.tipoDeUsuario = (new Random().nextInt(2) == 1) ? TipoDeUsuario.USUARIO_ROOT : TipoDeUsuario.USUARIO_STANDAR;

        return usu;
    }
    public static Usuario clonarUsuario(Usuario u) {
        var usu = new Usuario();

        usu.id = u.id;
        usu.nombre = u.nombre;
        usu.apellido = u.apellido;
        usu.domicilio = u.domicilio;
        usu.pais = u.pais;
        usu.salario = u.salario;
        usu.tipoDeUsuario = u.tipoDeUsuario;

        return usu;
    }
}
