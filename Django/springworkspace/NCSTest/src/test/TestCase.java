package test;

import static org.junit.Assert.assertSame;

import java.sql.SQLException;

import org.junit.Test;

import dao.TestDAO;
import vo.Testvo;

public class TestCase {
	//입력확인 테스트
	// 성공확인 
	@Test
	public void testOfinsert() {
		TestDAO dao = new TestDAO();
		Testvo vo = new Testvo("홍길동",100,100,100);
		try {
			int res = dao.insert(vo);
			assertSame(res,1);
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			
		}
	}
}
