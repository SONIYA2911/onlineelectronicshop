package com.onlineelectronicshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.model.User;

public class AdminDao {
public static User validateAdmin(String email,String password) {
	String validateQuery="select * from user_details where role='Admin' and email_id='"+email+"'and password='"+password+"'";
	Connection con=ConnectionUtil.getDbConnection();
	User user=null;
	try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(validateQuery);
		if(rs.next())
		{
			user=new User(rs.getString(2),email,password,Long.parseLong(rs.getString(5)),rs.getString(6));
		}
		else {
			System.out.println("not a valid user");
		}



} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	

}
	return user;
	
	
	
	
	
	
	
	
	
	
}
	
	
	    }
