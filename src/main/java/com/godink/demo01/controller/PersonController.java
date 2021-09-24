package com.godink.demo01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godink.demo01.model.PersonDo;
import com.godink.demo01.service.PersonService;

/**
 * @Description: 测试mybaties+本地mysql 
 * @author: Hong.Chen
 * @date: 2021年9月24日 上午10:19:06
 */
@RequestMapping("/person")
@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/list")
	@ResponseBody
	public String getAllPerson() {
		List<PersonDo> allPerson = personService.getAllPerson();
		StringBuilder sb = new StringBuilder("");
		allPerson.forEach(person -> {
			sb.append(person.toString());
		});
		return sb.toString();
	}
}
