package com.lftechnology.remittance.producers;

import com.lftechnology.remittance.annotations.TenantEm;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

/**
 * Created by prkandel on 3/15/17.
 */
@RequestScoped
public class TenantEmProducer {
    @Produces
    @RequestScoped
    @TenantEm
    private EntityManager em;

    public void handleEntityManagerEvent(@Observes @TenantEm EntityManager em){
        this.em = em;
    }
}
