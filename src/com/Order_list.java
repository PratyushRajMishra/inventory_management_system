package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Order_list implements ActionListener {
	JFrame f1;
	JPanel p1,p2;
	JLabel l1;
	JTextField tf1;
	JButton btn1, btn2;
	JTable tb1;
	
	
	Order_list()
	{
		f1= new JFrame("OrderUp- Orders list");
		
		
		p1= new JPanel();
		p1.setBounds(25, 10, 275, 50);
		p1.setBackground(Color.DARK_GRAY);
		p1.setLayout(null);
		p1.setVisible(true);
		
		
		l1 = new JLabel("Order List");
		l1.setBounds(50, 0, 300, 50);
		l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		l1.setForeground(Color.WHITE);
		l1.setLayout(null);
		l1.setVisible(true);
		
		
		tf1= new JTextField();
		tf1.setBounds(310, 15, 300, 40);
		tf1.setFont(new Font("Calibri", Font.PLAIN, 20));
		tf1.setVisible(true);
		
		
		btn1= new JButton("SEARCH");
		btn1.setBounds(610, 15, 150, 40);
		btn1.setFont(new Font("ARIAL NARROW", Font.BOLD, 25));
		btn1.setBackground(Color.BLUE);
		btn1.setForeground(Color.WHITE);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);
		
		btn2 = new JButton("All Orders");
		btn2.setBounds(800, 17, 150, 35);
		btn2.setFont(new Font("Serif", Font.BOLD, 20));
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 7, 5, 10);
		Border compound = new CompoundBorder(line, margin);
		btn2.setBorder(compound);
		btn2.setBackground(Color.ORANGE);
		btn2.setForeground(Color.BLACK);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);
		
		p2= new JPanel();
		p2.setBounds(30, 100, 925, 400);
		p2.setBackground(Color.WHITE);
		p2.setLayout(null);
		p2.setVisible(true);
		
		
		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 925, 400);
		jsp.setVisible(true);
		p2.add(jsp);

		// create table here
		tb1 = new JTable();
		tb1.setBounds(0, 0, 1150, 500);
		tb1.setBackground(Color.WHITE);
		tb1.setFont(new Font("Cablibri", Font.PLAIN, 15));
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = { "Order_ID", "Name", "Brand", "Price", "Quantity" };
		model.setColumnIdentifiers(column);
		tb1.setModel(model);
		tb1.setRowHeight(50);
		jsp.setViewportView(tb1);

		try {

			// Registering the Driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// Getting the connection
			String mysqlUrl = "jdbc:mysql://localhost:3306/test";
			java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

			java.sql.PreparedStatement pstmt = con1
					.prepareStatement("SELECT Order_ID, Name, Brand, Price, Quantity FROM orders");

			ResultSet rs1 = pstmt.executeQuery();

			tb1.setModel(DbUtils.resultSetToTableModel(rs1));
		}

		catch (Exception ex) {
			System.out.println(ex);
		}

		
		
		f1.add(p1);
		p1.add(l1);
		f1.add(tf1);
		f1.add(btn1);
		f1.add(btn2);
		f1.add(p2);
		p2.add(jsp);
		
		
		

		f1.setLayout(null);
		f1.setBounds(150, 175, 1000, 600);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			try {

				// Registering the Driver
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());

				// Getting the connection
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

				PreparedStatement pstmt = con1
						.prepareStatement("SELECT Order_ID, Name, Brand, Price, Quantity FROM orders  WHERE Order_ID=  "
								+ tf1.getText() + " ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(f1, "Please Enter Valid Product ID..");
			}
		}

		else if (e.getSource() == btn2) {

			try {

				// Registering the Driver
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());

				// Getting the connection
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

				PreparedStatement pstmt = con1
						.prepareStatement("SELECT Order_ID, Name, Brand, Price, Quantity FROM orders");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));

			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

	}
	
	public static void main(String[] args) {
		new Order_list();
	}


}
