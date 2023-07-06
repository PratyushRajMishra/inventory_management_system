package com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class Admin implements ActionListener{
	JFrame f2;
	JPanel p1, p2, p3;
	JLabel l1, l2, l3, l4, l5, l6;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	JTextField tf1;

	
	
	Admin()
	{
		f2= new JFrame("OrderUp-Administration");
		
		
		
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
		
		
		btn1= new JButton("Log out");
		btn1.setBounds(1440, 25, 95, 25);
		btn1.setFont(new Font("Arial", Font.BOLD, 15));
		btn1.setBackground(Color.blue);
		btn1.setForeground(Color.WHITE);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);
		
		
		
		p2= new JPanel();
		p2.setBounds(50, 100, 1000, 650);
		p2.setBackground(Color.WHITE);
		p2.setLayout(null);
		p2.setVisible(true);
		
		
		ImageIcon image1 = new ImageIcon("F:\\test_small.png");
		l3= new JLabel (image1);
		l3.setBounds(300,50,425,150);
		l3.setLayout(null);
		l3.setVisible(true);
		
		
		btn2= new JButton("Employee");
		btn2.setBounds(125, 275, 250, 75);
		btn2.setFont(new Font("Agency FB", Font.BOLD, 35));
		btn2.setBackground(Color.darkGray);
		btn2.setForeground(Color.WHITE);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);
		
		
		
		btn3= new JButton("Product");
		btn3.setBounds(600, 275, 250, 75);
		btn3.setFont(new Font("Agency FB", Font.BOLD, 35));
		btn3.setBackground(Color.darkGray);
		btn3.setForeground(Color.WHITE);
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);
		
		
		
		btn4= new JButton("Customer");
		btn4.setBounds(125, 400, 250, 75);
		btn4.setFont(new Font("Agency FB", Font.BOLD, 35));
		btn4.setBackground(Color.darkGray);
		btn4.setForeground(Color.WHITE);
		btn4.setLayout(null);
		btn4.setVisible(true);
		btn4.addActionListener(this);
		
		
		
		btn5= new JButton("Order");
		btn5.setBounds(600, 400, 250, 75);
		btn5.setFont(new Font("Agency FB", Font.BOLD, 35));
		btn5.setBackground(Color.darkGray);
		btn5.setForeground(Color.WHITE);
		btn5.setLayout(null);
		btn5.setVisible(true);
		btn5.addActionListener(this);
		
		
		
		btn6 = new JButton("Deactivated Account");
		btn6.setBounds(350, 550, 275, 65);
		btn6.setFont(new Font("Agency FB", Font.BOLD, 35));
		btn6.setBackground(Color.red);
		btn6.setForeground(Color.WHITE);
		btn6.setLayout(null);
		btn6.setVisible(true);
		btn6.addActionListener(this);
		
		
		
		p3= new JPanel();
		p3.setBounds(1125, 200, 350, 450);
		p3.setBackground(Color.white);
		p3.setLayout(null);
		p3.setVisible(true);
		
		
		l4= new JLabel ("WELCOME");
		l4.setBounds(60,185,300,50);
		l4.setFont(new Font("Arial Black", Font.BOLD, 40));
		l4.setLayout(null);
		l4.setVisible(true);
		
		
		ImageIcon image2 = new ImageIcon("F:\\Admin_logo.png");
		l5= new JLabel (image2);
		l5.setBounds(115,25,125,150);
		l5.setLayout(null);
		l5.setVisible(true);
		
		
		l6= new JLabel("(ADMIN)");
		l6.setBounds(100, 225, 300, 50);
		l6.setFont(new Font("Arial Black", Font.BOLD, 30));
		l6.setLayout(null);
		l6.setVisible(true);
		

		//data receive from Dash class
		tf1 = new JTextField();
		tf1.setBounds(25, 275, 300, 50);
		tf1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		tf1.setBackground(new Color(204, 255, 204));
		tf1.setForeground(Color.RED);
		tf1.setLayout(null);
		tf1.setVisible(true);
		
		
		btn7 = new JButton("Update Profile");
		btn7.setBounds(50, 345, 250, 40);
		btn7.setFont(new Font("Serif", Font.BOLD, 30));
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 7, 5, 10);
		Border compound = new CompoundBorder(line, margin);
		btn7.setBorder(compound);
		btn7.setBackground(new Color(0, 204, 204));
		btn7.setForeground(Color.WHITE);
		btn7.setLayout(null);
		btn7.setVisible(true);
		btn7.addActionListener(this);
		
		
		btn8 = new JButton("Delete Account");
		btn8.setBounds(50, 400, 250, 40);
		btn8.setFont(new Font("Serif", Font.BOLD, 30));
		new LineBorder(Color.BLACK);
		new EmptyBorder(5, 7, 5, 10);
		new CompoundBorder(line, margin);
		btn8.setBorder(compound);
		btn8.setBackground(Color.RED);
		btn8.setForeground(Color.WHITE);
		btn8.setLayout(null);
		btn8.setVisible(true);
		btn8.addActionListener(this);
		
		
		
		p1.add(l1);
		p1.add(l2);
		p1.add(btn1);
		f2.add(p1);
		f2.add(p2);
		p2.add(l3);
		p2.add(btn2);
		p2.add(btn3);
		p2.add(btn4);
		p2.add(btn5);
		p2.add(btn6);
		f2.add(p3);
		p3.add(l4);
		p3.add(l5);
		p3.add(l6);
		p3.add(tf1);
		p3.add(btn7);
		p3.add(btn8);
		
		
		
		f2.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    f2.setSize(screenSize.width, screenSize.height);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setVisible(true);
	}
	

	
	
	public void  actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btn1) 
		{
			new Dash();
			f2.dispose();
		}
		
		else if(ae.getSource()==btn2) 
		{
			new Ad_employee();
			f2.dispose(); 
		}
		
		else if(ae.getSource()==btn3) 
		{
			new Ad_product();
			f2.dispose(); 
		}
		
		else if(ae.getSource()==btn4) 
		{
			try {
				new Ad_customer();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f2.dispose(); 
		}
		
		else if(ae.getSource()==btn5) 
		{
			try {
				new Ad_order();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f2.dispose(); 
		}
		
		else if(ae.getSource()==btn6) 
		{
			new Ad_deactivate();
			f2.dispose(); 
		}
		
		else if(ae.getSource()==btn7)
		{

			String cell = Dash.tf1.getText();
			String str = "SELECT * FROM admin WHERE email='" + cell + "'";
			Ad_profile pro = new Ad_profile();
			try {

				Connect con = new Connect();
				ResultSet rs = ((Statement) con.stmt).executeQuery(str);
				if (rs.next()) {

					String c1 = rs.getString(1);
					String c2 = rs.getString(2);
					String c3 = rs.getString(3);
					String c4 = rs.getString(4);
					String c5 = rs.getString(5);
					String c6 = rs.getString(6);
					String c7 = rs.getString(7);
					String c8 = rs.getString(8);
					String c9 = rs.getString(9);

					pro.tf1.setText(c1);
					pro.tf2.setText(c2);
					pro.tf3.setText(c3);
					pro.pf1.setText(c4);
					pro.tf4.setText(c5);
					((JTextField) pro.date1.getDateEditor().getUiComponent()).setText(c6);
					pro.cb1.setSelectedItem(c7);
					pro.tf5.setText(c8);
					pro.tf6.setText(c9);

				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		
		
		else if (ae.getSource() == btn8) {

			String cell = Dash.tf1.getText();

			String str1 = "DELETE FROM admin WHERE email='" + cell + "'";
			String str2 = "DELETE FROM login WHERE email= '" + cell + "' ";

			int a = JOptionPane.showConfirmDialog(f2, "Are you sure want to delete?");
			if (a == JOptionPane.YES_OPTION) {


			try {
				Connect con = new Connect();
				con.stmt.executeUpdate(str1);
				con.stmt.executeUpdate(str2);
				JOptionPane.showInternalMessageDialog(null, "Account Deleted successfully!");

				f2.dispose();
				new Dash();
			}

			catch (Exception ex) {
				System.out.println(ex);
			}

		}

		}
	}
		



public static void main(String[] args) {
	new Admin();
}

}


