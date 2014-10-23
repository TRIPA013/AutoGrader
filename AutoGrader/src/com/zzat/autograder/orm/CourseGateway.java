package com.zzat.autograder.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzat.autograder.pojo.Course;
import com.zzat.autograder.pojo.User;
import com.zzat.autograder.util.DBHelper;

public class CourseGateway {

	public static void insertCourse(Course course) {

		String sqlQuery = "Insert into Course (CourseID, CourseName) values ("
				+ course.getCourseId() + ",'" + course.getCourseName() + "')";
		DBHelper db = new DBHelper();
		try {
			db.runInsertQuery(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateCourse(Course course) {
		String sqlQuery = "Update Course Set CourseName= '"
				+ course.getCourseName() + "' where CourseID = "
				+ course.getCourseId();
		DBHelper db = new DBHelper();
		db.runUpdateQuery(sqlQuery);
	}

	public static void deleteCourse(Course course) {
		String sqlQuery = "Delete from Course where CourseID="
				+ course.getCourseId();
		DBHelper db = new DBHelper();
		db.runUpdateQuery(sqlQuery);
	}

	public static Course findCourseByCourseID(Course course) {

		String sqlQuery = "Select TOP 1 * from Course where CourseID="
				+ course.getCourseId();
		DBHelper db = new DBHelper();

		ResultSet rs = db.runFindQuery(sqlQuery);
		try {
			while (rs.next()) {
				course.setCourseName(rs.getString("CourseName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;

	}
}