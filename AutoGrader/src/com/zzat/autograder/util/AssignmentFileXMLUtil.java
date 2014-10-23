package com.zzat.autograder.util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.zzat.autograder.orm.AssignmentFileGateway;
import com.zzat.autograder.pojo.AssignmentFile;

public class AssignmentFileXMLUtil {

	private static final String ASSIGNMENT_XML = "Assignment.xml";

	private static final String POINTS = "Points";

	private static final String USER_ID = "Student_ID";

	private static final String ASSIGNMENT_ID = "Assignment_ID";

	public static void main(String[] args) {
		AssignmentFile assignmentFile = AssignmentFileXMLUtil
				.getAssignmentFile(ASSIGNMENT_XML);
		System.out.println(assignmentFile.getAssignmentID());

		AssignmentFileGateway.insertAssignment(assignmentFile);
	}

	public static AssignmentFile getAssignmentFile(String assignmentXml) {

		AssignmentFile assignmentFile = null;
		Document document = XMLParser.getRootDocument(assignmentXml);

		if (document != null) {
			int assignmentID = getAssignmentID(document);

			int userID = getUserID(document);

			assignmentFile = new AssignmentFile();

			assignmentFile.setAssignmentID(assignmentID);
			assignmentFile.setScore(getTotalPoints(document));

			assignmentFile.setSolution(false);
			assignmentFile.setAssignmentFileName(ASSIGNMENT_XML);

			assignmentFile.setUserID(userID);
		}

		return assignmentFile;
	}

	private static int getUserID(Document document) {
		NodeList elementsByTagName = document.getElementsByTagName(USER_ID);
		return Integer.parseInt(elementsByTagName.item(0).getFirstChild()
				.getNodeValue());

	}

	private static int getAssignmentID(Document document) {
		NodeList elementsByTagName = document
				.getElementsByTagName(ASSIGNMENT_ID);
		return Integer.parseInt(elementsByTagName.item(0).getFirstChild()
				.getNodeValue());
	}

	public static float getTotalPoints(Document document) {
		float totalPoints = 0.0f;
		NodeList elementsByTagName = document.getElementsByTagName(POINTS);
		for (int i = 0; i < elementsByTagName.getLength(); i++) {
			totalPoints += Float.parseFloat(elementsByTagName.item(i)
					.getFirstChild().getNodeValue());
		}
		return totalPoints;
	}
}
