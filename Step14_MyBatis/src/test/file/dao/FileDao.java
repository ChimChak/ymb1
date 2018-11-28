package test.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.file.dto.FileDto;
import test.mybatis.SqlMapConfig;

public class FileDao {
	private static FileDao dao;
	private static SqlSessionFactory factory;
	private FileDao() {}
	//FileDao 객체를 리턴해주는 static 맴버 메소드 
	public static FileDao getInstance() {
		if(dao==null) {
			dao=new FileDao();
			factory=SqlMapConfig.getSessionFactory();
		}
		return dao;
	}
	//검색 키워드가 있는 키워드에 맞는 갯수를 리턴하는 메소드
	public int getCount(FileDto dto) {
		//파일의 갯수를 저장할 지역변수 
		int count=0;
		SqlSession session = null;
		try {
			session = factory.openSession();
			count=session.selectOne("file.getCount", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	//파일 정보 삭제하는 메소드
	public boolean delete(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			/*
			 *  sql id : delete
			 *  parameterType : int
			 */
			flag=session.delete("file.delete", num);
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
	
	//파일 다운로드 수 증가 시키는 메소드
	public boolean addDownCount(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.update("file.addDownCount", num);
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
	
	//인자로 전달된 번호에 해당하는 파일 정보를 리턴해주는 메소드 
	public FileDto getData(int num) {
		FileDto dto=null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			dto=session.selectOne("file.getData", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
	
	//파일 정보 저장하는 메소드
	public boolean insert(FileDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.insert("file.insert", dto);
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
	/* 인자로 전달된 FileDto 에 startRowNum 과 endRowNum 을 이용해서 
	   select 하는 메소드 
	   
	   1. 파일 번호에 대해서 내림차순 정렬을 한다.
	   2. 정렬한 row 에 대해 ROWNUM 을 부여한다.
	   3. WHERE 절에서 ROWNUM 이 
	   	  startRowNum <= ROWNUM  <= endRowNum 
	      범위에 있는 row 만 select 되도록 한다. 
	    
	   SELECT *
	   FROM (SELECT result1.*, ROWNUM rnum
	   		 FROM (SELECT num,writer,title,orgFileName,fileSize,downCount,regdate
		           FROM board_file
		           ORDER BY num DESC) result1 )
	   WHERE rnum BETWEEN ? AND ?
	*/
	public List<FileDto> getList(FileDto dto){
		List<FileDto> list=null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			list=session.selectList("file.getList", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}












