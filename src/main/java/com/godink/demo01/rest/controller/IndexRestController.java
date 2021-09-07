package com.godink.demo01.rest.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godink.demo01.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class IndexRestController {
	
	@Value("${user.password}")
	private String password;
	
	@Value("${user.name}")
	private String name;
	
	@Value("${user.pn}")
	private String pn;

	@GetMapping("/index")
	public String index(@RequestParam String name) {
		log.info("info log");
		log.debug("debug log");
		return name;
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> getBlog(){
		log.info("pn: {}", pn);
		 User user = User.builder().name(name).password(password).build();
		 return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
