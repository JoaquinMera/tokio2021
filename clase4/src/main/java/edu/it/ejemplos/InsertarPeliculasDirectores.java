package edu.it.ejemplos;

import edu.it.entities.*;
import edu.it.repository.ActorRepository;
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

    @Autowired
    ActorRepository actorRepository;

    public void run() {

        Actor javierBardem = new Actor("300000001", "Javier Bardem");
        Actor pabloEcharri = new Actor("300000002", "Pablo Echarri");
        Actor eduardoNoriega = new Actor("300000003", "Eduardo Noriega");
        Actor sbaraglia = new Actor("300000004", "Leonardo Sbaraglia");
        Actor pepaPig = new Actor("300000005", "Papa Cerdito");

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

        plataQuemada.agregarActor(pabloEcharri);
        plataQuemada.agregarActor(eduardoNoriega);
        plataQuemada.agregarActor(sbaraglia);

        elMetodo.agregarActor(eduardoNoriega);
        elMetodo.agregarActor(pepaPig);

        directorRepository.save(kubrick);
        directorRepository.save(almodovar);
        directorRepository.save(pineiro);
        directorRepository.save(rodrigoGrande);
        directorRepository.save(ethanCohen);

        actorRepository.save(javierBardem);
    }
}
