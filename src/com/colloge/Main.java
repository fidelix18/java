package com.colloge;

import javax.swing.UIManager;

import com.colloge.ui.LoginFrame;

public class Main {

	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		new LoginFrame();
		// new HomeFrame();

		// new InstructorDialog();

	}

}
