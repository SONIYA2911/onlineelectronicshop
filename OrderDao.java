package com.onlineelectronicshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.model.User;

public class OrderDao {
public void insertOrder(Components component, User user, int noOf) {
	String insertQuery = "insert into order_items (component_id,user_id,quantity,total_price) values(?,?,?,?)";

	String findProductID = "select id from products_cafe where name= '" + component.getComponentName() + "'";

	Connection con = ConnectionUtil.getDbConnection();
}}