package com.onlineelectronicshop.dao;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineelectronicshop.model.User;



	public class UserDao {

		public void insertUser(User user) {
			String insertQuery ="insert into user_details(user_name,email_id,password,contact_number,address) values(?,?,?,?,?)";
		    
			ConnectionUtil conUtil = new ConnectionUtil();
			Connection con = conUtil.getDbConnection();
			PreparedStatement pstmt = null;
			
			try {
				pstmt = con.prepareStatement(insertQuery);
				pstmt.setString(1, user.getUser_name());
				pstmt.setString(2, user.getEmail_id());
				pstmt.setString(3, user.getPassword());
				pstmt.setLong(4, user.getContactNumber());
				pstmt.setString(5,user.getAddress());
				pstmt.executeUpdate();
				System.err.println("Value inserted Successfully");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Value not inserted in the table");
			}
			
		}
		
		
			public static User validateUser(String email_id,String password)
			{
				String validateQuery="select * from user_details where role='user' and email_id='"+email_id+"'and password='"+password+"'";
				Connection con=ConnectionUtil.getDbConnection();
				User user=null;
				try {
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(validateQuery);
					if(rs.next())
					{
						user=new User(rs.getString(2),email_id,password,Long.parseLong(rs.getString(5)),rs.getString(6));
					}
					else {
						System.out.println("not a valid user");
					}
			
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Statement error");
			} 
			return user;
			
			}
			public void update(String update){
				String updatequery="update user_details set password=? where user_id=?";
				Connection con=ConnectionUtil.getDbConnection();
				System.out.println("connection get succesfully");
				try {
					PreparedStatement pstmt=con.prepareStatement(updatequery);
					pstmt.setString(1, update.split(",")[0]);
					pstmt.setInt(2,Integer.parseInt(update.split(",")[1]));
					int i=pstmt.executeUpdate();
					System.out.println(i+"row updated");
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			    public void deleteUser(String delete){
				String deleteQuery="delete from user_details where user_id=?";
				Connection con=ConnectionUtil.getDbConnection();
				System.out.println("connection get successfully");
				try {
				PreparedStatement pstmt=con.prepareStatement(deleteQuery);
				pstmt.setInt(1,Integer.parseInt(delete));
				int i=pstmt.executeUpdate();
				System.out.println(i+"row deleted");
				pstmt.close();
				con.close();
			}
			    catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			    }	
				public static int findUserId(String email_id)
				{
					String findUserID="select user_id from user_details where email_id'"+email_id+'"';
					Connection con=ConnectionUtil.getDbConnection();
					Statement stmt;
					int userId=0;
					try {
						stmt = con.createStatement();
						ResultSet rs=stmt.executeQuery(findUserID);
						if(rs.next())
						{
						userId=rs.getInt(1);
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return userId;
					
				}
					

				public static List<User> showAllUser() {
					List<User> UsersList=new ArrayList<User>();
					
					String showQuery="select *from user_details";
					Connection con=ConnectionUtil.getDbConnection();
					System.out.println("connection get successfully");
					Statement stmt;
					try {
					stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(showQuery);
					while(rs.next()) {
				
						UsersList.add(new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
					}
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
					return UsersList;
				}
				
				
				
			    	
				}
				
				 
				
			
			



