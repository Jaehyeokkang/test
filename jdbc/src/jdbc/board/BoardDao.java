package jdbc.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.DBConnection;

public class BoardDao {
	private DBConnection db;
	public BoardDao() {
		db = DBConnection.getInstance();
	}
	public void insert(BoardMem b) {
		Connection conn = db.conn();
		String sql = "insert into board values(num, ?, now(),?,?)";
		PreparedStatement ps;
		try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, b.getWriter());
		ps.setString(2, b.getContent());
		ps.setString(3, b.getTitle());
		int cnt = ps.executeUpdate();
		System.out.println(cnt+ "줄 추가");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public BoardMem select(int num) {
		Connection conn = db.conn();
		String sql = "select * from board where num = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new BoardMem(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5));
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
		}
		return null;
	}
	
	public ArrayList<BoardMem> selectByTitle(String title){
		Connection conn = db.conn();
		String sql = "select * from board where title like ? order by num";
		PreparedStatement ps;
		ArrayList<BoardMem> list = new ArrayList<BoardMem>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + title + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 list.add(new BoardMem(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5))); 
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
		}
		return list;
	}
	
	
	public ArrayList<BoardMem> selectByWriter(String writer){

		Connection conn = db.conn();
		String sql = "select * from board where writer = ? order by num";
		PreparedStatement ps;
		ArrayList<BoardMem> list = new ArrayList<BoardMem>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, writer);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 list.add(new BoardMem(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5))); 
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
		}
		return list;
	}
	
	
	public ArrayList<BoardMem> selectAll(){
		Connection conn = db.conn();
		String sql = "select * from board order by num";
		PreparedStatement ps;
		ArrayList<BoardMem> list = new ArrayList<BoardMem>();
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 list.add(new BoardMem(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5))); 
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
		}
		return list;
	}
	public void update(BoardMem b) {
		Connection conn = db.conn();
		String sql = "update board set title=?, content =? where num = ?";
		PreparedStatement ps;
		try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, b.getTitle());
		ps.setString(2, b.getContent());
		ps.setInt(3, b.getNum());
		int cnt = ps.executeUpdate();
		System.out.println(cnt+ "줄 update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	public void delete(int num) {
		Connection conn = db.conn();
		String sql = "delete from board where num = ?";
		PreparedStatement ps;
		try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, num);		
		int cnt = ps.executeUpdate();
		System.out.println(cnt+ "줄 delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
