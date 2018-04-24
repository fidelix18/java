package com.colloge.beans;

import java.util.Set;

import com.colloge.constants.Experty;
import com.colloge.constants.InstructorType;

public abstract class Instructor {

	public Instructor(InstructorType type, int classesPerWeek) {
		this.type = type;
		this.classesPerWeek = classesPerWeek;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorType getType() {
		return type;
	}

	public void setType(InstructorType type) {
		this.type = type;
	}

	public Set<Experty> getExperties() {
		return experties;
	}

	public void setExperties(Set<Experty> experties) {
		this.experties = experties;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getClassesPerWeek() {
		return classesPerWeek;
	}

	private long id;
	private String name;
	private String email;
	private InstructorType type;

	private Set<Experty> experties;

	protected int classesPerWeek;
	private String address;

}
