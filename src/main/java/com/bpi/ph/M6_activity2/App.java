package com.bpi.ph.M6_activity2;

import jakarta.persistence.EntityManager;
import com.bpi.ph.M6_activity2.util.*;
import com.bpi.ph.M6_activity2.model.*;

public class App {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			runM6Activity2(em);
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}

	static void runM6Activity2(EntityManager em) {

		try {
			em.getTransaction().begin();

			Student newStudent = new Student();
			newStudent.setName("Maven Java");
			newStudent.setAge(30);
			newStudent.setEmail("mavenjava@gmail.com");

			em.persist(newStudent);
			em.getTransaction().commit();

		} 
		catch (Exception e) {
            System.out.println("Error adding studentss: " + e.getMessage());
	       
	    }
	}
}