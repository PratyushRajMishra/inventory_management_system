package com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class My_pro implements ActionListener {
	JFrame f1;
	JPanel p1, p2, p3, p4;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JPasswordField pf1;
	JComboBox<?> cb1;
	JButton btn1, btn2, btn3;
	JDateChooser date1;

	My_pro() {
		f1 = new JFrame("My Profile-Order Management System");

		p1 = new JPanel();
		p1.setBounds(0, 0, 1400, 50);
		p1.setBackground(new Color(112, 128, 144));
		p1.setLayout(null);
		p1.setVisible(true);

		ImageIcon image = new ImageIcon("F:\\test_logo.png");
		l1 = new JLabel(image);
		l1.setBounds(10, 0, 130, 50);
		l1.setLayout(null);
		l1.setVisible(true);

		l2 = new JLabel("MY PROFILE");
		l2.setBounds(630, 0, 500, 50);
		l2.setFont(new Font("Agency FB", Font.BOLD, 40));
		l2.setForeground(Color.WHITE);
		l2.setLayout(null);
		l2.setVisible(true);

		p2 = new JPanel();
		p2.setBounds(50, 80, 800, 560);
		p2.setBackground(new Color(255, 178, 102));
		p2.setLayout(null);
		p2.setVisible(true);

		p3 = new JPanel();
		p3.setBounds(175, 10, 450, 50);
		p3.setBackground(new Color(0, 153, 153));
		p3.setLayout(null);
		p3.setVisible(true);

		l3 = new JLabel("UPDATE PROFILE");
		l3.setBounds(25, 5, 500, 40);
		l3.setFont(new Font("Arial BLACK", Font.BOLD, 40));
		l3.setForeground(Color.WHITE);
		l3.setLayout(null);
		l3.setVisible(true);

		l4 = new JLabel("First name:-");
		l4.setBounds(25, 75, 300, 50);
		l4.setFont(new Font("Calibri", Font.BOLD, 20));
		l4.setLayout(null);
		l4.setVisible(true);

		l5 = new JLabel("Last name:-");
		l5.setBounds(475, 75, 300, 50);
		l5.setFont(new Font("Calibri", Font.BOLD, 20));
		l5.setLayout(null);
		l5.setVisible(true);

		tf1 = new JTextField();
		tf1.setBounds(25, 105, 300, 40);
		tf1.setFont(new Font("Arial", Font.PLAIN, 15));

		tf2 = new JTextField();
		tf2.setBounds(475, 105, 300, 40);
		tf2.setFont(new Font("Arial", Font.PLAIN, 15));

		l6 = new JLabel("Password:-");
		l6.setBounds(25, 155, 300, 50);
		l6.setFont(new Font("Calibri", Font.BOLD, 20));
		l6.setLayout(null);
		l6.setVisible(true);

		pf1 = new JPasswordField();
		pf1.setBounds(25, 185, 750, 40);
		pf1.setFont(new Font("Arial", Font.PLAIN, 15));

		l7 = new JLabel("Gender:-");
		l7.setBounds(25, 250, 300, 50);
		l7.setFont(new Font("Calibri", Font.BOLD, 20));
		l7.setLayout(null);
		l7.setVisible(true);

		String[] s1 = { "Male", "Female", "Others" };
		cb1 = new JComboBox<Object>(s1);
		cb1.setBounds(125, 252, 200, 40);
		cb1.setLayout(null);
		cb1.setVisible(true);

		l8 = new JLabel("Date of birth:-");
		l8.setBounds(475, 250, 300, 50);
		l8.setFont(new Font("Calibri", Font.BOLD, 20));
		l8.setLayout(null);
		l8.setVisible(true);

		// choose date of Birth here
		date1 = new JDateChooser();
		date1.setPreferredSize(new Dimension(175, 35));
		date1.setDateFormatString("yyyy-MM-dd");
		JPanel panel = new JPanel();
		panel.add(date1);
		panel.setBounds(600, 252, 175, 40);
		panel.setBackground(new Color(255, 178, 102));
		panel.setVisible(true);

		l9 = new JLabel("Mobile no.:-");
		l9.setBounds(25, 310, 300, 50);
		l9.setFont(new Font("Calibri", Font.BOLD, 20));
		l9.setLayout(null);
		l9.setVisible(true);

		l10 = new JLabel("Pincode:-");
		l10.setBounds(475, 310, 300, 50);
		l10.setFont(new Font("Calibri", Font.BOLD, 20));
		l10.setLayout(null);
		l10.setVisible(true);

		tf4 = new JTextField("+91");
		tf4.setBounds(25, 340, 300, 40);
		tf4.setFont(new Font("Arial", Font.PLAIN, 15));

		tf5 = new JTextField();
		tf5.setBounds(475, 340, 300, 40);
		tf5.setFont(new Font("Arial", Font.PLAIN, 15));

		l11 = new JLabel("Address:-");
		l11.setBounds(25, 415, 300, 50);
		l11.setFont(new Font("Calibri", Font.BOLD, 20));
		l11.setLayout(null);
		l11.setVisible(true);

		tf6 = new JTextField();
		tf6.setBounds(100, 410, 675, 60);
		tf6.setFont(new Font("Arial", Font.PLAIN, 15));

		btn1 = new JButton("UPDATE");
		btn1.setBounds(325, 490, 150, 45);
		btn1.setFont(new Font("ARIAL NARROW", Font.BOLD, 30));
		btn1.setBackground(new Color(0, 25, 51));
		btn1.setForeground(Color.WHITE);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);

		p4 = new JPanel();
		p4.setBounds(950, 175, 385, 375);
		p4.setBackground(new Color(0, 153, 153));
		p4.setLayout(null);
		p4.setVisible(true);

		
		l12 = new JLabel("WELCOME");
		l12.setBounds(25, 25, 360, 100);
		l12.setFont(new Font("Agency FB", Font.BOLD, 100));
		l12.setForeground(new Color(255, 178, 102));
		l12.setLayout(null);
		l12.setVisible(true);

		l13 = new JLabel("Enter Email ID:-");
		l13.setBounds(15, 150, 360, 40);
		l13.setFont(new Font("Times New Roman", Font.BOLD, 25));
		l13.setForeground(Color.WHITE);
		l13.setLayout(null);
		l13.setVisible(true);

		tf7 = new JTextField();
		tf7.setBounds(15, 180, 350, 40);
		tf7.setFont(new Font("Arial", Font.PLAIN, 15));

		btn2 = new JButton("UPDATE ACCOUNT");
		btn2.setBounds(42, 250, 300, 45);
		btn2.setFont(new Font("ARIAL NARROW", Font.BOLD, 25));
		btn2.setBackground(Color.RED);
		btn2.setForeground(Color.WHITE);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);

		
		btn3 = new JButton("DEACTIVATE ACCOUNT");
		btn3.setBounds(42, 315, 300, 45);
		btn3.setFont(new Font("ARIAL NARROW", Font.BOLD, 25));
		btn3.setBackground(Color.RED);
		btn3.setForeground(Color.WHITE);
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);
		

		f1.add(p1);
		p1.add(l1);
		p1.add(l2);
		f1.add(p2);
		p2.add(l3);
		p2.add(l4);
		p2.add(l5);
		p2.add(l6);
		p2.add(l7);
		p2.add(l8);
		p2.add(l9);
		p2.add(l10);
		p2.add(l11);
		p2.add(cb1);
		p2.add(panel);
		p2.add(tf1);
		p2.add(tf2);
		p2.add(pf1);
		p2.add(tf4);
		p2.add(tf5);
		p2.add(tf6);
		p2.add(p3);
		p2.add(btn1);
		p3.add(l3);
		f1.add(p4);
		p4.add(l12);
		p4.add(l13);
		p4.add(tf7);
		p4.add(btn2);
		p4.add(btn3);


		f1.setLayout(null);
		f1.setBounds(70, 85, 1400, 700);
		f1.getContentPane().setBackground(new Color(255, 255, 204));
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn2) {
			Connect con = new Connect();
			String str1 = "SELECT * FROM customer WHERE email='" + tf7.getText() + "'";

			try {
				ResultSet rs = ((Statement) con.stmt).executeQuery(str1);
				if (rs.next()) {

					// fetching records from SQL table
					String l4 = rs.getString(1);
					String l5 = rs.getString(2);
					String l6 = rs.getString(4);
					String l7 = rs.getString(5);
					String l8 = rs.getString(6);
					String l9 = rs.getString(7);
					String l10 = rs.getString(8);
					String l11 = rs.getString(9);

					// Set data in TextFields
					tf1.setText(l4);
					tf2.setText(l5);
					pf1.setText(l6);
					cb1.setSelectedItem(l7);
					((JTextField) date1.getDateEditor().getUiComponent()).setText(l8);
					tf4.setText(l9);
					tf5.setText(l10);
					tf6.setText(l11);
				}

				else {
					JOptionPane.showMessageDialog(f1, "Please Enter Valid Email ID");
				}
			} catch (Exception ex) {
				System.out.println();
			}
		}

		else if (e.getSource() == btn3) {
			if (tf7.getText().isEmpty()) {
				JOptionPane.showInternalMessageDialog(null, "Please Enter Valid Email ID");
			}

			else {
				int a = JOptionPane.showConfirmDialog(f1, "Are you sure want to deactivate?");
				if (a == JOptionPane.YES_OPTION) {
				String str3 = "INSERT INTO deactive( Fname, Lname, email, pass, birth, Gender, Mob, Pin, Address, Account)"
						+ "SELECT Fname, Lname, email, pass, birth, Gender, mob, Pin, Address , 'Customer' from customer WHERE email= '"
						+ tf7.getText() + "' ";
				String str4 = "DELETE FROM login WHERE email= '" + tf7.getText() + "' ";


				try {
						Connect con = new Connect();
					con.stmt.executeUpdate(str3);
					con.stmt.executeUpdate(str4);

					JOptionPane.showInternalMessageDialog(null, "Account Deactivated!!");
					f1.dispose();
					new Dash();
				}
				catch (Exception ex) {
					JOptionPane.showInternalMessageDialog(null, "Record not matched");
					System.out.println(ex);
				}
				}
			}
		}
	

	



		else if (e.getSource() == btn1) {
			Connect con = new Connect();
			@SuppressWarnings("deprecation")
			String str5 = "UPDATE customer SET Fname='" + tf1.getText() + "', Lname='" + tf2.getText() + "', pass='"
					+ pf1.getText() + "'" + ", Gender='" + cb1.getSelectedItem() + "',  birth='"
					+ ((JTextField) date1.getDateEditor().getUiComponent()).getText() + "', mob= '" + tf4.getText()
					+ "'," + "Pin= '" + tf5.getText() + "', Address='" + tf6.getText() + "'  WHERE email='"
					+ tf7.getText() + "'";

			try {
				con.stmt.executeUpdate(str5);
				JOptionPane.showMessageDialog(f1, "Successfully Updated");
				f1.dispose();
				new Dash();
			}

			catch (Exception ex) {
				JOptionPane.showInternalMessageDialog(null, "Fill correct in the box");
				System.out.println(ex);
			}
		}
		}




	public static void main(String[] args) {
		new My_pro();
	}
}
