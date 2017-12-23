package com.uooz.eureka.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uooz.eureka.client.entity.User;

@RestController
public class TestController {

	@GetMapping("/get/{id}")
	public User hello(@PathVariable("id") Integer id) throws Exception {
		User user = new User();
		user.setId(id);
		user.setUsername("xiaoming");
		user.setPassword("123456");
		return user;
	}
}
