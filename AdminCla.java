package lms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JOptionPane;

public class AdminCla extends Users {
	private int adminID;
	private static int Numofadmin;
	private StudentCla std;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	

    public void setadminID(int libID) {
		adminID = libID;
	}
	public int getadminID() {
		try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "Select max(ID) from admin ";
			rs = ((Statement) stmt).executeQuery(sql);
			while(rs.next()) {
			this.adminID= Integer.parseInt(rs.getString("max(ID)"));
			
		}}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return adminID;
	}
	public int getNumofadmin() {
     try {
			
			Connection conn = DB.bdconnect();
			Statement stmt = conn.createStatement();
			String sql = "Select count(ID) from admin ";
			ResultSet rs = ((Statement) stmt).executeQuery(sql);
			while (rs.next()) {
			Numofadmin = Integer.parseInt(rs.getString("count(ID)"));}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);}
		
		return Numofadmin;
	}

	public void add_admin(String Name, String FName, String DOB, long ContactNo,String Email, String Username,String Password,String Address) {
		this.Name = Name;
		this.FName = FName;
		this.DOB = DOB;
		this.ContactNo = ContactNo;
		this.Email = Email;
		this.Username = Username;
		this.Password = Password;
		this.Address = Address;	
	    try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "INSERT INTO admin(Name, FatherName, DOB, ContactNo, Email, Username, Password, Address) VALUES ('"+Name+"','"+FName+"','"+DOB+"','"+ContactNo+"','"+Email+"','"+Username+"','"+Password+"','"+Address+"')";
			stmt.executeUpdate(sql);
		    JOptionPane.showMessageDialog(null, "Admin is added successfully. ");
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }
			
		}
	 public void already_exist(String Name, String FName, String DOB, long ContactNo, String Email, String Username, String Password, String Address) {
		this.Name = Name;
		this.FName = FName;
		this.DOB = DOB;
		this.ContactNo = ContactNo;
		this.Email = Email;
		this.Username = Username;
		this.Password = Password;
		this.Address = Address;	
		std = new StudentCla();
		try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM admin WHERE Name = '"+Name+"' && FatherName = '"+FName+"' && DOB = '"+DOB+"' ";
			rs = ((Statement) stmt).executeQuery(sql);
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "This Admin already exists.");
	    		return;}	
			else if (already_exist_user(Username)) {
				JOptionPane.showMessageDialog(null, "The username "+Username+" already exists. Please use a different username.");
				return;
			}
			else if (std.already_exist_user(Username)) {
				JOptionPane.showMessageDialog(null, "The username "+Username+" already exists. Please use a different username.");
				return;
			}
			else {
				add_admin(Name, FName, DOB, ContactNo, Email, Username, Password, Address);
			}}
		 catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
			   }
		   }	
	
	 public boolean already_exist_user(String username) {
		this.Username = username;
		try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM admin WHERE Username = '"+username+"'";
			rs = ((Statement) stmt).executeQuery(sql);
			if (rs.next()) {
				return true;
			}
			else {
				return false;
			}
		    
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }
		return true;
		
	}
	 
	 public void update_admin(int ID , String Name, String FName, String DOB, long ContactNo, String Email, String Username, String Password, String Address) {
		    this.adminID = ID;
		    this.Name = Name;
			this.FName = FName;
			this.DOB = DOB;
			this.ContactNo = ContactNo;
			this.Email = Email;
			this.Username = Username;
			this.Password = Password;
			this.Address = Address;	
		  int p = JOptionPane.showConfirmDialog(null, "Do you really want to Update?","Update", JOptionPane.YES_NO_OPTION);
		  if (p==0) {
		   try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "UPDATE admin SET Name='"+Name+"', FatherName='"+FName+"', DOB='"+DOB+"', ContactNo='"+ContactNo+"', Email='"+Email+"', Username = '"+Username+"', Password = '"+Password+"', Address = '"+Address+"' WHERE ID ='"+adminID+"'";
			stmt.executeUpdate(sql);
		    JOptionPane.showMessageDialog(null, "Admin is successfully Updated");}
		   
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
	
	}   
	   }}
	 public void delete_admin(int adminID) {
		   this.adminID = adminID;
		   int d = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?","Delete", JOptionPane.YES_NO_OPTION);
		  if (d==0) {
		   try {
			   conn = DB.bdconnect();
			   stmt = conn.createStatement();
			   String sql = "DELETE FROM admin WHERE ID ='"+adminID+"'";
			   stmt.executeUpdate(sql);
			   JOptionPane.showMessageDialog(null, "Admin is Deleted");
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }
	   }
	   }	
}
