package com.degloba.ecommerce.compres.eventsourcing.events;

import com.degloba.domain.events.DomainEvent;
import com.degloba.events.annotations.EventAnnotation;
import com.degloba.persistence.rdbms.api.jpa.AggregateId;


/**
 * @category s'ha produit un rollback d'un {@link Pagament}
 * 
 * @author degloba
 *
 */
@EventAnnotation
public class PagamentRolledBackEvent extends DomainEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AggregateId pagamentId;
	
	public PagamentRolledBackEvent(AggregateId pagamentId){
		this.pagamentId = pagamentId;
	}
	
	public AggregateId getPagamentId() {
		return pagamentId;
	}

}
