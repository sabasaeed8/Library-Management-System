package lms;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Issuebook extends JFrame {
	

	private JPanel IssuebookPane;
	private JTextField textBook_id,textUser_id,textbookName,textAuthor,textEdition,textpublisher,textstdName,
	textFatherName,textDOB,textdep,textRollNo,textContactNo,StextField;
	private JComboBox BookcomboBox,stdcomboBox,SearchcomboBox;
	private JButton btnSearchBook,btnSearchUser,issueButton,isButton,upButton,delButton,updateButton, deleteButton;
	private JDateChooser IssuedateChooser, DuedateChooser;
	private BookCla book;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	private JTextField IssueIDtextField;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel adminIdLabel;
	private JTextField adminIDtextField;
	private String bookID, studentID;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issuebook frame = new Issuebook();
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
	@SuppressWarnings("unchecked")
	public Issuebook(final String username) {
		conn = DB.bdconnect();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("Issue Book-My Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1355, 654);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
		IssuebookPane = new JPanel();
		IssuebookPane.setBackground(Color.GRAY);
		IssuebookPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(IssuebookPane);
		IssuebookPane.setLayout(null);
		
		JLabel lblBookid = new JLabel("Book_Id");
		lblBookid.setForeground(Color.WHITE);
		lblBookid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBookid.setBounds(20, 233, 67, 24);
		IssuebookPane.add(lblBookid);
		
		JLabel lblUserid = new JLabel("Student_Id");
		lblUserid.setForeground(Color.WHITE);
		lblUserid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserid.setBounds(359, 236, 92, 19);
		IssuebookPane.add(lblUserid);
		
		textBook_id = new JTextField();
		textBook_id.addKeyListener(new KeyAdapter() {
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
		textBook_id.setBounds(112, 231, 96, 24);
		IssuebookPane.add(textBook_id);
		textBook_id.setColumns(10);
		
		textUser_id = new JTextField();
		textUser_id.addKeyListener(new KeyAdapter() {
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
		textUser_id.setBounds(472, 235, 97, 25);
		IssuebookPane.add(textUser_id);
		textUser_id.setColumns(10);
		
		btnSearchBook = new JButton("Search");
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int bookID = Integer.parseInt(textBook_id.getText());
					String sql = "SELECT * FROM book WHERE ID = '"+bookID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						textbookName.setText(rs.getString("Name"));
						textAuthor.setText(rs.getString("Author"));
						textEdition.setText(rs.getString("Edition"));
						textpublisher.setText(rs.getString("Publisher"));
						//textquantity.setText(rs.getString("Quantity"));
						}
					else {
						JOptionPane.showMessageDialog(IssuebookPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(IssuebookPane,"Please Enter Book ID.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(IssuebookPane,e1);
				}
			}
		});
		btnSearchBook.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchBook.setBounds(218, 234, 89, 23);
		IssuebookPane.add(btnSearchBook);
		
		btnSearchUser = new JButton("Search");
		btnSearchUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int studentID = Integer.parseInt(textUser_id.getText());
					String sql = "SELECT * FROM students WHERE ID = '"+studentID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						textstdName.setText(rs.getString("Name"));
						textFatherName.setText(rs.getString("FatherName"));
						textDOB.setText(rs.getString("DOB"));
						textdep.setText(rs.getString("Department"));
						textRollNo.setText(rs.getString("RollNo"));
						textContactNo.setText(rs.getString("ContactNo"));
						}							
					else {
						JOptionPane.showMessageDialog(IssuebookPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(IssuebookPane,"Please Enter Student ID.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(IssuebookPane,e1);
				}
			}
		});
		btnSearchUser.setBounds(579, 234, 89, 23);
		IssuebookPane.add(btnSearchUser);
		
		JLabel lblBookName = new JLabel("Name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setBounds(20, 274, 67, 26);
		IssuebookPane.add(lblBookName);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAuthor.setBounds(20, 320, 67, 14);
		IssuebookPane.add(lblAuthor);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdition.setForeground(Color.WHITE);
		lblEdition.setBounds(20, 358, 67, 29);
		IssuebookPane.add(lblEdition);
		
		JLabel publisherlbl = new JLabel("Publisher");
		publisherlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		publisherlbl.setForeground(Color.WHITE);
		publisherlbl.setBounds(20, 404, 82, 14);
		IssuebookPane.add(publisherlbl);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(359, 286, 60, 14);
		IssuebookPane.add(lblName);
		
		JLabel lblFatherNmae = new JLabel("Father's Name");
		lblFatherNmae.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFatherNmae.setForeground(Color.WHITE);
		lblFatherNmae.setBounds(359, 320, 114, 14);
		IssuebookPane.add(lblFatherNmae);
		
		JLabel lblDOB = new JLabel("DOB");
		lblDOB.setForeground(Color.WHITE);
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDOB.setBounds(361, 365, 46, 14);
		IssuebookPane.add(lblDOB);
		
		JLabel lbldep = new JLabel("Department");
		lbldep.setForeground(Color.WHITE);
		lbldep.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldep.setBounds(359, 402, 92, 19);
		IssuebookPane.add(lbldep);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setForeground(Color.WHITE);
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRollNo.setBounds(359, 444, 82, 24);
		IssuebookPane.add(lblRollNo);
		
		JLabel lblDate = new JLabel("Issue Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(20, 440, 101, 33);
		IssuebookPane.add(lblDate);
		
	    issueButton = new JButton("Issue ");
	    issueButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    		int stdid = Integer.parseInt(textUser_id.getText());
	    		int adminId = Integer.parseInt(adminIDtextField.getText());
	    		String stdname = textstdName.getText();
	    		int Bookid = Integer.parseInt(textBook_id.getText());
	    		String Bookname = textbookName.getText();
	    		String RollNo = textRollNo.getText();
	    		long ContactNo = Long.parseLong(textContactNo.getText());
	    		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	    		String issue;
	    		String due;
	    		try {
				issue = sdf.format(IssuedateChooser.getDate());}
	    		catch(NullPointerException e2){
					JOptionPane.showMessageDialog(IssuebookPane,"Please Enter Issue Date.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
					IssuedateChooser.grabFocus();
					return;}
	    		try {
					due = sdf.format(DuedateChooser.getDate());}
		    		catch(NullPointerException e2){
						JOptionPane.showMessageDialog(IssuebookPane,"Please Enter Due Date.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
						DuedateChooser.grabFocus();
						return;}
	    		String IsReturned = "FALSE";
	    		book = new BookCla();
				book.issue_book(stdid, adminId, stdname, Bookid, Bookname, RollNo, ContactNo, issue, due,IsReturned);
	    		}
	    		catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(IssuebookPane,"Please Enter Details.", "Enter Details", JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(Exception e1 ) {
					JOptionPane.showMessageDialog(IssuebookPane, e1);
				}
	    		 
	    		book = new BookCla();
	    		IssueIDtextField.setText(book.getIssueID()+1 + "");
	    		textBook_id.setText("");
	    		textbookName.setText("");
				textAuthor.setText("");
				textEdition.setText("");
				textpublisher.setText("");
				textUser_id.setText("");
				textstdName.setText("");
				textFatherName.setText("");
				textDOB.setText("");
				textdep.setText("");
				textRollNo.setText("");
				textContactNo.setText("");
				IssuedateChooser.setDate(null);
				DuedateChooser.setDate(null);
				book = new BookCla();
				book.View_IssueBooks(table);
	    		
	    	}
	    });
	    issueButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		issueButton.setBounds(156, 545, 89, 35);
		IssuebookPane.add(issueButton);
		
		textbookName = new JTextField();
		textbookName.setBounds(112, 267, 152, 33);
		IssuebookPane.add(textbookName);
		textbookName.setColumns(10);
		
		textAuthor = new JTextField();
		textAuthor.setBounds(112, 311, 152, 33);
		IssuebookPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		textEdition = new JTextField();
		textEdition.setBounds(112, 351, 152, 37);
		IssuebookPane.add(textEdition);
		textEdition.setColumns(10);
		
		textpublisher = new JTextField();
		textpublisher.setBounds(112, 398, 152, 30);
		IssuebookPane.add(textpublisher);
		textpublisher.setColumns(10);
		
		textstdName = new JTextField();
		textstdName.setBounds(469, 272, 160, 33);
		IssuebookPane.add(textstdName);
		textstdName.setColumns(10);
		
		textFatherName = new JTextField();
		textFatherName.setBounds(469, 313, 160, 33);
		IssuebookPane.add(textFatherName);
		textFatherName.setColumns(10);
		
		textDOB = new JTextField();
		textDOB.setBounds(469, 352, 160, 34);
		IssuebookPane.add(textDOB);
		textDOB.setColumns(10);
		
		textdep = new JTextField();
		textdep.setBounds(469, 397, 160, 29);
		IssuebookPane.add(textdep);
		textdep.setColumns(10);
		
		textRollNo = new JTextField();
		textRollNo.setBounds(469, 437, 160, 33);
		IssuebookPane.add(textRollNo);
		textRollNo.setColumns(10);
		
		JLabel lblNo = new JLabel("Contact No");
		lblNo.setForeground(Color.WHITE);
		lblNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNo.setBounds(359, 488, 92, 19);
		IssuebookPane.add(lblNo);
		
		textContactNo = new JTextField();
		textContactNo.setBounds(469, 481, 160, 33);
		IssuebookPane.add(textContactNo);
		textContactNo.setColumns(10);
		
		IssuedateChooser = new JDateChooser();
		IssuedateChooser.setBounds(112, 439, 171, 29);
		IssuebookPane.add(IssuedateChooser);
		
		DuedateChooser = new JDateChooser();
		DuedateChooser.setBounds(112, 481, 171, 29);
		IssuebookPane.add(DuedateChooser);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setForeground(Color.WHITE);
		lblDueDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDueDate.setBounds(20, 490, 82, 14);
		IssuebookPane.add(lblDueDate);
		
		textbookName.setEnabled(false);
		textAuthor.setEnabled(false);
		textEdition.setEnabled(false);
		textpublisher.setEnabled(false);
		textstdName.setEnabled(false);
		textFatherName.setEnabled(false);
		textDOB.setEnabled(false);
		textdep.setEnabled(false);
		textRollNo.setEnabled(false);
		textContactNo.setEnabled(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		panel.setBounds(402, 11, 550, 73);
		IssuebookPane.add(panel);
		
		JLabel issuebookLabel = new JLabel("Issue Book");
		issuebookLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(issuebookLabel);
		
		JLabel IssueIDLabel = new JLabel("Issue ID");
		IssueIDLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		IssueIDLabel.setForeground(Color.WHITE);
		IssueIDLabel.setBounds(20, 160, 82, 31);
		IssuebookPane.add(IssueIDLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu ad = new AdminMenu(username);
				ad.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(504, 545, 89, 35);
		IssuebookPane.add(btnNewButton);
	
		
		IssueIDtextField = new JTextField();
		IssueIDtextField.setBounds(112, 162, 86, 31);
		IssuebookPane.add(IssueIDtextField);
		IssueIDtextField.setColumns(10);
		IssueIDtextField.setEnabled(false);
		book = new BookCla();
		IssueIDtextField.setText(book.getIssueID()+1 + "");
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(688, 114, 651, 407);
		IssuebookPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IssueID", "AdminID", "StudentID", "StudentName", "BookID", "BookName", "RollNo", "ContactNo", "IssueDate", "IsReturned"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		//*************************************** View Issue Books*************************
		book = new BookCla();
		book.View_IssueBooks(table);
		
		adminIdLabel = new JLabel("Admin ID");
		adminIdLabel.setForeground(Color.WHITE);
		adminIdLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		adminIdLabel.setBounds(359, 167, 92, 24);
		IssuebookPane.add(adminIdLabel);
		
		adminIDtextField = new JTextField();
		adminIDtextField.setBounds(472, 162, 86, 31);
		IssuebookPane.add(adminIDtextField);
		adminIDtextField.setColumns(10);
		adminIDtextField.setEnabled(false);
			try {
				stmt = conn.createStatement();
				String sql = "SELECT * FROM admin WHERE Username = '"+username+"'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
				adminIDtextField.setText(rs.getString("ID"));}
				}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null,e1);
			}
			
			StextField = new JTextField();
			StextField.addKeyListener(new KeyAdapter() {
				   	@Override
				   	public void keyReleased(KeyEvent e) {
				   		
				   		DefaultTableModel Table = (DefaultTableModel)table.getModel();
				   		String Search = StextField.getText();
				   		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Table);
				   		table.setRowSorter(tr);
				   		tr.setRowFilter(RowFilter.regexFilter(Search));
				   		/*try {
							conn = DB.bdconnect();
				   			stmt = conn.createStatement();
							String S = StextField.getText();
				   			String sql = "SELECT * FROM book WHERE ID = '"+S+"' ||  Name ='"+S+"' ||  Author = '"+S+"' || Edition = '"+S+"' ||  Publisher = '"+S+"' ";
							rs = stmt.executeQuery(sql);
							table.setModel(DbUtils.resultSetToTableModel(rs));}
					
						catch(Exception e1) {
							JOptionPane.showMessageDialog(BookPane,e1);
						}*/
				   		
				   		
				   	}
				   });
				   StextField.setBounds(1067, 79, 226, 27);
				   IssuebookPane.add(StextField);
				   StextField.setColumns(10);
				   
				   JLabel lblNewLabel = new JLabel("Search Record");
				   lblNewLabel.setForeground(Color.WHITE);
				   lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
				   lblNewLabel.setBounds(953, 80, 114, 26);
				   IssuebookPane.add(lblNewLabel);
				   
				   JLabel lblNewLabel_1 = new JLabel("");
				   lblNewLabel_1.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\search.JPG"));
				   lblNewLabel_1.setBounds(1293, 79, 46, 27);
				   IssuebookPane.add(lblNewLabel_1);
			
				   BookcomboBox = new JComboBox();
				   BookcomboBox.addActionListener(new ActionListener() {
				   	public void actionPerformed(ActionEvent e) {
				   		try {
							stmt = conn.createStatement();
							String name = (String) BookcomboBox.getSelectedItem();
							if (name == "Select Book Name") {
								textBook_id.setText("");
								textbookName.setText("");
								textAuthor.setText("");
								textEdition.setText("");
								textpublisher.setText("");
							}
							else {
							String sql = "SELECT * FROM book WHERE Name = '"+name+"'";
							rs = stmt.executeQuery(sql);
							while (rs.next()) {
								textBook_id.setText(rs.getString("ID"));
								textbookName.setText(rs.getString("Name"));
								textAuthor.setText(rs.getString("Author"));
								textEdition.setText(rs.getString("Edition"));
								textpublisher.setText(rs.getString("Publisher"));
								}
							}}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(IssuebookPane,e1);
						}

				   	
				   	}});
				   BookcomboBox.setBounds(112, 196, 204, 29);
				   IssuebookPane.add(BookcomboBox);
				   BookcomboBox.addItem("Select Book Name");
				   BookcomboBox.setSelectedItem("Select Book Name");
				  
			      
			      stdcomboBox = new JComboBox();
				  stdcomboBox.addActionListener(new ActionListener() {
				   	public void actionPerformed(ActionEvent e) {
				   		try {
							stmt = conn.createStatement();
							String name = (String) stdcomboBox.getSelectedItem();
							if (name == "Select Student Name") {
								textUser_id.setText("");
								textstdName.setText("");
								textFatherName.setText("");
								textDOB.setText("");
								textdep.setText("");
								textRollNo.setText("");
								textContactNo.setText("");
							}
							else {
							String sql = "SELECT * FROM students WHERE Name = '"+name+"'";
							rs = stmt.executeQuery(sql);
							while (rs.next()) {
								textUser_id.setText(rs.getString("ID"));
								textstdName.setText(rs.getString("Name"));
								textFatherName.setText(rs.getString("FatherName"));
								textDOB.setText(rs.getString("DOB"));
								textdep.setText(rs.getString("Department"));
								textRollNo.setText(rs.getString("RollNo"));
								textContactNo.setText(rs.getString("ContactNo"));
								}
							}}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(IssuebookPane,e1);
						}

				   	
				   	}});
				   stdcomboBox.setBounds(472, 196, 204, 29);
				   IssuebookPane.add(stdcomboBox);
				   stdcomboBox.addItem("Select Student Name");
				   stdcomboBox.setSelectedItem("Select Student Name");
				   
				   updateButton = new JButton("Update");
				   updateButton.addActionListener(new ActionListener() {
				   	public void actionPerformed(ActionEvent e) {
				   		try {
				   			String issueid = (String) SearchcomboBox.getSelectedItem();
				    		int stdid = Integer.parseInt(textUser_id.getText());
				    		int adminId = Integer.parseInt(adminIDtextField.getText());
				    		String stdname = textstdName.getText();
				    		int Bookid = Integer.parseInt(textBook_id.getText());
				    		String Bookname = textbookName.getText();
				    		String RollNo = textRollNo.getText();
				    		long ContactNo = Long.parseLong(textContactNo.getText());
				    		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				    		String issue;
				    		String due;
				    		try {
							issue = sdf.format(IssuedateChooser.getDate());}
				    		catch(NullPointerException e2){
								JOptionPane.showMessageDialog(IssuebookPane,"Please Enter Issue Date.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
								IssuedateChooser.grabFocus();
								return;}
				    		try {
								due = sdf.format(DuedateChooser.getDate());}
					    		catch(NullPointerException e2){
									JOptionPane.showMessageDialog(IssuebookPane,"Please Enter Due Date.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
									DuedateChooser.grabFocus();
									return;}
				    		String IsReturned = "FALSE";
				    		book = new BookCla();
							book.update_issuebook(issueid, stdid, adminId, stdname, Bookid, Bookname, RollNo, ContactNo, issue, due,IsReturned);
				    		}
				    		catch(NumberFormatException e1) {
								JOptionPane.showMessageDialog(IssuebookPane,"Please Enter Details.", "Enter Details", JOptionPane.ERROR_MESSAGE);
								return;
							}
							catch(Exception e1 ) {
							    JOptionPane.showMessageDialog(IssuebookPane, e1);
							}
				   		book = new BookCla();
						book.View_IssueBooks(table);
						textBook_id.setText("");
			    		textbookName.setText("");
						textAuthor.setText("");
						textEdition.setText("");
						textpublisher.setText("");
						textUser_id.setText("");
						textstdName.setText("");
						textFatherName.setText("");
						textDOB.setText("");
						textdep.setText("");
						textRollNo.setText("");
						textContactNo.setText("");
						IssuedateChooser.setDate(null);
						DuedateChooser.setDate(null);
				   	}
				   });
				   updateButton.setFont(new Font("Tahoma", Font.BOLD, 15));
				   updateButton.setBounds(266, 545, 89, 35);
				   IssuebookPane.add(updateButton);
				   
				   SearchcomboBox = new JComboBox();
				   SearchcomboBox.addActionListener(new ActionListener() {
				   	public void actionPerformed(ActionEvent e) {
				   		try {
							stmt = conn.createStatement();
							String id = (String) SearchcomboBox.getSelectedItem();
							if (id == "Select Issue ID") {
								textBook_id.setText("");
								textUser_id.setText("");
								textbookName.setText("");
								textAuthor.setText("");
								textEdition.setText("");
								textpublisher.setText("");
								textstdName.setText("");
								textFatherName.setText("");
								textDOB.setText("");
								textdep.setText("");
								textRollNo.setText("");
								textContactNo.setText("");
								IssuedateChooser.setCalendar(null);
								DuedateChooser.setCalendar(null);
							}
							else {
							String sql = "SELECT * FROM issuebook WHERE IssueId = '"+id+"'";
							rs = stmt.executeQuery(sql);
							while (rs.next()) {
								IssueIDtextField.setText(rs.getString("IssueId"));
								adminIDtextField.setText(rs.getString("AdminId"));
								textBook_id.setText(rs.getString("BookId"));
								textUser_id.setText(rs.getString("StudentId"));
								bookID = rs.getString("BookId");
								studentID = rs.getString("StudentId");
							java.sql.Date Issuedate = rs.getDate("IssueDate");
							IssuedateChooser.setDate(Issuedate);
							java.sql.Date Duedate = rs.getDate("DueDate");
							DuedateChooser.setDate(Duedate);}
							try {
								stmt = conn.createStatement();
								String sql2 = "SELECT * FROM book WHERE ID = '"+bookID+"'";
								ResultSet rs1 = stmt.executeQuery(sql2);
								if (rs1.next()) {
									textbookName.setText(rs1.getString("Name"));
									textAuthor.setText(rs1.getString("Author"));
									textEdition.setText(rs1.getString("Edition"));
									textpublisher.setText(rs1.getString("Publisher"));}}
							catch(Exception e2) {
								e2.printStackTrace();
								//JOptionPane.showMessageDialog(IssuebookPane,e2);
							}
								
							try {
								Statement stmt1 = conn.createStatement();
								String sql1 = "SELECT * FROM students WHERE ID = '"+studentID+"'";
								ResultSet rs2 = stmt1.executeQuery(sql1);
								if (rs2.next()) {
									textstdName.setText(rs2.getString("Name"));
									textFatherName.setText(rs2.getString("FatherName"));
									textDOB.setText(rs2.getString("DOB"));
									textdep.setText(rs2.getString("Department"));
									textRollNo.setText(rs2.getString("RollNo"));
									textContactNo.setText(rs2.getString("ContactNo"));}}
							catch(Exception e2) {
								e2.printStackTrace();
								//alJOptionPane.showMessageDialog(IssuebookPane,e2);
							}
							
								
								}}
						catch(Exception e1) {
							e1.printStackTrace();
							//JOptionPane.showMessageDialog(IssuebookPane,e1);
						}
				   	}
				   });
				   SearchcomboBox.setBounds(112, 122, 268, 29);
				   IssuebookPane.add(SearchcomboBox);
				   SearchcomboBox.addItem("Select Issue ID");
				   
				   isButton = new JButton("Issue");
				   isButton.addActionListener(new ActionListener() {
				   	public void actionPerformed(ActionEvent e) {
				   		book = new BookCla();
			    		IssueIDtextField.setText(book.getIssueID()+1 + "");
				   		isButton.setEnabled(false);
				   		upButton.setEnabled(true);
				   		delButton.setEnabled(true);
				   		SearchcomboBox.setVisible(false);
				   		updateButton.setEnabled(false);
				   		deleteButton.setEnabled(false);
				   		issueButton.setEnabled(true);
				   		BookcomboBox.setVisible(true);
				   		stdcomboBox.setVisible(true);
				   		btnSearchBook.setVisible(true);
				   		btnSearchUser.setVisible(true);
				   		textBook_id.setEnabled(true);
				   		textUser_id.setEnabled(true);
				   		
				   		
				   	}
				   });
				   isButton.setFont(new Font("Tahoma", Font.BOLD, 15));
				   isButton.setBounds(10, 62, 107, 33);
				   IssuebookPane.add(isButton);
				   
				   upButton = new JButton("Update");
				   upButton.addActionListener(new ActionListener() {
				   	public void actionPerformed(ActionEvent e) {
				   		upButton.setEnabled(false);
				   		isButton.setEnabled(true);
				   		delButton.setEnabled(true);
				   		SearchcomboBox.setVisible(true);
				   		updateButton.setEnabled(true);
				   		deleteButton.setEnabled(false);
				   		issueButton.setEnabled(false);
				   		BookcomboBox.setVisible(true);
				   		stdcomboBox.setVisible(true);
				   		btnSearchBook.setVisible(true);
				   		btnSearchUser.setVisible(true);
				   		textBook_id.setEnabled(true);
				   		textUser_id.setEnabled(true);
				   	}
				   });
				   upButton.setFont(new Font("Tahoma", Font.BOLD, 15));
				   upButton.setBounds(138, 62, 107, 33);
				   IssuebookPane.add(upButton);
				   
				   delButton = new JButton("Delate");
				   delButton.addActionListener(new ActionListener() {
				   	public void actionPerformed(ActionEvent e) {
				   		isButton.setEnabled(true);
				   		upButton.setEnabled(true);
				   		delButton.setEnabled(false);
				   		SearchcomboBox.setVisible(true);
				   		updateButton.setEnabled(false);
				   		deleteButton.setEnabled(true);
				   		issueButton.setEnabled(false);
				   		BookcomboBox.setVisible(false);
				   		stdcomboBox.setVisible(false);
				   		btnSearchBook.setVisible(false);
				   		btnSearchUser.setVisible(false);
				   		textBook_id.setEnabled(false);
				   		textUser_id.setEnabled(false);
				   		
				   	}
				   });
				   delButton.setEnabled(true);
				   delButton.setFont(new Font("Tahoma", Font.BOLD, 15));
				   delButton.setBounds(273, 62, 107, 33);
				   IssuebookPane.add(delButton);
				   
				   deleteButton = new JButton("Delete");
				   deleteButton.addActionListener(new ActionListener() {
				   	public void actionPerformed(ActionEvent e) {
				   		String issueid = (String) SearchcomboBox.getSelectedItem();
						book = new BookCla();
						book.delete_issuebook(issueid);
						book = new BookCla();
						book.View_IssueBooks(table);
						textBook_id.setText("");
			    		textbookName.setText("");
						textAuthor.setText("");
						textEdition.setText("");
						textpublisher.setText("");
						textUser_id.setText("");
						textstdName.setText("");
						textFatherName.setText("");
						textDOB.setText("");
						textdep.setText("");
						textRollNo.setText("");
						textContactNo.setText("");
						IssuedateChooser.setDate(null);
						DuedateChooser.setDate(null);
				   	}
				   });
				   deleteButton.setFont(new Font("Tahoma", Font.BOLD, 15));
				   deleteButton.setBounds(384, 545, 89, 35);
				   IssuebookPane.add(deleteButton);
				   
				   SearchcomboBox.setVisible(false);
				   updateButton.setEnabled(false);
				   deleteButton.setEnabled(false);
				   issueButton.setEnabled(false);
				   
				  fill_book_combo();
			      fill_student_combo();
			      fill_search_combo();
	}
	
	@SuppressWarnings("unchecked")
	private void fill_search_combo() {
	       try {
		   stmt = conn.createStatement();
		   String sql = "SELECT * FROM issuebook";
		   rs = stmt.executeQuery(sql);
		   while (rs.next()) {
			String id = rs.getString("IssueId");
			SearchcomboBox.addItem(id);
		}
			}
	     catch(Exception e1) {
		  JOptionPane.showMessageDialog(IssuebookPane,e1);
	}
	    }   
	
	 
	 private void fill_book_combo() {
	       try {
		   stmt = conn.createStatement();
		   String sql = "SELECT * FROM book";
		   rs = stmt.executeQuery(sql);
		   while (rs.next()) {
			String name = rs.getString("Name");
			BookcomboBox.addItem(name);
		}
			}
	     catch(Exception e1) {
		  JOptionPane.showMessageDialog(IssuebookPane,e1);
	}
	    }   
	    
     private void fill_student_combo() {
      try {
	   stmt = conn.createStatement();
	   String sql = "SELECT * FROM students";
	   rs = stmt.executeQuery(sql);
	   while (rs.next()) {
		String name = rs.getString("Name");
		stdcomboBox.addItem(name);
	}
		}
      catch(Exception e1) {
	  JOptionPane.showMessageDialog(IssuebookPane,e1);
}}	
}
  
				  
