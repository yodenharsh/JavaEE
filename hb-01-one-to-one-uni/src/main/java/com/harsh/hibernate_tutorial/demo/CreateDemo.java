package com.harsh.hibernate_tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harsh.hibernate_tutorial.entity.Instructor;
import com.harsh.hibernate_tutorial.entity.InstructorDetail;

public class CreateDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			Instructor instructor = new Instructor("Harsh", "Morayya", "harshmorayya@ymail.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/harsh_morayya", "Gaming");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			session.persist(instructor);
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
