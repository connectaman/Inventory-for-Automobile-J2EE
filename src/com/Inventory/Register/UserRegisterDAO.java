package com.Inventory.Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserRegisterDAO {

	public static boolean addUserRegister(UserRegisterModel r) {
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_vehicle", "root", "Amanulla1997");
			PreparedStatement pst = con.prepareStatement("insert into inventory_vehicle.UserRegister(name,email,phone,password,state) values(?,?,?,?,?)");
			pst.setString(1, r.getName());
			pst.setString(2, r.getEmail());
			pst.setString(3, r.getPhone());
			pst.setString(4, r.getPassword());
			pst.setString(5, r.getState());
			result = pst.executeUpdate();
			if(result == 1) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
}
