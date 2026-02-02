package com.bpi.ph.M6_activity5;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class App {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			printAllStudentNames(em);
			countCoursesByStudentId(em, 1);
			countStudentsByAgeGreaterThan(em, 25);
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}

	static void printAllStudentNames(EntityManager em) 
		{
			em.getTransaction().begin();

			String jpql = "SELECT s.name FROM Student s";
			TypedQuery<String> query = em.createQuery(jpql, String.class);
			List<String> studentName = query.getResultList();

			// print student name
			studentName.forEach(name -> System.out.println(name));

			em.getTransaction().commit();	       
	    }
	
	static Long countCoursesByStudentId(EntityManager em, int id) {
		Long countCoursesByStudentId = em.createQuery(
			    "SELECT COUNT(c) FROM Student s JOIN s.courses c WHERE s.id = :id",
			    Long.class
			).setParameter("id", id)
			 .getSingleResult();
		System.out.println("Total count of courses for Student ID = " + id + " is: "+ countCoursesByStudentId);
		return countCoursesByStudentId;
		}
	
	static Long countStudentsByAgeGreaterThan(EntityManager em, int age)
 {
		Long countStudentsByAgeGreaterThan = em.createQuery(
		    "SELECT COUNT(s) FROM Student s where s.age > :age", Long.class
		).setParameter("age", age).getSingleResult();
		System.out.println("Total count of Students older than " + age + " is: " + countStudentsByAgeGreaterThan);
		return countStudentsByAgeGreaterThan;
		}
	
		}
