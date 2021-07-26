package edu.it.ejemplos;

import edu.it.entities.*;
import edu.it.repository.DirectorRepository;
import edu.it.repository.Pelicularepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertarPeliculasDirectores {
    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    Pelicularepository peliculaRepository;

    public void run() {
        Director kubrick = new Director("200000001", "Stanley Kubrick");
        Director almodovar = new Director("200000002", "Pedor Almodovar");
        Director pineiro = new Director("200000003", "Marcelo Pyneiro");
        Director rodrigoGrande = new Director("200000004", "Rodrigo Grande");
        Director ethanCohen = new Director("200000005", "Hermanos Cohen");

        Pelicula volver = new Pelicula("100000001", "Volver", "drama", almodovar);
        Pelicula doloryGloria = new Pelicula("100000002", "Dolor y Gloria", "drama", almodovar);
        Pelicula HableConElla = new Pelicula("100000002bis", "Hable con ella", "drama", almodovar);

        Pelicula elResplandor = new Pelicula("100000003", "El resplandor", "suspenso", kubrick);

        Pelicula barryLindon = new Pelicula("100000004", "Barry Lyndon", "drama", kubrick);
        Pelicula plataQuemada = new Pelicula("100000005", "Plata quemada","Drama", pineiro);
        Pelicula alFinalDelTunnel = new Pelicula("100000006", "Al final del tunnel","Suspenso", rodrigoGrande);
        Pelicula elMetodo = new Pelicula("100000007", "El metodo", "Suspenso", pineiro);
        Pelicula noCountryForOldMen = new Pelicula("100000008", "No Country for Old Men", "Suspenso", ethanCohen);

        directorRepository.save(kubrick);
        directorRepository.save(almodovar);
        directorRepository.save(pineiro);
        directorRepository.save(rodrigoGrande);
        directorRepository.save(ethanCohen);
    }
}
