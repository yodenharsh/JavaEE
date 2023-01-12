package com.harsh.hibernate_tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harsh.hibernate_tutorial.entity.Course;
import com.harsh.hibernate_tutorial.entity.Instructor;
import com.harsh.hibernate_tutorial.entity.InstructorDetail;
import com.harsh.hibernate_tutorial.entity.Review;
import com.harsh.hibernate_tutorial.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		
		try(SessionFactory factory = new Configuration().addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Student.class)
				.configure().buildSessionFactory();
		
		Session session = factory.getCurrentSession();){
			
			session.beginTransaction();
			
			Course course1 = new Course("Guitar Hero Guide");
			Course course2 = new Course("Hello World in 5 languages");
			
			Student s1 = new Student("Harsh Morayya", "lAST name", "something@something.com");
			Student s2 = new Student("Bing", "Chilling", "xilaogumma@waibu.com");
			
			course1.addStudent(s1);
			course1.addStudent(s2);
			course2.addStudent(s1);
			
			session.persist(course1);
			session.persist(course2);
			
			session.getTransaction().commit();
			
		}
	}
}
