package com.degloba.domain.specification;

import static org.junit.jupiter.api.Assertions.*;

import com.degloba.domain.specifications.OrSpecification;
import com.degloba.domain.specifications.Specification;


import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @category valida el funcionament de l'Specification OR
 * 
 * NO UTILITZA L'SPECIFICATION D'SPRING
 * 
 * @author degloba
 *
 */
public class OrSpecificationTest {
    
    private Specification<String> specification1;
    
    private Specification<String> specification2;
    
    private String fact = "abc";
    
    private Specification<String> instance;
    
    @BeforeEach
    public void setUp() {
        specification1 = mock(Specification.class);
        specification2 = mock(Specification.class);
        instance = new OrSpecification<String>(specification1, specification2);
    }

    @Test
    public void testIsSatisfiedByTrueTrue() {
        when(specification1.isSatisfiedBy(fact)).thenReturn(true);
        when(specification2.isSatisfiedBy(fact)).thenReturn(true);
        assertTrue(instance.isSatisfiedBy(fact));
    }

    @Test
    public void testIsSatisfiedByTrueFalse() {
        when(specification1.isSatisfiedBy(fact)).thenReturn(true);
        when(specification2.isSatisfiedBy(fact)).thenReturn(false);
        assertTrue(instance.isSatisfiedBy(fact));
    }

    @Test
    public void testIsSatisfiedByFalseTrue() {
        when(specification1.isSatisfiedBy(fact)).thenReturn(false);
        when(specification2.isSatisfiedBy(fact)).thenReturn(true);
        assertTrue(instance.isSatisfiedBy(fact));
    }

    @Test
    public void testIsSatisfiedByFalseFalse() {
        when(specification1.isSatisfiedBy(fact)).thenReturn(false);
        when(specification2.isSatisfiedBy(fact)).thenReturn(false);
        assertFalse(instance.isSatisfiedBy(fact));
    }

    @Test
    public void testIsSatisfiedBy() {
    }
    
}
