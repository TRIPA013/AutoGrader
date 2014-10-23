package com.zzat.autograder.pojo;

public class Assignment {

	private int assignmentID;
	
	public int getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	private int courseID;

	public enum AssignmentType {
		HOMEWORK, QUIZ, EXAM;
	}

	private AssignmentType assignmentType;

	private double maxPoints;

	private String configurationFile;

	/**
	 * @return the courseID
	 */
	public int getCourseID() {
		return courseID;
	}

	/**
	 * @param courseID
	 *            the courseID to set
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	/**
	 * @return the assignmentType
	 */
	public AssignmentType getAssignmentType() {
		return assignmentType;
	}

	/**
	 * @param assignmentType
	 *            the assignmentType to set
	 */
	public void setAssignmentType(AssignmentType assignmentType) {
		this.assignmentType = assignmentType;
	}

	/**
	 * @return the maxPoints
	 */
	public double getMaxPoints() {
		return maxPoints;
	}

	/**
	 * @param maxPoints
	 *            the maxPoints to set
	 */
	public void setMaxPoints(double maxPoints) {
		this.maxPoints = maxPoints;
	}

	/**
	 * @return the configurationFile
	 */
	public String getConfigurationFile() {
		return configurationFile;
	}

	/**
	 * @param configurationFile
	 *            the configurationFile to set
	 */
	public void setConfigurationFile(String configurationFile) {
		this.configurationFile = configurationFile;
	}

}
