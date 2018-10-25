package dbpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	public static Connection getConnection() {
		//DB커넥션을 받아오는 메서드
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hkitedu";

		try {
			Class.forName(driver);
			System.out.println("db드라이버 연결 성공");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("db계정 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("db드라이버 연결 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("db계정 연결 실패");
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeConn(ResultSet rs, PreparedStatement ps,
			Connection conn) {
		//DB연결 객체를 해제하는 메서드
		try {
			if (rs != null)
				rs.close();
			System.out.println("ResultSet 해제 완료");
		} catch (Exception e) {
			System.out.println("ResultSet 해제 실패");
			e.printStackTrace();
		}
		try {
			if (ps != null)
				ps.close();
			System.out.println("PreparedStatement 해제 완료");
		} catch (Exception e) {
			System.out.println("PreparedStatement 해제 실패");
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
			System.out.println("Connection 해제 완료");
		} catch (Exception e) {
			System.out.println("Connection 해제 실패");
			e.printStackTrace();
		}
	}
}
