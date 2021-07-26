package edu.it.ejemplos;

import edu.it.components.ConectorJPA;
import org.apache.log4j.Logger;
import edu.it.entities.*;
import java.util.UUID;

public class Transacciones implements Runnable {
    Logger logger = Logger.getLogger(Transacciones.class);

    public void run() {
        var em = new ConectorJPA().getEntityManager();

        A a = new A(UUID.randomUUID().toString(), "Valor uno");
        B b = new B(UUID.randomUUID().toString(), "Valor dos");

        try {
            int z = 1+1;
            var tx = em.getTransaction();
            tx.begin();
            em.merge(b);
            em.flush();
            tx.commit();
        }
        catch (Throwable ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException("Propago la exception para que se sepa que no concluyo !!!!");
        }
    }
}
