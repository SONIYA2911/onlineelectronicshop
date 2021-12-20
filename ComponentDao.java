package com.onlineelectronicshop.dao;


	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import com.onlineelectronicshop.model.Components;

	public class ComponentDao {
		public List<Components> showComponent(){
			List<Components> componentsList=new ArrayList<Components>();
			
				try {
				String showQuery="select*from component_info";
				Connection con=ConnectionUtil.getDbConnection();
			    Statement stmt=con.createStatement();
			    ResultSet rs=stmt.executeQuery(showQuery);
			    while(rs.next()) {
			    	Components component=new Components(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6));
			    	componentsList.add(component);                         
			    }
			    			                          
			    }catch(SQLException e) {	
			    			e.printStackTrace();
			    }
				return componentsList;
				}
		
		public static int findComponentId(Components components)
		{
			String findUserID="select *from componet_info";
			Connection con=ConnectionUtil.getDbConnection();
			Statement stmt;
			int componentId=0;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findUserID);
				if(rs.next())
				{
				componentId=rs.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return componentId;
			
		}
		
		}


