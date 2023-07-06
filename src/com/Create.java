package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Create implements ActionListener {
	JFrame f1;
	JLabel l5, l6, l7, l8, l9, l10, l11, l12, l13;
	JTextField tf2, tf3, tf4, tf5;
	JPasswordField pf2;
	JRadioButton a, c;
	ButtonGroup grp1;
	JComboBox<?> cb;
	JButton btn3;

	Create() {
		f1 = new JFrame("OrderUp-Create new account");

		l5 = new JLabel("Sign Up");
		l5.setFont(new Font("Calibri", Font.BOLD, 40));
		l5.setBounds(10, 10, 200, 50);
		l5.setLayout(null);
		l5.setVisible(true);

		l6 = new JLabel("It's quick and easy.");
		l6.setFont(new Font("Candara", Font.PLAIN, 15));
		l6.setForeground(Color.GRAY);
		l6.setBounds(10, 40, 200, 50);
		l6.setLayout(null);
		l6.setVisible(true);

		l7 = new JLabel("First Name:-");
		l7.setFont(new Font("Calibri", Font.BOLD, 20));
		l7.setBounds(50, 100, 200, 50);
		l7.setLayout(null);
		l7.setVisible(true);

		l8 = new JLabel("Last Name:-");
		l8.setFont(new Font("Calibri", Font.BOLD, 20));
		l8.setBounds(270, 100, 200, 50);
		l8.setLayout(null);
		l8.setVisible(true);

		tf2 = new JTextField();
		tf2.setBounds(50, 130, 200, 35);

		tf3 = new JTextField();
		tf3.setBounds(270, 130, 200, 35);

		l9 = new JLabel("Email address:-");
		l9.setFont(new Font("Calibri", Font.BOLD, 20));
		l9.setBounds(50, 180, 200, 50);
		l9.setLayout(null);
		l9.setVisible(true);

		tf4 = new JTextField();
		tf4.setBounds(50, 210, 420, 35);

		l10 = new JLabel("Password:-");
		l10.setFont(new Font("Calibri", Font.BOLD, 20));
		l10.setBounds(50, 260, 200, 50);
		l10.setLayout(null);
		l10.setVisible(true);

		pf2 = new JPasswordField();
		pf2.setBounds(50, 290, 420, 35);

		l11 = new JLabel("Select Account:-");
		l11.setFont(new Font("Calibri", Font.BOLD, 20));
		l11.setBounds(50, 340, 250, 50);
		l11.setLayout(null);
		l11.setVisible(true);

		a = new JRadioButton("Admin");
		a.setBounds(210, 340, 90, 45);
		a.setFont(new Font("Sans-Serif", Font.BOLD, 20));
		a.setVisible(true);

		c = new JRadioButton("Customer");
		c.setBounds(340, 340, 120, 45);
		c.setFont(new Font("Sans-Serif", Font.BOLD, 20));
		c.setVisible(true);

		grp1 = new ButtonGroup();
		grp1.add(a);
		grp1.add(c);

		l12 = new JLabel("Mobile no.:-");
		l12.setFont(new Font("Calibri", Font.BOLD, 20));
		l12.setBounds(50, 390, 250, 50);
		l12.setLayout(null);
		l12.setVisible(true);

		tf5 = new JTextField();
		tf5.setBounds(50, 420, 420, 35);

		l13 = new JLabel("Gender:-");
		l13.setFont(new Font("Calibri", Font.BOLD, 20));
		l13.setBounds(50, 470, 250, 50);
		l13.setLayout(null);
		l13.setVisible(true);

		String[] s1 = { "Male", "Female", "Others" };
		cb = new JComboBox<Object>(s1);
		cb.setBounds(210, 475, 200, 35);
		cb.setLayout(null);
		cb.setVisible(true);

		btn3 = new JButton("Sign Up");
		btn3.setBounds(180, 545, 155, 45);
		btn3.setFont(new Font("ARIAL NARROW", Font.BOLD, 30));
		btn3.setBackground(Color.RED);
		btn3.setForeground(Color.WHITE);
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);

		f1.add(l5);
		f1.add(l6);
		f1.add(l7);
		f1.add(l8);
		f1.add(tf2);
		f1.add(tf3);
		f1.add(l9);
		f1.add(tf4);
		f1.add(l10);
		f1.add(pf2);
		f1.add(l11);
		f1.add(a);
		f1.add(c);
		f1.add(l12);
		f1.add(tf5);
		f1.add(l13);
		f1.add(cb);
		f1.add(btn3);

		f1.setLayout(null);
		f1.setBounds(850, 100, 550, 645);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == btn3) {
			String l7 = tf2.getText();
			String l8 = tf3.getText();
			String l9 = tf4.getText();
			String l10 = String.valueOf(pf2.getPassword());
			String l11 = null;
			if (a.isSelected()) {
				l11 = "Admin";
			} else if (c.isSelected()) {
				l11 = "Customer";
			}
			String l12 = tf5.getText();
			String l13 = (String) cb.getSelectedItem();




			try {

				Connect con = new Connect();
				String str1 = "insert into login values('" + l7 + "','" + l8 + "','" + l9 + "','" + l10 + "','" + l11
						+ "','" + l12 + "','" + l13 + "')";
				con.stmt.executeUpdate(str1);


				if (a.isSelected()) {
					String str2 = "insert into admin(Fname, Lname, email, pass, mob, Gender) values('" + l7 + "','" + l8
							+ "','" + l9 + "','" + l10 + "','" + l12 + "','" + l13 + "')";
					con.stmt.executeUpdate(str2);
				}

				else if (c.isSelected()) {
					String str3 = "insert into customer(Fname, Lname, email, pass, mob, Gender) values('" + l7 + "','"
							+ l8 + "','" + l9 + "','" + l10 + "','" + l12 + "','" + l13 + "')";
					con.stmt.executeUpdate(str3);
				}
				JOptionPane.showInternalMessageDialog(null, "New Account Created");
				f1.dispose();
			}

			catch (Exception ex) {
				JOptionPane.showInternalMessageDialog(null, "           ALERT!" + "\n" + "Fill correct information");
				System.out.println(ex);
			}

		}

	}

	public static void main(String[] args) {
		new Create();
	}

}
