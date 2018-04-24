package com.colloge.beans;

import com.colloge.constants.Experty;

public class Course {

	private long id;

	private String name;
	private Experty experty;
	private Instructor instructor;

	private String room;
	private String timing;

	private int seats;

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

	public Experty getExperty() {
		return experty;
	}

	public void setExperty(Experty experty) {
		this.experty = experty;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

//	@Override
//	public boolean equals(Object obj) {
//
//		Course course = (Course) obj;
//
//		return this.getTiming().equals(course.getTiming());
//	}

	@Override
	public String toString() {

		return name;
	}

}
