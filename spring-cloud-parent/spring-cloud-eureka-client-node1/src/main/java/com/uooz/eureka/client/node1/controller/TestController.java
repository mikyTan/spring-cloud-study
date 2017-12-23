package com.uooz.eureka.client.node1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uooz.eureka.client.node1.entity.User;

@RestController
public class TestController {

	@GetMapping("hello")
	public User hello() {
		User user = new User();
		user.setId(1);
		user.setUsername("xiaoming");
		user.setPassword("123456");
		return user;
	}
}
