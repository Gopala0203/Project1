package daoImpl;

import java.sql.*;

import javax.swing.JOptionPane;


import dao.EmployeeDao;
import loginFrame.LoginSet;
import loginFrame.New_Registation;
import model.Employee;
import config.JDBCConnection;


public  class EmployeeDaoImpl implements EmployeeDao{

	Connection conn=null;
	@Override
	public void getAllEmployees() {
		try {
			conn=JDBCConnection.getDBConnection();
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Employee");
			if(rst!=null) {
				Employee emp=new Employee();
				while(rst.next()) {
					emp.setEmpId(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserId(rst.getString(4));
					emp.setPassword(rst.getString(5));
					emp.setAge(rst.getString(6));
					emp.setDateofBirth(rst.getString(7));
					emp.setRole(rst.getString(8));
					emp.setGender(rst.getString(9));
					emp.setMobile(rst.getString(10));
					
					emp.setActive(rst.getString(11));
					System.out.println(emp);
				}
			}
			conn.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public EmployeeDaoImpl addEmployee(String fname, String lname, String userID, String pass, String age, String dOB, String role,
			String gender, String mobile, String emp) {
		
		try {
			conn=JDBCConnection.getDBConnection();
			PreparedStatement pst=conn.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, fname);
			pst.setString(2,lname);
			pst.setString(3, userID);
			pst.setString(4, pass);
			pst.setString(5, age);
			pst.setString(6, dOB);
			pst.setString(7, role);
			pst.setString(8, gender);
			pst.setString(9, mobile);
			//pst.setString(10, skills);
			pst.setString(10, emp);
			int i=pst.executeUpdate();
			if(i==1) {
				JOptionPane.showInputDialog( "Data Saved Successfully");
			
				System.out.println("1 record inserted...");
			}
			else
			{
				JOptionPane.showInputDialog( "Data Not Save, Retry");
				
				System.out.println("insertion failed...");
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
		
		
	}
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

}