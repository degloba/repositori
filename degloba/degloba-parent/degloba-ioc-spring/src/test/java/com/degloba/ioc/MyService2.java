package com.degloba.ioc;

import javax.inject.Named;

@Named("service2")
public class MyService2 implements Service {
	public String sayHello() {
		return "I am Service 2";
	}
}
