package com;

import java.awt.Color;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Emp_list {
	JFrame f1;
	JPanel p1, p2;
	JLabel l1;
	JTable tb1;

	Emp_list() {

		f1 = new JFrame("OrderUp-Employee list");

		p1 = new JPanel();
		p1.setBounds(325, 15, 250, 40);
		p1.setBackground(Color.DARK_GRAY);
		p1.setLayout(null);
		p1.setVisible(true);

		l1 = new JLabel("Employee List");
		l1.setBounds(25, 0, 250, 40);
		l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		l1.setForeground(Color.WHITE);
		l1.setLayout(null);
		l1.setVisible(true);


		p2 = new JPanel();
		p2.setBounds(25, 75, 860, 510);
		p2.setBackground(Color.BLUE);
		p2.setLayout(null);
		p2.setVisible(true);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 860, 510);
		jsp.setVisible(true);
		p2.add(jsp);

		// create table here
		tb1 = new JTable();
		tb1.setBounds(0, 0, 860, 510);
		tb1.setBackground(Color.WHITE);
		tb1.setFont(new Font("Cablibri", Font.PLAIN, 15));
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = { "empID", "Fname", "Lname", "email", "Mob", "birth", "Pin", "Gender", "Address" };
		model.setColumnIdentifiers(column);
		tb1.setModel(model);
		tb1.setRowHeight(50);
		jsp.setViewportView(tb1);

		try {

			// Registering the Driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// Getting the connection
			String mysqlUrl = "jdbc:mysql://localhost:3306/test";
			java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

			java.sql.PreparedStatement pstmt = con1.prepareStatement(
					"select empID, Fname, Lname, email, Mob, birth, Pin, Gender, Address from employee");

			ResultSet rs1 = pstmt.executeQuery();

			tb1.setModel(DbUtils.resultSetToTableModel(rs1));
		}

		catch (Exception ex) {
			System.out.println(ex);
		}

		f1.add(p1);
		p1.add(l1);
		f1.add(p2);
		p2.add(jsp);

		f1.setBounds(400, 125, 925, 650);
		f1.getContentPane().setBackground(Color.WHITE);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setLayout(null);
		f1.setVisible(true);
	}


	public static void main(String[] args) {
		new Emp_list();
	}


}
