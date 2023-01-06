package com.harsh.actalyst_full_stack;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/* This class contains the entity DOB for the requests table*/


@Entity
@Table(name="requests")
public class DOB {
	
	@Id
	@GeneratedValue
	private int id;
	

	private Date DOB;

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public DOB(Date dOB) {
		DOB = dOB;
	}

}
