package test.users.dao;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import test.mybatis.SqlMapConfig;
import test.users.dto.UsersDto;

public class UsersDao {
	private static UsersDao dao;
	private static SqlSessionFactory factory;
	//외부에서 객체 생성하지 못하도록 
	private UsersDao() {}
	//UsersDao 객체의 참조값을 리턴해주는 static 메소드 제공 
	public static UsersDao getInstance() {
		if(dao==null) {
			dao=new UsersDao();
			factory=SqlMapConfig.getSessionFactory();
		}
		return dao;
	}
	//인자로 전달된 회원정보를 수정 반영하는 메소드
	public boolean update(UsersDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			/*
			 * users => mapper 의 namespace
			 * update => sql id
			 * dto => UsersDto type => parameterType
			 * flag => sql 문의 영향을 받은 row 의 갯수가 리턴된다. 
			 */
			flag=session.update("users.update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//인자로 전달된 아이디를 이용해서 정보를 삭제하는 메소드
	public boolean delete(String id) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.delete("users.delete", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//인자로 전달된 아이디를 이용해서 회원정보를 리턴해주는 메소드
	public UsersDto getData(String id) {
		UsersDto dto=null;
		SqlSession session=null;
		try {
			session=factory.openSession();
			/*  users => mapper namespace
			 *  getData => sql id
			 *  id => String => parameterType
			 *  dto => UsersDto => resultType
			 *  selectOne() => row 하나만 select 할 경우
			 *  selectOne() 메소드를 호출하면 resultType 에 명시한 데이터가
			 *  메소드의 return type 이 된다.  
			 */
			dto=session.selectOne("users.getData", id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	
	//인자로 전달된 회원 정보가 유효한 정보인지 여부를 리턴하는 메소드
	public boolean isValid(UsersDto dto) {
		String id=null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			/*
			 *  .selectOne() 을 호출하면 mapper 의 resultType 이
			 *  메소드의 return type 이 된다. 
			 */
			id=session.selectOne("users.isValid", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if(id!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	//인자로 전달되는 아이디를 사용가능한지 여부를 리턴해주는 메소드
	public boolean canUseId(String inputId) {
		String id=null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			id=session.selectOne("users.canUseId", inputId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if(id==null) {// id 가 null 이면 사용가능한 아이디 
			return true;
		}else {
			return false;
		}
	}
	
	//새로운 회원 정보를 추가 하는 메소드
	public boolean insert(UsersDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			// .openSession() 은 auto commit 이 false 이다
			// 따라서 custom 으로 commit 혹은 rollback 을 해야 한다.
			session = factory.openSession();
			flag=session.insert("users.insert", dto);
			//session.update(null, null);
			//session.delete(null, null);
			//session.insert(null, null);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
}
















