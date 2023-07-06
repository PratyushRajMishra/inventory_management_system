package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

public class Cart implements ActionListener {
	JFrame f1;
	JPanel p1, p2;
	JLabel l1, l2, l3;
	JTable tb1;
	JButton btn1, btn2, btn3;
	JTextField tf1;



	Cart() {
		f1 = new JFrame("Cart-Order Management System");

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

		l2 = new JLabel("MY-CART");
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
		jsp.setBounds(15, 10, 1160, 500);
		p2.add(jsp);

		// create table here
		tb1 = new JTable();
		tb1.setBounds(20, 20, 500, 100);
		tb1.setBackground(Color.WHITE);
		tb1.setFont(new Font("Cablibri", Font.PLAIN, 15));
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = { "Product ID", "Name", "Brand", "Price", "Quantity" };
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
							"SELECT   cart.Product_ID, cart.Name, cart.Brand, cart.Price, cart.Quantity FROM cart ");

			ResultSet rs1 = pstmt.executeQuery();

			tb1.setModel(DbUtils.resultSetToTableModel(rs1));

		}

		catch (Exception ex) {
			System.out.println(ex);
		}


		l3 = new JLabel("Quantity:-");
		l3.setBounds(25, 525, 200, 50);
		l3.setFont(new Font("Arial", Font.BOLD, 30));
		l3.setForeground(Color.BLACK);
		l3.setLayout(null);
		l3.setVisible(true);

		tf1 = new JTextField();
		tf1.setBounds(170, 533, 200, 40);
		tf1.setFont(new Font("Arial", Font.PLAIN, 15));

		btn1 = new JButton("Set");
		btn1.setBounds(370, 533, 75, 40);
		btn1.setFont(new Font("Serif", Font.BOLD, 30));
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn1.addActionListener(this);

		btn2 = new JButton("Order Placed");
		btn2.setBounds(950, 525, 225, 50);
		btn2.setFont(new Font("Serif", Font.BOLD, 30));
		btn2.setBackground(Color.GREEN);
		btn2.setForeground(Color.BLACK);
		btn2.addActionListener(this);

		btn3 = new JButton("Delete Item");
		btn3.setBounds(700, 525, 225, 50);
		btn3.setFont(new Font("Serif", Font.BOLD, 30));
		btn3.setBackground(Color.RED);
		btn3.setForeground(Color.WHITE);
		btn3.addActionListener(this);



		f1.add(p1);
		p1.add(l1);
		p1.add(l2);
		f1.add(p2);
		p2.add(jsp);
		p2.add(btn2);
		p2.add(l3);
		p2.add(tf1);
		p2.add(btn1);
		p2.add(btn3);

		f1.setLayout(null);
		f1.setBounds(75, 85, 1200, 700);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setVisible(true);

	}





	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			tb1.getModel();
			String l1 = tf1.getText();
			int x = Integer.parseInt(l1);

			if (tb1.getSelectedRowCount() == 1) {
				int row = tb1.getSelectedRow();
				String cell = tb1.getModel().getValueAt(row, 0).toString();

				String cc = "SELECT Available_Quantity FROM products WHERE Product_ID=" + cell;

				String query = "UPDATE cart SET Quantity= " + x + "  WHERE Product_ID = " + cell;
				String str1 = "UPDATE products SET Available_Quantity= Available_Quantity-'" + x
						+ "' WHERE Product_ID= " + cell;

				try {
					Connect con = new Connect();
					ResultSet rs = ((Statement) con.stmt).executeQuery(cc);

					if (rs.next()) {
						int s = rs.getInt(1);
						if (s >= x) {
							con.stmt.executeUpdate(query);
							JOptionPane.showMessageDialog(null, "Quantity Set");
							Cart cart = new Cart();
							cart.btn3.setVisible(false);
							con.stmt.executeUpdate(str1);
							f1.dispose();
						}
				else {
					JOptionPane.showMessageDialog(null,
							"                Sorry!" + "\n" + "   We have only " + s + " Items");
				}


				}
			}


				catch (Exception ex) {
					System.out.println(ex);
				}
			}


			else {
				JOptionPane.showMessageDialog(null, "Please select only One Item ");
			}
		}


		else if (e.getSource() == btn3) {
			DefaultTableModel tb1model = (DefaultTableModel) tb1.getModel();

			if (tb1.getSelectedRowCount() == 1) {
				int row = tb1.getSelectedRow();
				 int a=JOptionPane.showConfirmDialog(f1,"Are you sure?");  
				 if(a==JOptionPane.YES_OPTION){  
						String cell = tb1.getModel().getValueAt(row, 0).toString();
						String query = "DELETE FROM cart WHERE Product_ID = " + cell;

				try {
					Connect con = new Connect();
					con.stmt.executeUpdate(query);
					tb1model.removeRow(tb1.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Item deleted successfully!..");
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(f1, ex);
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

		else if (e.getSource() == btn2) {
			if (tb1.getRowCount() > 0) {
				new Order();
				f1.dispose();
			} else {
					JOptionPane.showMessageDialog(null, "Table is empty..");
				}

			}
		}


	public static void main(String[] args) {
		new Cart();
	}


}
