package com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Employee implements ActionListener {
	JFrame f1;
	JPanel p1;
	JLabel l1,l2,l3,l4,l5;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;

	
	
	
	Employee()
	{
		f1= new JFrame("OrderUp-Employee");
		
		
		
		p1= new JPanel();
		p1.setBounds(0, 0, 1550, 50);
		p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setVisible(true);
		
		
		ImageIcon image = new ImageIcon("F:\\test_logo.png");
		l1= new JLabel (image);
		l1.setBounds(0,0,130,50);
		l1.setLayout(null);
		l1.setVisible(true);
		
		
		l2= new JLabel ("EMPLOYEE-PORTAL");
		l2.setBounds(630,0,500,50);
		l2.setFont(new Font("Agency FB", Font.BOLD, 40));
		l2.setForeground(Color.WHITE);
		l2.setLayout(null);
		l2.setVisible(true);
		
		
		btn1= new JButton("Add Product");
		btn1.setBounds(5, 55, 175, 50);
		btn1.setBackground(Color.ORANGE);
		btn1.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);
		
		
		
		btn3= new JButton("Edit Product");
		btn3.setBounds(185, 55, 190, 50);
		btn3.setBackground(Color.ORANGE);
		btn3.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);
		
		
		btn4= new JButton("Customers");
		btn4.setBounds(575, 55, 190, 50);
		btn4.setBackground(Color.ORANGE);
		btn4.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn4.setLayout(null);
		btn4.setVisible(true);
		btn4.addActionListener(this);
		
		
		btn5= new JButton("Orders");
		btn5.setBounds(770, 55, 190, 50);
		btn5.setBackground(Color.ORANGE);
		btn5.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn5.setLayout(null);
		btn5.setVisible(true);
		btn5.addActionListener(this);
		
		
		btn6= new JButton("Products");
		btn6.setBounds(380, 55, 190, 50);
		btn6.setBackground(Color.ORANGE);
		btn6.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn6.setLayout(null);
		btn6.setVisible(true);
		btn6.addActionListener(this);
		
		
		btn7= new JButton("Log out");
		btn7.setBounds(1390, 55, 125, 50);
		btn7.setBackground(Color.RED);
		btn7.setForeground(Color.WHITE);
		btn7.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn7.setLayout(null);
		btn7.setVisible(true);
		btn7.addActionListener(this);
		
		
		
		ImageIcon img1 = new ImageIcon("F:\\ad_emp1.png");
		l3= new JLabel (img1);
		l3.setBounds(1250,200,300,600);
		l3.setLayout(null);
		l3.setVisible(true);
		
		
		ImageIcon img2 = new ImageIcon("F:\\ad_emp2.png");
		l4= new JLabel (img2);
		l4.setBounds(300,200,700,500);
		l4.setLayout(null);
		l4.setVisible(true);
		
		

		ImageIcon img3 = new ImageIcon("F:\\test_small.png");
		l5= new JLabel (img3);
		l5.setBounds(125,100,450,200);
		l5.setLayout(null);
		l5.setVisible(true);
		
		
		
		f1.add(p1);
		p1.add(l1);
		p1.add(l2);
		f1.add(btn1);
		f1.add(btn3);
		f1.add(btn4);
		f1.add(btn5);
		f1.add(btn6);
		f1.add(btn7);
		f1.add(l3);
		l4.add(l5);
		f1.add(l4);
		
		
		
		
		f1.setLayout(null);
		f1.getContentPane().setBackground(Color.WHITE);
		Dimension screensize= Toolkit.getDefaultToolkit().getScreenSize();
		f1.setSize(screensize.width, screensize.height);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}
	
	
	public void  actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btn7) 
		{
			new Dash();
			f1.dispose();
		}
		
		else if(ae.getSource()==btn1)
		{
			new Add_product();
		}
		
		else if (ae.getSource() == btn3) {
			new Edit_pro();
		}
		
		else if(ae.getSource()==btn4)
		{
			new Cust_list();
		}
		
		else if(ae.getSource()==btn5)
		{
			new Order_list();
		}
		
		else if(ae.getSource()==btn6)
		{
			new Product_list();
		}
		
	}
	
	
public static void main(String[] args) {
	new Employee();
}
}
