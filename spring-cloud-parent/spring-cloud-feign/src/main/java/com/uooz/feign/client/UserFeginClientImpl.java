package com.uooz.feign.client;

import org.springframework.stereotype.Component;

import com.uooz.feign.entity.User;

@Component // 切记如果要在FeginClient上使用fallback，他的实现类一定要加入IOC容器
public class UserFeginClientImpl implements UserFeignClient {

	@Override
	public User getUserbyId(Integer id) {
		User user = new User(2, "xiaozhou", "123456");
		return user;
	}

}
