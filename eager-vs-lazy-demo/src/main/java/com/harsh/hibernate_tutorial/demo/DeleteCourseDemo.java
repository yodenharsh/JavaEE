package com.harsh.hibernate_tutorial.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harsh.hibernate_tutorial.entity.Course;
import com.harsh.hibernate_tutorial.entity.Instructor;
import com.harsh.hibernate_tutorial.entity.InstructorDetail;
import com.harsh.hibernate_tutorial.entity.Review;
import com.harsh.hibernate_tutorial.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		try(SessionFactory factory = new Configuration().addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Student.class)
				.configure().buildSessionFactory();
		
		Session session = factory.getCurrentSession();){
			
			session.beginTransaction();
			
			Course course = session.get(Course.class, 17);
			
			List<Student> students = course.getStudents();
			
			students.forEach(student -> System.out.println(student.getFirstName()));
			
			session.getTransaction().commit();
			
		}
	}
}
