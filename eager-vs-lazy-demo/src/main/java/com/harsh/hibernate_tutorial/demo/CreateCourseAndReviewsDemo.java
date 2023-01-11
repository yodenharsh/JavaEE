package com.harsh.hibernate_tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harsh.hibernate_tutorial.entity.Course;
import com.harsh.hibernate_tutorial.entity.Instructor;
import com.harsh.hibernate_tutorial.entity.InstructorDetail;
import com.harsh.hibernate_tutorial.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		try(SessionFactory factory = new Configuration().addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.configure().buildSessionFactory();
		
		Session session = factory.getCurrentSession();){
			
			session.beginTransaction();
			
			Course course = new Course("Pacman - how to play");
			course.addReview(new Review("Great course!"));
			course.addReview(new Review("Thanks"));
			course.addReview(new Review("Loved it"));
			
			session.persist(course);
			
			session.getTransaction().commit();
			
		}
	}
}
