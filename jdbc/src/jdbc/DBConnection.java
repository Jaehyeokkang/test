package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤
//db연결해서 사용할 connection 객체를 반환
public class DBConnection {
	private static DBConnection dbconn = new DBConnection();
	private String url = "jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=UTC";
	
	private DBConnection() {}
	
	public Connection conn() {		
		try {
			//드라이버 로드. 클래스 이름으로 찾아서 메모리에 얹음
			Class.forName("oracle.jdbc.OracleDriver");
			//db에 로그인. 세션 수립하고 생성된 connection 객체 반환
			return DriverManager.getConnection(url, "root", "Jaehyeokk8910;");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static DBConnection getInstance() {
		return dbconn;
	}
	
}




