package com.colloge.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.colloge.DataLayer;
import com.colloge.beans.Course;
import com.colloge.beans.Instructor;

public class FindCourseDialog extends JDialog {

	public FindCourseDialog() {
		initGUI();
	}

	private void initGUI() {
		setTitle("University of Hertfordshire: Course");

		Container con = getContentPane();

		con.add(getTopPanel(), BorderLayout.NORTH);
		con.add(getCenterPanel());
		con.add(getButtonPanel(), BorderLayout.SOUTH);

		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 500);
		setLocationRelativeTo(null);

	}

	private Component getTopPanel() {
		JPanel panel = new JPanel();

		JLabel lbSelect = new JLabel("Select By:");

		String[] filters = { "ID", "NAME", "EXPERTY", "INSTRUCTOR", "TIMING" };
		cmbFilter = new JComboBox<>(filters);

		txtSearchKey = new JTextField(20);

		panel.add(lbSelect);
		panel.add(cmbFilter);
		panel.add(txtSearchKey);

		return panel;
	}

	private Component getButtonPanel() {
		JPanel panel = new JPanel();

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String filter = (String) cmbFilter.getSelectedItem();
				String key = txtSearchKey.getText();

				List<Course> instructors = DataLayer.getCourses(filter, key);

				table.setModel(new InstructorSearchModel(instructors));
			}
		});

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FindCourseDialog.this.dispose();
			}
		});

		panel.add(btnSearch);
		panel.add(btnClose);

		return panel;
	}

	private JPanel getCenterPanel() {
		JPanel panel = new JPanel(new BorderLayout());

		table = new JTable();

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());

		TableColumnModel colModel = table.getColumnModel();
		for (int i = 0; i < colModel.getColumnCount(); i++) {

			TableColumn col = colModel.getColumn(i);

			if (i == COL_SNO || i == COL_ID) {
				col.setMaxWidth(50);
			}

			colModel.getColumn(i).setCellRenderer(centerRenderer);

		}

		table.setRowHeight(20);

		JScrollPane jsp = new JScrollPane(table);

		panel.add(jsp);

		return panel;
	}

	private class InstructorSearchModel extends AbstractTableModel {

		private List<Course> courses;

		private String[] columns = { "S.No.", "ID", "NAME", "ROOM", "SEATS", "EXPERTY", "INSTRUCTOR", "TIMING" };

		public InstructorSearchModel(List<Course> courses) {
			this.courses = courses;
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

		private static final long serialVersionUID = -8466732139803609947L;
	}

	private JComboBox<String> cmbFilter;
	private JTextField txtSearchKey;
	private JTable table;

	private static final int COL_SNO = 0;
	private static final int COL_ID = 1;
	private static final int COL_NAME = 2;
	private static final int COL_ROOM = 3;
	private static final int COL_SEATS = 4;
	private static final int COL_EXPERTY = 5;
	private static final int COL_INSTRUCTOR = 6;
	private static final int COL_TIMING = 7;

	private static final long serialVersionUID = 1655385413543385909L;

}
