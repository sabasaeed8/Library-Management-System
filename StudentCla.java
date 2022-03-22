package lms;

import java.sql.*;

import javax.swing.JOptionPane;

public class StudentCla extends Users {
	private String Department,Rollno;	
	private int StudentID ;
	private static int NumofStu;
	private AdminCla ad;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
   
	
	//*********SETTER MATHODS****************
	
	public void setDepartment(String Department){
		this.Department = Department;
	}
	public void setRollno(String Rollno){
		this.Rollno = Rollno;
	}
	public  void setStudentID(int StuID){
		this.StudentID = StuID;
	}
	
	//*********GETTER MATHODS****************
	
	public String getDepartment(){
		return Department;
	}
	public String getRollno(){
		return Rollno;
	}
	public int getStudentID(){
		try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "Select max(ID) from students ";
			rs = ((Statement) stmt).executeQuery(sql);
			while(rs.next()) {
			this.StudentID= Integer.parseInt(rs.getString("max(ID)"));
			
		}}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return StudentID;
	}
		
	public int getNumofStudents()  {
	  try {
		
		Connection conn = DB.bdconnect();
		Statement stmt = conn.createStatement();
		String sql = "Select count(ID) from students ";
		ResultSet rs = ((Statement) stmt).executeQuery(sql);
		while (rs.next()) {
		NumofStu = Integer.parseInt(rs.getString("count(ID)"));}
	}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);}
	
	return NumofStu;
}
	
	//**************Methods**********
	
	public void add_student(String Name,String FName,String DOB,String Department,String Rollno,long ContactNo,String Email,
			String Username,String Password,String Address) {
		
		
	    conn =  DB.bdconnect();
		this.Name = Name;
		this.FName = FName;
		this.DOB = DOB;
		this.Department = Department; 
		this.Rollno = Rollno ;
		this.ContactNo = ContactNo;
		this.Email = Email;
		this.Username = Username;
		this.Password = Password;
		this.Address = Address;	
	   try { 
	 
	    stmt = conn.createStatement();
	    String sql = "INSERT INTO students(Name, FatherName, DOB, Department, RollNo, ContactNo, Email, Username, Password, Address ) VALUES ('"+Name+"','"+FName+"','"+DOB+"','"+Department+"','"+Rollno+"','"+ContactNo+"','"+Email+"','"+Username+"','"+Password+"','"+Address+"');";
	    stmt.executeUpdate(sql);
	    JOptionPane.showMessageDialog(null, "Student is added.");
	   }
	   catch(Exception e) {
		   JOptionPane.showMessageDialog(null, e);
	   }
	}
	
	public void already_exist(String Name,String FName,String DOB,String Department,String Rollno,long ContactNo,String Email,
			String Username,String Password,String Address) {
		
	   
		this.Name = Name;
		this.FName = FName;
		this.DOB = DOB;
		this.Department = Department; 
		this.Rollno = Rollno ;
		this.ContactNo = ContactNo;
		this.Email = Email;
		this.Username = Username;
		this.Password = Password;
		this.Address = Address;	
		ad = new AdminCla();
		try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM students WHERE Name = '"+Name+"' && FatherName = '"+FName+"' && DOB = '"+DOB+"' ";
			rs = ((Statement) stmt).executeQuery(sql);
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "This Student already exists.");
	    		return;}	
			else if (already_exist_user(Username)) {
				JOptionPane.showMessageDialog(null, "The username "+Username+" already exists. Please use a different username.");
			}
			else if (ad.already_exist_user(Username)) {
				JOptionPane.showMessageDialog(null, "The username "+Username+" already exists. Please use a different username.");
			}
			else {
				add_student(Name, FName, DOB,Department, Rollno, ContactNo, Email, Username, Password, Address);
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
			String sql = "SELECT * FROM students WHERE Username = '"+username+"'";
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
	 
	 public void update_student(int ID, String Name,String FName,String DOB,String Department,String Rollno,long ContactNo,String Email,
				String Username,String Password,String Address) {
		    this.StudentID = ID;
		    this.Name = Name;
			this.FName = FName;
			this.DOB = DOB;
			this.Department = Department; 
			this.Rollno = Rollno ;
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
			String sql = "UPDATE students SET Name='"+Name+"', FatherName='"+FName+"', DOB='"+DOB+"',Department = '"+Department+"',RollNo = '"+Rollno+"', ContactNo='"+ContactNo+"', Email='"+Email+"', Username = '"+Username+"', Password = '"+Password+"', Address = '"+Address+"' WHERE ID ='"+StudentID+"'";
			stmt.executeUpdate(sql);
		    JOptionPane.showMessageDialog(null, "Student is successfully Updated");}
		   
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
	
	}   
	   }}
	 public void delete_student(int StudentID) {
		   this.StudentID = StudentID;
		   int d = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?","Delete", JOptionPane.YES_NO_OPTION);
		  if (d==0) {
		   try {
			   conn = DB.bdconnect();
			   stmt = conn.createStatement();
			   String sql = "DELETE FROM students WHERE ID ='"+StudentID+"'";
			   stmt.executeUpdate(sql);
			   JOptionPane.showMessageDialog(null, "Student is Deleted");
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }
	   }
	   }	
	  
    

	
}

