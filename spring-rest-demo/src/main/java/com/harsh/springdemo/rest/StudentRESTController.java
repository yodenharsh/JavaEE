package com.harsh.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.springdemo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRESTController {

	private List<Student> students = new ArrayList<>();

	@PostConstruct
	public void loadStudents() {
		students.add(new Student("Harsh", "Morayya"));
		students.add(new Student("Brother", "Mario"));
		students.add(new Student("Sister", "God"));
		
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if(studentId > students.size() || studentId < 0) 
			throw new StudentNotFoundException("Student id: "+studentId+" not found");
		
		return students.get(studentId);
	}
	

}
