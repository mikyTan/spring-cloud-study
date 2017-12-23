package com.uooz.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uooz.feign.entity.User;

@FeignClient(name = "spring-cloud-euerka-client", fallback = UserFeginClientImpl.class)
public interface UserFeignClient {

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	User getUserbyId(@PathVariable("id") Integer id);
}
