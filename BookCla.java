package lms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class BookCla {
	private String name, author, publisher, Edition;
	private int bookId, Bookquantity, IssueID;
	private static int numofbooks;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
   
	
	
	//*********** GETTER METHODS ***********
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public int getBookId() {
	   try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "Select max(ID) from book ";
			rs = ((Statement) stmt).executeQuery(sql);
			while(rs.next()) {
			bookId= Integer.parseInt(rs.getString("max(ID)"));
			
		}}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	    return bookId;
	}
	
	//*********** SETTER METHODS ***********
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getEdition() {
		return Edition;
	}
	public void setEdition(String edition) {
		this.Edition = edition;
	}
	public int getBookquantity() {
		return Bookquantity;
	}
	public void setBookquantity(int bookquantity) {
		this.Bookquantity = bookquantity;
	}
	public static int getNumofbooks() {
		try {
			
			Connection conn = DB.bdconnect();
			Statement stmt = conn.createStatement();
			String sql = "Select count(ID) from book ";
			ResultSet rs = ((Statement) stmt).executeQuery(sql);
			while (rs.next()) {
			numofbooks = Integer.parseInt(rs.getString("count(ID)"));}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return numofbooks;
		
	}
	public static void setNumofbooks(int numofbooks) {
		BookCla.numofbooks = numofbooks;
	}
	
	public int getIssueID() {
		try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "Select max(IssueId) from issuebook ";
			rs = ((Statement) stmt).executeQuery(sql);
			while(rs.next()) {
			IssueID= Integer.parseInt(rs.getString("max(IssueId)"));
			
		}}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return IssueID;
	}
	public void setIssueID(int issueID) {
		IssueID = issueID;
	}
	
	//************* ADD BOOK ****************************
	public void add_book(String name,String author,String publisher,String Edition,int Bookquantity) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.Edition = Edition;
		this.Bookquantity = Bookquantity;
		try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "INSERT INTO book(Name, Author, Edition, Publisher, Quantity) VALUES ('"+name+"','"+author+"','"+Edition+"','"+publisher+"','"+Bookquantity+"')";
			stmt.executeUpdate(sql);
		    JOptionPane.showMessageDialog(null, "Book is added successfully. ");
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }

			
		}
	public void already_exist(String name,String author,String publisher,String Edition,int Bookquantity) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.Edition = Edition;
		try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM book WHERE Name = '"+name+"' && Author = '"+author+"' && Edition = '"+Edition+"' && Publisher = '"+publisher+"' ";
			rs = ((Statement) stmt).executeQuery(sql);
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "This Book is already registered.");
				return;
			}
			else {
				add_book(name,author,publisher,Edition,Bookquantity);
			}
		    
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }
		
	}
	
	   public void update_book(int ID, String name,String author,String publisher,String Edition,int Bookquantity) {
		   
	      this.bookId = ID;
		  this.name = name;
		  this.author = author;
		  this.publisher = publisher;
		  this.Edition = Edition;
		  this.Bookquantity = Bookquantity;
		  int p = JOptionPane.showConfirmDialog(null, "Do you really want to Update?","Update", JOptionPane.YES_NO_OPTION);
		  if (p==0) {
		   try {
			conn = DB.bdconnect();
			stmt = conn.createStatement();
			String sql = "UPDATE book SET Name='"+name+"', Author='"+author+"', Edition='"+Edition+"', Publisher='"+publisher+"', Quantity='"+Bookquantity+"' WHERE ID ='"+bookId+"'";
			stmt.executeUpdate(sql);
		    JOptionPane.showMessageDialog(null, "Data is successfully Updated");}
		   
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
	
	}   
	   }}
	   public void delete_book(int bookId) {
		   this.bookId = bookId;
		   int d = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?","Delete", JOptionPane.YES_NO_OPTION);
		  if (d==0) {
		   try {
			   conn = DB.bdconnect();
			   stmt = conn.createStatement();
			   String sql = "DELETE FROM book WHERE ID ='"+bookId+"'";
			   stmt.executeUpdate(sql);
			   JOptionPane.showMessageDialog(null, "Data is Deleted");
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }
		   
	   }
	   }
	   
	   public ResultSet View_books() {
		   try {
			   conn = DB.bdconnect();
			   stmt = conn.createStatement();
			   String sql = "SELECT * FROM book";
			   rs = stmt.executeQuery(sql);
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }
		   return rs;
}
	   public void issue_book(int stdid,int adminId, String stdName, int bookid, String bookName, String RollNo, long ContactNo, String issuedate, String duedate, String IsReturned) {
		   try {
				conn = DB.bdconnect();
				stmt = conn.createStatement();
				String sql = "INSERT INTO issuebook(StudentId, AdminId, StudentName, BookId, BookName, RollNo, ContactNo, IssueDate, DueDate,IsReturned) VALUES ('"+stdid+"','"+adminId+"','"+stdName+"','"+bookid+"','"+bookName+"','"+RollNo+"','"+ContactNo+"','"+issuedate+"', '"+duedate+"','"+IsReturned+"')";
				int i = stmt.executeUpdate(sql);
				if (i>0) {
			    JOptionPane.showMessageDialog(null, "Book Issued Successfully. ");
				}
				else {
					JOptionPane.showMessageDialog(null, "error ");
				}
			   }
			   catch(Exception e) {
				   JOptionPane.showMessageDialog(null, e);
			   }
		   
	   }
	   public void View_IssueBooks(JTable table) {
		   try {
			   conn = DB.bdconnect();
			   stmt = conn.createStatement();
			   String sql = "SELECT * FROM issuebook";
			   rs = stmt.executeQuery(sql);
			   table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }}
	   
	   public void return_book(int issueId, int stdid,int adminId, String stdName, int bookid, String bookName, String RollNo, long ContactNo, String issuedate,String duedate, String returndate, int fine, String IsReturned ) {
		   try {
				conn = DB.bdconnect();
				stmt = conn.createStatement();
				String sql = "INSERT INTO returnbook(AdminId, BookId, BookName, StudentId, StudentName, RollNo, ContactNo, IssueDate,DueDate, ReturnDate, Fine) VALUES ('"+adminId+"','"+bookid+"','"+bookName+"','"+stdid+"','"+stdName+"','"+RollNo+"','"+ContactNo+"','"+issuedate+"','"+duedate+"','"+returndate+"','"+fine+"')";
				int i = stmt.executeUpdate(sql);
				
					//conn = DB.bdconnect();
				Statement stmt1 = conn.createStatement();
				String sql1 = "UPDATE issuebook SET AdminId='"+adminId+"', BookId='"+bookid+"', BookName='"+bookName+"',StudentId = '"+stdid+"',StudentName = '"+stdName+"',RollNo='"+RollNo+"', ContactNo='"+ContactNo+"', IssueDate='"+issuedate+"', DueDate = '"+duedate+"',IsReturned = '"+IsReturned+"' WHERE IssueId ='"+issueId+"'";
				int j = stmt1.executeUpdate(sql1);
				   
				if (i>0 && j>0) {
			    JOptionPane.showMessageDialog(null, "Book Returned Successfully. ");
				}
				else {
					JOptionPane.showMessageDialog(null, "error ");
				}
			   }
			   catch(Exception e) {
				   e.printStackTrace();
				  // JOptionPane.showMessageDialog(null, e);
			   }
	   }
		   
		  public void View_returnBooks (JTable table) {
			   try {
				   conn = DB.bdconnect();
				   stmt = conn.createStatement();
				   String sql = "SELECT * FROM returnbook";
				   rs = stmt.executeQuery(sql);
				   table.setModel(DbUtils.resultSetToTableModel(rs));
			   }
			   catch(Exception e) {
				   JOptionPane.showMessageDialog(null, e);
			   }
		  }
		  public void update_issuebook(String issueid, int stdid,int adminId, String stdName, int bookid, String bookName, String RollNo, long ContactNo, String issuedate, String duedate,String IsReturned) {
			  int p = JOptionPane.showConfirmDialog(null, "Do you really want to Update?","Update", JOptionPane.YES_NO_OPTION);
			  if (p==0) {
			   try {
				conn = DB.bdconnect();
				stmt = conn.createStatement();
				String sql = "UPDATE issuebook SET AdminId='"+adminId+"', BookId='"+bookid+"', BookName='"+bookName+"',StudentId = '"+stdid+"',StudentName = '"+stdName+"',RollNo='"+RollNo+"', ContactNo='"+ContactNo+"', IssueDate='"+issuedate+"', DueDate = '"+duedate+"',IsReturned = '"+IsReturned+"' WHERE IssueId ='"+issueid+"'";
				stmt.executeUpdate(sql);
			    JOptionPane.showMessageDialog(null, "IssueBook is successfully Updated");}
			   
			   catch(Exception e) {
				   JOptionPane.showMessageDialog(null, e);}
			   

			   }
}
		  public void delete_issuebook(String issueId) {
			   //this.bookId = bookId;
			   int d = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?","Delete", JOptionPane.YES_NO_OPTION);
			  if (d==0) {
			   try {
				   conn = DB.bdconnect();
				   stmt = conn.createStatement();
				   String sql = "DELETE FROM issuebook WHERE IssueId ='"+issueId+"'";
				   stmt.executeUpdate(sql);
				   JOptionPane.showMessageDialog(null, "Data is Deleted");
			   }
			   catch(Exception e) {
				   JOptionPane.showMessageDialog(null, e);
			   }
		   }
		   }}