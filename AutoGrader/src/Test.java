import com.zzat.autograder.orm.AssignmentFileGateway;
import com.zzat.autograder.orm.AssignmentGateway;
import com.zzat.autograder.orm.UserGateway;
import com.zzat.autograder.pojo.*;
import com.zzat.autograder.pojo.Assignment.AssignmentType;
import com.zzat.autograder.util.AssignmentFileXMLUtil;

public class Test {
	private static final String ASSIGNMENT_XML = "Assignment.xml";

	public static void main(String[] args) {

		// Course course = new Course();
		// course.setCourseId(6331);
		// course.setCourseName("Advanced Algorithms");
		// CourseGateway.insertCourse(course);

		// User user = new User();
		// user.setEmailAddress("abhinav@gmail.com");
		// user.setName("Abhinav Tripathi");
		// user.setPassword("password");
		// user.setUserName("abhinavosu");
		// user.setRole("s");
		// System.out.println(UserGateway.inserUser(user));

		// Assignment assignment = new Assignment();
		// assignment.setAssignmentType(AssignmentType.HOMEWORK);
		// assignment.setConfigurationFile("c:\\config.xml");
		// assignment.setCourseID(6331);
		// assignment.setMaxPoints(10.0);
		// AssignmentGateway.insertAssignment(assignment);

		 AssignmentFile assignmentFile = AssignmentFileXMLUtil
		 .getAssignmentFile(ASSIGNMENT_XML);
		 System.out.println(AssignmentFileGateway
		 .insertAssignmentFile(assignmentFile));
		//
		// AssignmentFile assignmentFile = AssignmentFileXMLUtil
		// .getAssignmentFile(ASSIGNMENT_XML);
		//
		// assignmentFile.setAssignmentFileID(3);
		//
		// AssignmentFileGateway.updateAssignmentFile((assignmentFile));
		
		
	}	

}
