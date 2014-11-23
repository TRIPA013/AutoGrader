package com.zzat.autograder.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

import com.zzat.autograder.Entity.UserEntity;
import com.zzat.autograder.orm.UserGateway;

@Stateless
public class LoginSession {
	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	public UserEntity login(UserEntity user) { // method called from LoginBean
											// Backing Bean

		UserEntity newEntity = user;

		List<UserEntity> users = new ArrayList<UserEntity>();
		
		try {
			Query query = em.createNativeQuery // create query using this syntax
					(UserGateway.login(user), UserEntity.class);

			users = query.getResultList();

			if (!users.isEmpty()) // if user actually exists
			{
				newEntity = users.get(0);
				return newEntity;
			}
		}

		catch (Exception e) {
			return newEntity;
		}

		return newEntity; // return fail if user not found and handle appropriately
				// in Backing Bean
	}

}
