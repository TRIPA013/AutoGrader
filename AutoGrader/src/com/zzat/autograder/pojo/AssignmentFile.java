package com.zzat.autograder.pojo;

import com.zzat.autograder.pojo.Assignment.AssignmentType;

public class AssignmentFile {

	private int assignmentFileID;

	private String assignmentFileName;

	private int assignmentID;

	private int userID;

	private double score;

	private boolean isSolution;

	/**
	 * @return the assignmentFileID
	 */
	public int getAssignmentFileID() {
		return assignmentFileID;
	}

	/**
	 * @param assignmentFileID
	 *            the assignmentFileID to set
	 */
	public void setAssignmentFileID(int assignmentFileID) {
		this.assignmentFileID = assignmentFileID;
	}

	/**
	 * @return the assignmentFileName
	 */
	public String getAssignmentFileName() {
		return assignmentFileName;
	}

	/**
	 * @param assignmentFileName
	 *            the assignmentFileName to set
	 */
	public void setAssignmentFileName(String assignmentFileName) {
		this.assignmentFileName = assignmentFileName;
	}

	/**
	 * @return the assignmentID
	 */
	public int getAssignmentID() {
		return assignmentID;
	}

	/**
	 * @param assignmentID
	 *            the assignmentID to set
	 */
	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * @return the isSolution
	 */
	public boolean isSolution() {
		return isSolution;
	}

	/**
	 * @param isSolution
	 *            the isSolution to set
	 */
	public void setSolution(boolean isSolution) {
		this.isSolution = isSolution;
	}

}
