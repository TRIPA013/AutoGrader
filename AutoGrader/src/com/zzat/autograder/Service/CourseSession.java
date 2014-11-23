package com.zzat.autograder.Service`9.EJB.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

import com.zzat.autograder.Entity.CourseEntity;
import com.zzat.autograder.Entity.UserEntity;
import com.zzat.autograder.orm.CourseGateway;

@Stateless
public class CourseSession {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public List<CourseEntity> findCourses(UserEntity user) {
		
		List<CourseEntity> courses = new ArrayList<CourseEntity>;

		Query query = em.createNativeQuery
				(CourseGateway.findCourseByUserID(user), CourseEntity.class);

		courses = query.getResultList();
		return courses;
	}
}
