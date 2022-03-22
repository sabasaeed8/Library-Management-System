package lms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class StudentRegisteration extends JFrame {

	private JPanel studentPane;
	private JTextField IDtextField, NametextField, FnametextField, notextField, emailtextField, usertextField, passtextField, RegNotextField, StextField ;
	private JButton addButton, delButton, updateButton, searchButton, SaveButton, clearButton, UpSearchButton, DelSearchButton, Update2Button, Del2Button, Clear2Button, Search2Button ;
	private JDateChooser DOBdateChooser;
	private JLabel userLabel,passLabel;
	private JComboBox<String> DepcomboBox, comboBox;
	private JTextPane addresstextPane;
	private JScrollPane scrollPane;
	private JTable table;
	StudentCla std;
	
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
					StudentRegisteration frame = new StudentRegisteration();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StudentRegisteration(final String username) {
		
		conn = DB.bdconnect();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 750);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		studentPane = new JPanel();
		studentPane.setBackground(Color.GRAY);
		studentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(studentPane);
		studentPane.setLayout(null);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem backMenuItem = new JMenuItem("Back");
		backMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu ad = new AdminMenu(username);
				ad.setVisible(true);
				setVisible(false);
			}
			
		});
		mnNewMenu.add(backMenuItem);
		
		JMenuItem exirMenuItem = new JMenuItem("Exit");
		exirMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		mnNewMenu.add(exirMenuItem);
		
		JMenuItem logoutMenuItem_1 = new JMenuItem("Logout");
		logoutMenuItem_1.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.main(null);
				setVisible(false);
			}
		});
		mnNewMenu.add(logoutMenuItem_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 9));
		panel.setBounds(408, 22, 467, 70);
		studentPane.add(panel);
		
		JLabel bookLabel = new JLabel("Student");
		bookLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(bookLabel);
		
		addButton = new JButton("Add Student");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton.setEnabled(false);
				delButton.setEnabled(true);
				searchButton.setEnabled(true);
				updateButton.setEnabled(true);
				IDtextField.setEnabled(false);
				std = new StudentCla();
				IDtextField.setText(std.getStudentID()+1 + "");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				RegNotextField.setText("");
				DepcomboBox.setSelectedItem("Department");
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				NametextField.setEnabled(true);
				FnametextField.setEnabled(true);
				DOBdateChooser.setEnabled(true);
				RegNotextField.setEnabled(true);
				DepcomboBox.setEnabled(true);
				notextField.setEnabled(true);
				emailtextField.setEnabled(true);
				usertextField.setEnabled(true);
				passtextField.setEnabled(true);
				addresstextPane.setEnabled(true);
				SaveButton.setVisible(true);
				clearButton.setVisible(true);
				Clear2Button.setVisible(false);
				DelSearchButton.setVisible(false);
				UpSearchButton.setVisible(false);
				Search2Button.setVisible(false);
				Del2Button.setVisible(false);
				Update2Button.setVisible(false);
				usertextField.setVisible(true);
				passtextField.setVisible(true);
				userLabel.setVisible(true);
				passLabel.setVisible(true);
				comboBox.setVisible(false);
				comboBox.setSelectedItem("Select Name");
				
			}
		});
		addButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		addButton.setBounds(33, 104, 165, 33);
		studentPane.add(addButton);
		
		delButton = new JButton("Delete");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton.setEnabled(true);
				delButton.setEnabled(false);
				searchButton.setEnabled(true);
				updateButton.setEnabled(true);
				IDtextField.setEnabled(true);
				IDtextField.setText("");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				RegNotextField.setText("");
				DepcomboBox.setSelectedItem("Department");
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				NametextField.setEnabled(false);
				FnametextField.setEnabled(false);
				DOBdateChooser.setEnabled(false);
				RegNotextField.setEnabled(false);
				DepcomboBox.setEnabled(false);
				notextField.setEnabled(false);
				emailtextField.setEnabled(false);
				usertextField.setEnabled(false);
				passtextField.setEnabled(false);
				addresstextPane.setEnabled(false);
				SaveButton.setVisible(false);
				clearButton.setVisible(false);
				Clear2Button.setVisible(true);
				DelSearchButton.setVisible(true);
				UpSearchButton.setVisible(false);
				Search2Button.setVisible(false);
				Del2Button.setVisible(true);
				Update2Button.setVisible(false);
				usertextField.setVisible(false);
				passtextField.setVisible(false);
				userLabel.setVisible(false);
				passLabel.setVisible(false);
				comboBox.setVisible(true);
				comboBox.setSelectedItem("Select Name");
			}
		});
		delButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		delButton.setBounds(208, 104, 114, 33);
		studentPane.add(delButton);
		
		updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton.setEnabled(true);
				delButton.setEnabled(true);
				searchButton.setEnabled(true);
				updateButton.setEnabled(false);
				IDtextField.setText("");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				RegNotextField.setText("");
				DepcomboBox.setSelectedItem("Department");
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				IDtextField.setEnabled(true);
				DelSearchButton.setVisible(false);
				UpSearchButton.setVisible(true);
				Update2Button.setVisible(true);
				Del2Button.setVisible(false);
				SaveButton.setVisible(false);
				NametextField.setEnabled(true);
				FnametextField.setEnabled(true);
				DOBdateChooser.setEnabled(true);
				RegNotextField.setEnabled(true);
				DepcomboBox.setEnabled(true);
				notextField.setEnabled(true);
				emailtextField.setEnabled(true);
				usertextField.setEnabled(true);
				passtextField.setEnabled(true);			
			    addresstextPane.setEnabled(true);
				clearButton.setVisible(false);
				Clear2Button.setVisible(true);
				Search2Button.setVisible(false);
				usertextField.setVisible(false);
				passtextField.setVisible(false);
				userLabel.setVisible(false);
				passLabel.setVisible(false);
				comboBox.setVisible(true);
				comboBox.setSelectedItem("Select Name");
			}
		});
		updateButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		updateButton.setBounds(333, 103, 110, 33);
		studentPane.add(updateButton);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton.setEnabled(true);
				delButton.setEnabled(true);
				searchButton.setEnabled(false);
				updateButton.setEnabled(true);
				IDtextField.setText("");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				RegNotextField.setText("");
				DepcomboBox.setSelectedItem("Department");
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				IDtextField.setEnabled(true);
				NametextField.setEnabled(false);
				FnametextField.setEnabled(false);
				DOBdateChooser.setEnabled(false);
				RegNotextField.setEnabled(false);
				DepcomboBox.setEnabled(false);
				notextField.setEnabled(false);
				emailtextField.setEnabled(false);
				usertextField.setEnabled(false);
				passtextField.setEnabled(false);
				addresstextPane.setEnabled(false);
				SaveButton.setVisible(false);
				clearButton.setVisible(false);
				Clear2Button.setVisible(true);
				DelSearchButton.setVisible(false);
				UpSearchButton.setVisible(false);
				Search2Button.setVisible(true);
				Del2Button.setVisible(false);
				Update2Button.setVisible(false);
				usertextField.setVisible(false);
				passtextField.setVisible(false);
				userLabel.setVisible(false);
				passLabel.setVisible(false);
				comboBox.setVisible(true);
				comboBox.setSelectedItem("Select Name");
			}
		});
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		searchButton.setBounds(453, 104, 114, 33);
		studentPane.add(searchButton);
		
		JLabel IDLabel = new JLabel("Student ID");
		IDLabel.setForeground(Color.WHITE);
		IDLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		IDLabel.setBounds(33, 177, 125, 21);
		studentPane.add(IDLabel);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(198, 177, 86, 21);
		studentPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setForeground(Color.WHITE);
		NameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		NameLabel.setBounds(33, 206, 75, 30);
		studentPane.add(NameLabel);
		
		NametextField = new JTextField();
		NametextField.setBounds(198, 206, 220, 30);
		studentPane.add(NametextField);
		NametextField.setColumns(10);
		
		JLabel FnameLabel = new JLabel("Father Name");
		FnameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		FnameLabel.setForeground(Color.WHITE);
		FnameLabel.setBounds(32, 235, 144, 32);
		studentPane.add(FnameLabel);
		
		FnametextField = new JTextField();
		FnametextField.setBounds(198, 240, 220, 30);
		studentPane.add(FnametextField);
		FnametextField.setColumns(10);
		
		JLabel DOBLabel = new JLabel("Date Of Birth");
		DOBLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		DOBLabel.setForeground(Color.WHITE);
		DOBLabel.setBounds(33, 276, 132, 30);
		studentPane.add(DOBLabel);
		
		DOBdateChooser = new JDateChooser();
		DOBdateChooser.setBounds(198, 276, 220, 30);
		studentPane.add(DOBdateChooser);
		
		JLabel RegNoLabel = new JLabel("Roll No");
		RegNoLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		RegNoLabel.setForeground(Color.WHITE);
		RegNoLabel.setEnabled(true);
		RegNoLabel.setBounds(33, 346, 166, 25);
		studentPane.add(RegNoLabel);
		
		RegNotextField = new JTextField();
		RegNotextField.setBounds(198, 346, 222, 30);
		studentPane.add(RegNotextField);
		RegNotextField.setColumns(10);
		

		JLabel depLabel = new JLabel("Department");
		depLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		depLabel.setForeground(Color.WHITE);
		depLabel.setBounds(33, 311, 125, 25);
		studentPane.add(depLabel);
		
		DepcomboBox = new JComboBox<String>();
		DepcomboBox.addItem("Department");
		DepcomboBox.addItem("Electrical Engineering");
		DepcomboBox.addItem("Computer Engineering");
		DepcomboBox.addItem("Computer Science");
		DepcomboBox.addItem("Mechanical Engineering");
		DepcomboBox.addItem("Industrial & Manufacturing Engineering");
		DepcomboBox.addItem("Mechatronics & Control Engineering");	
		DepcomboBox.setBounds(198, 312, 220, 30);
		studentPane.add(DepcomboBox);
		
		
		JLabel noLabel = new JLabel("Contact No");
		noLabel.setForeground(Color.WHITE);
		noLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		noLabel.setEnabled(true);
		noLabel.setBounds(33, 378, 132, 30);
		studentPane.add(noLabel);
		
		notextField = new JTextField();
		notextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
		}			@Override
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
		notextField.setBounds(198, 382, 220, 30);
		studentPane.add(notextField);
		notextField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBounds(33, 413, 75, 30);
		studentPane.add(emailLabel);
		
		emailtextField = new JTextField();
		emailtextField.setBounds(198, 417, 220, 30);
		studentPane.add(emailtextField);
		emailtextField.setColumns(10);
		
		userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(33, 541, 102, 30);
		studentPane.add(userLabel);
		
		usertextField = new JTextField();
		usertextField.setBounds(198, 544, 220, 33);
		studentPane.add(usertextField);
		usertextField.setColumns(10);
		
		passLabel = new JLabel("Password");
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		passLabel.setBounds(33, 579, 116, 30);
		studentPane.add(passLabel);
		
		passtextField = new JTextField();
		passtextField.setBounds(198, 583, 220, 33);
	    studentPane.add(passtextField);
		passtextField.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		addressLabel.setForeground(Color.WHITE);
		addressLabel.setBounds(33, 482, 125, 30);
		studentPane.add(addressLabel);
		
		addresstextPane = new JTextPane();
		addresstextPane.setBounds(198, 454, 281, 85);
		studentPane.add(addresstextPane);
		
		SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = NametextField.getText().toLowerCase();
					String Fname = FnametextField.getText().toLowerCase();
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					String DOB = sdf.format(DOBdateChooser.getDate());
					String dep = (String) DepcomboBox.getSelectedItem();
					String Regno = RegNotextField.getText();
					long no = Long.parseLong(notextField.getText());
					String email = emailtextField.getText().toLowerCase();
					String user = usertextField.getText();
					String pass = passtextField.getText();			
					String address = addresstextPane.getText().toLowerCase();
				
				if (name.isEmpty() || Fname.isEmpty() || dep=="Department" || Regno.isEmpty() || email.isEmpty() || user.isEmpty() || pass.isEmpty() || address.isEmpty()  ) {
					JOptionPane.showMessageDialog(studentPane,"Please Enter Complete Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
					return;}
				if (no <= 0) {
					JOptionPane.showMessageDialog(studentPane,"Please Enter Valid Contact Number.", "Enter Details", JOptionPane.ERROR_MESSAGE);
					notextField.requestFocus();
					return;}
				std= new StudentCla();
				std.already_exist(name,Fname,DOB,dep,Regno,no,email,user,pass,address);
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				RegNotextField.setText("");
				DepcomboBox.setSelectedItem("Department");
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				std = new StudentCla();
				IDtextField.setText(std.getStudentID()+1 + "");
				
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(studentPane,"Please Enter Contact Number.", "Enter Details", JOptionPane.ERROR_MESSAGE);
					notextField.requestFocus();
					return;
				}
				catch(NullPointerException e2){
					JOptionPane.showMessageDialog(studentPane,"Please Enter Complete Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
					DOBdateChooser.grabFocus();
					return;}
				catch(Exception e1 ) {
					JOptionPane.showMessageDialog(studentPane, e1);
				}
				View_students();
			}
		});
		SaveButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		SaveButton.setBounds(128, 645, 89, 33);
		studentPane.add(SaveButton);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDtextField.setEnabled(false);
				std = new StudentCla();
				IDtextField.setText(std.getStudentID()+1 + "");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				RegNotextField.setText("");
				DepcomboBox.setSelectedItem("Department");
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		clearButton.setBounds(292, 645, 89, 32);
		studentPane.add(clearButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(496, 179, 852, 499);
		studentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "FatherName", "DOB", "Department", "RollNo", "ContactNo", "Email", "Username", "Password", "Address"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		UpSearchButton = new JButton("Search");
		UpSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NametextField.setEnabled(true);
					FnametextField.setEnabled(true);
					DOBdateChooser.setEnabled(true);
					RegNotextField.setEnabled(true);
					DepcomboBox.setEnabled(true);
					notextField.setEnabled(true);
					emailtextField.setEnabled(true);
					usertextField.setEnabled(true);
					passtextField.setEnabled(true);			
				    addresstextPane.setEnabled(true);
					stmt = conn.createStatement();
					int StudentID = Integer.parseInt(IDtextField.getText());
					String sql = "SELECT * FROM students WHERE ID = '"+StudentID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						NametextField.setText(rs.getString("Name"));
						FnametextField.setText(rs.getString("FatherName"));
						java.sql.Date date = rs.getDate("DOB");
						DOBdateChooser.setDate(date);
						DepcomboBox.setSelectedItem(rs.getString("Department"));
						RegNotextField.setText(rs.getString("RollNo"));
						notextField.setText(rs.getString("ContactNo"));
						emailtextField.setText(rs.getString("Email"));
						usertextField.setText(rs.getString("Username"));
						passtextField.setText(rs.getString("Password"));			
					    addresstextPane.setText(rs.getString("address"));
						
						}
					else {
						JOptionPane.showMessageDialog(studentPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(studentPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(studentPane,e1);
				}
			}
		});
		UpSearchButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		UpSearchButton.setBounds(292, 178, 89, 23);
		studentPane.add(UpSearchButton);
		
		DelSearchButton = new JButton("Search");
		DelSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int StudentID = Integer.parseInt(IDtextField.getText());
					String sql = "SELECT * FROM students WHERE ID = '"+StudentID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						NametextField.setText(rs.getString("Name"));
						FnametextField.setText(rs.getString("FatherName"));
						java.sql.Date date = rs.getDate("DOB");
						DOBdateChooser.setDate(date);
						DepcomboBox.setSelectedItem(rs.getString("Department"));
						RegNotextField.setText(rs.getString("RollNo"));
						notextField.setText(rs.getString("ContactNo"));
						emailtextField.setText(rs.getString("Email"));
						usertextField.setText(rs.getString("Username"));
						passtextField.setText(rs.getString("Password"));			
					    addresstextPane.setText(rs.getString("address"));
						}
					else {
						JOptionPane.showMessageDialog(studentPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(studentPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(studentPane,e1);
				}
			}
		});
		DelSearchButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		DelSearchButton.setBounds(292, 178, 89, 23);
		studentPane.add(DelSearchButton);
		
		Update2Button = new JButton("Update");
		Update2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ID = Integer.parseInt(IDtextField.getText());
					String name = NametextField.getText();
					String Fname = FnametextField.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					String DOB = sdf.format(DOBdateChooser.getDate());
					String dep = (String) DepcomboBox.getSelectedItem();
					String rollno = RegNotextField.getText();
					long no = Long.parseLong(notextField.getText());
					String email = emailtextField.getText();
					String user = usertextField.getText();
					String pass = passtextField.getText();			
					String address = addresstextPane.getText();
				
					if (name.isEmpty() || Fname.isEmpty() || dep=="Department" || rollno.isEmpty() || email.isEmpty() || user.isEmpty() || pass.isEmpty() || address.isEmpty()  ) {
						JOptionPane.showMessageDialog(studentPane,"Please Enter Complete Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
						return;}
					if (no <= 0) {
						JOptionPane.showMessageDialog(studentPane,"Please Enter Valid Contact Number.", "Enter Details", JOptionPane.ERROR_MESSAGE);
						notextField.requestFocus();
						return;}
				std = new StudentCla();
				std.update_student(ID, name,Fname,DOB,dep,rollno,no,email,user,pass,address);
				IDtextField.setText("");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				DepcomboBox.setSelectedItem("Department");
				RegNotextField.setText("");
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				NametextField.setEnabled(true);
				FnametextField.setEnabled(true);
				DOBdateChooser.setEnabled(true);
				RegNotextField.setEnabled(true);
				DepcomboBox.setEnabled(true);
				notextField.setEnabled(true);
				emailtextField.setEnabled(true);
				usertextField.setEnabled(true);
				passtextField.setEnabled(true);			
			    addresstextPane.setEnabled(true);
			    View_students();
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(studentPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(studentPane,e2);
				}
			}});
		Update2Button.setEnabled(true);
		Update2Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		Update2Button.setBounds(128, 645, 89, 33);
		studentPane.add(Update2Button);
		
		Del2Button = new JButton("Delete");
		Del2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int studentID = Integer.parseInt(IDtextField.getText());
				std = new StudentCla();
				std.delete_student(studentID);
				IDtextField.setText("");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				DepcomboBox.setSelectedItem("Department");
				RegNotextField.setText("");
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				View_students();
				
			}
			
		});
		Del2Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		Del2Button.setBounds(128, 645, 89, 33);
		studentPane.add(Del2Button);
		
		Clear2Button = new JButton("Clear");
		Clear2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDtextField.setText("");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				DepcomboBox.setSelectedItem("Department");
				RegNotextField.setText("");
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
			}
		});
		Clear2Button.setFont(new Font("Tahoma", Font.BOLD, 20));
		Clear2Button.setBounds(292, 645, 89, 32);
		studentPane.add(Clear2Button);
		
	    Search2Button = new JButton("Search");
	    Search2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int studentID = Integer.parseInt(IDtextField.getText());
					String sql = "SELECT * FROM students WHERE ID = '"+studentID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						NametextField.setText(rs.getString("Name"));
						FnametextField.setText(rs.getString("FatherName"));
						java.sql.Date date1 = rs.getDate("DOB");
						DOBdateChooser.setDate(date1);
						//((JTextField) DOBdateChooser.getDateEditor().getUiComponent()).setText(rs.getString("DOB"));
						DepcomboBox.setSelectedItem(rs.getString("Department"));
						RegNotextField.setText(rs.getString("RollNo"));
						notextField.setText(rs.getString("ContactNo"));
						emailtextField.setText(rs.getString("Email"));
						usertextField.setText(rs.getString("Username"));
						passtextField.setText(rs.getString("Password"));			
					    addresstextPane.setText(rs.getString("address"));}
					else {
						JOptionPane.showMessageDialog(studentPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(studentPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(studentPane,e1);
				}
			}
		});
	    Search2Button.setFont(new Font("Tahoma", Font.BOLD, 15));
	    Search2Button.setBounds(294, 178, 89, 23);
	    studentPane.add(Search2Button);
	    
		IDtextField.setEnabled(false);
		NametextField.setEnabled(false);
		FnametextField.setEnabled(false);
		DOBdateChooser.setEnabled(false);
		DepcomboBox.setEnabled(false);
		RegNotextField.setEnabled(false);
		notextField.setEnabled(false);
		emailtextField.setEnabled(false);
		usertextField.setEnabled(false);
		passtextField.setEnabled(false);			
	    addresstextPane.setEnabled(false);
	    
	    UpSearchButton.setVisible(false);
	    DelSearchButton.setVisible(false);
	    SaveButton.setVisible(false);
	    Del2Button.setVisible(false);
	    Update2Button.setVisible(false);
	    clearButton.setVisible(false);
	    Clear2Button.setVisible(false);
	    Search2Button.setVisible(false);
	    View_students();
	    
	    StextField = new JTextField();
		StextField.addKeyListener(new KeyAdapter() {
		   	@Override
		 public void keyReleased(KeyEvent e) {
		   		
		   		DefaultTableModel Table = (DefaultTableModel)table.getModel();
		   		String Search = StextField.getText().toLowerCase();
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
		   StextField.setBounds(996, 141, 226, 27);
		   studentPane.add(StextField);
		   StextField.setColumns(10);
		   
		   JLabel lblNewLabel = new JLabel("Search Record");
		   lblNewLabel.setForeground(Color.WHITE);
		   lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		   lblNewLabel.setBounds(872, 140, 114, 26);
		   studentPane.add(lblNewLabel);
		   
		   JLabel lblNewLabel_1 = new JLabel("");
		   lblNewLabel_1.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\search.JPG"));
		   lblNewLabel_1.setBounds(1222, 141, 46, 27);
		   studentPane.add(lblNewLabel_1);
		   
		   comboBox = new JComboBox();
		   comboBox.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		try {
					stmt = conn.createStatement();
					String name = (String) comboBox.getSelectedItem();
					if (name == "Select Name") {
						NametextField.setText("");
						FnametextField.setText("");
						DOBdateChooser.setCalendar(null);
						RegNotextField.setText("");
						DepcomboBox.setSelectedItem("Department");
						notextField.setText("");
						emailtextField.setText("");
						usertextField.setText("");
						passtextField.setText("");			
						addresstextPane.setText("");
					}
					else {
					String sql = "SELECT * FROM students WHERE Name = '"+name+"'";
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						IDtextField.setText(rs.getString("ID"));
						NametextField.setText(rs.getString("Name"));
						FnametextField.setText(rs.getString("FatherName"));
						
						((JTextField) DOBdateChooser.getDateEditor().getUiComponent()).setText(rs.getString("DOB"));
						DepcomboBox.setSelectedItem(rs.getString("Department"));
						RegNotextField.setText(rs.getString("RollNo"));
						notextField.setText(rs.getString("ContactNo"));
						emailtextField.setText(rs.getString("Email"));
						usertextField.setText(rs.getString("Username"));
						passtextField.setText(rs.getString("Password"));			
					    addresstextPane.setText(rs.getString("address"));}
						}
					}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(studentPane,e1);
				}

		   	
		   	}});
		   comboBox.setBounds(199, 147, 184, 22);
		   studentPane.add(comboBox);
		   comboBox.addItem("Select Name");
		   comboBox.setSelectedItem("Select Name");
		   comboBox.setVisible(false);
		   fill_combo();
	    
	}
	
	private void View_students() {
		   try {
			   conn = DB.bdconnect();
			   stmt = conn.createStatement();
			   String sql = "SELECT * FROM students";
			   rs = stmt.executeQuery(sql);
			   table.setModel(DbUtils.resultSetToTableModel(rs));
			   table.removeColumn(table.getColumnModel().getColumn(8));
			   table.removeColumn(table.getColumnModel().getColumn(8));
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }
		   }
	private void fill_combo() {
	    try {
		stmt = conn.createStatement();
		String sql = "SELECT * FROM students";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String name = rs.getString("Name");
			comboBox.addItem(name);
		}
			}
	catch(Exception e1) {
		JOptionPane.showMessageDialog(studentPane,e1);
	}
}

	}

