package com.harsh.jackson_databinding_json_demo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
	public static void main(String[] args) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Student theStudent = null;
		try {
			theStudent = objectMapper.readValue(new File("data/sample-full.json"), Student.class);
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("First name: "+theStudent.getFirstName());
		System.out.println("Address:\n");
		System.out.println("Street: "+theStudent.getAddress().getState());
		System.out.println("City: "+theStudent.getAddress().getCity());
	
		System.out.println("Languages: ");
		for(String lang: theStudent.getLanguages()){
			System.out.print(lang + " ");
		}
	}
}
