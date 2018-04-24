package com.colloge.constants;

public enum Experty {

	PROGRRAMING("Programming"), DATABASE("Database"), NETWORKING("Networking"), AI("Artificial Intelligence"), IOT(
			"Internet Of Things");

	private String name;

	private Experty(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

}
