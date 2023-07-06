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
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Customer implements ActionListener {
	JFrame f1;
	JPanel p1, p2, p3;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12;
	JTextField tf1;
	JTable tb1;
	JMenuBar mb;
	JMenuItem m1, m2, m3, m4;

	Customer() {
		f1 = new JFrame("OrderUp-Customer Portal");

		p1 = new JPanel();
		p1.setBounds(0, 0, 1550, 50);
		p1.setBackground(new Color(112, 128, 144));
		p1.setLayout(null);
		p1.setVisible(true);

		ImageIcon image = new ImageIcon("F:\\test_logo.png");
		l1 = new JLabel(image);
		l1.setBounds(10, 0, 130, 50);
		l1.setLayout(null);
		l1.setVisible(true);

		ImageIcon image1 = new ImageIcon("F:\\logout.png");
		btn1 = new JButton(image1);
		btn1.setBounds(1455, 0, 82, 50);
		btn1.setBackground(Color.WHITE);
		btn1.setLayout(null);
		btn1.setVisible(true);
		btn1.addActionListener(this);

		tf1 = new JTextField("Enter Product ID");
		tf1.setBounds(175, 5, 500, 40);
		tf1.setFont(new Font("Arial", Font.PLAIN, 15));
		tf1.setLayout(null);
		tf1.setVisible(true);

		ImageIcon image2 = new ImageIcon("F:\\search.png");
		btn2 = new JButton(image2);
		btn2.setBounds(675, 5, 40, 40);
		btn2.setBackground(new Color(255, 178, 102));
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);

		l2 = new JLabel("Hello,");
		l2.setBounds(970, 5, 100, 40);
		l2.setFont(new Font("Arial", Font.PLAIN, 30));
		l2.setForeground(Color.WHITE);
		l2.setLayout(null);
		l2.setVisible(true);

		// received data from Dash class
		l3 = new JLabel();
		l3.setBounds(1050, 10, 400, 30);
		l3.setFont(new Font("Arial", Font.BOLD, 20));
		l3.setForeground(Color.WHITE);
		l3.setLayout(null);
		l3.setVisible(true);

		p2 = new JPanel();
		p2.setBounds(0, 50, 1550, 125);
		p2.setBackground(Color.WHITE);
		p2.setLayout(null);
		p2.setVisible(true);

		ImageIcon fashion = new ImageIcon("F:\\fashion.png");
		btn3 = new JButton(fashion);
		btn3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btn3.setBounds(0, 0, 100, 125);
		btn3.setFont(new Font("Arial", Font.BOLD, 20));
		btn3.setBackground(Color.WHITE);
		btn3.setLayout(null);
		btn3.setVisible(true);
		btn3.addActionListener(this);

		l4 = new JLabel("Fashion");
		l4.setBounds(20, 82, 100, 50);
		l4.setFont(new Font("Arial", Font.BOLD, 15));
		l4.setVisible(true);

		ImageIcon electronics = new ImageIcon("F:\\electronics.png");
		btn4 = new JButton(electronics);
		btn4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btn4.setBounds(150, 0, 100, 125);
		btn4.setFont(new Font("Arial", Font.BOLD, 20));
		btn4.setBackground(Color.WHITE);
		btn4.setLayout(null);
		btn4.setVisible(true);
		btn4.addActionListener(this);

		l5 = new JLabel("Electronics");
		l5.setBounds(10, 82, 100, 50);
		l5.setFont(new Font("Arial", Font.BOLD, 15));
		l5.setVisible(true);

		ImageIcon dairy = new ImageIcon("F:\\dairy.png");
		btn5 = new JButton(dairy);
		btn5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btn5.setBounds(300, 0, 100, 125);
		btn5.setFont(new Font("Arial", Font.BOLD, 20));
		btn5.setBackground(Color.WHITE);
		btn5.setLayout(null);
		btn5.setVisible(true);
		btn5.addActionListener(this);

		l6 = new JLabel("Dairy");
		l6.setBounds(30, 82, 100, 50);
		l6.setFont(new Font("Arial", Font.BOLD, 15));
		l6.setVisible(true);

		ImageIcon pharmacy = new ImageIcon("F:\\pharmacy.png");
		btn6 = new JButton(pharmacy);
		btn6.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btn6.setBounds(450, 0, 100, 125);
		btn6.setFont(new Font("Arial", Font.BOLD, 20));
		btn6.setBackground(Color.WHITE);
		btn6.setLayout(null);
		btn6.setVisible(true);
		btn6.addActionListener(this);

		l7 = new JLabel("Pharmacy");
		l7.setBounds(12, 82, 100, 50);
		l7.setFont(new Font("Arial", Font.BOLD, 15));
		l7.setVisible(true);

		ImageIcon kitchenware = new ImageIcon("F:\\kitchenware.png");
		btn7 = new JButton(kitchenware);
		btn7.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btn7.setBounds(600, 0, 100, 125);
		btn7.setFont(new Font("Arial", Font.BOLD, 20));
		btn7.setBackground(Color.WHITE);
		btn7.setLayout(null);
		btn7.setVisible(true);
		btn7.addActionListener(this);

		l8 = new JLabel("Kitchenware");
		l8.setBounds(3, 82, 100, 50);
		l8.setFont(new Font("Arial", Font.BOLD, 15));
		l8.setVisible(true);

		ImageIcon baker = new ImageIcon("F:\\bakery.png");
		btn8 = new JButton(baker);
		btn8.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btn8.setBounds(750, 0, 100, 125);
		btn8.setFont(new Font("Arial", Font.BOLD, 20));
		btn8.setBackground(Color.WHITE);
		btn8.setLayout(null);
		btn8.setVisible(true);
		btn8.addActionListener(this);

		l9 = new JLabel("Bakeries");
		l9.setBounds(15, 82, 100, 50);
		l9.setFont(new Font("Arial", Font.BOLD, 15));
		l9.setVisible(true);

		ImageIcon meat = new ImageIcon("F:\\meat.png");
		btn9 = new JButton(meat);
		btn9.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btn9.setBounds(900, 0, 100, 125);
		btn9.setFont(new Font("Arial", Font.BOLD, 20));
		btn9.setBackground(Color.WHITE);
		btn9.setLayout(null);
		btn9.setVisible(true);
		btn9.addActionListener(this);

		l10 = new JLabel("Meat");
		l10.setBounds(30, 82, 100, 50);
		l10.setFont(new Font("Arial", Font.BOLD, 15));
		l10.setVisible(true);

		ImageIcon grocery = new ImageIcon("F:\\grocery.png");
		btn10 = new JButton(grocery);
		btn10.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btn10.setBounds(1050, 0, 100, 125);
		btn10.setFont(new Font("Arial", Font.BOLD, 20));
		btn10.setBackground(Color.WHITE);
		btn10.setLayout(null);
		btn10.setVisible(true);
		btn10.addActionListener(this);

		l11 = new JLabel("Groceries");
		l11.setBounds(13, 82, 100, 50);
		l11.setFont(new Font("Arial", Font.BOLD, 15));
		l11.setVisible(true);

		ImageIcon cart = new ImageIcon("F:\\cart.png");
		btn11 = new JButton(cart);
		btn11.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btn11.setBounds(1200, 0, 100, 125);
		btn11.setFont(new Font("Arial", Font.BOLD, 20));
		btn11.setBackground(Color.WHITE);
		btn11.setLayout(null);
		btn11.setVisible(true);
		btn11.addActionListener(this);

		l12 = new JLabel("Add to cart");
		l12.setBounds(10, 82, 100, 50);
		l12.setFont(new Font("Arial", Font.BOLD, 15));
		l12.setVisible(true);

		btn12 = new JButton("All Products");
		btn12.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btn12.setBounds(750, 5, 150, 40);
		btn12.setFont(new Font("Arial", Font.BOLD, 20));
		btn12.setForeground(Color.ORANGE);
		btn12.setBackground(Color.BLACK);
		btn12.setLayout(null);
		btn12.setVisible(true);
		btn12.addActionListener(this);

//Create MenuBar
		mb = new JMenuBar();
		mb.setBounds(1380, 95, 125, 20);
		mb.setLayout(null);
		mb.setVisible(true);

		JMenu x = new JMenu("Your Profile");
		x.setBounds(0, -15, 125, 50);
		x.setFont(new Font("Arial", Font.BOLD, 20));

		m1 = new JMenuItem("My Profile");
		m1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		m1.setBackground(new Color(112, 128, 144));
		m1.setForeground(Color.WHITE);
		m1.setPreferredSize(new Dimension(125, 40));
		m1.addActionListener(this);

		m2 = new JMenuItem("My Order");
		m2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		m2.setBackground(new Color(112, 128, 144));
		m2.setForeground(Color.WHITE);
		m2.setPreferredSize(new Dimension(125, 40));
		m2.addActionListener(this);

		m3 = new JMenuItem("My Cart");
		m3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		m3.setBackground(new Color(112, 128, 144));                                                                                                                                                                                                                                                  
		m3.setForeground(Color.WHITE);
		m3.setPreferredSize(new Dimension(125, 40));
		m3.addActionListener(this);

		m4 = new JMenuItem("Logout");
		m4.setFont(new Font("Arial Black", Font.PLAIN, 20));
		m4.setBackground(new Color(112, 128, 144));
		m4.setForeground(Color.WHITE);
		m4.setPreferredSize(new Dimension(125, 40));
		m4.addActionListener(this);

		x.add(m1);
		x.add(m2);
		x.add(m3);
		x.add(m4);

		mb.add(x);

		ImageIcon profile = new ImageIcon("F:\\profile.png");
		l13 = new JLabel(profile);
		l13.setBounds(1395, 0, 100, 100);
		l13.setFont(new Font("Arial", Font.BOLD, 15));
		l13.setVisible(true);

		p3 = new JPanel();
		p3.setBounds(0, 175, 1525, 625);
		p3.setLayout(null);
		p3.setVisible(true);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(-250, 0, 1770, 625);
		p3.add(jsp);

		// create table here
		tb1 = new JTable();
		tb1.setBounds(0, 20, 1770, 625);
		tb1.setBackground(Color.WHITE);
		tb1.setFont(new Font("Cablibri", Font.PLAIN, 15));
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = { "Product_ID", "Name", "Brand", "Price", "Warranty", "Specification", "Image" };
		model.setColumnIdentifiers(column);
		tb1.setModel(model);
		tb1.setRowHeight(100);
		jsp.setViewportView(tb1);

		try {

			// Registering the Driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// Getting the connection
			String mysqlUrl = "jdbc:mysql://localhost:3306/test";
			java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

			java.sql.PreparedStatement pstmt = con1
					.prepareStatement(
							"SELECT Product_ID, Name, Brand, Price, Warranty, Specification, Image FROM products ");

			ResultSet rs1 = pstmt.executeQuery();

			tb1.setModel(DbUtils.resultSetToTableModel(rs1));
			tb1.getColumn("Image").setCellRenderer(new ImageRender());
		}

		catch (Exception ex) {
			System.out.println(ex);
		}

		f1.add(p1);
		p1.add(l1);
		p1.add(btn1);
		p1.add(tf1);
		p1.add(btn2);

		p1.add(btn12);

		p1.add(l2);
		p1.add(l3);
		f1.add(p2);

		p2.add(btn3);
		btn3.add(l4);

		p2.add(btn4);
		btn4.add(l5);

		p2.add(btn5);
		btn5.add(l6);

		p2.add(btn6);
		btn6.add(l7);

		p2.add(btn7);
		btn7.add(l8);

		p2.add(btn8);
		btn8.add(l9);

		p2.add(btn9);
		btn9.add(l10);

		p2.add(btn10);
		btn10.add(l11);

		p2.add(btn11);
		btn11.add(l12);

		p2.add(mb);
		p2.add(l13);
		f1.add(p3);

		p3.add(jsp);

		f1.setLayout(null);
		f1.getContentPane().setBackground(Color.WHITE);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		f1.setSize(screensize.width, screensize.height);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);

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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			new Dash();
			f1.dispose();
		}

		else if (e.getSource() == btn2) {

			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID,Name, Brand, Price, Warranty, Specification, Image FROM products WHERE Product_ID= "
								+ tf1.getText() + " ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());
			}

			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Please Enter Valid Product ID!!");
			}
		}

		else if (e.getSource() == btn3) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID,Name, Brand, Price, Warranty, Specification, Image FROM products WHERE Variety= 'Fashion' ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		}

		else if (e.getSource() == btn4) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID, Name, Brand, Price, Warranty, Specification, Image FROM products WHERE Variety= 'Electronics' ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		}

		else if (e.getSource() == btn5) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID, Name, Brand, Price, Warranty, Specification, Image FROM products WHERE Variety= 'Dairy' ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		}

		else if (e.getSource() == btn6) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID, Name, Brand, Price, Warranty, Specification, Image FROM products WHERE Variety= 'Pharmacy' ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		}

		else if (e.getSource() == btn7) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID, Name, Brand, Price, Warranty, Specification, Image FROM products WHERE Variety= 'Kitchenware' ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		}

		else if (e.getSource() == btn8) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID, Name, Brand, Price, Warranty, Specification, Image FROM products WHERE Variety= 'Bakery' ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		}

		else if (e.getSource() == btn9) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID, Name, Brand, Price, Warranty, Specification, Image FROM products WHERE Variety= 'Meat' ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		}

		else if (e.getSource() == btn10) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");
				java.sql.PreparedStatement pstmt = con1.prepareStatement(
						"SELECT Product_ID, Name, Brand, Price, Warranty, Specification, Image FROM products WHERE Variety= 'Groceries' ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		}

		else if (e.getSource() == btn11) {

			tb1.getModel();

			if (tb1.getSelectedRowCount() == 1) {
				int row = tb1.getSelectedRow();
				String cell = tb1.getModel().getValueAt(row, 0).toString();
				String query = "INSERT INTO cart(Product_ID, Name, Brand, Price) SELECT Product_ID, Name, Brand, Price FROM products WHERE Product_ID = "
						+ cell;

				try {
					Connect con = new Connect();
					con.stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Item Selected....!");

				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}

			else {
				JOptionPane.showMessageDialog(null, "Please select One Item for Purchase");
			}
		}

		else if (e.getSource() == btn12) {
			try {

				// Registering the Driver
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());

				// Getting the connection
				String mysqlUrl = "jdbc:mysql://localhost:3306/test";
				java.sql.Connection con1 = DriverManager.getConnection(mysqlUrl, "root", "root");

				java.sql.PreparedStatement pstmt = con1
						.prepareStatement(
								"SELECT Product_ID, Name, Brand, Price, Warranty, Specification, Image FROM products ");

				ResultSet rs1 = pstmt.executeQuery();

				tb1.setModel(DbUtils.resultSetToTableModel(rs1));
				tb1.getColumn("Image").setCellRenderer(new ImageRender());
			}

			catch (Exception ex) {
				System.out.println(ex);
			}
		}

		else if (e.getSource() == m1) {
			new My_pro();
			f1.dispose();
		}

		else if (e.getSource() == m2) {
			new Order();
		}

		else if (e.getSource() == m3) {
			new Cart();
		}

		else if (e.getSource() == m4) {
			new Dash();
			f1.dispose();
		}

	}

	public static void main(String[] args) {
		new Customer();
	}
}
