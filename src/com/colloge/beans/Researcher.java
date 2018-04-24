package com.colloge.beans;

import com.colloge.constants.InstructorType;

public class Researcher extends Instructor {

	public Researcher() {
		super(InstructorType.RESEARCHER, 0);
	}

	@Override
	public String toString() {
		return getType() + " : " + getName();
	}
}
