package com.harsh.actalyst_full_stack;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RequestResource {

	@Autowired
	public RequestRepository requestRepository;
	
	@PostMapping("/request")
	public ResponseEntity<Object> addRequest(@RequestBody DOB dob){
		DOB savedRequest = requestRepository.save(dob);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedRequest.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
