package com.zzat.autograder.orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.zzat.autograder.pojo.AssignmentFile;
import com.zzat.autograder.util.DBHelper;

public class AssignmentFileGateway {

	public static int insertAssignmentFile(AssignmentFile assignmentFile) {
		int id = -1;
		String sqlQuery = "Insert into AssignmentFile (AssignmentFileName,AssignmentID,UserID,Score,IsSolution) values ('"
				+ assignmentFile.getAssignmentFileName()
				+ "','"
				+ assignmentFile.getAssignmentID()
				+ "','"
				+ assignmentFile.getUserID()
				+ "','"
				+ assignmentFile.getScore()
				+ "','"
				+ assignmentFile.isSolution() + "')";
		DBHelper db = new DBHelper();
		try {
			id = db.runInsertQuery(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static void updateAssignmentFile(AssignmentFile assignmentFile) {
		String sqlQuery = "Update AssignmentFile Set AssignmentID="
				+ assignmentFile.getAssignmentID() + ",AssignmentFileName='"
				+ assignmentFile.getAssignmentFileName() + "',Score='"
				+ assignmentFile.getScore() + "',IsSolution="
				+ assignmentFile.isSolution() + " where AssignmentFileID = "
				+ assignmentFile.getAssignmentFileID();
		DBHelper db = new DBHelper();
		db.runUpdateQuery(sqlQuery);
	}

	public static void deleteAssignmentFile(AssignmentFile assignmentFile) {
		String sqlQuery = "Delete from AssignmentFile where AssignmentFileID="
				+ assignmentFile.getAssignmentFileID();
		DBHelper db = new DBHelper();
		db.runUpdateQuery(sqlQuery);
	}

	public static AssignmentFile findAssignmentFileByAssignmentFileID(AssignmentFile assignmentFile) {

		String sqlQuery = "Select TOP 1 * from AssignmentFile where AssignmentFileID="
				+ assignmentFile.getAssignmentFileID();
		DBHelper db = new DBHelper();

		ResultSet rs = db.runFindQuery(sqlQuery);
		try {
			while (rs.next()) {
				assignmentFile.setAssignmentFileName(rs
						.getString("AssignmentFileName"));
				assignmentFile.setScore(rs.getDouble("Score"));
				assignmentFile.setUserID(rs.getInt("UserID"));
				assignmentFile.setAssignmentID(rs.getInt("AssignmentID"));
				assignmentFile.setSolution(rs.getBoolean("IsSolution"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assignmentFile;

	}

}
