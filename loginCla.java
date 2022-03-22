package lms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;




public class loginCla {
	
	Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
	public ResultSet std(String username,String password) {
		conn = DB.bdconnect();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM students WHERE Username = '"+username+"' && Password = '"+password+"'";
			rs = stmt.executeQuery(sql);}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
		}
		return rs;
	}
	
	public ResultSet admin(String username,String password) {
		conn = DB.bdconnect();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM admin WHERE Username = '"+username+"' && Password = '"+password+"'";
			rs = stmt.executeQuery(sql);}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
		}
		return rs;
	}
	

}
