package test.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 *  MyBatis 기반의 Dao 에서 필요로 하는 SqlSessinFactory 객체를 리턴해주는 
 *  클래스 정의하기 
 */
public class SqlMapConfig {
	//static 맴버 필드로 SqlSessionFactory type 선언
	private static SqlSessionFactory sessionFactory;
	//static 초기화
	static{
		//MyBatis 설정 xml 문서의 위치 
		String resource="test/mybatis/Configuration.xml";
		try{
			Reader reader=Resources.getResourceAsReader(resource);
			//SqlSessionFactory 객체의 참조값을 얻어내서 맴버필드에 저장
			sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("SqlSessionFactory 객체 생성 성공!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("SqlSessionFactory 객체 생성 실패!");
		}
	}
	//static 맴버 메소드
	public static SqlSessionFactory getSessionFactory(){
		return sessionFactory;
	}
}







