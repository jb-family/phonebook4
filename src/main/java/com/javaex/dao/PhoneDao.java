package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

   @Autowired
   private SqlSession sqlSession;
   
   

   //리스트
   public List<PersonVo> getPersonList() {
      System.out.println("phoneDao > getPersonList()");
      
      List<PersonVo> personList  = sqlSession.selectList("phonebook.selectList");
      System.out.println(personList);
      
      return personList;
   }
   
   //추가
   public int personInsert(PersonVo personVo) {
	   System.out.println("phoneDao > personInsert()"); 
	   
	   int count = sqlSession.insert("phonebook.personInsert", personVo);
	   return count;
   }
   
   //map추가하는 메소드
   public int personInsert2(Map<String, String> pMap) {
	   
	   
	   int count = sqlSession.insert("phonebook.personInsert2",pMap);
	   
	   return count;
   }
   
   //삭제
   public int personDelete(int no) {
	   System.out.println("phoneDao > personDelete()");
	   
	   int count = sqlSession.delete("phonebook.personDelete", no);
	   
	   return count;
   }
   
   //1명 정보불러오기
   public PersonVo getPerson(int no) {
	   System.out.println("phoneDao > getPerson()");
	   
	   PersonVo person = sqlSession.selectOne("phonebook.getPerson", no);
	   
	   return person;
   }
   //map추가하는 메소드
   public Map<String, Object> getPerson2(int no) {
	   System.out.println("phoneDao > getPerson2()");
	   
	   Map<String, Object> pMap = sqlSession.selectOne("phonebook.getPerson2", no);
	  System.out.println("pomapppp"+pMap);
	   return pMap;
   }
   
   
   //변경
   public int personUpdate(PersonVo personVo) {
	   System.out.println("phoneDao > personUpdate()");
	   
	   int count = sqlSession.update("phonebook.personUpdate", personVo);
	   
	   return count;
   }
   
   
   
}