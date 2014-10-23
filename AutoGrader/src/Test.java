import com.zzat.autograder.orm.CourseGateway;
import com.zzat.autograder.pojo.Course;

public class Test {

	public static void main(String[] args) {

		Course course = new Course();
		course.setCourseId(5236);
		course.setCourseName("Mobile Application Development");
		CourseGateway.insertCourse(course);

	}

}
