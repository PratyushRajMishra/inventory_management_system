package com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Upd_emp implements ActionListener {
	JFrame f1;
	JPanel p1, p2;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JDateChooser date1;
	JComboBox<?> cb1, cb2;
	JButton btn1, btn2;

	Upd_emp() {
		f1 = new JFrame("OrderUp-Update employee details");

		p1 = new JPanel();
		p1.setBounds(300, 20, 300, 40);
		p1.setBackground(Color.DARK_GRAY);
		p1.setLayout(null);
		p1.setVisible(true);

		l1 = new JLabel("Update employee");
		l1.setBounds(25, 0, 300, 40);
		l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		l1.setForeground(Color.WHITE);
		l1.setLayout(null);
		l1.setVisible(true);

		l2 = new JLabel("Enter Employee id:-");
		l2.setBounds(75, 80, 300, 40);
		l2.setFont(new Font("Calibri", Font.BOLD, 30));
		l2.setLayout(null);
		l2.setVisible(true);

		tf1 = new JTextField();
		tf1.setBounds(325, 75, 300, 40);
		tf1.setVisible(true);

		btn1 = new JButton("SEARCH");
		btn1.setBounds(650, 75, 120, 40);
		btn1.setFont(new Font("Serif", Font.BOLD, 20));
		btn1.setBackground(Color.GREEN);
		btn1.setForeground(Color.BLACK);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);

		p2 = new JPanel();
		p2.setBounds(25, 125, 860, 475);
		p2.setBackground(Color.WHITE);
		p2.setLayout(null);
		p2.setVisible(true);

		l3 = new JLabel("First name:-");
		l3.setBounds(35, 35, 300, 50);
		l3.setFont(new Font("Calibri", Font.BOLD, 20));
		l3.setLayout(null);
		l3.setVisible(true);

		tf2 = new JTextField();
		tf2.setBounds(135, 40, 250, 40);
		tf2.setVisible(true);

		l4 = new JLabel("Last name:-");
		l4.setBounds(475, 35, 300, 50);
		l4.setFont(new Font("Calibri", Font.BOLD, 20));
		l4.setLayout(null);
		l4.setVisible(true);

		tf3 = new JTextField();
		tf3.setBounds(575, 40, 250, 40);
		tf3.setVisible(true);

		l5 = new JLabel("Password:-");
		l5.setBounds(35, 110, 300, 50);
		l5.setFont(new Font("Calibri", Font.BOLD, 20));
		l5.setLayout(null);
		l5.setVisible(true);

		tf4 = new JTextField();
		tf4.setBounds(135, 115, 250, 40);
		tf4.setVisible(true);

		l6 = new JLabel("Mobile no:-");
		l6.setBounds(475, 110, 300, 50);
		l6.setFont(new Font("Calibri", Font.BOLD, 20));
		l6.setLayout(null);
		l6.setVisible(true);

		tf5 = new JTextField("+91");
		tf5.setBounds(575, 115, 250, 40);
		tf5.setVisible(true);

		l7 = new JLabel("Pin code:-");
		l7.setBounds(35, 185, 300, 50);
		l7.setFont(new Font("Calibri", Font.BOLD, 20));
		l7.setLayout(null);
		l7.setVisible(true);

		tf6 = new JTextField();
		tf6.setBounds(135, 190, 250, 40);
		tf6.setVisible(true);

		l8 = new JLabel("Birth date:-");
		l8.setBounds(475, 185, 300, 50);
		l8.setFont(new Font("Calibri", Font.BOLD, 20));
		l8.setLayout(null);
		l8.setVisible(true);

		// choose date of Birth here
		date1 = new JDateChooser();
		date1.setPreferredSize(new Dimension(250, 40));
		date1.setDateFormatString("yyyy-MM-dd");
		JPanel panel = new JPanel();
		panel.add(date1);
		panel.setBounds(550, 185, 300, 45);
		panel.setBackground(Color.WHITE);
		panel.setVisible(true);

		l9 = new JLabel("Gender:-");
		l9.setBounds(35, 260, 300, 50);
		l9.setFont(new Font("Calibri", Font.BOLD, 20));
		l9.setLayout(null);
		l9.setVisible(true);

		String[] s1 = { "Male", "Female", "Others" };
		cb1 = new JComboBox<Object>(s1);
		cb1.setBounds(135, 260, 250, 40);
		cb1.setLayout(null);
		cb1.setVisible(true);

		l10 = new JLabel("Department:-");
		l10.setBounds(475, 260, 300, 50);
		l10.setFont(new Font("Calibri", Font.BOLD, 20));
		l10.setLayout(null);
		l10.setVisible(true);

		String[] s2 = { "Beauty", "Electric", "Dairy", "Pharmacy", "Kitchenware", "Backery", "Meat", "Groceries" };
		cb2 = new JComboBox<Object>(s2);
		cb2.setBounds(595, 260, 225, 40);
		cb2.setLayout(null);
		cb2.setVisible(true);

		l11 = new JLabel("Address:-");
		l11.setBounds(35, 335, 300, 50);
		l11.setFont(new Font("Calibri", Font.BOLD, 20));
		l11.setLayout(null);
		l11.setVisible(true);

		tf7 = new JTextField();
		tf7.setBounds(135, 350, 500, 80);
		tf7.setVisible(true);

		btn2 = new JButton("UPDATE");
		btn2.setBounds(700, 400, 120, 40);
		btn2.setFont(new Font("Serif", Font.BOLD, 20));
		btn2.setBackground(Color.RED);
		btn2.setForeground(Color.WHITE);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);

		f1.add(p1);
		p1.add(l1);
		f1.add(l2);
		f1.add(tf1);
		f1.add(btn1);
		f1.add(p2);
		p2.add(l3);
		p2.add(tf2);
		p2.add(l4);
		p2.add(tf3);
		p2.add(l5);
		p2.add(tf4);
		p2.add(l6);
		p2.add(tf5);
		p2.add(l7);
		p2.add(tf6);
		p2.add(l8);
		p2.add(panel);
		p2.add(l9);
		p2.add(cb1);
		p2.add(l10);
		p2.add(cb2);
		p2.add(l11);
		p2.add(tf7);
		p2.add(btn2);

		f1.setBounds(400, 125, 925, 650);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setLayout(null);
		f1.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == btn1) {
			Connect con = new Connect();
			String str1 = "SELECT * FROM employee WHERE empID='" + tf1.getText() + "'";

			try {
				ResultSet rs = ((Statement) con.stmt).executeQuery(str1);
				if (rs.next()) {

					// fetching records from SQL table
					String l3 = rs.getString(1);
					String l4 = rs.getString(2);
					String l5 = rs.getString(4);
					String l6 = rs.getString(7);
					String l7 = rs.getString(8);
					String l8 = rs.getString(6);
					String l9 = rs.getString(9);
					String l10 = rs.getString(10);
					String l11 = rs.getString(11);

					// Set data in TextFields
					tf2.setText(l3);
					tf3.setText(l4);
					tf4.setText(l5);
					tf5.setText(l6);
					tf6.setText(l7);
					((JTextField) date1.getDateEditor().getUiComponent()).setText(l8);
					cb1.setSelectedItem(l9);
					cb2.setSelectedItem(l10);
					tf7.setText(l11);

				}

				else {
					JOptionPane.showMessageDialog(f1, "Please Enter Valid Employee ID");
				}
			}
			catch (Exception ex) {
				System.out.println();
		}
		}
	
		if (ae.getSource() == btn2) {
			Connect con = new Connect();
			String str2 = "UPDATE employee SET Fname='" + tf2.getText() + "', Lname='" + tf3.getText() + "', pass='"
					+ tf4.getText() + "'" + ", Mob='" + tf5.getText() + "', Pin='" + tf6.getText() + "', birth='"
					+ ((JTextField) date1.getDateEditor().getUiComponent()).getText() + "', Gender='"
					+ cb1.getSelectedItem() + "', Dep='" + cb2.getSelectedItem() + "', Address='" + tf7.getText()
					+ "'  WHERE empID='"
					+ tf1.getText() + "'";

			try {
				con.stmt.executeUpdate(str2);
				JOptionPane.showMessageDialog(f1, "Successfully Updated");
				}

			catch (Exception ex) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		new Upd_emp();
	}

}
