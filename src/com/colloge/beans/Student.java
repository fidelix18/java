package com.colloge.beans;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private long id;
	private String name;
	private String email;
	private String password;

	private Set<Course> courses;
	
	public Student() {
		courses=new HashSet<>();
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> cources) {
		this.courses = cources;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
