package test.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import test.users.dto.UsersDto;
import test.util.DbcpBean;

public class UsersDao {
	private static UsersDao dao;
	//외부에서 객체 생성하지 못하도록 
	private UsersDao() {}
	//UsersDao 객체의 참조값을 리턴해주는 static 메소드 제공 
	public static UsersDao getInstance() {
		if(dao==null) {
			dao=new UsersDao();
		}
		return dao;
	}
	//인자로 전달된 회원정보를 수정 반영하는 메소드
	public boolean update(UsersDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			String sql = "UPDATE users "
					+ " SET pwd=?,email=?"
					+ " WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPwd());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getId());
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//인자로 전달된 아이디를 이용해서 정보를 삭제하는 메소드
	public boolean delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			String sql = "DELETE FROM users WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//인자로 전달된 아이디를 이용해서 회원정보를 리턴해주는 메소드
	public UsersDto getData(String id) {
		//UsersDto 객체의 참조값을 담을 변수 미리 만들기  
		UsersDto dto=null;
		//필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// Connection pool 에서 Connection 객체 하나 가져오기 
			conn = new DbcpBean().getConn();
			// 실행할 sql 문 준비 
			String sql = "SELECT pwd,email,regdate"
					+ " FROM users"
					+ " WHERE id=?";
			//PreparedStatement 객체의 참조값 얻어오기 
			pstmt = conn.prepareStatement(sql);
			// ? 에 필요한 값 바인딩 
			pstmt.setString(1, id);
			// sql(쿼리) 문을 수행하고 ResultSet 객체를 리턴 받는다.
			rs = pstmt.executeQuery();
			if(rs.next()) {// select 된 row 가 존재한다면...
				dto=new UsersDto();
				dto.setId(id);
				dto.setPwd(rs.getString("pwd"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		//회원 정보가 담긴 UsersDto 객체의 참조값 리턴해주기
		return dto;
	}
	
	//인자로 전달된 회원 정보가 유효한 정보인지 여부를 리턴하는 메소드
	public boolean isValid(UsersDto dto) {
		// select 된 row 가 있는지 여부 (아이디 비밀번호가 맞는지 여부)
		boolean isValid=false;
		//필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// Connection pool 에서 Connection 객체 하나 가져오기 
			conn = new DbcpBean().getConn();
			// 실행할 sql 문 준비 
			String sql = "SELECT * FROM users "
					+ " WHERE id=? AND pwd=?";
			//PreparedStatement 객체의 참조값 얻어오기 
			pstmt = conn.prepareStatement(sql);
			// ? 에 필요한 값 바인딩 
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			// sql(쿼리) 문을 수행하고 ResultSet 객체를 리턴 받는다.
			rs = pstmt.executeQuery();
			//select 된 row 가 존재 한다면
			if (rs.next()) {
				//유효한 정보라고 표시한다. 
				isValid=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return isValid;
	}
	
	//인자로 전달되는 아이디를 사용가능한지 여부를 리턴해주는 메소드
	public boolean canUseId(String inputId) {
		//사용 가능한지 여부를 담을 지역변수 만들고 초기값 true 부여 
		boolean canUse=true;
		//필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// Connection pool 에서 Connection 객체 하나 가져오기 
			conn = new DbcpBean().getConn();
			// 실행할 sql 문 준비 
			String sql = "SELECT id FROM users"
					+ " WHERE id=?";
			//PreparedStatement 객체의 참조값 얻어오기 
			pstmt = conn.prepareStatement(sql);
			// ? 에 필요한 값 바인딩 
			pstmt.setString(1, inputId);
			// sql(쿼리) 문을 수행하고 ResultSet 객체를 리턴 받는다.
			rs = pstmt.executeQuery();
			//select 된 결과 셋이 있으면
			if (rs.next()) {
				//가입 불가한 아이디 이다. 
				canUse=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		//지역 변수에 있는 값을 리턴해준다. 
		return canUse;
	}
	
	//새로운 회원 정보를 추가 하는 메소드
	public boolean insert(UsersDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			// INSERT 구문 작성 
			String sql = "INSERT INTO users"
					+ " (id, pwd, email, regdate)"
					+ " VALUES(?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩하기
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getEmail());
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
}
















