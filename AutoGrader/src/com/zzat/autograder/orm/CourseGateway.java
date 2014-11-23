package com.zzat.autograder.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzat.autograder.Entity.CourseEntity;
import com.zzat.autograder.Entity.UserEntity;
import com.zzat.autograder.pojo.Course;
import com.zzat.autograder.pojo.User;
import com.zzat.autograder.util.DBHelper;

public class CourseGateway {

	public static String insertCourse(CourseEntity course) {

		return "Insert into Course (CourseID, CourseName) values ("
				+ course.getCourseID() + ",'" + course.getCourseName() + "')";

	}

	public static String updateCourse(CourseEntity course) {
		return "Update Course Set CourseName= '" + course.getCourseName()
				+ "' where CourseID = " + course.getCourseID();

	}

	public static String deleteCourse(CourseEntity course) {
		return "Delete from Course where CourseID=" + course.getCourseID();

	}

	public static String findCourseByCourseID(CourseEntity course) {

		return "Select TOP 1 * from Course where CourseID="
				+ course.getCourseID();

	}

	public static String findCourseByUserID(UserEntity user) {

		return "select c.CourseID, c.CourseName from User u inner join Seat s on u.UserID = s.UserID inner join Course c on s.CourseID = c.CourseID where u.UserID="
				+ user.getUserID();

	}
}
