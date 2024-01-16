package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

	 static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter the id");
		int id = sc.nextInt();
		System.out.println("enter the login id");
		int l_id = sc.nextInt();
		System.out.println("enter the password");
		String pass = sc.next();
		System.out.println("enter the name");
		String name = sc.next();
		System.out.println("enter the role");
		String role = sc.next();
		System.out.println("enter the address");
		String add = sc.next();
		System.out.println("enter the zip");
		int zip = sc.nextInt();
		System.out.println("enter the state");
		String state = sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/user_table","root","root");
			
			
			PreparedStatement p = c.prepareStatement("insert into user values (?,?,?,?,?,?,?,?)");
			
			p.setInt(1,id);
			p.setInt(2,l_id );
			p.setString(3, pass);
			p.setString(4,name);
			p.setString(5,role);
			p.setString(6, add);
			p.setInt(7, zip);
			p.setString(8, state);
			
			p.executeUpdate();
			
			System.out.println("Data added successfully");
			
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
	}
}
