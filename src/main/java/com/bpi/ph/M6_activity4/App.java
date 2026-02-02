package com.bpi.ph.M6_activity4;

import jakarta.persistence.EntityManager;

public class App {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			runM6Activit43(em);
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}
static void runM6Activit43(EntityManager em) {

    em.getTransaction().begin();

    // 1. create Student object, assign values
    Student newStudent = new Student();
    newStudent.setName("Owel Atayde");
    newStudent.setAge(21);
    newStudent.setEmail("owel@yahoo.com");

    // 2. attach transient student object to persistence context

    em.persist(newStudent);

    // 3. call flush()

    em.flush();

    // 4. detach the managed newStudent from the persistence context
    em.detach(newStudent);

    // 5. print "is newStudent inside the persistence context: " + call contains()

    System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));

    // 6. reattach the detached newStudent

    Student managedStudent = em.merge(newStudent);

    // 7. update newStudent, change some values like age or email
    managedStudent.setAge(22);
    managedStudent.setEmail("john.doe+updated@example.com");

    // 8. call flush()
    em.flush();

    // 9. print "is newStudent inside the persistence context: " + call contains()

    System.out.println("is newStudent inside the persistence context: " + em.contains(managedStudent));

    // 10. mark managed newStudent for deletion
    em.remove(managedStudent);

    // 11. call flush()
    em.flush();

    // 12. print "is newStudent inside the persistence context: " + call contains()

    System.out.println("is newStudent inside the persistence context: " + em.contains(managedStudent));

    em.getTransaction().commit();

}
}
