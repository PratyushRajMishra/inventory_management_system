package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Depart_emp implements ActionListener {
	JFrame f1;
	JPanel p1, p2;
	JLabel l1, l2;
	JComboBox<?> cb1;
	JButton btn1;
	JTable tb1;

	Depart_emp() {
		f1 = new JFrame("OrderUp-Department");

		p1 = new JPanel();
		p1.setBounds(250, 15, 200, 40);
		p1.setBackground(Color.DARK_GRAY);
		p1.setLayout(null);
		p1.setVisible(true);

		l1 = new JLabel("Department");
		l1.setBounds(15, 0, 200, 40);
		l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		l1.setForeground(Color.WHITE);
		l1.setLayout(null);
		l1.setVisible(true);

		l2 = new JLabel("Select department:-");
		l2.setBounds(50, 75, 350, 40);
		l2.setFont(new Font("Calibri", Font.BOLD, 30));
		l2.setLayout(null);
		l2.setVisible(true);

		String[] s2 = { "Beauty", "Electric", "Dairy", "Pharmacy", "Kitchenware", "Backery", "Meat", "Groceries" };
		cb1 = new JComboBox<Object>(s2);
		cb1.setBounds(310, 75, 175, 35);
		cb1.setFont(new Font("Calibri", Font.BOLD, 20));
		cb1.setLayout(null);
		cb1.setVisible(true);

		p2 = new JPanel();
		p2.setBounds(10, 125, 690, 325);
		p2.setBackground(Color.ORANGE);
		p2.setLayout(null);
		p2.setVisible(true);

		btn1 = new JButton("SHOW DATA");
		btn1.setBounds(525, 75, 155, 35);
		btn1.setFont(new Font("Serif", Font.BOLD, 20));
		btn1.setBackground(Color.BLUE);
		btn1.setForeground(Color.WHITE);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);

		// create table here
		tb1 = new JTable();
		tb1.setBounds(0, 20, 690, 325);
		tb1.setBackground(Color.WHITE);
		tb1.setFont(new Font("Cablibri", Font.PLAIN, 15));
		p2.add(tb1);

		JLabel l3 = new JLabel("First name");
		l3.setBounds(0, 5, 100, 20);
		l3.setFont(new Font("Calibri", Font.BOLD, 20));
		p2.add(l3);

		JLabel l4 = new JLabel("Last name");
		l4.setBounds(172, 5, 100, 20);
		l4.setFont(new Font("Calibri", Font.BOLD, 20));
		p2.add(l4);

		JLabel l5 = new JLabel("Email ID");
		l5.setBounds(345, 5, 100, 20);
		l5.setFont(new Font("Calibri", Font.BOLD, 20));
		p2.add(l5);

		JLabel l6 = new JLabel("Mobile no.");
		l6.setBounds(517, 5, 100, 20);
		l6.setFont(new Font("Calibri", Font.BOLD, 20));
		p2.add(l6);




		f1.add(p1);
		p1.add(l1);
		f1.add(l2);
		f1.add(cb1);
		f1.add(p2);
		f1.add(btn1);

		f1.setBounds(500, 200, 725, 500);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setLayout(null);
		f1.setVisible(true);
	}

public void  actionPerformed(ActionEvent ae) {
	
	if (ae.getSource() == btn1) {
		try {
			String str = "select Fname, Lname, email, Mob from employee where Dep = '" + cb1.getSelectedItem()
					+ "'";

			Connect con = new Connect();
		ResultSet rs;
		if (String.valueOf(cb1.getSelectedItem()) != null) {
				rs = con.stmt.executeQuery(str);
				tb1.setModel(DbUtils.resultSetToTableModel(rs));
		}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
		
			
		}

	public static void main(String[] args) {
		new Depart_emp();
	}

}
