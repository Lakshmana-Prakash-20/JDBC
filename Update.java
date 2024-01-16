package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		
		Scanner s = new Scanner (System.in);
		
		System.out.println("Enter the id ");
		int id = s.nextInt();
		System.out.println("enter the role ");
		String role = s.next();
		System.out.println("enter the name");
		String name = s.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			
			Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/user_table","root","root");
			
			
			PreparedStatement p = c.prepareStatement("update  user set name =? , role=? where id = ?");
			
			p.setString(1, name);
			p.setString(2, role);
			p.setInt(3, id);
			
			p.executeUpdate();
			
			System.out.println("data updated");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
	}
}
