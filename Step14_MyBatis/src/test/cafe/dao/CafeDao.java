package test.cafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.cafe.dto.CafeDto;
import test.mybatis.SqlMapConfig;

public class CafeDao {
	private static CafeDao dao;
	private static SqlSessionFactory factory;
	private CafeDao() {}
	//CafeDao 객체를 리턴해주는 static 맴버 메소드 
	public static CafeDao getInstance() {
		if(dao==null) {
			dao=new CafeDao();
			factory=SqlMapConfig.getSessionFactory();
		}
		return dao;
	}
	//전체 row 의 갯수를 리턴해주는 메소드
	public int getCount(CafeDto dto) {
		int totalCount=0;
		SqlSession session = null;
		try {
			session = factory.openSession();
			totalCount=session.selectOne("cafe.getCount", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return totalCount;
	}
	
	//조회수 증가 시키는 메소드
	public boolean addViewCount(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.update("cafe.addViewCount", num);
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
	
	//글 저장하는 메소드 
	public boolean insert(CafeDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.insert("cafe.insert", dto);
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
	//글 수정하는 메소드
	public boolean update(CafeDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.update("cafe.update", dto);
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
	//글 삭제하는 메소드
	public boolean delete(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.delete("cafe.delete", num);
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
	//글 하나의 정보 리턴하는 메소드
	public CafeDto getData(int num) {
		CafeDto dto=null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			dto=session.selectOne("cafe.getData", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
	//글 하나의 정보 리턴하는 메소드
	public CafeDto getData(CafeDto dto) {
		CafeDto resultDto=null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			resultDto=session.selectOne("cafe.getData2", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultDto;
	}
	//글 목록을 리턴하는 메소드
	public List<CafeDto> getList(CafeDto dto){
		List<CafeDto> list=null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			list=session.selectList("cafe.getList", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}























