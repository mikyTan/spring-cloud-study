package com.uooz.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.uooz.feign.client.UserFeignClient;
import com.uooz.feign.entity.User;

@RestController
public class UserController {

	@Autowired
	private UserFeignClient feignClient;

	@GetMapping("testFeign")
	@HystrixCommand(fallbackMethod = "")
	public User getUserById() {
		User user = feignClient.getUserbyId(1);
		return user;
	}

	public User fallback() {
		User user = new User(2, "xiaozhou", "123456");
		return user;
	}
}
