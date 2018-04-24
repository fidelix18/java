package com.colloge.constants;

public enum InstructorType {

	STUDENT("student"), PROFESSOR("professor"), LECTURER("lecturer"), RESEARCHER("researcher");

	private String name;

	private InstructorType(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

}
