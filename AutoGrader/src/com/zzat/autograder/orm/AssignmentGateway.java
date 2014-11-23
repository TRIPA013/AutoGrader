package com.zzat.autograder.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzat.autograder.Entity.AssignmentEntity;
import com.zzat.autograder.Entity.CourseEntity;
import com.zzat.autograder.pojo.Assignment;
import com.zzat.autograder.util.DBHelper;

public class AssignmentGateway {
	public static String insertAssignment(AssignmentEntity assignment) {
		return "Insert into Assignment (CourseID,MaxPoints,AssignmentType,ConfigurationFile) values ("
				+ assignment.getCourseID()
				+ ","
				+ assignment.getMaxPoints()
				+ ",'"
				+ assignment.getAssignmentType()
				+ "','"
				+ assignment.getConfigurationFile() + "')";
		
	}

	public static String updateAssignment(AssignmentEntity assignment) {
		return "Update Assignment Set CourseID="
				+ assignment.getCourseID() + ",MaxPoints="
				+ assignment.getMaxPoints() + ",AssignmentTyope='"
				+ assignment.getAssignmentType() + "',ConfigurationFile="
				+ assignment.getConfigurationFile() + " where AssignmentID = "
				+ assignment.getAssignmentID();
		
	}

	public static String deleteAssignment(AssignmentEntity assignment) {
		return "Delete from Assignment where AssignmentID="
				+ assignment.getAssignmentID();
		
	}

	public static String findAssignmentByAssignmentID(AssignmentEntity assignment) {

		return "Select TOP 1 * from Assignment where AssignmentID="
				+ assignment.getAssignmentID();
	}

	public static String findAssignmentByCourseID(CourseEntity course) {

		return "Select * from Assignment where CourseID="
				+ course.getCourseID();
	}
}
