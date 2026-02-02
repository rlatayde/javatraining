package com.bpi.ph.M6_activity3;

import jakarta.persistence.EntityManager;
import com.bpi.ph.M6_activity3.util.*;
import com.bpi.ph.M6_activity3.model.*;

public class App {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			runM6Activity3(em);
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}

	static void runM6Activity3(EntityManager em) {

		try {
			em.getTransaction().begin();
			
			Student student1 = em.find(Student.class, 2L);
			
			Course newCourse = new Course();
			newCourse.setCourseName("Java 2");
			newCourse.setGrade((double) 80);
			newCourse.setStudent(student1);
			
			em.persist(newCourse);
			
			em.getTransaction().commit();


		} 
		catch (Exception e) {
            System.out.println("Error adding studentss: " + e.getMessage());
	       
	    }
	}
}