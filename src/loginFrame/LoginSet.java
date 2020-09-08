package loginFrame;
import javax.swing.*;
import javax.swing.text.Caret;

import config.JDBCConnection;

import controller.UserHome;

import java.awt.event.*;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
class Logg extends JFrame implements ActionListener {
	JLabel ltittle, lusername, lpassword, ldesign, lmessage;
	JTextField tusername;
	JPasswordField ppassword;
	JButton blogin, bregistation;	
	JComboBox Combo;
	
	


public void loginScreen() {
	String Des[]= {"HRA","PME","EMP"};
	ltittle=new JLabel("Login Window");
	ltittle.setBounds(180, 20, 150, 25);
	lusername=new JLabel("UserID");
	lusername.setBounds(50, 80, 150, 25);
	lpassword=new JLabel("Password");
	lpassword.setBounds(50, 160, 150, 25);
	ldesign=new JLabel("Designation");
	ldesign.setBounds(50, 240, 150, 25);
	lmessage=new JLabel();
	lmessage.setBounds(50,270,150,25);
	
	tusername=new JTextField();
	tusername.setBounds(200, 80, 150, 25);
	
	ppassword=new JPasswordField();
	ppassword.setBounds(200, 160, 150, 25);
	ppassword.setEchoChar('*');
	
	Combo=new JComboBox(Des);
	Combo.setBounds(200, 240, 150, 25);
	
	
	
	blogin=new JButton("Login");
	blogin.setBounds(180, 320,150, 25);
	blogin.addActionListener(this);
	//dialog=new JDialog(this,"Login",true);
	
	bregistation=new JButton("Register");
	bregistation.setBounds(350, 320,150, 25);
	bregistation.addActionListener(this);
	//dialog=new JDialog(this,"Register",true);
	
	add(ltittle);
	add(lusername);
	add(lpassword);
	add(ldesign);
	add(tusername);
	add(ppassword);
	add(Combo);
	
	add(blogin);
	add(bregistation);
	
	
	
	setSize(700,650);
	setLayout(null);
	setVisible(true);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}



@Override
public void actionPerformed(ActionEvent e) {
	try {
	if(e.getSource()==bregistation)
	{
		dispose();
		New_Registation regg=new New_Registation();
		regg.setVisible(true);
	}
	else if(e.getSource()==blogin) {
		String uid=tusername.getText();
		String pass=ppassword.getText();
		String role=Combo.getSelectedItem().toString();
		
			Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;database=project","sa","niit@123");
			 PreparedStatement st = (PreparedStatement) conn
                     .prepareStatement("Select userid, password from Employee where userid=? and password=? and role=?");
			
	
	st.setString(1, uid);
	st.setString(2, pass);
	st.setString(3, role);
	//
	 ResultSet rs = st.executeQuery();
    if (rs.next()) {
    	dispose();
    	
    	 UserHome ah = new UserHome(uid,pass, role);
    	ah.setTittle("Welcome");
    	ah.setVisible(true);
    	 JOptionPane.showMessageDialog(blogin, "You have successfully logged in");
    	
    }
    else {
    	 JOptionPane.showMessageDialog(blogin, "You Entered wrong Detailes");
    	 ppassword.setText("");
    }
	
	}
	
	}
	catch (SQLException sqlException) {
        sqlException.printStackTrace();
    }
	
}
}


public class LoginSet {
	

	public static void main(String[] args) {
		Logg log=new Logg();
		log.loginScreen();
		
		
	}

	public void setVisible(boolean b) {
	
		Logg log=new Logg();
		log.loginScreen();
	}

}
