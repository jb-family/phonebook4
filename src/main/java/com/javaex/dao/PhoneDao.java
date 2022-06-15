package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

   @Autowired
   private SqlSession sqlSession;
   
   
   
   @Autowired
   private DataSource dataSource;
   
   
   // 0. import java.sql.*;
   private Connection conn = null;
   private PreparedStatement pstmt = null;
   private ResultSet rs = null;

   private String driver = "oracle.jdbc.driver.OracleDriver";
   private String url = "jdbc:oracle:thin:@localhost:1521:xe";
   private String id = "phonedb";
   private String pw = "phonedb";
   
   
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
   
   //삭제
   public int personDelete(int no) {
	   System.out.println("phoneDao > personDelete()");
	   
	   int count = sqlSession.delete("phonebook.personDelete", no);
	   
	   return count;
   }
   
   //변경
   public int personUpdate(PersonVo personVo) {
	   System.out.println("phoneDao > personUpdate()");
	   
	   int count = sqlSession.update("phonebook.personUpdate", personVo);
	   
	   return count;
   }
   
   //1명 정보불러오기
   public PersonVo getPerson(int no) {
	   System.out.println("phoneDao > getPerson()");
	   
	   PersonVo person = sqlSession.selectOne("phonebook.getPerson", no);
	   
	   return person;
   }
   
   
}