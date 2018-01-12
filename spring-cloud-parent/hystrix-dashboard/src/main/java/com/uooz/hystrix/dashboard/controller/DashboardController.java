package com.uooz.hystrix.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.uooz.hystrix.dashboard.entity.User;

@RestController
public class DashboardController {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallback")
	@GetMapping("testDashboard")
	public User testDashboard() {
		return restTemplate.getForObject("http://spring-cloud-euerka-client/get/{1}", User.class, "1");
	}
	
	public User fallback() {
		return new User(2, "daming", "123456");
	}
}
