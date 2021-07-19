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
        usu.domicilio = fkr.address().streetName() + fkr.address().streetAddressNumber();
        usu.pais = fkr.address().country();
        usu.salario = (new Random().nextInt(100) + 100) * 1000;
        usu.tipoDeUsuario = (new Random().nextInt(2) == 1) ? TipoDeUsuario.USUARIO_ROOT : TipoDeUsuario.USUARIO_STANDAR;

        return usu;
    }
}
