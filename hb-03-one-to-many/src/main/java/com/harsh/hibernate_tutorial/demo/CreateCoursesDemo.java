package com.harsh.hibernate_tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harsh.hibernate_tutorial.entity.Course;
import com.harsh.hibernate_tutorial.entity.Instructor;
import com.harsh.hibernate_tutorial.entity.InstructorDetail;

public class CreateCoursesDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
									
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			Course course1 = new Course("Mathematics");
			Course course2 = new Course("How to be funny");
			instructor.add(course2);instructor.add(course1);
			
			session.persist(course2);session.persist(course1);
			
			session.getTransaction().commit();
		} finally {
			factory.close();
			session.close();
		}
	}
}
