package com.zzat.autograder.Service`9.EJB.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

import com.zzat.autograder.Entity.AssignmentEntity;
import com.zzat.autograder.Entity.CourseEntity;
import com.zzat.autograder.Entity.UserEntity;
import com.zzat.autograder.orm.AssignmentGateway;
import com.zzat.autograder.orm.CourseGateway;

@Stateless
public class CourseSession {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public List<CourseEntity> findAssignments(CourseEntity course) {
		
		List<AssignmentEntity> assignments = new ArrayList<AssignmentEntity>;

		Query query = em.createNativeQuery
				(AssignmentGateway.findAssignmentByCourseID(course), AssignmentEntity.class);

		assignments = query.getResultList();
		return assignments;
	}
}
