package loginFrame;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import config.JDBCConnection;
import controller.newUserHome;
import daoImpl.EmployeeDaoImpl;
import model.Employee;
import test.TestClass;
class registation extends JFrame implements ActionListener {

	private static final boolean True = false;
	JLabel lFirstName, lLastName,lUserID,lPassword, lAge, lRole, lGender, lDateOfBirth, lMobileNumber,lSkills;
	JTextField tFirstName, tLastName,tUserID, tAge, tRole, tGender,tDateofBirth, tMobileNumber, tSkills;
	JButton bConfirm, bReset, bHome;
	JPasswordField pPassword;
	
	public void reg_form(){
		lFirstName=new JLabel("First Name");
		lFirstName.setBounds(50, 20, 150, 25);
		lLastName=new JLabel("Last Nmae");
		lLastName.setBounds(50, 50, 150, 25);
		lUserID=new JLabel("UserID");
		lUserID.setBounds(50,80,150,25);
		lPassword=new JLabel("New Password");
		lPassword.setBounds(50,110,150,25);
		lAge=new JLabel("Age");
		lAge.setBounds(50, 140, 150, 25);
		lDateOfBirth=new JLabel("Date Of Birth");
		lDateOfBirth.setBounds(50, 170, 150, 25);
		lGender=new JLabel("Gender");
		lGender.setBounds(50, 200, 150, 25);
		lRole=new JLabel("Role");
		lRole.setBounds(50,230,150,25);
		lMobileNumber=new JLabel("MobileNumber");
		lMobileNumber.setBounds(50,260,150,25);
		lSkills=new JLabel("Skills");
		lSkills.setBounds(50,290,150,25);
		
		
		tFirstName=new JTextField();
		tFirstName.setBounds(150, 20, 150, 25);
		tLastName=new JTextField();
		tLastName.setBounds(150, 50, 150, 25);
		tUserID=new JTextField();
		tUserID.setBounds(150,80,150,25);
		pPassword=new JPasswordField();
		pPassword.setBounds(150,110,150,25);
		tAge=new JTextField();
		tAge.setBounds(150, 140, 150, 25);
		tDateofBirth=new JTextField();
		tDateofBirth.setBounds(150, 170, 150, 25);
		tGender=new JTextField(); 
		tGender.setBounds(150, 210, 150, 25);
		tRole=new JTextField();
		tRole.setBounds(150,240,150,25);
		tMobileNumber=new JTextField();
		tMobileNumber.setBounds(150,270,150,25);
		tSkills=new JTextField();
		tSkills.setBounds(150,300,150,25);
		
		
		bConfirm= new JButton("Confirm");
		bConfirm.addActionListener(this);
		bConfirm.setBounds(180, 350,150, 25);
		bReset=new JButton("Reset");
		bReset.addActionListener(this);
		bReset.setBounds(350, 350,150, 25);
		bHome=new JButton("Home");
		bHome.addActionListener(this);
		bHome.setBounds(520, 350,150, 25);
		
		add(lFirstName);
		add(lLastName);
		add(lUserID);
		add(lPassword);
		add(lAge);
		add(lRole);
		add(lGender);
		add(lDateOfBirth);
		add(lMobileNumber);
	
		add(tFirstName);
		add(tLastName);
		add(tUserID);
		add(pPassword);
		add(tAge);
		add(tRole);
		add(tGender);
		add(tDateofBirth);
		add(tMobileNumber);
		
		add(bConfirm);
		add(bReset);
		add(bHome);
		
		
		setTitle("New Registation Form");
		setSize(500,600);
		setLayout(null);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		String emp="";
		if(e.getSource()== bConfirm)
		{		
			int x=0;
		String Fname=tFirstName.getText();
		String Lname=tLastName.getText();
		String UserID=tUserID.getText();
		char[] pas=pPassword.getPassword();
		String Pass=new String(pas);
		String Age=tAge.getText();
		String DOB=tDateofBirth.getText();
		String Role=tRole.getText();
		String Gender=tGender.getText();
		String Mobile=tMobileNumber.getText();
		if(Role.equals("HRA"))
			emp="True";
		else
			emp="False";
		
		EmployeeDaoImpl nuh=new EmployeeDaoImpl().addEmployee(Fname,Lname,UserID,Pass,Age,DOB,Role,Gender,Mobile,emp);	
		
		dispose();	
		New_Registation reg=new New_Registation();
		reg.setVisible(True);
	
		}
		
		 else if(e.getSource()==bReset)
		 {
			 tFirstName.setText("");
			 tLastName.setText("");
			 tUserID.setText("");
			 pPassword.setText("");
			 tAge.setText("");
			 tDateofBirth.setText("");
			 tGender.setText("");
			 tRole.setText("");
			 tMobileNumber.setText("");
			 tSkills.setText("");
			 
		 }	
		 else if(e.getSource()==bHome){
			 dispose();
			 LoginSet log=new LoginSet();
			 log.setVisible(true);
		 }
	
	
}

}

public class New_Registation  {

	

	public void setVisible(boolean b) {
		
		//setVisible(true);
		registation reg=new registation();
		reg.reg_form();
		
	}	
	

}
