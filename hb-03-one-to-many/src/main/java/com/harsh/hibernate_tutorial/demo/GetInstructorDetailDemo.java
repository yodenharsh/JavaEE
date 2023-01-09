package com.harsh.hibernate_tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harsh.hibernate_tutorial.entity.Instructor;
import com.harsh.hibernate_tutorial.entity.InstructorDetail;

public class GetInstructorDetailDemo {
	public static void main(String[] args) {
		try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();)

		 {
			
			
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 22); //breaks the code
			System.out.println(instructorDetail.getInstructor().getFirstName());
			
			session.getTransaction().commit();
		} 
	}
}
