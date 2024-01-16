package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Fetch {
	
	public static void main(String[] args) {
	
		Scanner s = new Scanner (System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/user_table","root","root");
			
			Statement s1 = c.createStatement();
			
//			PreparedStatement p = c.prepareStatement("select * from user where state = ? desc state");
				
		ResultSet rs =	s1.executeQuery("select * from user where id = 1");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getInt(7));
				System.out.println(rs.getString(8));
			}
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
	}

}
