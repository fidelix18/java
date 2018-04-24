package com.colloge.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.WeakReference;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.colloge.beans.Student;

public class HomeFrame {

	public HomeFrame() {
		initGUI();
	}

	private void initGUI() {
		JFrame frame = new JFrame("University of Hertfordshire");

		Container con = frame.getContentPane();

		URL url = getClass().getResource("/images/University of Hertfordshire.png");

		JLabel lbImage = new JLabel(new ImageIcon(url));

		con.add(lbImage);

		frame.setJMenuBar(getJMenuBar());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	private JMenuBar getJMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		/*********** Show All *************/
		
		URL urlCourses = getClass().getResource("/images/courses.jpg");
		ImageIcon iconCourses = new ImageIcon(urlCourses);
		
		URL urlInstructor = getClass().getResource("/images/instructor.jpg");
		ImageIcon iconInstructor = new ImageIcon(urlInstructor);
		
		URL urlMyCourses = getClass().getResource("/images/myCourses.png");
		ImageIcon iconMyCourses = new ImageIcon(urlMyCourses);

		JMenu menuShow = new JMenu("Show All");

		JMenuItem showInstructors = new JMenuItem("Instructors",iconInstructor);
		showInstructors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WeakReference<ShowInstructorDialog> ref = new WeakReference<ShowInstructorDialog>(
						new ShowInstructorDialog());
				ref.get().setVisible(true);
			}
		});

		JMenuItem showCourses = new JMenuItem("Courses",iconCourses);
		showCourses.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WeakReference<ShowCourseDialog> ref = new WeakReference<ShowCourseDialog>(new ShowCourseDialog());
				ref.get().setVisible(true);
			}
		});

		JMenuItem showMyCourses = new JMenuItem("My Courses",iconMyCourses);
		showMyCourses.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WeakReference<ShowMyCourseDialog> ref = new WeakReference<ShowMyCourseDialog>(new ShowMyCourseDialog());
				ref.get().setVisible(true);
			}
		});

		menuShow.add(showInstructors);
		menuShow.add(showCourses);
		menuShow.add(showMyCourses);

		/****************************************/
		/************* Find All *****************/

		JMenu menuFind = new JMenu("Find");

		JMenuItem findInstructors = new JMenuItem("Instructors",iconInstructor);
		findInstructors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WeakReference<FindInstructorDialog> ref = new WeakReference<FindInstructorDialog>(
						new FindInstructorDialog());
				ref.get().setVisible(true);
			}
		});

		JMenuItem findCourses = new JMenuItem("Courses",iconCourses);
		findCourses.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WeakReference<FindCourseDialog> ref = new WeakReference<FindCourseDialog>(new FindCourseDialog());
				ref.get().setVisible(true);
			}
		});

		menuFind.add(findInstructors);
		menuFind.add(findCourses);

		/****************************************/

		/*************** Reports ****************/
		JMenu menuReports = new JMenu("Reports");
		/****************************************/

		menuBar.add(menuShow);
		menuBar.add(menuFind);
		menuBar.add(menuReports);

		return menuBar;

	}

	public static Student getStudentUser() {
		return user;
	}

	public static void setStudentUser(Student user) {
		HomeFrame.user = user;
	}

	static private Student user;

}
