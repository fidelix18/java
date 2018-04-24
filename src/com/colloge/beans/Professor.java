package com.colloge.beans;

import com.colloge.constants.InstructorType;

public class Professor extends Instructor {

	public Professor() {

		super(InstructorType.PROFESSOR, 2);

	}

	@Override
	public String toString() {
		return getType() + " : " + getName();
	}

}
