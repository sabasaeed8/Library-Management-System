package lms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Users {
    long ContactNo;
	String DOB;
	String  Name, FName, Username, Password, Address, Email;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	//*********SETTER MATHODS****************
	
	public void setName(String Name){
		this.Name = Name;
	}
	public void setFName(String FName){
		this.FName = FName;
	}
	public void setDOB(String DOB){
		this.DOB = DOB;
	}
	public void setAddress(String Address){
		this.Address = Address;
	}
	public void setContactNo(long ContactNo){
		this.ContactNo = ContactNo;
	}
	public void setUsername(String Username){
		this.Username = Username;
	}
	public void setPassword(String Password){
		this.Password = Password;
	}
	public void setEmail(String Email){
		this.Email = Email;
	}
	public void setChangepass(String changePass){
		this.Password = changePass;	
	}
	
	//*********GETTER MATHODS****************
	
	public String getName(){
		return Name;
	}
	public String getFName(){
		return FName;
	}
	public String getDOB(){
		return DOB;
	}
	public String getAddress(){
		return Address;
	}
	public long getContactNo(){
		return ContactNo;
	}
	public String getUsername(){
		return Username;
	}
	public String getPassword(){
		return Password;
	}
	public String getEmail(){
		return Email;
	}
	public String getChangepass(){
		return Password;	
	}
	
	public ResultSet stdpass(String username) {
		conn = DB.bdconnect();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM students WHERE Username = '"+username+"'";
			rs = stmt.executeQuery(sql);}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
		}
		return rs;
	}
	
	public ResultSet adminpass(String username) {
		conn = DB.bdconnect();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM admin WHERE Username = '"+username+"'";
			rs = stmt.executeQuery(sql);}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
		}
		return rs;
	}
	
	public void update_studentpass(String Username, String Password) {
	  int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your password?","Change Password", JOptionPane.YES_NO_OPTION);
	  if (p==0) {
	   try {
		conn = DB.bdconnect();
		stmt = conn.createStatement();
		String sql = "UPDATE students SET Password = '"+Password+"' WHERE Username ='"+Username+"'";
		stmt.executeUpdate(sql);
	    JOptionPane.showMessageDialog(null, "Your Password has been changed.");}
	   
	   catch(Exception e) {
		   JOptionPane.showMessageDialog(null, e);

}   
  }
	  }
	public void update_adminpass(String Username, String Password) {
		  int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your password?","Change Password", JOptionPane.YES_NO_OPTION);
		  if (p==0) {
		   try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "UPDATE admin SET Password = '"+Password+"' WHERE Username ='"+Username+"'";
			stmt.executeUpdate(sql);
		    JOptionPane.showMessageDialog(null, "Your Password has been changed.");}
		   
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);

	}   
	  }
		  }
	
	}
	


