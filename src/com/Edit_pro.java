package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Edit_pro implements ActionListener {
	JFrame f1;
	JLabel l, l1, l2, l4, l5, l6, l7, l8, l9;

	JTextField tf1, tf2, tf5, tf6, tf8, tf9;
	JPanel p1;
	JComboBox<?> cb1, cb2;
	JButton btn2, btn3;
	String s;

	Edit_pro() {

		f1 = new JFrame("OrderUp-Update Product");

		p1 = new JPanel();
		p1.setBounds(350, 10, 300, 40);
		p1.setBackground(Color.DARK_GRAY);
		p1.setLayout(null);
		p1.setVisible(true);

		l = new JLabel("Update Product");
		l.setBounds(25, 0, 300, 40);
		l.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		l.setForeground(Color.WHITE);
		l.setLayout(null);
		l.setVisible(true);

		l1 = new JLabel("Product ID:-");
		l1.setBounds(195, 78, 300, 50);
		l1.setFont(new Font("Calibri", Font.BOLD, 30));
		l1.setLayout(null);
		l1.setVisible(true);

		l2 = new JLabel("Product name:-");
		l2.setBounds(100, 150, 300, 50);
		l2.setFont(new Font("Calibri", Font.BOLD, 20));
		l2.setLayout(null);
		l2.setVisible(true);

		tf1 = new JTextField();
		tf1.setBounds(350, 80, 300, 40);
		tf1.setFont(new Font("Arial", Font.PLAIN, 15));

		tf2 = new JTextField();
		tf2.setBounds(100, 180, 300, 40);
		tf2.setFont(new Font("Arial", Font.PLAIN, 15));
		tf2.setVisible(true);


		l4 = new JLabel("Product variety:-");
		l4.setBounds(575, 150, 300, 50);
		l4.setFont(new Font("Calibri", Font.BOLD, 20));
		l4.setLayout(null);
		l4.setVisible(true);


		String[] s2 = { "Fashion", "Electronics", "Dairy", "Pharmacy", "Kitchenware", "Bakery", "Meat", "Groceries" };
		cb1 = new JComboBox<Object>(s2);
		cb1.setBounds(575, 180, 300, 40);
		cb1.setFont(new Font("Calibri", Font.BOLD, 20));
		cb1.setBackground(Color.WHITE);
		cb1.setLayout(null);
		cb1.setVisible(true);

		l5 = new JLabel("Brand name:-");
		l5.setBounds(100, 240, 300, 50);
		l5.setFont(new Font("Calibri", Font.BOLD, 20));
		l5.setLayout(null);
		l5.setVisible(true);

		l6 = new JLabel("Price(Per Product):-");
		l6.setBounds(575, 240, 300, 50);
		l6.setFont(new Font("Calibri", Font.BOLD, 20));
		l6.setLayout(null);
		l6.setVisible(true);

		tf5 = new JTextField();
		tf5.setBounds(100, 270, 300, 40);
		tf5.setFont(new Font("Arial", Font.PLAIN, 15));

		tf6 = new JTextField();
		tf6.setBounds(575, 270, 300, 40);
		tf6.setFont(new Font("Arial", Font.PLAIN, 15));

		l7 = new JLabel("Product warranty:-");
		l7.setBounds(100, 330, 300, 50);
		l7.setFont(new Font("Calibri", Font.BOLD, 20));
		l7.setLayout(null);
		l7.setVisible(true);

		l8 = new JLabel("Quantity:-");
		l8.setBounds(575, 330, 300, 50);
		l8.setFont(new Font("Calibri", Font.BOLD, 20));
		l8.setLayout(null);
		l8.setVisible(true);

		String[] s3 = { "3 Months", "6 Months", "1 Year", "2 Years", "5 Years", };
		cb2 = new JComboBox<Object>(s3);
		cb2.setBounds(100, 360, 300, 40);
		cb2.setFont(new Font("Calibri", Font.BOLD, 20));
		cb2.setBackground(Color.WHITE);
		cb2.setLayout(null);
		cb2.setVisible(true);

		tf8 = new JTextField("");
		tf8.setBounds(575, 360, 300, 40);
		tf8.setFont(new Font("Arial", Font.PLAIN, 15));

		l9 = new JLabel("Product Specifications:-");
		l9.setBounds(100, 420, 300, 50);
		l9.setFont(new Font("Calibri", Font.BOLD, 20));
		l9.setLayout(null);
		l9.setVisible(true);

		tf9 = new JTextField();
		tf9.setBounds(100, 450, 775, 60);
		tf9.setFont(new Font("Arial", Font.PLAIN, 15));

		btn2 = new JButton("UPDATE");
		btn2.setBounds(410, 540, 150, 40);
		btn2.setFont(new Font("ARIAL NARROW", Font.BOLD, 30));
		btn2.setBackground(Color.GREEN);
		btn2.setForeground(Color.BLACK);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);

		btn3 = new JButton("SEARCH");
		btn3.setBounds(655, 80, 125, 40);
		btn3.setFont(new Font("ARIAL NARROW", Font.BOLD, 25));
		btn3.setBackground(Color.RED);
		btn3.setForeground(Color.WHITE);
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);

		f1.add(p1);
		p1.add(l);
		f1.add(l1);
		f1.add(l2);
		f1.add(tf1);
		f1.add(tf2);
		f1.add(l4);
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
		f1.add(btn3);

		f1.setLayout(null);
		f1.setBounds(150, 165, 1000, 635);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn3) {
			Connect con = new Connect();
			String str1 = "SELECT * FROM products WHERE Product_ID='" + tf1.getText() + "'";

			try {
				ResultSet rs = ((Statement) con.stmt).executeQuery(str1);
				if (rs.next()) {

					// fetching records from SQL table
					String l2 = rs.getString(2);
					String l4 = rs.getString(4);
					String l5 = rs.getString(5);
					String l6 = rs.getString(6);
					String l7 = rs.getString(7);
					String l8 = rs.getString(9);
					String l9 = rs.getString(8);

					// Set data in TextFields
					tf2.setText(l2);
					cb1.setSelectedItem(l4);
					tf5.setText(l5);
					tf6.setText(l6);
					cb2.setSelectedItem(l7);
					tf8.setText(l8);
					tf9.setText(l9);

				}

				else {
					JOptionPane.showMessageDialog(f1, "Please Enter Valid Employee ID");
				}
			} catch (Exception ex) {
				System.out.println();
			}
		}

		if (ae.getSource() == btn2) {

			Connect con = new Connect();
			String str2 = "UPDATE products SET Name='" + tf2.getText() + "', Variety='" + cb1.getSelectedItem()
					+ "', Brand='" + tf5.getText() + "', Price='" + tf6.getText() + "', Warranty='"
					+ cb2.getSelectedItem() + "', Available_Quantity='" + tf8.getText() + "', Specification='"
					+ tf9.getText()
					+ "'  WHERE Product_ID='" + tf1.getText() + "'";

			try {
				con.stmt.executeUpdate(str2);
				JOptionPane.showMessageDialog(f1, "Successfully Updated");
				f1.dispose();
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		}
		}
		

	

	public static void main(String[] args) {
		new Edit_pro();
	}
}
