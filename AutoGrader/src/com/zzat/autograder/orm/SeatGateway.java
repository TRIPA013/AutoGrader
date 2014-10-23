package com.zzat.autograder.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzat.autograder.pojo.Seat;
import com.zzat.autograder.util.DBHelper;

public class SeatGateway {
	public static int insertSeat(Seat seat) {

		int id = -1;
		String sqlQuery = "Insert into Seat (UserID, CourseID) values ("
				+ seat.getUserID() + "," + seat.getCourseID() + ")";
		DBHelper db = new DBHelper();
		try {
			id = db.runInsertQuery(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	public static void updateSeat(Seat seat) {
		String sqlQuery = "Update Seat Set CourseID= " + seat.getCourseID()
				+ ", UserID=" + seat.getUserID() + " where SeatID = "
				+ seat.getSeatID();
		DBHelper db = new DBHelper();
		db.runUpdateQuery(sqlQuery);
	}

	public static void deleteSeat(Seat seat) {
		String sqlQuery = "Delete from Seat where SeatID=" + seat.getSeatID();
		DBHelper db = new DBHelper();
		db.runUpdateQuery(sqlQuery);
	}

	public static Seat findSeatBySeatID(Seat seat) {

		String sqlQuery = "Select TOP 1 * from Seat where SeatID="
				+ seat.getSeatID();
		DBHelper db = new DBHelper();

		ResultSet rs = db.runFindQuery(sqlQuery);
		try {
			while (rs.next()) {
				seat.setCourseID(rs.getInt("CourseID"));
				seat.setUserID(rs.getInt("UserID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seat;

	}
}