package com.Inventory.Login;
import com.Inventory.Register.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
public static boolean isUserValid(String name,String password) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_vehicle", "root", "Amanulla1997");
		PreparedStatement pst = con.prepareStatement("select id from inventory_vehicle.UserRegister where email=? and password=?");
		pst.setString(1,name);
		pst.setString(2,password);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			return true;
		}
	}catch(Exception e) {
		e.printStackTrace();
	}	
	return false;
}
	
public static UserLoginModel getUserData(String email){
	UserLoginModel user = new UserLoginModel();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_vehicle", "root", "Amanulla1997");
		PreparedStatement pst = con.prepareStatement("select id,name,email,phone,state from inventory_vehicle.UserRegister where email=?");
		pst.setString(1,email);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPhone(rs.getString("phone"));
			user.setState(rs.getString("state"));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}	
	
	return user;
}



}
