package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		
		Scanner s = new Scanner (System.in);
		
		System.out.println("Enter the id to be delete");
		int id = s.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/user_table","root","root");
			
			
			PreparedStatement p = c.prepareStatement("delete  from  user where id = ?");
			
			p.setInt(1, id);
			
			p.executeUpdate();
			System.out.println("Data deleted successfully");
			
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
	}
}
