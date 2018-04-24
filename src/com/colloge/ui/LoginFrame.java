package com.colloge.ui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.colloge.DataLayer;
import com.colloge.beans.Student;
import com.colloge.constants.InstructorType;

public class LoginFrame {

	public LoginFrame() {
		initGUI();
	}

	private void initGUI() {
		JFrame frame = new JFrame("Login Frame");

		Container con = frame.getContentPane();

		con.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		JLabel lbUser = new JLabel("Email");
		JLabel lbEmail = new JLabel("Email");
		JLabel lbPassword = new JLabel("Email");
		JButton btnLogin = new JButton("Login");

		JComboBox<InstructorType> cmbUser = new JComboBox<>(InstructorType.values());
		JTextField txtEmail = new JTextField(15);
		txtEmail.setText("test@test.com");
		
		JTextField txtPassword = new JPasswordField(15);
		txtPassword.setText("1234");
		
		JButton btnExit = new JButton("Exit");

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InstructorType user = (InstructorType) cmbUser.getSelectedItem();

				if (user == InstructorType.STUDENT) {

					String email = txtEmail.getText();
					String password = txtPassword.getText();

					if (email == null || email.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please enter email.");
						return;
					} else if (password == null || password.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please enter password.");
						return;
					}

					Student student = DataLayer.findStudent(email, password);

					if (student != null) {
						HomeFrame.setStudentUser(student);

						JOptionPane.showMessageDialog(frame, "Login Successful...");
						frame.dispose();

						new HomeFrame();

					}
					
					else {
						JOptionPane.showMessageDialog(frame, "Wrong Email or Password","Login Failed...",JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		gbc.gridx = 0;
		gbc.gridy = 0;
		con.add(lbUser, gbc);

		gbc.gridy = 1;
		con.add(lbEmail, gbc);

		gbc.gridy = 2;
		con.add(lbPassword, gbc);

		gbc.gridy = 3;
		con.add(btnLogin, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		con.add(cmbUser, gbc);

		gbc.gridy = 1;
		con.add(txtEmail, gbc);

		gbc.gridy = 2;
		con.add(txtPassword, gbc);

		gbc.gridy = 3;
		con.add(btnExit, gbc);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
