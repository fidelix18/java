package com.colloge.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.colloge.beans.Course;

public class ShowMyCourseDialog extends JDialog {

	private JTable table;

	public ShowMyCourseDialog() {
		initGUI();
	}

	private void initGUI() {
		setTitle("University of Hertfordshire:My Courses");

		Container con = getContentPane();

		con.add(getCenterPanel());
		con.add(getButtonPanel(), BorderLayout.SOUTH);
		
		
		URL url = getClass().getResource("/images/myCourses.png");
		ImageIcon icon = new ImageIcon(url);

		setIconImage(icon.getImage());

		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 500);
		setLocationRelativeTo(null);

	}

	private Component getButtonPanel() {
		JPanel panel = new JPanel();

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ShowMyCourseDialog.this.dispose();
			}
		});

		panel.add(btnPrint);
		panel.add(btnClose);

		return panel;
	}

	private JPanel getCenterPanel() {
		JPanel panel = new JPanel(new BorderLayout());

		table = new JTable(new InstructorModel());

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		// centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());

		TableColumnModel colModel = table.getColumnModel();
		for (int i = 0; i < colModel.getColumnCount(); i++) {

			colModel.getColumn(i).setCellRenderer(centerRenderer);

		}

		colModel.getColumn(COL_SNO).setMaxWidth(50);
		colModel.getColumn(COL_ID).setMaxWidth(50);
		colModel.getColumn(COL_ROOM).setMaxWidth(50);
		colModel.getColumn(COL_SEATS).setMaxWidth(50);
		// colModel.getColumn(COL_EXPERTY).setMaxWidth(300);

		table.setRowHeight(20);

		JScrollPane jsp = new JScrollPane(table);

		panel.add(jsp);

		return panel;
	}

	private class InstructorModel extends AbstractTableModel {

		private List<Course> courses;

		private String[] columns = { "S.No.", "ID", "NAME", "ROOM", "SEATS", "EXPERTY", "INSTRUCTOR", "TIMING" };

		public InstructorModel() {
			courses = new ArrayList<>(HomeFrame.getStudentUser().getCourses());
		}

		@Override
		public int getRowCount() {

			return courses.size();
		}

		@Override
		public int getColumnCount() {

			return columns.length;
		}

		@Override
		public String getColumnName(int column) {

			return columns[column];
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Course course = courses.get(rowIndex);

			switch (columnIndex) {
			case COL_SNO: {
				return rowIndex + 1;
			}
			case COL_ID: {
				return course.getId();
			}
			case COL_NAME: {
				return course.getName();
			}
			case COL_ROOM: {
				return course.getRoom();
			}
			case COL_SEATS: {
				return course.getSeats();
			}
			case COL_INSTRUCTOR: {
				return course.getInstructor();
			}
			case COL_EXPERTY: {
				return course.getExperty();
			}
			case COL_TIMING: {
				return course.getTiming();
			}
			default:
				return null;
			}

		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch (columnIndex) {
			case COL_ID: {

				return Number.class;
			}
			case COL_SNO: {

				return Number.class;
			}
			case COL_SEATS: {

				return Number.class;
			}

			default:
				return String.class;
			}
		}

		private static final long serialVersionUID = -8466732139803609947L;
	}

	private static final int COL_SNO = 0;
	private static final int COL_ID = 1;
	private static final int COL_NAME = 2;
	private static final int COL_ROOM = 3;
	private static final int COL_SEATS = 4;
	private static final int COL_EXPERTY = 5;
	private static final int COL_INSTRUCTOR = 6;
	private static final int COL_TIMING = 7;

}
