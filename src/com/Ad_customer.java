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
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Ad_customer implements ActionListener {
	JFrame f1;
	JPanel p1, p2, p3, p4;
	JLabel l1, l2, l3, l4, l5;
	JButton btn1, btn2, btn3;
	JTable tb1;

	Ad_customer() throws SQLException {
		f1 = new JFrame("OrderUp-Customer details");

		p1 = new JPanel();
		p1.setBounds(0, 0, 1550, 50);
		p1.setBackground(Color.BLUE);
		p1.setLayout(null);
		p1.setVisible(true);

		ImageIcon image = new ImageIcon("F:\\test_logo.png");
		l1 = new JLabel(image);
		l1.setBounds(0, 0, 130, 50);
		l1.setLayout(null);
		l1.setVisible(true);

		l2 = new JLabel("ADMIN-PORTAL");
		l2.setBounds(675, 0, 500, 50);
		l2.setFont(new Font("Agency FB", Font.BOLD, 40));
		l2.setForeground(Color.WHITE);
		l2.setLayout(null);
		l2.setVisible(true);

		btn1 = new JButton("Back");
		btn1.setBounds(1440, 25, 95, 30);
		btn1.setFont(new Font("Arial", Font.BOLD, 25));
		btn1.setBackground(Color.blue);
		btn1.setForeground(Color.WHITE);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);

		p2 = new JPanel();
		p2.setBounds(25, 50, 350, 70);
		p2.setBackground(Color.CYAN);
		p2.setLayout(null);
		p2.setVisible(true);

		l3 = new JLabel("CUSTOMERS");
		l3.setBounds(45, 10, 300, 70);
		l3.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 50));
		l3.setForeground(Color.BLACK);
		l3.setLayout(null);
		l3.setVisible(true);

		btn2 = new JButton("Add Customer");
		btn2.setBounds(590, 70, 205, 40);
		btn2.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn2.setBackground(Color.GREEN);
		btn2.setForeground(Color.BLACK);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);

		btn3 = new JButton("Delete Customer");
		btn3.setBounds(800, 70, 205, 40);
		btn3.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn3.setBackground(Color.RED);
		btn3.setForeground(Color.WHITE);
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);


		p3 = new JPanel();
		p3.setBounds(1225, 50, 275, 70);
		p3.setBackground(Color.ORANGE);
		p3.setLayout(null);
		p3.setVisible(true);

		l4 = new JLabel("Total customers");
		l4.setBounds(5, 5, 300, 30);
		l4.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 30));
		l4.setForeground(Color.WHITE);
		l4.setLayout(null);
		l4.setVisible(true);

		// here count the customers
		Connect con = new Connect();
		String query = "select count(*) from customer";
		ResultSet rs = con.stmt.executeQuery(query);
		rs.next();
		int count = rs.getInt(1);

		l5 = new JLabel("" + count);
		l5.setBounds(235, 45, 300, 30);
		l5.setFont(new Font("Calibri", Font.ITALIC | Font.BOLD, 30));
		l5.setForeground(Color.WHITE);
		l5.setLayout(null);
		l5.setVisible(true);

		p4 = new JPanel();
		p4.setBounds(25, 130, 1475, 650);
		p4.setBackground(Color.BLACK);
		p4.setLayout(null);
		p4.setVisible(true);


		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 1475, 650);
		jsp.setVisible(true);
		p4.add(jsp);

		// create table here
		tb1 = new JTable();
		tb1.setBounds(0, 0, 1475, 650);
		tb1.setBackground(Color.WHITE);
		tb1.setFont(new Font("Cablibri", Font.PLAIN, 15));
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = { "Name", "Brand", "Price", "Warranty", "Specification", "Image" };
		model.setColumnIdentifiers(column);
		tb1.setModel(model);
		tb1.setRowHeight(75);
		jsp.setViewportView(tb1);

		try {

			// Registering the Driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// Getting the connection
			String mysqlUrl = "jdbc:mysql://localhost:3306/test";
			java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

			java.sql.PreparedStatement pstmt = con1
					.prepareStatement(
							"SELECT Customer_ID, Fname, Lname, email, Gender, birth, mob, Pin, Address FROM customer ");

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
		f1.add(btn2);
		f1.add(btn3);
		f1.add(p3);
		p3.add(l4);
		p3.add(l5);
		f1.add(p4);
		p4.add(jsp);

		Color c1 = new Color(236, 236, 236);
		f1.getContentPane().setBackground(c1);
		f1.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		f1.setSize(screenSize.width, screenSize.height);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn1) {
			new Admin();
			f1.dispose();
		}

		else if (ae.getSource() == btn2) {
			new Add_cust();
		}


		else if (ae.getSource() == btn3) {
			DefaultTableModel tb1model = (DefaultTableModel) tb1.getModel();

			if (tb1.getSelectedRowCount() == 1) {
				int row = tb1.getSelectedRow();
				int a = JOptionPane.showConfirmDialog(f1, "Are you sure?");
				if (a == JOptionPane.YES_OPTION) {
					String cell = tb1.getModel().getValueAt(row, 0).toString();
					String query1 = "DELETE FROM customer WHERE Customer_ID = " + cell;

					String cell1 = tb1.getModel().getValueAt(row, 6).toString();
					String query2 = "DELETE FROM login WHERE Mob=" + cell1;
				try {
					Connect con = new Connect();
					con.stmt.executeUpdate(query1);
					con.stmt.executeUpdate(query2);
					tb1model.removeRow(tb1.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Item deleted successfully!..");
					f1.dispose();
					new Ad_customer();
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
		new Ad_customer();
	}

}
