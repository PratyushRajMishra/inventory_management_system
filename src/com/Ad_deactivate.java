package com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Ad_deactivate implements ActionListener {
	JFrame f1;
	JPanel p1, p2, p3;
	JLabel l1, l2, l3;
	JButton btn1, btn2;
	JTable tb1;
	
	
	
	
	
	Ad_deactivate()
	{
f1= new JFrame("OrderUp-Feedbacks");
		
		
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
		
		
		p2 = new JPanel();
		p2.setBounds(620, 55, 300, 60);
		p2.setBackground(Color.RED);
		p2.setLayout(null);
		p2.setVisible(true);
		
		l3 = new JLabel("Deactivated Account");
		l3.setBounds(15, 0, 300, 50);
		l3.setFont(new Font("Serif", Font.BOLD, 30));
		l3.setForeground(Color.WHITE);
		l3.setLayout(null);
		l3.setVisible(true);
		
		
		btn2 = new JButton("Activate Account");
		btn2.setBounds(1200, 65, 200, 40);
		btn2.setFont(new Font("Arial", Font.BOLD, 20));
		btn2.setBackground(Color.GREEN);
		btn2.setForeground(Color.WHITE);
		btn2.setLayout(null);
		btn2.setVisible(true);
		btn2.addActionListener(this);

		p3 = new JPanel();
		p3.setBounds(40, 125, 1450, 650);
		p3.setBackground(Color.BLUE);
		p3.setLayout(null);
		p3.setVisible(true);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(0, 0, 1450, 650);
		jsp.setVisible(true);
		p3.add(jsp);

		// create table here
		tb1 = new JTable();
		tb1.setBounds(0, 0, 1450, 650);
		tb1.setBackground(Color.WHITE);
		tb1.setFont(new Font("Cablibri", Font.PLAIN, 15));
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = { "Fname", "Lname", "email", "pass", "Mob", "birth", "Pin", "Gender", "Address", "Account" };
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

			java.sql.PreparedStatement pstmt = con1.prepareStatement("SELECT * FROM deactive");

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
		f1.add(p3);
		p3.add(jsp);
		f1.add(btn2);
		
		
		
		

		f1.getContentPane().setBackground(Color.WHITE);
		f1.setLayout(null);
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

		else if (ae.getSource() == btn2) {
			DefaultTableModel tb1model = (DefaultTableModel) tb1.getModel();

			if (tb1.getSelectedRowCount() == 1) {
				int row = tb1.getSelectedRow();
				int a = JOptionPane.showConfirmDialog(f1, "Are you sure want to activate this Account?");
				if (a == JOptionPane.YES_OPTION) {
					String cell = tb1.getModel().getValueAt(row, 6).toString();
					String query = "INSERT INTO login(Fname, Lname, email, pass, Account, Mob, Gender) "
							+ "SELECT Fname, Lname, email, pass, Account, Mob, Gender FROM deactive";
					
					String str = "DELETE FROM deactive WHERE Mob=" + cell;
					try {
						Connect con = new Connect();
						con.stmt.executeUpdate(query);
						con.stmt.executeUpdate(str);
						tb1model.removeRow(tb1.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Account Activated!!");
						f1.dispose();
						new Ad_deactivate();
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

		
	public static void main(String[] args) {
		new Ad_deactivate();
	} 

}
