package loginFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import config.JDBCConnection;

class Employee extends JFrame implements ActionListener{
	JFrame frame;
	JButton btn1, btn2;
	JLabel lti;
	JTable table;
	Connection conn=null;
	String[] columnNames = {"empid","firstName", "lastName", "userid ", "password", "age","dateofbirth","role","gender","mobile","active"};
	public void Emp(String uid) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		model.addRow(columnNames);
		table = new JTable();
		table.setModel(model);
		table.setRowHeight(30);
		table.setRowHeight(3, 60);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setWidth(100);
		table.setBounds(80,30,800,320);
		
		//Add values to table
		String userid=uid;
		int emp=0;
		String first="";
		String last="";
		String user="";
		String pas="";
		String ag="";
		String dob="";
		String ro="";
		String ge="";
		String mo="";
		String ac="";
		
		
	
		try {
			conn=JDBCConnection.getDBConnection();
			Statement stmt=conn.createStatement();
			 PreparedStatement st = (PreparedStatement) conn
                     .prepareStatement("Select empid,firstname,lastname,userid,password,age,dateofbirth,role,gender,mobile,active from Employee where userid=? ");
			st.setString(1, userid);
			ResultSet rst=st.executeQuery();
			
			if(rst!=null) {
			while(rst.next()) {
				emp=rst.getInt("empid");
				first=rst.getString("firstname");
				last=rst.getString("lastname");
				user=rst.getString("userid");
				pas=rst.getString("password");
				ag=rst.getString("age");
				dob=rst.getString("dateofbirth");
				ro=rst.getString("role");
				ge=rst.getString("gender");
				mo=rst.getString("mobile");
				//sk=rst.getString("skills");
				ac=rst.getString("active");
				model.addRow(new Object[]{emp, first, last, user,pas,ag,dob,ro,ge,mo,ac});	
				}  }
			conn.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception ex)
		{
		JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
		JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		//Declare Buttons
		btn1=new JButton("Logout");
		btn1.setBounds(980, 160,150, 25);
		btn1.addActionListener(this);
		btn2=new JButton("Update");
		btn2.setBounds(980, 260,150, 25);
		btn2.addActionListener(this);
		lti=new JLabel("ex");
		lti.setBounds(250, 120,150, 25);
		
		//Adding buttons
		add(table);
		add(btn1);
		add(btn2);
		add(lti);
		
		setVisible(true);
		setSize(800, 700);
		setLayout(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1)
		{ dispose();
		 LoginSet log=new LoginSet();
		 log.setVisible(true);
		 }
		
		
	}
	
}

public class EmployeeView {

	//public static void main(String[] args)
	public EmployeeView(String uid)
	{
		// TODO Auto-generated method stub
		Employee e=new Employee();
		e.Emp( uid);

	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
