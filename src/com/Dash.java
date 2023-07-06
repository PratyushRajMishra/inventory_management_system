package com;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Dash implements ActionListener {
	JFrame f;
	JLabel l1, l2, l21, l3, l4;
	JComboBox<?> cb1;
	static JTextField tf1;
	JPasswordField pf1;
	JButton btn1, btn2;
	
	
	Dash()
	{
		f = new JFrame("OrderUp-Inventory Management System");
		
		
		ImageIcon image = new ImageIcon("F:\\test.png");
		l1= new JLabel (image);
		l1.setBounds(50,220,700,300);
		l1.setLayout(null);
		l1.setVisible(true);
		
		l2= new JLabel("LOGIN-HERE");
		l2.setFont(new Font("Lucida Fax", Font.BOLD, 40));
		l2.setBounds(987, 100, 300, 50);
		l2.setLayout(null);
		l2.setVisible(true);
		
		l21= new JLabel("Select account type:-");
		l21.setFont(new Font("Calibri", Font.BOLD, 20));
		l21.setBounds(970, 175, 250, 50);
		l21.setLayout(null);
		l21.setVisible(true);
		
		
		String[] s1= {"Admin", "Employee", "Customer"};
		cb1 = new JComboBox<Object>(s1);
		cb1.setBounds(970, 210, 300, 35);
		cb1.setLayout(null);
		cb1.setVisible(true);
		
		l3= new JLabel("Enter E-mail:-");
		l3.setFont(new Font("Calibri", Font.BOLD, 20));
		l3.setBounds(970, 250, 300, 50);
		l3.setLayout(null);
		l3.setVisible(true);
		
		tf1= new JTextField();
		tf1.setBounds(970, 280, 300, 35);
		
		l4= new JLabel("Enter Password:-");
		l4.setFont(new Font("Calibri", Font.BOLD, 20));
		l4.setBounds(970, 320, 300, 50);
		l4.setLayout(null);
		l4.setVisible(true);
		
		pf1= new JPasswordField();
		pf1.setBounds(970, 350, 300, 35);
		
		btn1= new JButton("LOGIN");
		btn1.setBounds(1045, 420, 150, 40);
		btn1.setFont(new Font("Serif", Font.BOLD, 30));
		btn1.setBackground(Color.ORANGE);
		btn1.addActionListener(this);
		
		btn2= new JButton("Create an account");
		btn2.setBounds(970, 520, 300, 50);
		btn2.setFont(new Font("Sans-Serif", Font.BOLD, 30));
		btn2.setBackground(Color.BLUE);
		btn2.setForeground(Color.WHITE);
		btn2.addActionListener(this);
		
		
		
		
		f.add(l1);
		f.add(l2);
		f.add(l21);
		f.add(cb1);
		f.add(l3);
		f.add(tf1);
		f.add(l4);
		f.add(pf1);
		f.add(btn1);
		f.add(btn2);

	
		f.setLayout(null);
		f.setBounds(70,40,1400,750);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
	
	}

	
	public void  actionPerformed(ActionEvent ae) {
		
	if(ae.getSource()==btn1) {
		String email=tf1.getText();
		String pass=String.valueOf(pf1.getPassword());
		String option= cb1.getSelectedItem().toString();
		Connect con=new Connect();
		String str = "select * from login where email='" + email + "' and pass='" + pass + "'";
	
		
		try {
			ResultSet rs= ((Statement) con.stmt).executeQuery(str);
			if(rs.next()) 
			{
				String s1= rs.getString("Account");
				if(option.equalsIgnoreCase("Admin")&& s1.equalsIgnoreCase("Admin"))
				{
					//send data in Admin class
					Admin Adobj= new Admin();
					Adobj.tf1.setText("'" + email + "'");
					f.dispose();
				}
				
				if(option.equalsIgnoreCase("Employee")&& s1.equalsIgnoreCase("Employee"))
				{
					new Employee();
					f.dispose();
				}
				
				if(option.equalsIgnoreCase("Customer")&& s1.equalsIgnoreCase("Customer"))
				{

					// send data to Customer class
					Customer Cusobj = new Customer();
					Cusobj.l3.setText("'" + email + "'");
					f.dispose();
				}
				
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Incorrect Email or Password");
			}
		}
		
		catch(Exception ex) {}}
			else if(ae.getSource()==btn2)
			{
				new Create();
			}
		}
	

public static void main(String[] args) { 
	 new Dash();
}
}

