package com.colloge.beans;

import com.colloge.constants.InstructorType;

public class Lecturer extends Instructor {

	public Lecturer() {
		super(InstructorType.LECTURER, 2);
	}

	@Override
	public String toString() {
		return getType() + " : " + getName();
	}

}
