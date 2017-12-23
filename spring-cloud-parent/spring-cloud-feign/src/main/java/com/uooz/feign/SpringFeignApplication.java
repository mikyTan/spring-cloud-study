package com.uooz.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class SpringFeignApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringFeignApplication.class, args);
	}

}
