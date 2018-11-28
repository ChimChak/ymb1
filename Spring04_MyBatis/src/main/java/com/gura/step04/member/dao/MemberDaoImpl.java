package com.gura.step04.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step04.member.dto.MemberDto;
/*
 *  @Autowired 로 주입된 객체는 Spring Bean Container 에서 관리되는 객체이다.
 *  
 *  new SqlSessionTemplate() 해서 생성된 객체이고 
 *  SqlSessionTemplate 클래스는 SqlSession 인터페이스를 구현한 클래스이다. 
 */
@Repository
public class MemberDaoImpl implements MemberDao{
	//필요한 핵심 의존 객체 주입받기 (DI)
	@Autowired
	private SqlSession session;

	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
	}

	@Override
	public MemberDto getData(int num) {
		/*
		 *  mapper namespace : member
		 *  sql id : getData
		 *  parameterType : int
		 *  resultType : MemberDto 
		 */
		MemberDto dto=session.selectOne("member.getData", num);
		return dto;
	}

	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list=session.selectList("member.getList");
		return list;
	}
	
	
}



