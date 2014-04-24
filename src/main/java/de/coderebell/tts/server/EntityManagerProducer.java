package de.coderebell.tts.server;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by MALPI on 24.04.2014.
 */
public class EntityManagerProducer {
    @PersistenceContext(name = "persistenceUnit", type= PersistenceContextType.EXTENDED)
    EntityManager em;

    @Produces
    public EntityManager createEntityManager() {
        return em;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
