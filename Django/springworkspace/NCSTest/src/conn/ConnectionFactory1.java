package conn;

import java.sql.*;

// 1 ~ 2 단계를 거쳐 만들어지는 컨넥션 객체를 리턴 시켜주는 컨넥션 공장
// 4단계 ~ 자원 반납
public class ConnectionFactory1 {
	// 외부 접근 못하고 , static 이니 하나만 만든다.
	private static Connection conn = null;
	 // synchronized - 쓰레드가 다중 동시 접속시 순서 세우기 작업 (동기화)
	public synchronized static Connection create() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url, user, password);
			return conn;
	}
	public synchronized static void close() {
		try {
			// 닫을 수 있는 조건 - conn 객체가 있어야 하고 닫겨 있지 않아야 한다.
			if (conn != null && !conn.isClosed())
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
