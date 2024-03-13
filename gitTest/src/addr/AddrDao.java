package addr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddrDao {
	private DBConnect dbConnect;
	public AddrDao(){
		dbConnect = DBConnect.getInstance();
	}
	public int insert(Addr m) {
		Connection conn = dbConnect.conn();
		String sql = "insert into addr values(seq_addr.nextval, ?, ?, ?)";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getTel());
			pstmt.setString(3, m.getAddr());
			cnt = pstmt.executeUpdate();
			System.out.println(cnt+"줄 추기");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}return cnt;
		}
	public int update(Addr m) {
		Connection conn = dbConnect.conn();
		String sql = "update addr set tel=?,addr=? where num = ? ";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getTel());
			pstmt.setString(2, m.getAddr());
			pstmt.setInt(3, m.getNum());
			cnt = pstmt.executeUpdate();
			System.out.println(cnt+"줄 수정");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return cnt;
		
	}
	public int delete(int num) {
		Connection conn = dbConnect.conn();
		String sql = "delete addr where num  =  ?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "줄 삭제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return cnt;
	}
	
	public Addr findById(int seq) {
		Connection conn = dbConnect.conn();
		String sql = "select * from addr where num = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Addr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return null;
	}
	
	public ArrayList<Addr> findAll() {
		Connection conn = dbConnect.conn();
		String sql = "select * from addr";
		ArrayList<Addr> list = new ArrayList<Addr>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Addr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return list;
	}
	public ArrayList<Addr> findByName(String name) {
		Connection conn = dbConnect.conn();
		String sql = "select * from addr where name like ?";
		ArrayList<Addr> list = new ArrayList<Addr>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+name+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Addr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return list;
		
	}
	public ArrayList<Addr> findByTel(String tel) {
		Connection conn = dbConnect.conn();
		String sql = "select * from addr where tel like ?";
		ArrayList<Addr> list = new ArrayList<Addr>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+tel+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Addr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return list;
}
	}
