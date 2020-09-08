package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.JDBCConnection;
import loginFrame.LoginSet;
import model.Employee;

public class newUserHome extends JFrame {
int x=0;
	public newUserHome(String fname, String lname, String userID, String pass, String age, String dOB, String role,
			String gender, String mobile, String skills, String emp) {
		try {
			if(role.equals("HRA"))
			emp="true";
		     
		else
			emp="false";
			
		
		Connection	conn=JDBCConnection.getDBConnection();
			PreparedStatement pst=conn.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, fname);
			pst.setString(2,lname);
			pst.setString(3, userID);
			pst.setString(4, pass);
			pst.setString(5, age);
			pst.setString(6, dOB);
			pst.setString(7, role);
			pst.setString(8, gender);
			pst.setString(9, mobile);
			pst.setString(10, skills);
			pst.setString(11, emp);
			int i=pst.executeUpdate();
			
					x++;
							ResultSet rs = pst.executeQuery();
					if(x>=1) {
						
						JOptionPane.showInputDialog( "Data Saved Successfully");
					
					}
					else {
						JOptionPane.showInputDialog( "Data Not Saved");
						}
					conn.close();
					rs.close();
					}
			
				catch(ClassNotFoundException e1) {
					System.out.println(e1.getMessage());
					
				}
				catch(SQLException e1) {
					System.out.println(e1.getMessage());
				}
	}
	

}
