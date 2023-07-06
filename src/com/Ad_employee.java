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

public class Ad_employee implements ActionListener
{
	JFrame f3;
	JPanel p1,p2,p3,p4;
	JLabel l1,l2,l3,l4,l5,l6;
	JButton btn1, btn2, btn3, btn4, btn5, btn6;
	
	
	
	Ad_employee()
	{
		f3= new JFrame("OrderUp-Employee details");
		
		
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
		
		
		l2= new JLabel ("ADMIN-PORTAL");
		l2.setBounds(630,0,500,50);
		l2.setFont(new Font("Agency FB", Font.BOLD, 40));
		l2.setForeground(Color.WHITE);
		l2.setLayout(null);
		l2.setVisible(true);
		
		
		btn1= new JButton("Back");
		btn1.setBounds(1440, 25, 95, 30);
		btn1.setFont(new Font("Arial", Font.BOLD, 20));
		btn1.setBackground(Color.blue);
		btn1.setForeground(Color.WHITE);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);
		
		
		
		p2= new JPanel();
		p2.setBounds(0, 50, 350, 750);
		p2.setBackground(Color.LIGHT_GRAY);
		p2.setLayout(null);
		p2.setVisible(true);
		
		
		
		btn2= new JButton("Add Employee");
		btn2.setBounds(50, 125, 250, 60);
		btn2.setFont(new Font("Agency FB", Font.BOLD, 35));
		btn2.setBackground(Color.RED);
		btn2.setForeground(Color.WHITE);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);
		
		
		
		btn3= new JButton("Delete Employee");
		btn3.setBounds(50, 250, 250, 60);
		btn3.setFont(new Font("Agency FB", Font.BOLD, 35));
		btn3.setBackground(Color.RED);
		btn3.setForeground(Color.WHITE);
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);
		
		
		
		btn4= new JButton("Update Employee");
		btn4.setBounds(50, 375, 250, 60);
		btn4.setFont(new Font("Agency FB", Font.BOLD, 35));
		btn4.setBackground(Color.RED);
		btn4.setForeground(Color.WHITE);
		btn4.setLayout(null);
		btn4.setVisible(true);
		btn4.addActionListener(this);
		
		
		btn5= new JButton("Department");
		btn5.setBounds(50, 500, 250, 60);
		btn5.setFont(new Font("Agency FB", Font.BOLD, 35));
		btn5.setBackground(Color.red);
		btn5.setForeground(Color.WHITE);
		btn5.setLayout(null);
		btn5.setVisible(true);
		btn5.addActionListener(this);
		
		
		btn6= new JButton("Employee list");
		btn6.setBounds(50, 625, 250, 60);
		btn6.setFont(new Font("Agency FB", Font.BOLD, 35));
		btn6.setBackground(Color.red);
		btn6.setForeground(Color.WHITE);
		btn6.setLayout(null);
		btn6.setVisible(true);
		btn6.addActionListener(this);
		
		
		
		p3= new JPanel();
		p3.setBounds(0, 0, 350, 70);
		p3.setBackground(Color.BLACK);
		p3.setLayout(null);
		p3.setVisible(true);
		
		
		l3= new JLabel ("EMPLOYEES");
		l3.setBounds(45,10,300,70);
		l3.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 50));
		l3.setForeground(Color.WHITE);
		l3.setLayout(null);
		l3.setVisible(true);
		
		
		p4= new JPanel();
		p4.setBounds(350, 50, 1185, 750);
		p4.setBackground(Color.WHITE);
		p4.setLayout(null);
		p4.setVisible(true);
	
		
		ImageIcon img1 = new ImageIcon("F:\\ad_emp1.png");
		l4= new JLabel (img1);
		l4.setBounds(930,190,300,600);
		l4.setLayout(null);
		l4.setVisible(true);
		
		
		ImageIcon img2 = new ImageIcon("F:\\ad_emp2.png");
		l6= new JLabel (img2);
		l6.setBounds(150,125,700,500);
		l6.setLayout(null);
		l6.setVisible(true);
		
		

		ImageIcon img3 = new ImageIcon("F:\\test_small.png");
		l5= new JLabel (img3);
		l5.setBounds(280,225,450,200);
		l5.setLayout(null);
		l5.setVisible(true);
		
		
		
		
		
		p1.add(l1);
		p1.add(l2);
		p1.add(btn1);
		f3.add(p1);
		f3.add(p2);
		p2.add(p3);
		p2.add(btn2);
		p2.add(btn3);
		p2.add(btn4);
		p2.add(btn5);
		p2.add(btn6);
		p3.add(l3);
		f3.add(p4);
		p4.add(l4);
		p4.add(l5);
		p4.add(l6);
		
		
		
		f3.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    f3.setSize(screenSize.width, screenSize.height);
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f3.setVisible(true);
		
		
	}
	
	
	
	public void  actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btn1) 
		{
			new Admin();
			f3.dispose();
		}
		
		else if(ae.getSource()==btn2)
		{
			new Add_emp();
		}
		
		else if(ae.getSource()==btn3)
		{
			new Del_emp();
		}
		
		else if(ae.getSource()==btn4)
		{
			new Upd_emp();
		}
		
		else if(ae.getSource()==btn5)
		{
			new Depart_emp();
		}
		
		else if(ae.getSource()==btn6)
		{
			new Emp_list();
		}
	}
		
	
		
		
public static void main(String[] args) 
	{
		new Ad_employee();
	}
}
