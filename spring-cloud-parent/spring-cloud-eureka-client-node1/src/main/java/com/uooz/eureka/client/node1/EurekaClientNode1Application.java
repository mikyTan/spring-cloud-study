package com.uooz.eureka.client.node1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient//应用范围更广  //@EnableEurekaClient只针对eureka注册中心
@SpringBootApplication
public class EurekaClientNode1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientNode1Application.class, args);
	}
}
