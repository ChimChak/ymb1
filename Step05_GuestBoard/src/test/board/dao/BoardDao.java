package test.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.board.dto.BoardDto;
import test.util.DbcpBean;
/*
 *  날짜 변환 함수 활용
 *  
 *  2000.12.10 오전 10:24 => TO_CHAR(regdate,'YYYY.MM.DD AM HH:MI')
 *  2000.12.10 15:24 => TO_CHAR(regdate,'YYYY.MM.DD HH24:MI')
 *  2000년12월10일 오전 10시24분 
 *  => TO_CHAR(regdate, 'YYYY"년"MM"월"DD"일" AM HH"시"MI"분"')
 *  2000년 12월 10일 오전 10시 24분 
 *  => TO_CHAR(regdate, 'YYYY"년 "MM"월 "DD"일 " AM HH"시 "MI"분"')
 *  
 *  - 문자열로 작성할때는 " 바로앞에 역슬레시가 필요하다 
 *  String sql="TO_CHAR(regdate, 'YYYY\"년 \"MM\"월 \"DD\"일 \" AM HH\"시 \"MI\"분\"')";
 */
public class BoardDao {
	
	private static BoardDao dao;
	//외부에서 객체 생성할수 없도록 생성자의 접근 지정자를 private 로 지정 
	private BoardDao() {}
	//자신의 참조값을 리턴해주는 static 메소드를 제공한다. 
	public static BoardDao getInstance() {
		if(dao==null) {
			dao=new BoardDao();
		}
		return dao;
	}
	//글정보를 수정하는 메소드
	public boolean update(BoardDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DbcpBean().getConn();
			String sql="UPDATE board_guest"
					+ " SET writer=?, title=?, content=?"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum());
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
			return true;
		}else {
			return false;
		}				
	}
	
	//글정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DbcpBean().getConn();
			String sql="DELETE FROM board_guest WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
			return true;
		}else {
			return false;
		}		
	}
	
	//글 하나의 정보를 리턴하는 메소드
	public BoardDto getData(int num) {
		//BoardDto 객체의 참조값을 담을 지역변수 
		BoardDto dto=null;
		//필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			// Connection pool 에서 Connection 객체 하나 가져오기 
			conn=new DbcpBean().getConn();
			// 실행할 sql 문 준비 
			String sql="SELECT writer,title,content,TO_CHAR(regdate, 'YYYY.MM.DD AM HH:MI') AS regdate "
					+ " FROM board_guest"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기 
			pstmt=conn.prepareStatement(sql);
			// ? 에 글번호 바인딩
			pstmt.setInt(1, num);
			// sql(쿼리) 문을 수행하고 ResultSet 객체를 리턴 받는다.
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//BoardDto 객체를 생성해서 
				dto=new BoardDto();
				//글 하나의 정보를 setter 메소드를 이용해서 담는다. 
				dto.setNum(num);
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
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
		//글하나의 정보가 담겨 있는 BoardDto 객체의 참조값을 리턴해준다.
		return dto;
	}//getData()
	
	//글 목록을 리턴하는 메소드
	public List<BoardDto> getList(){
		List<BoardDto> list=new ArrayList<>();
		//필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			// Connection pool 에서 Connection 객체 하나 가져오기 
			conn=new DbcpBean().getConn();
			// 실행할 sql 문 준비 
			String sql="SELECT num,writer,title,TO_CHAR(regdate, 'YYYY.MM.DD AM HH:MI') AS regdate"
					+ " FROM board_guest"
					+ " ORDER BY num DESC";
			//PreparedStatement 객체의 참조값 얻어오기 
			pstmt=conn.prepareStatement(sql);
			// sql(쿼리) 문을 수행하고 ResultSet 객체를 리턴 받는다.
			rs=pstmt.executeQuery();
			
			//반복문 돌면서 
			while(rs.next()) {//커서를 한칸씩 내리면서
				//BoardDto 객체를 생성한 다음
				BoardDto dto=new BoardDto();
				//커서가 위치한 곳의 데이터를 BoardDto 객체에 저장하고 
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setRegdate(rs.getString("regdate"));
				//BoardDto 객체의 참조값을 List 객체에 누적 시키기 
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
		
		return list;
	}
	
	// 글정보를 저장하는 메소드
	public boolean insert(BoardDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DbcpBean().getConn();
			String sql="INSERT INTO board_guest"
					+ " (num, writer, title, content, regdate)"
					+ " VALUES(board_guest_seq.NEXTVAL,? ,? ,? , SYSDATE)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
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
			return true;
		}else {
			return false;
		}
	}
}




















