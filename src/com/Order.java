package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Order implements ActionListener {
	JFrame f1;
	JPanel p1, p2;
	JLabel l1, l2;
	JButton btn1, btn2, btn3, btn4;
	JTable tb1;
	JTextField tf1;

	Order() {
		f1 = new JFrame("Order-Order Management System");

		p1 = new JPanel();
		p1.setBounds(0, 0, 1200, 50);
		p1.setBackground(new Color(0, 153, 153));
		p1.setLayout(null);
		p1.setVisible(true);

		ImageIcon image = new ImageIcon("F:\\test_logo.png");
		l1 = new JLabel(image);
		l1.setBounds(0, 0, 130, 50);
		l1.setLayout(null);
		l1.setVisible(true);

		l2 = new JLabel("MY-ORDER");
		l2.setBounds(550, 0, 500, 50);
		l2.setFont(new Font("Agency FB", Font.BOLD, 40));
		l2.setForeground(Color.WHITE);
		l2.setLayout(null);
		l2.setVisible(true);

		p2 = new JPanel();
		p2.setBounds(0, 50, 1200, 625);
		p2.setBackground(new Color(255, 178, 102));
		p2.setLayout(null);
		p2.setVisible(true);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(15, 80, 1160, 425);
		p2.add(jsp);

		// create table here
		tb1 = new JTable();
		tb1.setBounds(20, 20, 500, 100);
		tb1.setBackground(Color.WHITE);
		tb1.setFont(new Font("Cablibri", Font.PLAIN, 15));
		DefaultTableModel model = new DefaultTableModel();
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
					.prepareStatement("SELECT Product_ID, Name, Brand, Price, Quantity FROM cart ");

			ResultSet rs1 = pstmt.executeQuery();

			tb1.setModel(DbUtils.resultSetToTableModel(rs1));

		}

		catch (Exception ex) {
			System.out.println(ex);
		}

		tf1 = new JTextField();
		tf1.setToolTipText("Enter Order ID to Search");
		tf1.getToolTipText();
		tf1.setBounds(75, 15, 475, 40);
		tf1.setFont(new Font("Arial", Font.PLAIN, 15));

		btn2 = new JButton("CONFIRM ORDER");
		btn2.setBounds(900, 530, 250, 50);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.CYAN);
		btn2.setFont(new Font("Arial", Font.BOLD, 25));
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);

		ImageIcon image1 = new ImageIcon("F:\\search.png");
		btn1 = new JButton(image1);
		btn1.setBounds(550, 15, 40, 40);
		btn1.setFont(new Font("Arial", Font.BOLD, 20));
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);

		btn3 = new JButton("My Order");
		btn3.setBounds(775, 15, 150, 40);
		btn3.setFont(new Font("Arial", Font.BOLD, 20));
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);

		btn4 = new JButton("Back to Cart");
		btn4.setBounds(950, 15, 175, 40);
		btn4.setFont(new Font("Arial", Font.BOLD, 20));
		btn4.setLayout(null);
		btn4.setVisible(true);
		btn4.addActionListener(this);


		f1.add(p1);
		p1.add(l1);
		p1.add(l2);
		f1.add(p2);
		p2.add(jsp);
		p2.add(tf1);
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn3);
		p2.add(btn4);

		f1.setLayout(null);
		f1.setBounds(75, 85, 1200, 700);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Name, Brand, Price, Quantity FROM orders WHERE Order_ID= " + tf1.getText() + " ");

				ResultSet rs1 = pstmt.executeQuery();
				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Enter Valid Order ID!!");
			}
		}

		else if (e.getSource() == btn2) {
			if (tb1.getRowCount() >= 1) {
				String query = "INSERT INTO orders( Product_ID, Name, Brand, Price, Quantity )SELECT Product_ID, Name, Brand, Price, Quantity FROM cart";
			String str = "TRUNCATE CART";

			try {
				Connect con = new Connect();
				con.stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Order Confirmed..!!");



				con.stmt.executeUpdate(str);


				f1.dispose();

			}

			catch (Exception ex) {
				System.out.println(ex);
			}

		}
		else {
			JOptionPane.showMessageDialog(f1, "Empty Table!");
		}
	}

		else if (e.getSource() == btn3) {
			try {

				// Registering the Driver
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());

				// Getting the connection
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

				java.sql.PreparedStatement pstmt = con1
						.prepareStatement("SELECT Order_ID, Name, Brand, Price, Quantity FROM orders ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				btn2.setVisible(false);
			}

			catch (Exception ex) {
				System.out.println(ex);
			}

		}

		else {
			new Cart();
			f1.dispose();
		}
	}

	public static void main(String[] args) {
		new Order();
	}
}
