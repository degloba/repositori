package com.degloba.security.gae.security;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.security.core.GrantedAuthority;

import com.degloba.security.impl.spring.authorities.AppRole;


/**
 * @author degloba
 */
public class AppRoleTests {

	@Test
	public void getAuthorityReturnsRoleName() {
		GrantedAuthority admin = AppRole.ADMIN;

		assertEquals("ROLE_ADMIN", admin.getAuthority());
	}

	@Test
	public void bitsAreCorrect() throws Exception {
		// If this fails, someone has modified the Enum and the Datastore is probably
		// corrupt!
		assertEquals(0, AppRole.ADMIN.getBit());
		assertEquals(1, AppRole.NEW_USER.getBit());
		assertEquals(2, AppRole.USER.getBit());
	}
}
