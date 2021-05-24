package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conn.ConnectionFactory1;
import vo.Testvo;




public class TestDAO  {

	
	public int insert(Testvo vo) throws SQLException {
		String sql ="INSERT INTO TEST (ID,NAME,KOR,MATH,ENG) VALUES (\"TEST_SEQ\".NEXTVAL,?,?,?,?)";
				
		Connection conn = ConnectionFactory1.create();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,vo.getName()); 
		pstmt.setInt(2,vo.getKor());
		pstmt.setInt(3,vo.getMath());
		pstmt.setInt(4,vo.getEng());
		
		int res =pstmt.executeUpdate();
		
		conn.close();
	
		
		return res;
	}

//	@Override
//	public int delete(Long key) throws SQLException {
//		String sql ="DELETE BOOK WHERE BOOKID = ?";
//		Connection conn = ConnectionFactory1.create();
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setLong(1,key);
//		
//		int res = pstmt.executeUpdate();
//		conn.close();
//		return res;
//	}
//
//	@Override
//	public int update(BookVO vo) throws SQLException {
//		String sql ="UPDATE BOOK SET BOOKNAME =?, PUBLISHER = ?, PRICE =? \r\n"
//				+ " WHERE bookid = ?";
//		Connection conn = ConnectionFactory1.create();
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1,vo.getBookname());
//		pstmt.setString(2,vo.getPublisher());
//		pstmt.setLong(3, vo.getPrice());
//		pstmt.setLong(4, vo.getBookid());
//		int res = pstmt.executeUpdate();
//		
//		conn.close();
//		
//		return res;
//	}
//
	
	public Testvo select(int id) throws SQLException {
		String sql = "SELECT * FROM BOOK WHERE ID =?";
		Connection conn = ConnectionFactory1.create();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		ResultSet rs = pstmt.executeQuery();
		Testvo vo = new Testvo();
		while(rs.next()) {
			vo.setId(rs.getInt("ID"));
			vo.setName(rs.getString("NAME"));
			vo.setKor(rs.getInt("KOR"));
			vo.setMath(rs.getInt("MATH"));
			vo.setEng(rs.getInt("ENG"));
		}
		conn.close();
		
		
		return vo;
	}
//
//	@Override
//	public List<BookVO> selectAll() throws SQLException {
//		String sql = "SELECT * FROM BOOK ";
//		Connection conn = ConnectionFactory1.create();
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		BookVO vo = new BookVO();
//		List<BookVO> data = new ArrayList<>();
//		while(rs.next()) {
//			vo.setBookid(rs.getLong("BOOKID"));
//			vo.setBookname(rs.getString("BOOKNAME"));
//			vo.setPublisher(rs.getString("PUBLISHER"));
//			vo.setPrice(rs.getInt("PRICE"));
//			data.add(vo);
//		}
//		conn.close();
//		return data;
//	}
//
//	@Override
//	public List<BookVO> selectByConditions(String conditions) throws SQLException {
//		String sql = "SELECT * FROM BOOK "+conditions;
//		Connection conn = ConnectionFactory1.create();
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		BookVO vo = new BookVO();
//		List<BookVO> data = new ArrayList<>();
//		while(rs.next()) {
//			vo.setBookid(rs.getLong("BOOKID"));
//			vo.setBookname(rs.getString("BOOKNAME"));
//			vo.setPublisher(rs.getString("PUBLISHER"));
//			vo.setPrice(rs.getInt("PRICE"));
//			data.add(vo);
//		}
//		conn.close();
//		return data;
//	}
//
//	@Override
//	public long getMaxNum() throws SQLException {
//		String sql = "SELECT MAX(BOOKID) FROM BOOK";
//		Connection conn = ConnectionFactory1.create();
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		long max = 0;
//		
//		while (rs.next())  {
//			max = rs.getLong(1);
//		}
//		conn.close();
//		return max;
//	}
//
//	@Override
//	public long getMinNum() throws SQLException {
//		String sql = "SELECT MIN(BOOKID) FROM BOOK";
//		Connection conn = ConnectionFactory1.create();
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		long min = 0;
//		
//		while (rs.next())  {
//			min = rs.getLong(1);
//		}
//		conn.close();
//		return min;
//	}

}
