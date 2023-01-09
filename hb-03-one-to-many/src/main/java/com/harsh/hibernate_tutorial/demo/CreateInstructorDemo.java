package com.harsh.hibernate_tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harsh.hibernate_tutorial.entity.Course;
import com.harsh.hibernate_tutorial.entity.Instructor;
import com.harsh.hibernate_tutorial.entity.InstructorDetail;

public class CreateInstructorDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			

			
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			System.out.println(instructor.getCourses());
			
			session.getTransaction().commit();
		} finally {
			factory.close();
			session.close();
		}
	}
}
