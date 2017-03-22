package com.lftechnology.remittance;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
public class Resources {
    @Produces
    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Produces
    @PersistenceContext(unitName = "primary1")
    private EntityManager em1;
}
