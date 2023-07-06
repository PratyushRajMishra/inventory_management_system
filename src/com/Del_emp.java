package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Del_emp implements ActionListener {
	JFrame f1;
	JPanel p1;
	JLabel l1, l2;
	JTextField tf1;
	JButton btn1, btn2;
	
	
	
	
	
	
	Del_emp()
	{
		f1= new JFrame("OrderUp-Delete employee");
		
		
		p1= new JPanel();
		p1.setBounds(185, 25, 325, 40);
		p1.setBackground(Color.DARK_GRAY);
		p1.setLayout(null);
		p1.setVisible(true);
		
		
		l1= new JLabel("Delete any employee");
		l1.setBounds(15, 0, 300, 40);
		l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		l1.setForeground(Color.WHITE);
		l1.setLayout(null);
		l1.setVisible(true);
		
		
		l2= new JLabel("Email address:-");
		l2.setBounds(75, 120, 300, 50);
		l2.setFont(new Font("Calibri", Font.BOLD, 30));
		l2.setLayout(null);
		l2.setVisible(true);
		
		
		tf1= new JTextField();
		tf1.setBounds(75, 155, 550, 40);
		tf1.setFont(new Font("Arial", Font.PLAIN, 15));

		
		btn1= new JButton("Delete Employee");
		btn1.setBounds(225, 250, 250, 40);
		btn1.setFont(new Font("ARIAL NARROW", Font.BOLD, 30));
		btn1.setBackground(Color.BLUE);
		btn1.setForeground(Color.WHITE);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);
		
		btn2= new JButton("Deactivate Employee");
		btn2.setBounds(185, 325, 325, 50);
		btn2.setFont(new Font("ARIAL NARROW", Font.BOLD, 35));
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
		f1.add(btn2);
		
		
		
		
		
		f1.setBounds(500, 200, 725, 500);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setLayout(null);
		f1.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()== btn1)
		{
			int a = JOptionPane.showConfirmDialog(f1, "DELETE?");
			if (a == JOptionPane.YES_OPTION) {
			
			String str1 = "DELETE FROM employee WHERE email='" + tf1.getText() + "'";
			String str2 = "DELETE FROM login WHERE email= '" + tf1.getText() + "' ";
			
			try 
			{
				Connect con = new Connect();
				con.stmt.executeUpdate(str1);
				con.stmt.executeUpdate(str2);
			JOptionPane.showInternalMessageDialog(null, "Employee deleted successfully!");
			f1.dispose();
			}
			

			catch(Exception ex)
			{
				JOptionPane.showInternalMessageDialog(null, "Record not matched");
				System.out.println(ex);
			}  
			}
		}

			else if (ae.getSource() == btn2) {
				int a = JOptionPane.showConfirmDialog(f1, "DEACTIVATE?");
				if (a == JOptionPane.YES_OPTION) {

				String str3 = "INSERT INTO deactive( Fname, Lname, email, pass, birth, Gender, Mob, Pin, Address, Account)"
						+ "SELECT Fname, Lname, email, pass, birth, Gender, Mob, Pin, Address , 'Employee' from employee WHERE email= '"
						+ tf1.getText() + "' ";
				String str4 = "DELETE FROM login WHERE email= '" + tf1.getText() + "' ";

				try {

					Connect con = new Connect();

					con.stmt.executeUpdate(str3);
					con.stmt.executeUpdate(str4);
					JOptionPane.showInternalMessageDialog(null, "Account Deactivated");
					f1.dispose();
				}

				catch (Exception ex) {
					JOptionPane.showInternalMessageDialog(null, "Record not matched");
					System.out.println(ex);
				}
			}
			}
			
		}
		
			
			
			
			
			
			
	
	public static void main(String[] args) {
		new Del_emp();
	}
	
}
