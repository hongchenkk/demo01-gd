package com.godink.demo01.scheduler;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.godink.demo01.model.User;
import com.godink.demo01.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledTask {
	
	@Autowired
	private UserService userService;
	
	//TODO:暂时注释
	//@Scheduled(cron = "*/2 * * * * ?")
	public void task1() {
		log.info("task1: Thread-name={}", Thread.currentThread().getName());
	}
	
	//TODO:暂时注释
	//@Scheduled(cron = "*/2 * * * * ?")
	public void task2() {
		log.info("task2: Thread-name={}", Thread.currentThread().getName());
	}
	
	//TODO:暂时注释
	//@Scheduled(cron = "*/2 * * * * ?")
	public void task3() {
		log.info("task3: Thread-name={}", Thread.currentThread().getName());
	}
	
	//TODO:暂时注释
	//@Scheduled(cron = "*/2 * * * * ?")
	public void task4() {
		log.info("task4: Thread-name={}", Thread.currentThread().getName());
		User user = new User();
		Random ra = new Random();
		user.setName("chong"+ra.nextInt(100));
		user.setAge(ra.nextInt(100));
		user.setOk(true);
		userService.asyncTask1(user);
	}
}
