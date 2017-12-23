package com.uooz.ribbon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uooz.ribbon.entity.User;

@RestController
public class RibbonController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/testRibbon")
	public List<User> rest() {
		return restTemplate.getForObject("http://spring-cloud-euerka-client" + "/hello", List.class);
	}
}
