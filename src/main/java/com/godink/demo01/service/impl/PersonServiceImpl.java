package com.godink.demo01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godink.demo01.dao.PersonDao;
import com.godink.demo01.model.PersonDo;
import com.godink.demo01.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;

	@Override
	public List<PersonDo> getAllPerson() {
		return personDao.getAllPerson();
	}

}
