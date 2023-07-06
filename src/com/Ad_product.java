package com;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Ad_product implements ActionListener {
	JFrame f1;
	JPanel p1,p2,p3;
	JLabel l1,l2,l3;
	JButton btn1, btn2, btn3, btn4, btn5;
	JTextField tf1;
	JTable tb1;
	
	
	
	
	
	
	Ad_product()
	{
		f1= new JFrame("OrderUp-Product details");
		
		
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
		p2.setBounds(640, 70, 275, 50);
		p2.setBackground(Color.DARK_GRAY);
		p2.setLayout(null);
		p2.setVisible(true);
		
		
		l3= new JLabel("Products");
		l3.setBounds(50, 0, 250, 50);
		l3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		l3.setForeground(Color.WHITE);
		l3.setLayout(null);
		l3.setVisible(true);
		
		
		tf1 = new JTextField("Enter Product ID");
		tf1.setBounds(100, 157, 550, 40);
		tf1.setFont(new Font("Arial", Font.PLAIN, 15));
		tf1.setLayout(null);
		tf1.setVisible(true);
		
		
		btn2= new JButton("Search");
		btn2.setBounds(655, 157, 125, 40);
		btn2.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn2.setBackground(Color.PINK);
		btn2.setForeground(Color.BLACK);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);
		
		
		btn3= new JButton("Edit Product");
		btn3.setBounds(950, 150, 225, 50);
		btn3.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn3.setBackground(Color.GREEN);
		btn3.setForeground(Color.BLACK);
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);
		
		
		btn4= new JButton("Delete Product");
		btn4.setBounds(1200, 150, 225, 50);
		btn4.setFont(new Font("Agency FB", Font.BOLD, 30));
		btn4.setBackground(Color.RED);
		btn4.setForeground(Color.WHITE);
		btn4.setLayout(null);
		btn4.setVisible(true);
		btn4.addActionListener(this);
		
		btn5 = new JButton("All Products");
		btn5.setBounds(1100, 100, 175, 35);
		btn5.setFont(new Font("Serif", Font.BOLD, 20));
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 7, 5, 10);
		Border compound = new CompoundBorder(line, margin);
		btn5.setBorder(compound);
		btn5.setBackground(Color.ORANGE);
		btn5.setForeground(Color.BLACK);
		btn5.setLayout(null);
		btn5.setVisible(true);
		btn5.addActionListener(this);
		
		p3= new JPanel();
		p3.setBounds(25, 215, 1475, 560);
		p3.setBackground(Color.BLUE);
		p3.setLayout(null);
		p3.setVisible(true);
		
		
		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 1475, 560);
		jsp.setVisible(true);
		p3.add(jsp);

		// create table here
		tb1 = new JTable();
		tb1.setBounds(0, 0, 1475, 560);
		tb1.setBackground(Color.WHITE);
		tb1.setFont(new Font("Cablibri", Font.PLAIN, 15));
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = { "Product_ID", "Name", "Brand", "Varirty", "Available_Quantity", "Price", "Image" };
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
							"SELECT Product_ID, Name, Brand, Variety, Available_Quantity, Price, Image FROM products ");

			ResultSet rs1 = pstmt.executeQuery();

			tb1.setModel(DbUtils.resultSetToTableModel(rs1));
			tb1.getColumn("Image").setCellRenderer(new ImageRender());
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
		f1.add(btn3);
		f1.add(btn4);
		f1.add(btn5);
		f1.add(p3);
		p3.add(jsp);
		
		
		
		
		f1.setLayout(null);
		f1.getContentPane().setBackground(Color.LIGHT_GRAY);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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

		if (ae.getSource() == btn2) {
			try {

				// Registering the Driver
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String l3 = tf1.getText();
				// Getting the connection
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

				PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID, Name, Brand, Variety, Quantity, Price, Image FROM products WHERE Product_ID= "
								+ l3 + " ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(f1, "Please Enter Valid Product ID");
			}
		}

		else if (ae.getSource() == btn3) {
			if (tb1.getSelectedRowCount() == 1) {
				int row = tb1.getSelectedRow();
				int a = JOptionPane.showConfirmDialog(f1, "Are you sure want to Edit?");
				if (a == JOptionPane.YES_OPTION) {
					String cell = tb1.getModel().getValueAt(row, 0).toString();
					Edit_pro edit = new Edit_pro();
					edit.btn3.setVisible(false);
					Connect con = new Connect();
					String str1 = "SELECT * FROM products WHERE Product_ID='" + cell + "'";

					try {
						ResultSet rs = ((Statement) con.stmt).executeQuery(str1);
						if (rs.next()) {

							// fetching records from SQL table
							String l1 = rs.getString(1);
							String l2 = rs.getString(2);
							String l4 = rs.getString(4);
							String l5 = rs.getString(5);
							String l6 = rs.getString(6);
							String l7 = rs.getString(7);
							String l8 = rs.getString(9);
							String l9 = rs.getString(8);

							// Set data in TextFields
							edit.tf1.setText(l1);
							edit.tf2.setText(l2);
							edit.cb1.setSelectedItem(l4);
							edit.tf5.setText(l5);
							edit.tf6.setText(l6);
							edit.cb2.setSelectedItem(l7);
							edit.tf8.setText(l8);
							edit.tf9.setText(l9);
						}
					} catch (Exception ex) {
						System.out.println(ex);
					}

				}
			}
		}



		else if (ae.getSource() == btn4) {
			DefaultTableModel tb1model = (DefaultTableModel) tb1.getModel();

			if (tb1.getSelectedRowCount() == 1) {
				int row = tb1.getSelectedRow();
				int a = JOptionPane.showConfirmDialog(f1, "Are you sure?");
				if (a == JOptionPane.YES_OPTION) {
					String cell = tb1.getModel().getValueAt(row, 0).toString();
					String query = "DELETE FROM products WHERE Product_ID = " + cell;

					try {
						Connect con = new Connect();
						con.stmt.executeUpdate(query);
						tb1model.removeRow(tb1.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Item deleted successfully!..");
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



		else if (ae.getSource() == btn5) {
			try {

				// Registering the Driver
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());

				// Getting the connection
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

				PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID, Name, Brand, Variety, Available_Quantity, Price, Image FROM products ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());

			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

	}

	public class ImageRender extends DefaultTableCellRenderer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable tb1, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			byte[] bytes = (byte[]) value;
			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(bytes).getImage().getScaledInstance(230, 100, Image.SCALE_DEFAULT));

			setIcon(imageIcon);
			return this;
		}
	}
	
		
		
		
	public static void main(String[] args) {
		new Ad_product();
	}
}
