package test.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.cafe.dto.CafeCommentDto;
import test.mybatis.SqlMapConfig;

public class CafeCommentDao {
	private static CafeCommentDao dao;
	private static SqlSessionFactory factory;
	private CafeCommentDao() {}
	//참조값을 리턴해주는 static 맴버 메소드
	public static CafeCommentDao getInstance() {
		if(dao==null) {
			dao=new CafeCommentDao();
			factory=SqlMapConfig.getSessionFactory();
		}
		return dao;
	}
	//댓글 내용을 수정하는 메소드
	public boolean update(CafeCommentDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.update("cafeComment.update", dto);
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
	
	//댓글을 삭제하는 메소드
	public boolean delete(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.update("cafeComment.delete", num);
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
	
	//새로운 댓글을 저장하는 메소드
	public boolean insert(CafeCommentDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.insert("cafeComment.insert", dto);
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
	
	//저장할 댓글의 시퀀스값(primary key) 을 리턴해주는 메소드
	public int getSequence() {
		int seq=0;
		SqlSession session = null;
		try {
			session = factory.openSession();
			seq=session.selectOne("cafeComment.getSequence");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return seq;
	}
	
	//댓글 목록을 리턴하는 메소드
	public List<CafeCommentDto> getList(int ref_group){
		List<CafeCommentDto> list=null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			list=session.selectList("cafeComment.getList", ref_group);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
}













