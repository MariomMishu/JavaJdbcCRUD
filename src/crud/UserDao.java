package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	//Database connection
	public static Connection getConnection() {
		Connection con = null;
				String url= "jdbc:mysql://localhost:3306/employee";
				String user="root";
				String password="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection(url, user, password);
			System.out.println("Database connected...");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
	//Data Insert into user table
	public static int save(User e) {
		int status=0;
		try {
			Connection connection = UserDao.getConnection();
			String sql="INSERT INTO user (username,email,fullname,password,phone,address) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement p = connection.prepareStatement(sql);
			
			p.setString(1, e.getUsername());
			p.setString(2, e.getEmail());
			p.setString(3, e.getFullname());
			p.setString(4, e.getPassword());
			p.setString(5, e.getPhone()); ;
			p.setString(6, e.getAddress());
			
			 status = p.executeUpdate();
			 connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
		
	}
	}
