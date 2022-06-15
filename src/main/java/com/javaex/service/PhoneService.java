package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Service
public class PhoneService {
	
	//필드
	@Autowired
	private PhoneDao phoneDao;
	
	//생성자
	
	//메소드 - gs
	
	//메소드 - 일반
	public List<PersonVo> getPersonList() {
		//코드작성
		System.out.println("PhoneController > list()");
		List<PersonVo> personList = phoneDao.getPersonList();
		return personList;
	}
	
	public int insert(PersonVo personVo) {
		//코드작성
		System.out.println("PhoneController > insert()");
		int count = phoneDao.personInsert(personVo);
		
		return count;
	}
	
	public int update(PersonVo personVo) {
		//코드작성
		System.out.println("PhoneController > update()");
		int count = phoneDao.personUpdate(personVo);
		
		return count;
	}
	
	public PersonVo getPerson(int no) {
		//코드작성
		System.out.println("PhoneController > getPerson()");
		PersonVo personVo = phoneDao.getPerson(no);
		
		return personVo;
	}
	
	public int delete(int personId) {
		//코드작성
		System.out.println("PhoneController > delete()");
		int count = phoneDao.personDelete(personId);
		
		return count;
	}
	
	
	
}
