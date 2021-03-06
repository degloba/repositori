package com.degloba.events.handlers;

import java.lang.reflect.Method;

import org.springframework.beans.factory.BeanFactory;

import com.degloba.events.api.IEvent;
import com.degloba.events.api.IEventHandler;

/**
 * @category Handler d'events de tipus d'events {@link IEvent} implementat amb Spring
 * 
 * @author degloba
 */
public class SpringEventHandler<T extends IEvent> implements IEventHandler<T> {

    private final Class<?> eventType;
    private final String beanName;
    private final Method method;
    private final BeanFactory beanFactory;

    /**
     *  Handler d'events de tipus d'events {@link IEvent} implementat amb Spring
     *  
     * @param eventType
     * @param beanName
     * @param method
     * @param beanFactory
     */
    public SpringEventHandler(Class<?> eventType, String beanName, Method method, BeanFactory beanFactory) {
        this.eventType = eventType;
        this.beanName = beanName;
        this.method = method;
        this.beanFactory = beanFactory;
    }

    public boolean potGestionar(T event) {
        return eventType.isAssignableFrom(event.getClass());
    }

    public void gestiona(T event) {
        Object bean = beanFactory.getBean(beanName);
        try {
            method.invoke(bean, event);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
