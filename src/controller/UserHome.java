package controller;

import loginFrame.EmployeeView;
import loginFrame.HRView;
import loginFrame.PmeView;


public class UserHome {

	public UserHome(String uid, String pass, String role) {
		if(role.contentEquals("HRA")) {
			HRView vhr=new HRView();
			
			vhr.setVisible(true);
			
			
			
		}
		else if(role.contentEquals("PME"))
		{
			PmeView vpm=new PmeView(uid);
			vpm.setVisible(true);
		}
		else {
			 EmployeeView  vem=new EmployeeView( uid);
			vem.setVisible(true);
		}
	}

	public void setTittle(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		
		
	}

}
