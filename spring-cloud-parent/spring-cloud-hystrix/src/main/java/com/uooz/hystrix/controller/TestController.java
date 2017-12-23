package com.uooz.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.uooz.hystrix.entity.User;

@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
	 * 该注解的作用为使该方法和hystrix处于同一个线程
	 * 如果不配置，默认配置为THREAD,就是hystrix处于一个隔离的线程
	 * @param id
	 * @return
	 */
	@GetMapping("get/{id}")
	@HystrixCommand(fallbackMethod = "getUserByIdFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE") })
	public User getUserById(@PathVariable("id") Integer id) {
		User user = restTemplate.getForObject("http://spring-cloud-euerka-client/hello/" + id, User.class);
		return user;
	}

	public User getUserByIdFallBack(Integer id) {
		User user = new User(id, "xiaohua", "456789");
		return user;
	}
}
