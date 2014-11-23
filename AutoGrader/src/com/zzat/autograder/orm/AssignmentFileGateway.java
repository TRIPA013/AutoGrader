package com.zzat.autograder.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzat.autograder.Entity.AssignmentFileEntity;
import com.zzat.autograder.pojo.AssignmentFile;
import com.zzat.autograder.util.DBHelper;

public class AssignmentFileGateway {

	public static String insertAssignmentFile(AssignmentFileEntity assignmentFile) {
		return "Insert into AssignmentFile (AssignmentFileName,AssignmentID,UserID,Score,IsSolution) values ('"
				+ assignmentFile.getAssignmentFileName()
				+ "','"
				+ assignmentFile.getAssignmentID()
				+ "','"
				+ assignmentFile.getUserID()
				+ "','"
				+ assignmentFile.getScore()
				+ "','"
				+ assignmentFile.getIsSolution() + "')";
		
	}

	public static String updateAssignmentFile(AssignmentFileEntity assignmentFile) {
		return "Update AssignmentFile Set AssignmentID="
				+ assignmentFile.getAssignmentID() + ",AssignmentFileName='"
				+ assignmentFile.getAssignmentFileName() + "',Score='"
				+ assignmentFile.getScore() + "',IsSolution="
				+ assignmentFile.getIsSolution() + " where AssignmentFileID = "
				+ assignmentFile.getAssignmentFileID();
		
	}

	public static String deleteAssignmentFile(AssignmentFileEntity assignmentFile) {
		return "Delete from AssignmentFile where AssignmentFileID="
				+ assignmentFile.getAssignmentFileID();
		
	}

	public static String findAssignmentFileByAssignmentFileID(AssignmentFileEntity assignmentFile) {

		return "Select TOP 1 * from AssignmentFile where AssignmentFileID="
				+ assignmentFile.getAssignmentFileID();
		

	}

}
