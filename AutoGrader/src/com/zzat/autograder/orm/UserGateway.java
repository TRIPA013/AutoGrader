package com.zzat.autograder.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzat.autograder.pojo.AssignmentFile;
import com.zzat.autograder.pojo.User;
import com.zzat.autograder.util.DBHelper;

public class UserGateway {

	public static int inserUser(User user) {
		int id = -1;
		String sqlQuery = "Insert into User (UserName,Password,EmailAdd,Role,Name) values ('"
				+ user.getUserName()
				+ "','"
				+ user.getPassword()
				+ "','"
				+ user.getEmailAddress()
				+ "','"
				+ user.getRole()
				+ "','"
				+ user.getName() + "')";
		DBHelper db = new DBHelper();
		try {
			id = db.runInsertQuery(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static void updateUser(User user) {
		String sqlQuery = "Update User Set UserName=" + user.getUserName()
				+ ",Password='" + user.getPassword() + "',EmailAdd='"
				+ user.getEmailAddress() + "',Role='" + user.getRole()
				+ "',Name='" + user.getName() + "' where UserID = "
				+ user.getUserId();
		DBHelper db = new DBHelper();
		db.runUpdateQuery(sqlQuery);
	}

	public static void deleteUser(User user) {
		String sqlQuery = "Delete from User where UserID=" + user.getUserId();
		DBHelper db = new DBHelper();
		db.runUpdateQuery(sqlQuery);
	}

	public static User findUserByUserID(User user) {

		String sqlQuery = "Select TOP 1 * from User where UserID="
				+ user.getUserId();
		DBHelper db = new DBHelper();

		ResultSet rs = db.runFindQuery(sqlQuery);
		try {
			while (rs.next()) {
				user.setUserName(rs.getString("UserName"));
				user.setPassword(rs.getString("Password"));
				user.setEmailAddress(rs.getString("EmailAdd"));
				user.setRole(rs.getString("Role"));
				user.setName(rs.getString("Name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}
}
