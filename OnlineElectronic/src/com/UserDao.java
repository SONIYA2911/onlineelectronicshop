package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.user.User;

public class UserDao {

	public void insertUser(User user) {
		String insertQuery ="insert into user_register(name,email_id,password) values(?,?,?)";
	    
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail_id());
			pst.setString(3, user.getPassword());
			pst.executeUpdate();
			System.err.println("Value inserted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted in the table");
		}
		
	}
	
	public User validateUser(String mailid)
	{
		String validateQuery="select * from user_register where email_id="+mailid;
		Connection con=ConnectionUtil.getDbConnection();
		User user=null;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(validateQuery);
			if(rs.next())
			{
				user=new User(rs.getString(2),mailid, validateQuery);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement error");
		} 
		return user;
	}
	
	
}