package com.godink.demo01.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.godink.demo01.model.User;
import com.godink.demo01.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Async
	@Override
	public void asyncTask1(User user) {
		log.info("asyncTask1: Thread = {} start", Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(5);
			log.info("asyncTask1: Thread = {}- user = {}", Thread.currentThread().getName(), user.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("asyncTask1: Thread = {} end", Thread.currentThread().getName());
	}

}
