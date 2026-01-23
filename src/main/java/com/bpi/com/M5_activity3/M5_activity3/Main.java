package com.bpi.com.M5_activity3.M5_activity3;

import java.sql.*;
import java.util.Scanner;

public class Main 
{
    // Database credentials
    private static final String URL = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER = "rlatayde";
    private static final String PASS = "";
    
	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	        	System.out.println("\n===== STUDENT COURSE MANAGEMENT =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. Add Course");
	            System.out.println("3. Display All Students");
	            System.out.println("4. Display All Courses");
	            System.out.println("5. Exit");
	            System.out.print("Choose option: ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1 -> addStudent(sc);
	                case 2 -> addCourse(sc);
	                case 3 -> displayStudents();
	                case 4 -> displayCourses();
	                case 5 -> {
	                    System.out.println("Goodbye!");
	                    return;
	                }
	                default -> System.out.println("Invalid choice!");
	            }
	        }
	    }

	    // -----------------------------
	    // ADD STUDENT
	    // -----------------------------
	    private static void addStudent(Scanner sc) {
	        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

	            System.out.print("Enter name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter age: ");
	            int age = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Enter email: ");
	            String email = sc.nextLine();

	            String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, name);
	            ps.setInt(2, age);
	            ps.setString(3, email);

	            ps.executeUpdate();
	            System.out.println("Student added successfully!");

	        } catch (Exception e) {
	            System.out.println("Error adding student: " + e.getMessage());
	        }
	    }

	    // -----------------------------
	    // ADD COURSE
	    // -----------------------------
	    private static void addCourse(Scanner sc) {
	        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

	            System.out.print("Enter student ID: ");
	            int studentId = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Enter course name: ");
	            String courseName = sc.nextLine();

	            System.out.print("Enter grade: ");
	            double grade = sc.nextDouble();
	            sc.nextLine();
	            
	            String sql = "INSERT INTO courses (student_id, course_name, grade) VALUES (?, ?, ?)";

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, studentId);
	            ps.setString(2, courseName);
	            ps.setDouble(3, grade);

	            ps.executeUpdate();
	            System.out.println("Course added successfully!");

	        } catch (Exception e) {
	            System.out.println("Error adding course: " + e.getMessage());
	        }
	    }

	    // -----------------------------
	    // DISPLAY STUDENTS
	    // -----------------------------
	    private static void displayStudents() {
	        String sql = "SELECT id, name, age, email FROM students ORDER BY id";

	        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            System.out.println("\n--- STUDENTS ---");
	            System.out.println("\nID | Name | Age | Email");
	            System.out.println("------------------------------------");
	            while (rs.next()) {
	       	                System.out.println(rs.getInt("id") +
	                        " | " + rs.getString("name") +
	                        " | "  + rs.getInt("age") +
	                        " | "  + rs.getString("email"));
	            }

	        } catch (Exception e) {
	            System.out.println("Error displaying students: " + e.getMessage());
	        }
	    }

	    // -----------------------------
	    // DISPLAY COURSES (JOIN)
	    // -----------------------------
	    private static void displayCourses() {
	        String sql = """
	                SELECT c.id, c.course_name, c.grade,
	                       s.name AS student_name
	                FROM courses c
	                JOIN students s ON c.student_id = s.id
	                ORDER BY c.id;
	        """;

	        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            System.out.println("\n--- COURSES ---");
	            System.out.println("\nID | Course | Grade | Student Name");
	            System.out.println("------------------------------------");
	            while (rs.next()) {
	                System.out.println(rs.getInt("id") +
	                		" | "  + rs.getString("course_name") +
	                		" | "  + rs.getDouble("grade") +
	                		" | "  + rs.getString("student_name"));
	            }

	        } catch (Exception e) {
	            System.out.println("Error displaying courses: " + e.getMessage());
	        }
	    }
	}
