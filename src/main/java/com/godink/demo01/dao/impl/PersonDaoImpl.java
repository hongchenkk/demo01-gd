package com.godink.demo01.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.godink.demo01.dao.PersonDao;
import com.godink.demo01.mapper.PersonMapper;
import com.godink.demo01.model.PersonDo;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private PersonMapper personMapper;

	@Override
	public List<PersonDo> getAllPerson() {
		return personMapper.getAllPerson();
	}
}
