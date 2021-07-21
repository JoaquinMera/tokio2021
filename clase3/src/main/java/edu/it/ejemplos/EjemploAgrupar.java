package edu.it.ejemplos;

import edu.it.components.ConectorJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;

class CantidadPromedio {
    public final Long cantidad;
    public final Double promedio;

    public CantidadPromedio(Long cantidad, Double promedio) {
        this.cantidad = cantidad;
        this.promedio = promedio;
    }

    public CantidadPromedio setCantidad(Long c) {
        return new CantidadPromedio(c, this.promedio);
    }
    public CantidadPromedio setPromedio(Double p) {
        return new CantidadPromedio(this.cantidad, p);
    }

    @Override
    public String toString() {
        return "CantidadPromedio{" + "cantidad=" + cantidad + ", promedio=" + promedio + '}';
    }
}

public class EjemploAgrupar implements Runnable {
    Logger logger = Logger.getLogger(EjemploAgrupar.class);

    public void run() {
        var em = new ConectorJPA().getEntityManager();

        String jpql = "SELECT count(u), avg(salario) FROM Usuario u";
        Query query = em.createQuery(jpql);
        
        List<Object[]> listArrObj = query.getResultList();

        var lstCantPromedio = new ArrayList<CantidadPromedio>();

        for (Object[] arrRes : listArrObj) {
            var cp = new CantidadPromedio((Long)arrRes[0], (Double)arrRes[1]);
            lstCantPromedio.add(cp);
            logger.info(cp.cantidad);
            logger.info(cp.promedio);
        }

        var x = new CantidadPromedio(2l, 3d);

        x = x
                .setCantidad(1000l)
                .setPromedio(444.44);

        logger.info(x);
     }
}
