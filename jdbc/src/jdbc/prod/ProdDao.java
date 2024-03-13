package jdbc.prod;



import java.sql.*;
import java.util.ArrayList;
import jdbc.DBConnection;

public class ProdDao {
	private DBConnection db;
	public ProdDao() {
		db = DBConnection.getInstance();
	}
//insert
	public void insert(Product p) {
		Connection conn = db.conn();
		String sql = "insert prod values(num, ?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getPrice());
			ps.setInt(3, p.getAmount());
			ps.setString(4, p.getSeller());
			int cnt = ps.executeUpdate();
			System.out.println(cnt + "line add");
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
	}
//select
	public Product select(int num) {
		Connection conn = db.conn();
		String sql = "select * from prod where num = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
//selectByName
	public ArrayList<Product> selectByName(String name){
		Connection conn = db.conn();
		String sql = "select * from prod where name like ? order by num";
		PreparedStatement ps;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
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
//selectByPrice
	public ArrayList<Product> selectByPrice(int num1, int num2){
		Connection conn = db.conn();
		String sql = "SELECT * FROM prod WHERE price BETWEEN ? AND ? order by num";
		PreparedStatement ps;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num1);
			ps.setInt(2, num2);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
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
//select all
	public ArrayList<Product> selectAll(){
		Connection conn = db.conn();
		String sql = "select * from pord order by num";
		PreparedStatement ps;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
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
//update
	public void update(Product p) {
		Connection conn = db.conn();
		String sql = "update prod set name = ?, price = ? where num = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getPrice());
			ps.setInt(3, p.getNum());
			int cnt = ps.executeUpdate();
			System.out.println(cnt + "line update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
//bound	
	public int bound(int num, int amount) {
		Connection conn = db.conn();
		String sql = "update prod set amount = amount + ? where num=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, amount);
			ps.setInt(2, num);
			int cnt = ps.executeUpdate();
			System.out.println(cnt+"line update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return 1;
	}	
//delete
	public void delete(int num) {
		Connection conn = db.conn();
		String sql = "delete from prod where num = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			int cnt = ps.executeUpdate();
			System.out.println(cnt + "line delete");
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
	}
}
