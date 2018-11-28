package test.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.member.dto.MemberDto;
import test.mybatis.SqlMapConfig;

public class MemberDao {
	//static 필드 
	private static MemberDao dao;
	private static SqlSessionFactory factory;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if(dao==null) {
			dao=new MemberDao();
			//SqlSessionFactory 객체도 static 필드에 저장하기 
			factory=SqlMapConfig.getSessionFactory();
		}
		return dao;
	}
	//회원 목록을 리턴하는 메소드
	public List<MemberDto> getList(){
		SqlSession session=null;
		List<MemberDto> list=null;
		try {
			session=factory.openSession();
			list=session.selectList("member.getList");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	//회원 정보를 추가하는 메소드
	public boolean insert(MemberDto dto) {
		//DB 에 작업 하기 위한 SqlSession 객체를 담을 지역변수 만들기
		SqlSession session=null;
		int flag=0;
		try {
			//SqlSessionFactory 객체로 부터 SqlSession 객체 얻어내기
			// .openSession(auto commit 여부)  // default : false
			session=factory.openSession(true); 
			// member.insert : mapper 의 namespace . sql id 
			// dto :  MemberDto type : parameterType 
			// flag : 영향을 받은 row 의 갯수 리턴 
			flag=session.insert("member.insert", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
	//회원 정보를 삭제하는 메소드
	public boolean delete(int num) {
		SqlSession session=null;
		int flag=0;
		try {
			session=factory.openSession(true);
			flag=session.delete("member.delete", num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
	//회원 정보를 수정하는 메소드
	public boolean update(MemberDto dto) {
		SqlSession session=null;
		int flag=0;
		try {
			session=factory.openSession(true);
			flag=session.update("member.update", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
	//회원 한명의 정보를 리턴하는 메소드
	public MemberDto getData(int num) {
		SqlSession session=null;
		MemberDto dto=null;
		try {
			session=factory.openSession(true);
			dto=session.selectOne("member.getData", num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}	
}



