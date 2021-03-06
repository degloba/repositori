package com.degloba.ecommerce.enviaments.domain.factories;

import javax.inject.Inject;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import com.degloba.domain.annotations.DomainFactory;
import com.degloba.ecommerce.enviaments.domain.persistence.rdbms.jpa.Enviament;
import com.degloba.persistence.rdbms.api.jpa.AggregateId;

/**
 * @category Fàbrica de {@link Enviament}
 */
@DomainFactory
public class EnviamentsFactory {

    @Inject
    private AutowireCapableBeanFactory spring;

    public Enviament creaEnviament(AggregateId comandaId) {
    	///////Key aggregateId = KeyFactory.stringToKey( UUID.randomUUID().toString());
        Enviament enviament = new Enviament(AggregateId.generate(), comandaId);
        spring.autowireBean(enviament);
        return enviament;
    }
}
