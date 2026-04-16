package com.kh.animal.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.common.Template;
import com.kh.animal.model.dao.AnimalDao;
import com.kh.animal.model.dto.AnimalDto;

public class AnimalService {

	public int save(AnimalDto animal) {
		SqlSession session = Template.getSession();
		int result = new AnimalDao().save(session, animal);
		session.close();
		return result;
	}

}
