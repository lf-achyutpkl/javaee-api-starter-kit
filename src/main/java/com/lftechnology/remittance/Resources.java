package com.lftechnology.remittance;

import com.lftechnology.remittance.enums.PCUnitName;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
public class Resources {

    @PersistenceContext(unitName = "tenant1")
    private EntityManager emDb1;

    @PersistenceContext(unitName = "tenant2")
    private EntityManager emDb2;

    public EntityManager createEntityManger(PCUnitName name) {
        switch (name) {
            case DB1:
                return emDb1;
            case DB2:
                return emDb2;
            default:
                throw new RuntimeException("unknown persistance context unit name");
        }
    }
}
