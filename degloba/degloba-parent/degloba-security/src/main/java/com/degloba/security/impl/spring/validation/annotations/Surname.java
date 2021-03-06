package com.degloba.security.impl.spring.validation.annotations;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.degloba.security.spring.gae.validation.SurnameValidator;

/**
 * @author Luke Taylor
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SurnameValidator.class)
public @interface Surname {
	String message() default "{samples.gae.surname}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
