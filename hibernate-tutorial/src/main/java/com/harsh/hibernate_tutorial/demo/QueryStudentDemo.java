package com.harsh.hibernate_tutorial.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harsh.hibernate_tutorial.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().addAnnotatedClass(Student.class).configure().buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			List<Student> students = session.createQuery("from Student s where s.lastName='Morayya'",Student.class).getResultList();
			students.forEach(student -> System.out.println(student.getFirstName()));
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
