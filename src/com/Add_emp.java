package com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Add_emp implements ActionListener {
	JFrame f1;
	JPanel p1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JPasswordField pf1;
	JDateChooser date1;
	JComboBox<?> cb1, cb2;
	JButton btn1;
	
	
	
	
	
	Add_emp()
	{
		f1= new JFrame("OrderUp-Add new employee");

		
		p1= new JPanel();
		p1.setBounds(300, 20, 325, 40);
		p1.setBackground(Color.DARK_GRAY);
		p1.setLayout(null);
		p1.setVisible(true);
		
		
		l1= new JLabel("Add new employee");
		l1.setBounds(25, 0, 300, 40);
		l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		l1.setForeground(Color.WHITE);
		l1.setLayout(null);
		l1.setVisible(true);
		
		
		l2=new JLabel("First name:-");
		l2.setBounds(75, 100, 300, 50);
		l2.setFont(new Font("Calibri", Font.BOLD, 20));
		l2.setLayout(null);
		l2.setVisible(true);
		
		
		l3=new JLabel("Last name:-");
		l3.setBounds(525, 100, 300, 50);
		l3.setFont(new Font("Calibri", Font.BOLD, 20));
		l3.setLayout(null);
		l3.setVisible(true);
		
		
		tf1= new JTextField();
		tf1.setBounds(75, 130, 300, 40);
		tf1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		
		tf2= new JTextField();
		tf2.setBounds(525, 130, 300, 40);
		tf2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		
		l4= new JLabel("Email address:-");
		l4.setBounds(75, 180, 300, 50);
		l4.setFont(new Font("Calibri", Font.BOLD, 20));
		l4.setLayout(null);
		l4.setVisible(true);
		
		
		l5=new JLabel("Password:-");
		l5.setBounds(525, 180, 300, 50);
		l5.setFont(new Font("Calibri", Font.BOLD, 20));
		l5.setLayout(null);
		l5.setVisible(true);
		
		
		tf3= new JTextField();
		tf3.setBounds(75, 210, 300, 40);
		tf3.setFont(new Font("Arial", Font.PLAIN, 15));
		
		
		pf1= new JPasswordField();
		pf1.setBounds(525, 210, 300, 40);
		pf1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		
		l6= new JLabel("Employee id:-");
		l6.setBounds(75, 260, 300, 50);
		l6.setFont(new Font("Calibri", Font.BOLD, 20));
		l6.setLayout(null);
		l6.setVisible(true);
		
		
		l7=new JLabel("Date of birth:-");
		l7.setBounds(525, 260, 300, 50);
		l7.setFont(new Font("Calibri", Font.BOLD, 20));
		l7.setLayout(null);
		l7.setVisible(true);
		
		
		tf4= new JTextField();
		tf4.setBounds(75, 290, 300, 40);
		tf4.setFont(new Font("Arial", Font.PLAIN, 15));
		
		
		
		//choose date of Birth here
		date1 = new JDateChooser();
		date1.setPreferredSize(new Dimension(295,35));
		date1.setDateFormatString("yyyy-MM-dd");
		JPanel panel = new JPanel();
		panel.add(date1);
		panel.setBounds(525, 290, 300, 40);
		panel.setBackground(Color.WHITE);
		panel.setVisible(true);
		
		
		
		l8= new JLabel("Mobile no.:-");
		l8.setBounds(75, 340, 300, 50);
		l8.setFont(new Font("Calibri", Font.BOLD, 20));
		l8.setLayout(null);
		l8.setVisible(true);
		
		
		l9=new JLabel("Pincode:-");
		l9.setBounds(525, 340, 300, 50);
		l9.setFont(new Font("Calibri", Font.BOLD, 20));
		l9.setLayout(null);
		l9.setVisible(true);
		
		
		tf5 = new JTextField();
		tf5.setBounds(75, 370, 300, 40);
		tf5.setFont(new Font("Arial", Font.PLAIN, 15));
		
		
		tf6= new JTextField();
		tf6.setBounds(525, 370, 300, 40);
		tf6.setFont(new Font("Arial", Font.PLAIN, 15));
		
		
		l10= new JLabel("Gender:-");
		l10.setBounds(75, 430, 300, 50);
		l10.setFont(new Font("Calibri", Font.BOLD, 20));
		l10.setLayout(null);
		l10.setVisible(true);
		
		
		String[] s1= {"Male", "Female", "Others"};
		cb1 = new JComboBox<Object>(s1);
		cb1.setBounds(175, 430, 200, 40);
		cb1.setLayout(null);
		cb1.setVisible(true);
		
		
		l11= new JLabel("Department:-");
		l11.setBounds(525, 430, 300, 50);
		l11.setFont(new Font("Calibri", Font.BOLD, 20));
		l11.setLayout(null);
		l11.setVisible(true);
		
		
		String[] s2= {"Beauty", "Electric", "Dairy", "Pharmacy", "Kitchenware", "Backery", "Meat","Groceries"};
		cb2 = new JComboBox<Object>(s2);
		cb2.setBounds(650, 430, 175, 40);
		cb2.setLayout(null);
		cb2.setVisible(true);
		
		

		l12= new JLabel("Address:-");
		l12.setBounds(75, 495, 300, 50);
		l12.setFont(new Font("Calibri", Font.BOLD, 20));
		l12.setLayout(null);
		l12.setVisible(true);
		
		
		tf7= new JTextField();
		tf7.setBounds(175, 490, 650, 60);
		tf7.setFont(new Font("Arial", Font.PLAIN, 15));
		
		
		btn1= new JButton("Add");
		btn1.setBounds(385, 565, 120, 40);
		btn1.setFont(new Font("ARIAL NARROW", Font.BOLD, 30));
		btn1.setBackground(Color.RED);
		btn1.setForeground(Color.WHITE);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);
		
		
		
		
		f1.add(p1);
		p1.add(l1);
		f1.add(l2);
		f1.add(l3);
		f1.add(tf1);
		f1.add(tf2);
		f1.add(l4);
		f1.add(l5);
		f1.add(tf3);
		f1.add(pf1);
		f1.add(l6);
		f1.add(l7);
		f1.add(tf4);
		f1.add(panel);
		f1.add(l8);
		f1.add(l9);
		f1.add(tf5);
		f1.add(tf6);
		f1.add(l10);
		f1.add(l11);
		f1.add(cb1);
		f1.add(cb2);
		f1.add(l12);
		f1.add(tf7);
		f1.add(btn1);
		
		
		
		
		f1.setBounds(400, 125, 925, 650);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setLayout(null);
		f1.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()== btn1)
		{
			String l2= tf1.getText();
			String l3= tf2.getText();
			String l4= tf3.getText();
			String l5= String.valueOf(pf1.getPassword());
			String l6= tf4.getText();
			String l7 = ((JTextField)date1.getDateEditor().getUiComponent()).getText();
			String l8= tf5.getText();
			String l9= tf6.getText();		
			String l10= (String) cb1.getSelectedItem();
			String l11= (String) cb2.getSelectedItem();
			String l12= tf7.getText();
			String emp = "Employee";
			
			
			Connect con= new Connect();
			String str1 = "insert into login(Fname, Lname, email, pass, Account, Mob, Gender) values( '" + tf1.getText()
					+ "','"
					+ tf2.getText() + "','" + tf3.getText()
					+ "','" + l5 + "','" + emp + "','" + tf5.getText() + "','" + cb1.getSelectedItem()
					+ "')";

			String str2 = "insert into employee values('" + l2 + "','" + l3 + "','" + l4
				+ "','" + l5 + "','" + l6 + "','" + l7 + "','" + l8 + "','" + l9 + "',"
						+ "'" + l10 + "','" + l11 + "','" + l12 + "')";
			

			try 
			{
				con.stmt.executeUpdate(str1);
				con.stmt.executeUpdate(str2);
			JOptionPane.showInternalMessageDialog(null, "Profile Update successfull!");
			f1.dispose();
			}
		
			catch(Exception ex)
			{
			JOptionPane.showInternalMessageDialog(null,"           ALERT!"+ "\n" +"Fill correct information");
			System.out.println(ex);
			}

		}
	}
	
	
	public static void main(String[] args) {
		new Add_emp();
	}

}
