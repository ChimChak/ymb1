package test.friend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.friend.dto.FriendDto;
import test.util.DBConnect;

public class FriendDao {
	private static FriendDao dao;
	private FriendDao() {}
	public static FriendDao getInstance() {
		if(dao==null) {
			dao=new FriendDao();
		}
		return dao;
	}
	//친구 목록을 리턴하는 메소드
	public List<FriendDto> getList(){
		//친구 정보를 누적할 List 객체 
		List<FriendDto> list=new ArrayList<>();
		//필요한 객체를 담을 지역변수 만들기
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 sql 문 준비 
			String sql="SELECT num,name,phone FROM friend ORDER BY num ASC";
			//PreparedStatement 객체의 참조값 얻어오기 
			pstmt=conn.prepareStatement(sql);
			//sql(query) 문 수행하고 결과를 ResultSet 으로 리턴 받기  
			rs=pstmt.executeQuery();
			while(rs.next()) {//cursor 를 한칸씩 내리면서 
				//cursor 가 위치한 row 에서 num, name, Phone 칼럼의 정보를 얻어낸다
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String Phone=rs.getString("Phone");
				//친구 한명의 정보를 FriendDto 객체에 담는다.
				FriendDto dto=new FriendDto(num, name, Phone);
				//배열에 FriendDto 객체의 참조값 누적 시키기
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		//친구 목록을 리턴해 준다. 		
		return list;
	}
	//친구 정보를 추가하는 메소드
	public boolean insert(FriendDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		//작업 성공 혹은 실패를 확인할 지역변수 선언하고 초기값 0 부여
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="INSERT INTO friend (num,name,phone) VALUES(?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			// ? 에 순서대로 값 바인딩하기 
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone());
			//영향을 받은 row 의 갯수를 리턴 받는다. 
			flag=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {
			return true; //작업 성공이라는 의미에서 true 를 리턴한다.
		}else {
			return false; //작업 실패라는 의미에서 false 를 리턴한다. 
		}
	}
	//친구 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		//작업 성공 혹은 실패를 확인할 지역변수 선언하고 초기값 0 부여
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="DELETE FROM friend WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			// ? 에 순서대로 값 바인딩하기 
			pstmt.setInt(1, num);
			//영향을 받은 row 의 갯수를 리턴 받는다. 
			flag=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {
			return true; //작업 성공이라는 의미에서 true 를 리턴한다.
		}else {
			return false; //작업 실패라는 의미에서 false 를 리턴한다. 
		}
	}
	//친구 정보를 수정하는 메소드
	public boolean update(FriendDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		//작업 성공 혹은 실패를 확인할 지역변수 선언하고 초기값 0 부여
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="UPDATE friend SET name=?,phone=? WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setInt(3, dto.getNum());
			//영향을 받은 row 의 갯수를 리턴 받는다. 
			flag=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {
			return true; //작업 성공이라는 의미에서 true 를 리턴한다.
		}else {
			return false; //작업 실패라는 의미에서 false 를 리턴한다. 
		}
	}
	//친구 한명의 정보를 리턴하는 메소드
	public FriendDto getData(int num) {
		//FriendDto 객체의 참조값을 담을 지역 변수 만들기
		FriendDto dto=null;
		//필요한 객체를 담을 지역변수 만들기
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 sql 문 준비 
			String sql="SELECT name,phone FROM friend WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기 
			pstmt=conn.prepareStatement(sql);
			// selection 인자 바인딩하기
			pstmt.setInt(1, num);
			//sql(query) 문 수행하고 결과를 ResultSet 으로 리턴 받기  
			rs=pstmt.executeQuery();
			if(rs.next()) {//cursor 를 한칸내려서 
				// FriendDto 객체를 생성해서
				dto=new FriendDto();
				// cursor 가 위치한 곳의 정보를 FriendDto 객체에 담는다.
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		//친구 한명의 정보를 리턴한다. 		
		return dto;
	}	
}
