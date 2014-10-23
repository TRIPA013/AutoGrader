package com.zzat.autograder.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzat.autograder.pojo.Assignment;
import com.zzat.autograder.util.DBHelper;

public class AssignmentGateway {
	public static int insertAssignment(Assignment assignment) {
		int id = -1;
		String sqlQuery = "Insert into Assignment (CourseID,MaxPoints,AssignmentType,ConfigurationFile) values ("
				+ assignment.getCourseID()
				+ ","
				+ assignment.getMaxPoints()
				+ ",'"
				+ assignment.getAssignmentType()
				+ "','"
				+ assignment.getConfigurationFile() + "')";
		DBHelper db = new DBHelper();
		try {
			id = db.runInsertQuery(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static void updateAssignment(Assignment assignment) {
		String sqlQuery = "Update Assignment Set CourseID="
				+ assignment.getCourseID() + ",MaxPoints="
				+ assignment.getMaxPoints() + ",AssignmentTyope='"
				+ assignment.getAssignmentType() + "',ConfigurationFile="
				+ assignment.getConfigurationFile() + " where AssignmentID = "
				+ assignment.getAssignmentID();
		DBHelper db = new DBHelper();
		db.runUpdateQuery(sqlQuery);
	}

	public static void deleteAssignment(Assignment assignment) {
		String sqlQuery = "Delete from Assignment where AssignmentID="
				+ assignment.getAssignmentID();
		DBHelper db = new DBHelper();
		db.runUpdateQuery(sqlQuery);
	}

	public static Assignment findAssignmentByAssignmentID(Assignment assignment) {

		String sqlQuery = "Select TOP 1 * from Assignment where AssignmentID="
				+ assignment.getAssignmentID();
		DBHelper db = new DBHelper();

		ResultSet rs = db.runFindQuery(sqlQuery);
		try {
			while (rs.next()) {
				assignment.setCourseID(rs.getInt("CourseID"));
				assignment.setMaxPoints(rs.getInt("MaxPoints"));
				Assignment.AssignmentType newEnum = Assignment.AssignmentType
						.valueOf(rs.getString("AssignmentType"));
				assignment.setAssignmentType(newEnum);
				assignment.setConfigurationFile(rs
						.getString("ConfigurationFile"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assignment;

	}
}
