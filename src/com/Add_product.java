package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;

public class Add_product implements ActionListener {
	JFrame f1;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JTextField tf1, tf2, tf3, tf5, tf6, tf8, tf9;
	JComboBox<?> cb1, cb2;
	JButton btn1, btn2;
	String s;
	public String cc;

	Add_product() {

		f1 = new JFrame("OrderUp-Add new Product");

		l1 = new JLabel("Product ID:-");
		l1.setBounds(100, 25, 300, 50);
		l1.setFont(new Font("Calibri", Font.BOLD, 20));
		l1.setLayout(null);
		l1.setVisible(true);

		l2 = new JLabel("Product name:-");
		l2.setBounds(575, 25, 300, 50);
		l2.setFont(new Font("Calibri", Font.BOLD, 20));
		l2.setLayout(null);
		l2.setVisible(true);

		tf1 = new JTextField();
		tf1.setBounds(100, 60, 300, 40);
		tf1.setFont(new Font("Arial", Font.PLAIN, 15));

		tf2 = new JTextField();
		tf2.setBounds(575, 60, 300, 40);
		tf2.setFont(new Font("Arial", Font.PLAIN, 15));

		l3 = new JLabel("Product image:-");
		l3.setBounds(100, 120, 300, 50);
		l3.setFont(new Font("Calibri", Font.BOLD, 20));
		l3.setLayout(null);
		l3.setVisible(true);

		l4 = new JLabel("Product variety:-");
		l4.setBounds(575, 120, 300, 50);
		l4.setFont(new Font("Calibri", Font.BOLD, 20));
		l4.setLayout(null);
		l4.setVisible(true);

		// here JFileChooser works
		tf3 = new JTextField();
		tf3.setBounds(100, 155, 225, 40);
		tf3.setFont(new Font("Arial", Font.PLAIN, 10));

		btn1 = new JButton("Browse");
		btn1.setBounds(326, 155, 65, 40);
		btn1.setFont(new Font("ARIAL NARROW", Font.BOLD, 15));
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 7, 5, 10);
		Border compound = new CompoundBorder(line, margin);
		btn1.setBorder(compound);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);

		String[] s2 = { "Fashion", "Electronics", "Dairy", "Pharmacy", "Kitchenware", "Bakery", "Meat", "Groceries" };
		cb1 = new JComboBox<Object>(s2);
		cb1.setBounds(575, 155, 300, 40);
		cb1.setFont(new Font("Calibri", Font.BOLD, 20));
		cb1.setBackground(Color.WHITE);
		cb1.setLayout(null);
		cb1.setVisible(true);

		l5 = new JLabel("Brand name:-");
		l5.setBounds(100, 215, 300, 50);
		l5.setFont(new Font("Calibri", Font.BOLD, 20));
		l5.setLayout(null);
		l5.setVisible(true);

		l6 = new JLabel("Price(Per Product):-");
		l6.setBounds(575, 215, 300, 50);
		l6.setFont(new Font("Calibri", Font.BOLD, 20));
		l6.setLayout(null);
		l6.setVisible(true);

		tf5 = new JTextField();
		tf5.setBounds(100, 250, 300, 40);
		tf5.setFont(new Font("Arial", Font.PLAIN, 15));

		tf6 = new JTextField();
		tf6.setBounds(575, 250, 300, 40);
		tf6.setFont(new Font("Arial", Font.PLAIN, 15));

		l7 = new JLabel("Product warranty:-");
		l7.setBounds(100, 310, 300, 50);
		l7.setFont(new Font("Calibri", Font.BOLD, 20));
		l7.setLayout(null);
		l7.setVisible(true);

		l8 = new JLabel("Quantity:-");
		l8.setBounds(575, 310, 300, 50);
		l8.setFont(new Font("Calibri", Font.BOLD, 20));
		l8.setLayout(null);
		l8.setVisible(true);

		String[] s3 = { "3 Months", "6 Months", "1 Year", "2 Years", "5 Years", };
		cb2 = new JComboBox<Object>(s3);
		cb2.setBounds(100, 345, 300, 40);
		cb2.setFont(new Font("Calibri", Font.BOLD, 20));
		cb2.setBackground(Color.WHITE);
		cb2.setLayout(null);
		cb2.setVisible(true);

		tf8 = new JTextField("");
		tf8.setBounds(575, 345, 300, 40);
		tf8.setFont(new Font("Arial", Font.PLAIN, 15));


		l9 = new JLabel("Product Specifications:-");
		l9.setBounds(100, 405, 300, 50);
		l9.setFont(new Font("Calibri", Font.BOLD, 20));
		l9.setLayout(null);
		l9.setVisible(true);

		tf9 = new JTextField();
		tf9.setBounds(100, 440, 775, 60);
		tf9.setFont(new Font("Arial", Font.PLAIN, 15));

		btn2 = new JButton("ADD");
		btn2.setBounds(425, 517, 150, 40);
		btn2.setFont(new Font("ARIAL NARROW", Font.BOLD, 30));
		btn2.setBackground(Color.RED);
		btn2.setForeground(Color.WHITE);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);

		f1.add(l1);
		f1.add(l2);
		f1.add(tf1);
		f1.add(tf2);
		f1.add(l3);
		f1.add(l4);
		f1.add(tf3);
		f1.add(btn1);
		f1.add(cb1);
		f1.add(l5);
		f1.add(l6);
		f1.add(tf5);
		f1.add(tf6);
		f1.add(l7);
		f1.add(l8);
		f1.add(cb2);
		f1.add(tf8);
		f1.add(l9);
		f1.add(tf9);
		f1.add(btn2);

		f1.setLayout(null);
		f1.setBounds(150, 175, 1000, 600);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == btn1) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			int returnValue = jfc.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				String path = selectedFile.getAbsolutePath();
				s = path;
				tf3.setText(s);
			}

			else if (returnValue == JFileChooser.CANCEL_OPTION) {
				JOptionPane.showInternalMessageDialog(null, "No Image selected...!!");
			}
		}

		else if (ae.getSource() == btn2) {

			try {
				// Registering the Driver
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());

				// Getting the connection
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");


				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO products (Product_ID, Name, Image, Variety, Brand, Price , Warranty, Available_Quantity, Specification) "
								+ "VALUES(?,?,?,?,?,?,?,?,?)");

				// Inserting Blob type
				InputStream in = new FileInputStream(new File(s));

				pstmt.setString(1, tf1.getText());
				pstmt.setString(2, tf2.getText());
				pstmt.setBlob(3, in);
				pstmt.setString(4, (String) cb1.getSelectedItem());
				pstmt.setString(5, tf5.getText());
				pstmt.setString(6, tf6.getText());
				pstmt.setString(7, (String) cb2.getSelectedItem());
				pstmt.setString(8, tf8.getText());
				pstmt.setString(9, tf9.getText());

				// Executing the statement
				pstmt.executeUpdate();

				JOptionPane.showInternalMessageDialog(null, "Add Product successfull!");
				f1.dispose();


			}

			catch (Exception ex) {
				JOptionPane.showInternalMessageDialog(null, "           ALERT!" + "\n" + "Fill correct information");
				System.out.println();
			}

		}
	}


	public static void main(String[] args) {
		new Add_product();
	}
}
