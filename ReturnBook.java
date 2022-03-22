package lms;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;

@SuppressWarnings("serial")
public class ReturnBook extends JFrame {

	private JPanel ReturnbookPane;
	private JTextField textBook_Id, textUser_Id, textbookName, textstdName, textRollNo, textContactNo, adminIDtextField, IssueIdtextField, FinetextField;
	private JButton btnSearchBook,ReturnButton;
	private JDateChooser IssuedateChooser,DuedateChooser, ReturndateChooser ;
	private JComboBox comboBox;
	private BookCla book;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ReturnBook(final String username) {
		conn = DB.bdconnect();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("Return Book-My Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 494);
		ReturnbookPane = new JPanel();
		ReturnbookPane.setBackground(Color.DARK_GRAY);
		ReturnbookPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ReturnbookPane);
		ReturnbookPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 7));
		panel.setBounds(202, 22, 384, 57);
		ReturnbookPane.add(panel);
		
		JLabel ReturnbookLabel = new JLabel("Return Book");
		ReturnbookLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(ReturnbookLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 754, 22);
		ReturnbookPane.add(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		JMenuItem backMenuItem = new JMenuItem("Back");
		backMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu ad = new AdminMenu(username);
				ad.setVisible(true);
				setVisible(false);
			}
			
		});
		FileMenu.add(backMenuItem);
		
		JMenuItem exirMenuItem = new JMenuItem("Exit");
		exirMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		FileMenu.add(exirMenuItem);
		
		JMenuItem logoutMenuItem_1 = new JMenuItem("Logout");
		logoutMenuItem_1.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.main(null);
				setVisible(false);
			}
		});
		FileMenu.add(logoutMenuItem_1);
		
		JLabel IssueIdLabel = new JLabel("Issue Id");
		IssueIdLabel.setForeground(Color.WHITE);
		IssueIdLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		IssueIdLabel.setBounds(20, 117, 92, 27);
		ReturnbookPane.add(IssueIdLabel);
		
		JLabel adminIdLabel = new JLabel("Admin ID");
		adminIdLabel.setForeground(Color.WHITE);
		adminIdLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		adminIdLabel.setBounds(359, 118, 92, 24);
		ReturnbookPane.add(adminIdLabel);
		
		JLabel lblBookid = new JLabel("Book_Id");
		lblBookid.setForeground(Color.WHITE);
		lblBookid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBookid.setBounds(20, 159, 67, 24);
		ReturnbookPane.add(lblBookid);
		
		JLabel lblUserid = new JLabel("Student_Id");
		lblUserid.setForeground(Color.WHITE);
		lblUserid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserid.setBounds(359, 162, 92, 19);
		ReturnbookPane.add(lblUserid);
		
		textBook_Id = new JTextField();
		textBook_Id.setBounds(131, 162, 96, 24);
		ReturnbookPane.add(textBook_Id);
		textBook_Id.setColumns(10);
		
		textUser_Id = new JTextField();
		textUser_Id.setBounds(479, 161, 97, 25);
		ReturnbookPane.add(textUser_Id);
		textUser_Id.setColumns(10);
		
		IssueIdtextField = new JTextField();
		IssueIdtextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
				
			}
				}
		});
		IssueIdtextField.setBounds(131, 120, 96, 24);
		ReturnbookPane.add(IssueIdtextField);
		IssueIdtextField.setColumns(10);
		
		btnSearchBook = new JButton("Search");
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int IssueID = Integer.parseInt(IssueIdtextField.getText());
					String sql = "SELECT * FROM issuebook WHERE IssueId = '"+IssueID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						adminIDtextField.setText(rs.getString("AdminId"));
						textBook_Id.setText(rs.getString("BookId"));
						textbookName.setText(rs.getString("BookName"));
						textUser_Id.setText(rs.getString("StudentId"));
						textstdName.setText(rs.getString("StudentName"));
						textRollNo.setText(rs.getString("RollNo"));
						textContactNo.setText(rs.getString("ContactNo"));
						java.sql.Date Issuedate = rs.getDate("IssueDate");
						IssuedateChooser.setDate(Issuedate);
						java.sql.Date Duedate = rs.getDate("DueDate");
						DuedateChooser.setDate(Duedate);
						
						
						}
					else {
						JOptionPane.showMessageDialog(ReturnbookPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(ReturnbookPane,"Please Enter Issue ID.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(ReturnbookPane,e1);
				}
			}
		});
		btnSearchBook.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchBook.setBounds(247, 119, 89, 23);
		ReturnbookPane.add(btnSearchBook);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setBounds(20, 207, 130, 22);
		ReturnbookPane.add(lblBookName);
		
		JLabel lblName = new JLabel("Student Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(359, 204, 110, 29);
		ReturnbookPane.add(lblName);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setForeground(Color.WHITE);
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRollNo.setBounds(359, 258, 82, 14);
		ReturnbookPane.add(lblRollNo);
		
		JLabel lblDate = new JLabel("Issue Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(20, 251, 101, 33);
		ReturnbookPane.add(lblDate);
		
		
		textbookName = new JTextField();
		textbookName.setBounds(130, 204, 152, 33);
		ReturnbookPane.add(textbookName);
		textbookName.setColumns(10);
		
		textstdName = new JTextField();
		textstdName.setBounds(479, 204, 160, 33);
		ReturnbookPane.add(textstdName);
		textstdName.setColumns(10);
		
		textRollNo = new JTextField();
		textRollNo.setBounds(479, 251, 160, 33);
		ReturnbookPane.add(textRollNo);
		textRollNo.setColumns(10);
		
		JLabel lblNo = new JLabel("Contact No");
		lblNo.setForeground(Color.WHITE);
		lblNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNo.setBounds(359, 309, 92, 22);
		ReturnbookPane.add(lblNo);
		
		textContactNo = new JTextField();
		textContactNo.setBounds(479, 302, 160, 33);
		ReturnbookPane.add(textContactNo);
		textContactNo.setColumns(10);
		
		IssuedateChooser = new JDateChooser();
		IssuedateChooser.setBounds(129, 258, 171, 29);
		ReturnbookPane.add(IssuedateChooser);
		
		DuedateChooser = new JDateChooser();
		DuedateChooser.setBounds(131, 302, 171, 29);
		ReturnbookPane.add(DuedateChooser);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setForeground(Color.WHITE);
		lblDueDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDueDate.setBounds(20, 309, 82, 22);
		ReturnbookPane.add(lblDueDate);
		
		ReturndateChooser = new JDateChooser();
		ReturndateChooser.setBounds(131, 345, 171, 29);
		ReturnbookPane.add(ReturndateChooser);
		
		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setForeground(Color.WHITE);
		lblReturnDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReturnDate.setBounds(20, 352, 92, 22);
		ReturnbookPane.add(lblReturnDate);
		
		adminIDtextField = new JTextField();
		adminIDtextField.setBounds(479, 117, 97, 25);
		ReturnbookPane.add(adminIDtextField);
		adminIDtextField.setColumns(10);
		
		
		adminIDtextField.setEnabled(false);
		textBook_Id.setEnabled(false);
		textUser_Id.setEnabled(false);
		textbookName.setEnabled(false);
		textstdName.setEnabled(false);
		textRollNo.setEnabled(false);
		textContactNo.setEnabled(false);
		IssuedateChooser.setEnabled(false);
		DuedateChooser.setEnabled(false);
		
		ReturnButton = new JButton("Return");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int issueid = Integer.parseInt(IssueIdtextField.getText());
		    		int stdid = Integer.parseInt(textUser_Id.getText());
		    		int adminId = Integer.parseInt(adminIDtextField.getText());
		    		int Bookid = Integer.parseInt(textBook_Id.getText());
		    		String stdname = textstdName.getText();
		    		String Bookname = textbookName.getText();
		    		String RollNo = textRollNo.getText();
		    		long ContactNo = Long.parseLong(textContactNo.getText());
		    		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    		String issue;
		    		String due;
					String Return;
					issue = sdf.format(IssuedateChooser.getDate());
					due = sdf.format(DuedateChooser.getDate());
		    		try {
						Return = sdf.format(ReturndateChooser.getDate());}
			    	catch(NullPointerException e2){
							JOptionPane.showMessageDialog(ReturnbookPane,"Please Enter Return Date.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
							ReturndateChooser.grabFocus();
							return;}
		    		String IsReturned = "TRUE";
		    		//calculate_fine(issue,due,Return);
		    		book = new BookCla();
					book.return_book(issueid,stdid,adminId, stdname, Bookid, Bookname, RollNo, ContactNo, issue,due, Return,calculate_fine(issue,due,Return),IsReturned);
					ReturnButton.setEnabled(false);
					}
				
		    	   catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(ReturnbookPane,"Please Enter Details.", "Enter Details", JOptionPane.ERROR_MESSAGE);
						return;
					}
					catch(Exception e1 ) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(ReturnbookPane, e1);
					}
		            
				    
					
		    		
		    	}
			
		});
		ReturnButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		ReturnButton.setBounds(191, 409, 89, 35);
		ReturnbookPane.add(ReturnButton);
		
		JLabel FineLabel = new JLabel("Fine");
		FineLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		FineLabel.setForeground(Color.WHITE);
		FineLabel.setBounds(369, 352, 46, 29);
		ReturnbookPane.add(FineLabel);
		
		FinetextField = new JTextField();
		FinetextField.setBounds(479, 351, 160, 33);
		ReturnbookPane.add(FinetextField);
		FinetextField.setColumns(10);
		FinetextField.setEnabled(false);
		
		JButton ClearButton = new JButton("Clear");
		ClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    IssueIdtextField.setText("");
				    adminIDtextField.setText("");
		    		textBook_Id.setText("");
		    		textbookName.setText("");
					textUser_Id.setText("");
					textstdName.setText("");
					textRollNo.setText("");
					textContactNo.setText("");
					IssuedateChooser.setDate(null);
					DuedateChooser.setDate(null);
					ReturndateChooser.setDate(null);
					FinetextField.setText("");
					ReturnButton.setEnabled(true);
					
			}
			
		});
		ClearButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		ClearButton.setBounds(311, 409, 89, 35);
		ReturnbookPane.add(ClearButton);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu ad = new AdminMenu(username);
				ad.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(429, 409, 89, 35);
		ReturnbookPane.add(btnNewButton);
		
		comboBox = new JComboBox();
		   comboBox.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		try {
					stmt = conn.createStatement();
					String id = (String) comboBox.getSelectedItem();
					if (id == "Select IssueID") {
					    IssueIdtextField.setText("");
					    adminIDtextField.setText("");
			    		textBook_Id.setText("");
			    		textbookName.setText("");
						textUser_Id.setText("");
						textstdName.setText("");
						textRollNo.setText("");
						textContactNo.setText("");
						IssuedateChooser.setDate(null);
						DuedateChooser.setDate(null);
	
						
					}
					else {
					String sql = "SELECT * FROM issuebook WHERE IssueId = '"+id+"'";
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						IssueIdtextField.setText(rs.getString("IssueId"));
					    adminIDtextField.setText(rs.getString("AdminId"));
			    		textBook_Id.setText(rs.getString("BookId"));
			    		textbookName.setText(rs.getString("BookName"));
						textUser_Id.setText(rs.getString("StudentId"));
						textstdName.setText(rs.getString("StudentName"));
						textRollNo.setText(rs.getString("RollNo"));
						textContactNo.setText(rs.getString("ContactNo"));
						java.sql.Date date = rs.getDate("IssueDate");
					    IssuedateChooser.setDate(date);
					    java.sql.Date date1 = rs.getDate("DueDate");
						DuedateChooser.setDate(date1);
						}
					}}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(ReturnbookPane,e1);
				}

		   	
		   	}});
		   comboBox.setBounds(132, 87, 204, 22);
		   ReturnbookPane.add(comboBox);
		   comboBox.addItem("Select IssueID");
		   comboBox.setSelectedItem("Select IssueID");
		   
		   JButton refreshButton_1 = new JButton("Refresh");
		   refreshButton_1.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		ReturnBook frame = new ReturnBook(username);
				frame.setVisible(true);
				setVisible(false);
		   		
		   		
		   	}
		   });
		   refreshButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		   refreshButton_1.setBounds(550, 410, 89, 35);
		   ReturnbookPane.add(refreshButton_1);
		   fill_combo();
	}
	
	
	private void fill_combo() {
	       try {
		   stmt = conn.createStatement();
		   String s = "False";
		   String sql = "SELECT * FROM issuebook WHERE IsReturned = '"+s+"'";
		   rs = stmt.executeQuery(sql);
		   while (rs.next()) {
			String id = rs.getString("IssueId");
			comboBox.addItem(id);
		}
			}
	     catch(Exception e1) {
		  JOptionPane.showMessageDialog(ReturnbookPane,e1);
	}
	    }   
	    private int fine;
	public int calculate_fine (String issue, String due, String Return) {
		try {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");		    		
		Date i = sdf1.parse(issue);
		Date d = sdf1.parse(due);
		Date r = sdf1.parse(Return);	
		long diff1 =( d.getTime() - i.getTime());
		int valid = (int) (TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS));
		long diff2 = (r.getTime() - i.getTime());
		int notvalid = (int) (diff2/(24*60*60*1000));
		int days = notvalid - valid;
		if (days > 0) {
		   fine = days*10;
		   FinetextField.setText(""+fine+"PKR");	
		  
		}
		else {
			fine = 0;
			FinetextField.setText(""+fine+"PKR");
			
		}
		}
		catch(Exception e1 ) {
			JOptionPane.showMessageDialog(ReturnbookPane, e1);
		}
		return fine;
		
		
	}
}
