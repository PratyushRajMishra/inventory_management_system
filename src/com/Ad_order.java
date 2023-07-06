package com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class Ad_order implements ActionListener {
	JFrame f1;
	JPanel p1,p2,p3,p4,p5,p6,p7;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	JButton btn1, btn2, btn3;
	JTextField tf1;
	JTable tb1;
	
	
	
	
	
	
	Ad_order() throws SQLException
	{
f1= new JFrame("OrderUp-Order details");
		
		
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
		l2.setBounds(675,0,500,50);
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
		p2.setBounds(0, 50, 400, 70);
		p2.setBackground(Color.BLACK);
		p2.setLayout(null);
		p2.setVisible(true);
		
		
		l3= new JLabel ("ORDERS");
		l3.setBounds(100,10,350,70);
		l3.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 55));
		l3.setForeground(Color.WHITE);
		l3.setLayout(null);
		l3.setVisible(true);
		
		
		tf1 = new JTextField("Enter Order ID");
		tf1.setBounds(575, 65, 600, 40);
		tf1.setFont(new Font("Calibri",Font.PLAIN, 20));
		tf1.setLayout(null);
		tf1.setVisible(true);
		
		
		btn2= new JButton("Search");
		btn2.setBounds(1185, 65, 110, 40);
		btn2.setFont(new Font("Arial", Font.BOLD, 20));
		btn2.setBackground(Color.GREEN);
		btn2.setForeground(Color.BLACK);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);
		
		
		btn3 = new JButton("Cancel order");
		btn3.setBounds(70, 500, 250, 50);
		btn3.setFont(new Font("Arial", Font.BOLD, 30));
		btn3.setBackground(Color.RED);
		btn3.setForeground(Color.WHITE);
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);
		
		
		p4= new JPanel();
		p4.setBounds(100, 650, 275, 100);
		p4.setBackground(new Color(64, 64, 64));
		p4.setLayout(null);
		p4.setVisible(true);
		
	
		l4= new JLabel ("Total orders");
		l4.setBounds(5,5,300,30);
		l4.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 30));
		l4.setForeground(Color.WHITE);
		l4.setLayout(null);
		l4.setVisible(true);
		
		// here count the employees
		Connect con3 = new Connect();
		String query3 = "select count(*) from orders";
		ResultSet rs3;
		rs3 = con3.stmt.executeQuery(query3);
		rs3.next();
		int count3 = rs3.getInt(1);
		
		l5 = new JLabel("" + count3);
		l5.setBounds(235,75,300,30);
		l5.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 30));
		l5.setForeground(Color.WHITE);
		l5.setLayout(null);
		l5.setVisible(true);
		
		
		
		p5= new JPanel();
		p5.setBounds(625, 650, 275, 100);
		p5.setBackground(new Color(64, 64, 64));
		p5.setLayout(null);
		p5.setVisible(true);
		
	
		l6= new JLabel ("Total customers");
		l6.setBounds(5,5,300,30);
		l6.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 30));
		l6.setForeground(Color.WHITE);
		l6.setLayout(null);
		l6.setVisible(true);
		
		// here count the customers
		Connect conc = new Connect();
				String query1 = "select count(*) from customer";
		ResultSet rsc;
		rsc = conc.stmt.executeQuery(query1);
		rsc.next();
		int count1 = rsc.getInt(1);
		
		
				l7 = new JLabel("" + count1);
		l7.setBounds(235,75,300,30);
		l7.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 30));
		l7.setForeground(Color.WHITE);
		l7.setLayout(null);
		l7.setVisible(true);
		
		
		
		p6= new JPanel();
		p6.setBounds(1150, 650, 275, 100);
		p6.setBackground(new Color(64, 64, 64));
		p6.setLayout(null);
		p6.setVisible(true);
		
	
		l8 = new JLabel("Total employees");
		l8.setBounds(5, 5, 300, 30);
		l8.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 30));
		l8.setForeground(Color.WHITE);
		l8.setLayout(null);
		l8.setVisible(true);

		// here count the employees
		Connect con2 = new Connect();
		String query2 = "select count(*) from employee";
		ResultSet rs2;
		rs2 = con2.stmt.executeQuery(query2);
		rs2.next();
		int count2 = rs2.getInt(1);
		
		l9 = new JLabel("" + count2);
		l9.setBounds(235, 75, 300, 30);
		l9.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 30));
		l9.setForeground(Color.WHITE);
		l9.setLayout(null);
		l9.setVisible(true);
		
		
		
		
		p7= new JPanel();
		p7.setBounds(15, 125, 375, 300);
		p7.setBackground(Color.WHITE);
		p7.setLayout(null);
		p7.setVisible(true);
		
		
		ImageIcon image1 = new ImageIcon("F:\\order_img.png");
		l10 = new JLabel(image1);
		l10.setBounds(20, 0, 350, 350);
		l10.setLayout(null);
		l10.setVisible(true);
		
		
		p3 = new JPanel();
		p3.setBounds(400, 150, 1075, 450);
		p3.setBackground(Color.WHITE);
		p3.setLayout(null);
		p3.setVisible(true);
		
		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 1075, 450);
		jsp.setVisible(true);
		p3.add(jsp);

		// create table here
		tb1 = new JTable();
		tb1.setBounds(0, 0, 1075, 450);
		tb1.setBackground(Color.WHITE);
		tb1.setFont(new Font("Cablibri", Font.PLAIN, 15));
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = { "Product_ID", "Order_ID", "Name", "Brand", "Price", "Quantity" };
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
					.prepareStatement(
							"SELECT Order_ID, Product_ID, Name, Brand, Price, Quantity FROM orders");

			ResultSet rs1 = pstmt.executeQuery();

			tb1.setModel(DbUtils.resultSetToTableModel(rs1));
		}

		catch (Exception ex) {
			System.out.println(ex);
		}
		
		
		p1.add(l1);
		p1.add(l2);
		p1.add(btn1);
		f1.add(p1);
		f1.add(p2);
		p2.add(l3);
		f1.add(tf1);
		f1.add(btn2);
		f1.add(p3);
		f1.add(btn3);
		f1.add(p4);
		p4.add(l4);
		p4.add(l5);
		f1.add(p5);
		p5.add(l6);
		p5.add(l7);
		f1.add(p6);
		p6.add(l8);
		p6.add(l9);
		f1.add(p7);
		p7.add(l10);
		p3.add(jsp);
		
		
		

		f1.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		f1.getContentPane().setBackground(Color.WHITE);
	    f1.setSize(screenSize.width, screenSize.height);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setVisible(true);
		
		
		
	}
	


	public void  actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btn1) 
		{
			new Admin();
			f1.dispose();
		}

		else if (ae.getSource() == btn2) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Order_ID, Product_ID, Name, Brand, Price, Quantity FROM orders WHERE Order_ID= "
								+ tf1.getText());

				ResultSet rs1 = pstmt.executeQuery();
				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Enter Valid Order ID!!");
			}
		}

		else if (ae.getSource() == btn3) {
			DefaultTableModel tb1model = (DefaultTableModel) tb1.getModel();

			if (tb1.getSelectedRowCount() == 1) {
				int row = tb1.getSelectedRow();
				int a = JOptionPane.showConfirmDialog(f1, "Are you sure?");
				if (a == JOptionPane.YES_OPTION) {
					String cell = tb1.getModel().getValueAt(row, 0).toString();
					String cell1 = tb1.getModel().getValueAt(row, 1).toString();



					// String query = "DELETE FROM orders WHERE Order_ID = " + cell;
					// String str2 = "UPDATE products SET Available_Quantity= Available_Quantity +
					// WHERE Product_ID="
					// + cell1;

					try {
						// Registering the Driver
						DriverManager.registerDriver(new com.mysql.jdbc.Driver());

						// Getting the connection
						String mysqlUrl = "jdbc:mysql://localhost:3306/test";
						java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

						java.sql.PreparedStatement pstmt = con1
								.prepareStatement("SELECT Quantity FROM orders WHERE Product_ID=" + cell1);

						ResultSet rs = pstmt.executeQuery();
						int quantity = 0;
						if (rs.next()) {
							quantity = rs.getInt("Quantity");
						}

						java.sql.PreparedStatement pstmt1 = con1
								.prepareStatement("UPDATE products SET Available_Quantity= Available_Quantity + '"
										+ quantity + "' WHERE Product_ID=" + cell1);

						java.sql.PreparedStatement pstmt2 = con1
								.prepareStatement("DELETE FROM orders WHERE Order_ID = " + cell);

						pstmt1.executeUpdate();
						pstmt2.executeUpdate();
						tb1model.removeRow(tb1.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Item deleted successfully!..");
						f1.dispose();
						new Ad_order();
					}

					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			} else {
				if (tb1.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Table is empty..");
				}

				else {
					JOptionPane.showMessageDialog(null, "Please select single row for Deletion..");
				}
			}
		}
	}
	
		

	public static void main(String[] args) throws SQLException {
		new Ad_order();
	}
	 

}
