package com.colloge.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.colloge.DataLayer;
import com.colloge.beans.Instructor;

public class ShowInstructorDialog extends JDialog {

	private JTable table;

	public ShowInstructorDialog() {
		initGUI();
	}

	private void initGUI() {
		setTitle("University of Hertfordshire: Instructor");

		Container con = getContentPane();

		con.add(getCenterPanel());
		con.add(getButtonPanel(), BorderLayout.SOUTH);

		URL url = getClass().getResource("/images/instructor.jpg");
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
				ShowInstructorDialog.this.dispose();
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
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());

		TableColumnModel colModel = table.getColumnModel();
		for (int i = 0; i < colModel.getColumnCount(); i++) {

			colModel.getColumn(i).setCellRenderer(centerRenderer);

		}

		colModel.getColumn(COL_SNO).setMaxWidth(50);
		colModel.getColumn(COL_ID).setMaxWidth(50);

		table.setRowHeight(20);

		JScrollPane jsp = new JScrollPane(table);

		panel.add(jsp);

		return panel;
	}

	private class InstructorModel extends AbstractTableModel {

		private List<Instructor> instructors;

		private String[] columns = { "S.No.", "ID", "NAME", "EMAIL", "EXPERTY", "ADDRESS", "TYPE" };

		public InstructorModel() {
			instructors = DataLayer.getInstructors();
		}

		@Override
		public int getRowCount() {

			return instructors.size();
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
			Instructor instructor = instructors.get(rowIndex);

			switch (columnIndex) {
			case COL_SNO: {
				return rowIndex + 1;
			}
			case COL_ID: {
				return instructor.getId();
			}
			case COL_NAME: {
				return instructor.getName();
			}
			case COL_EMAIL: {
				return instructor.getEmail();
			}
			case COL_EXPERTY: {
				return instructor.getExperties().toString();
			}
			case COL_ADDRESS: {
				return instructor.getAddress();
			}
			case COL_TYPE: {
				return instructor.getType();
			}

			default:
				return null;
			}

		}

		private static final long serialVersionUID = -8466732139803609947L;
	}

	private static final int COL_SNO = 0;
	private static final int COL_ID = 1;
	private static final int COL_NAME = 2;
	private static final int COL_EMAIL = 3;
	private static final int COL_EXPERTY = 4;
	private static final int COL_ADDRESS = 5;
	private static final int COL_TYPE = 6;

}
