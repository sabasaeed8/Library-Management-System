package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
public class DB {
	Connection con = null;
	PreparedStatement  pst;
	public static Connection bdconnect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql:///library management system","root","");
			return conn;
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
			 return null;
		}
	}

}
