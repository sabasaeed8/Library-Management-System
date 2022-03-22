package lms;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;



@SuppressWarnings("serial")
public class AdminRegisteration extends JFrame {

	private JPanel adminPane;
	private JTextField IDtextField, NametextField, FnametextField, notextField, emailtextField, usertextField, StextField ;
	private JButton addButton, delButton, updateButton, searchButton, SaveButton, clearButton, UpSearchButton, DelSearchButton, Update2Button, Del2Button, Clear2Button, Search2Button ;
	private JLabel userLabel,passLabel;
	private JDateChooser DOBdateChooser;
	private JTextPane addresstextPane;
	private JScrollPane scrollPane;
	private JTable table;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	AdminCla admin;
	
	
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    private JPasswordField passtextField;



	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegisteration frame = new AdminRegisteration();
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
	public AdminRegisteration(final String username) {
		
		conn = DB.bdconnect();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 750);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		adminPane = new JPanel();
		adminPane.setBackground(Color.GRAY);
		adminPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(adminPane);
		adminPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 9));
		panel.setBounds(408, 22, 467, 70);
		adminPane.add(panel);
		
		JLabel bookLabel = new JLabel("Admin");
		bookLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(bookLabel);
		
		addButton = new JButton("Add Admin");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton.setEnabled(false);
				delButton.setEnabled(true);
				searchButton.setEnabled(true);
				updateButton.setEnabled(true);
				IDtextField.setEnabled(false);
				admin = new AdminCla();
				IDtextField.setText(admin.getadminID()+1 + "");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				NametextField.setEnabled(true);
				FnametextField.setEnabled(true);
				DOBdateChooser.setEnabled(true);
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
		addButton.setBounds(40, 112, 158, 33);
		adminPane.add(addButton);
		
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
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				NametextField.setEnabled(false);
				FnametextField.setEnabled(false);
				DOBdateChooser.setEnabled(false);
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
		delButton.setBounds(208, 112, 114, 33);
		adminPane.add(delButton);
		
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
		updateButton.setBounds(332, 112, 110, 33);
		adminPane.add(updateButton);
		
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
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				IDtextField.setEnabled(true);
				NametextField.setEnabled(false);
				FnametextField.setEnabled(false);
				DOBdateChooser.setEnabled(false);
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
		searchButton.setBounds(452, 112, 114, 33);
		adminPane.add(searchButton);
		
		JLabel IDLabel = new JLabel("Admin ID");
		IDLabel.setForeground(Color.WHITE);
		IDLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		IDLabel.setBounds(40, 198, 125, 21);
		adminPane.add(IDLabel);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(197, 195, 86, 35);
		adminPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setForeground(Color.WHITE);
		NameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		NameLabel.setBounds(42, 237, 75, 30);
		adminPane.add(NameLabel);
		
		NametextField = new JTextField();
		NametextField.setBounds(197, 241, 220, 30);
		adminPane.add(NametextField);
		NametextField.setColumns(10);
		
		JLabel FnameLabel = new JLabel("Father Name");
		FnameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		FnameLabel.setForeground(Color.WHITE);
		FnameLabel.setBounds(40, 277, 144, 32);
		adminPane.add(FnameLabel);
		
		FnametextField = new JTextField();
		FnametextField.setBounds(197, 282, 220, 30);
		adminPane.add(FnametextField);
		FnametextField.setColumns(10);
		
		JLabel DOBLabel = new JLabel("Date Of Birth");
		DOBLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		DOBLabel.setForeground(Color.WHITE);
		DOBLabel.setBounds(40, 323, 132, 30);
		adminPane.add(DOBLabel);
		
		DOBdateChooser = new JDateChooser();
		DOBdateChooser.setBounds(197, 323, 220, 30);
		adminPane.add(DOBdateChooser);
		
		JLabel noLabel = new JLabel("Contact No");
		noLabel.setForeground(Color.WHITE);
		noLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		noLabel.setEnabled(true);
		noLabel.setBounds(40, 360, 132, 30);
		adminPane.add(noLabel);
		
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
		notextField.setBounds(197, 364, 220, 30);
		adminPane.add(notextField);
		notextField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBounds(40, 401, 75, 30);
		adminPane.add(emailLabel);
		
		emailtextField = new JTextField();
		emailtextField.setBounds(197, 405, 220, 30);
		adminPane.add(emailtextField);
		emailtextField.setColumns(10);
		
		userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(40, 538, 102, 30);
		adminPane.add(userLabel);
		
		usertextField = new JTextField();
		usertextField.setBounds(197, 542, 220, 30);
		adminPane.add(usertextField);
		usertextField.setColumns(10);
		
		passLabel = new JLabel("Password");
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		passLabel.setBounds(40, 583, 116, 30);
		adminPane.add(passLabel);
		
		passtextField = new JPasswordField();
		passtextField.setBounds(197, 583, 220, 30);
		adminPane.add(passtextField);
		passtextField.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		addressLabel.setForeground(Color.WHITE);
		addressLabel.setBounds(40, 481, 102, 30);
		adminPane.add(addressLabel);
		
		addresstextPane = new JTextPane();
		addresstextPane.setBounds(197, 446, 281, 85);
		adminPane.add(addresstextPane);
		
		SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = NametextField.getText();
					String Fname = FnametextField.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					String DOB = sdf.format(DOBdateChooser.getDate());
					long no = Long.parseLong(notextField.getText());
					String email = emailtextField.getText();
					String user = usertextField.getText();
					String pass = passtextField.getText();			
					String address = addresstextPane.getText();
				
				if (name.isEmpty() || Fname.isEmpty() || email.isEmpty() || user.isEmpty() || pass.isEmpty() || address.isEmpty() ) {
					JOptionPane.showMessageDialog(adminPane,"Please Enter Complete Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
					return;}
				if (no <= 0) {
					JOptionPane.showMessageDialog(adminPane,"Please Enter Valid Contact Number.", "Enter Details", JOptionPane.ERROR_MESSAGE);
					notextField.requestFocus();
					return;}
				admin = new AdminCla();
				admin.already_exist(name,Fname,DOB,no,email,user,pass,address);
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				admin = new AdminCla();
				IDtextField.setText(admin.getadminID()+1 + "");
				addButton.setEnabled(true);
				IDtextField.setEnabled(false);
				NametextField.setEnabled(false);
				FnametextField.setEnabled(false);
				DOBdateChooser.setEnabled(false);
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
			    comboBox.setVisible(false);
			    View_admins();
				
				
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(adminPane,"Please Enter Contact Number.", "Enter Details", JOptionPane.ERROR_MESSAGE);
					notextField.requestFocus();
					return;
				}
				catch(NullPointerException e2){
					JOptionPane.showMessageDialog(adminPane,"Please Enter Complete Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
					DOBdateChooser.grabFocus();
					return;}
				catch(Exception e1 ) {
					JOptionPane.showMessageDialog(adminPane, e1);
				}
				View_admins();
			}
		});
		SaveButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		SaveButton.setBounds(128, 645, 89, 33);
		adminPane.add(SaveButton);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDtextField.setEnabled(false);
				admin = new AdminCla();
				IDtextField.setText(admin.getadminID()+1 + "");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		clearButton.setBounds(292, 645, 89, 32);
		adminPane.add(clearButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(496, 179, 852, 499);
		adminPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "FatherName", "DOB", "ContactNo", "Email", "Username", "Password", "Address"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
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
					notextField.setEnabled(true);
					emailtextField.setEnabled(true);
					usertextField.setEnabled(true);
					passtextField.setEnabled(true);			
				    addresstextPane.setEnabled(true);
					stmt = conn.createStatement();
					int adminID = Integer.parseInt(IDtextField.getText());
					String sql = "SELECT * FROM admin WHERE ID = '"+adminID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						NametextField.setText(rs.getString("Name"));
						FnametextField.setText(rs.getString("FatherName"));
						java.sql.Date date = rs.getDate("DOB");
						DOBdateChooser.setDate(date);
						notextField.setText(rs.getString("ContactNo"));
						emailtextField.setText(rs.getString("Email"));
						usertextField.setText(rs.getString("Username"));
						passtextField.setText(rs.getString("Password"));			
					    addresstextPane.setText(rs.getString("address"));
						
						}
					else {
						JOptionPane.showMessageDialog(adminPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(adminPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(adminPane,e1);
				}
			}
		});
		UpSearchButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		UpSearchButton.setBounds(293, 201, 89, 23);
		adminPane.add(UpSearchButton);
		
		DelSearchButton = new JButton("Search");
		DelSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int adminID = Integer.parseInt(IDtextField.getText());
					String sql = "SELECT * FROM admin WHERE ID = '"+adminID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						NametextField.setText(rs.getString("Name"));
						FnametextField.setText(rs.getString("FatherName"));
						java.sql.Date date = rs.getDate("DOB");
						DOBdateChooser.setDate(date);
						notextField.setText(rs.getString("ContactNo"));
						emailtextField.setText(rs.getString("Email"));
						usertextField.setText(rs.getString("Username"));
						passtextField.setText(rs.getString("Password"));			
					    addresstextPane.setText(rs.getString("address"));
						}
					else {
						JOptionPane.showMessageDialog(adminPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(adminPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(adminPane,e1);
				}
			}
		});
		DelSearchButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		DelSearchButton.setBounds(293, 201, 89, 23);
		adminPane.add(DelSearchButton);
		
		Update2Button = new JButton("Update");
		Update2Button.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				try {
					int ID = Integer.parseInt(IDtextField.getText());
					String name = NametextField.getText();
					String Fname = FnametextField.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					String DOB = sdf.format(DOBdateChooser.getDate());
					long no = Long.parseLong(notextField.getText());
					String email = emailtextField.getText();
					String user = usertextField.getText();
					String pass = passtextField.getText();			
					String address = addresstextPane.getText();
				
				if (name.isEmpty() || Fname.isEmpty() || email.isEmpty() || user.isEmpty() || pass.isEmpty() || address.isEmpty() || DOB.isEmpty()  ) {
					JOptionPane.showMessageDialog(adminPane,"Please Enter Complete Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
					return;}
				if (DOB == null) {
					JOptionPane.showMessageDialog(adminPane,"Please Enter Date Of Birth.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
					DOBdateChooser.grabFocus();
					return;}
				if (no <= 0) {
					JOptionPane.showMessageDialog(adminPane,"Please Enter Valid Contact Number.", "Enter Details", JOptionPane.ERROR_MESSAGE);
					notextField.requestFocus();
					return;}
				admin = new AdminCla();
				admin.update_admin(ID, name,Fname,DOB,no,email,user,pass,address);
				IDtextField.setText("");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				NametextField.setEnabled(true);
				FnametextField.setEnabled(true);
				DOBdateChooser.setEnabled(true);
				notextField.setEnabled(true);
				emailtextField.setEnabled(true);
				usertextField.setEnabled(true);
				passtextField.setEnabled(true);
				addresstextPane.setEnabled(true);
				View_admins();
				updateButton.setEnabled(true);
				IDtextField.setEnabled(false);
				NametextField.setEnabled(false);
				FnametextField.setEnabled(false);
				DOBdateChooser.setEnabled(false);
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
			    comboBox.setVisible(false);
			    
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(adminPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(adminPane,e2);
				}
			}});
		Update2Button.setEnabled(true);
		Update2Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		Update2Button.setBounds(128, 645, 89, 33);
		adminPane.add(Update2Button);
		
		Del2Button = new JButton("Delete");
		Del2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int adminID = Integer.parseInt(IDtextField.getText());
				admin = new AdminCla();
				admin.delete_admin(adminID);
				IDtextField.setText("");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
				delButton.setEnabled(true);
				IDtextField.setEnabled(false);
				NametextField.setEnabled(false);
				FnametextField.setEnabled(false);
				DOBdateChooser.setEnabled(false);
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
			    comboBox.setVisible(false);
				View_admins();
				
			}
			
		});
		Del2Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		Del2Button.setBounds(128, 645, 89, 33);
		adminPane.add(Del2Button);
		
		Clear2Button = new JButton("Clear");
		Clear2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDtextField.setText("");
				NametextField.setText("");
				FnametextField.setText("");
				DOBdateChooser.setCalendar(null);
				notextField.setText("");
				emailtextField.setText("");
				usertextField.setText("");
				passtextField.setText("");			
				addresstextPane.setText("");
			}
		});
		Clear2Button.setFont(new Font("Tahoma", Font.BOLD, 20));
		Clear2Button.setBounds(292, 645, 89, 32);
		adminPane.add(Clear2Button);
		
		IDtextField.setEnabled(false);
		NametextField.setEnabled(false);
		FnametextField.setEnabled(false);
		DOBdateChooser.setEnabled(false);
		notextField.setEnabled(false);
		emailtextField.setEnabled(false);
		usertextField.setEnabled(false);
		passtextField.setEnabled(false);			
	    addresstextPane.setEnabled(false);
	    
	    Search2Button = new JButton("Search");
	    Search2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int adminID = Integer.parseInt(IDtextField.getText());
					String sql = "SELECT * FROM admin WHERE ID = '"+adminID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						NametextField.setText(rs.getString("Name"));
						FnametextField.setText(rs.getString("FatherName"));
						((JTextField) DOBdateChooser.getDateEditor().getUiComponent()).setText(rs.getString("DOB"));
						notextField.setText(rs.getString("ContactNo"));
						emailtextField.setText(rs.getString("Email"));
						usertextField.setText(rs.getString("Username"));
						passtextField.setText(rs.getString("Password"));			
					    addresstextPane.setText(rs.getString("address"));}
					else {
						JOptionPane.showMessageDialog(adminPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(adminPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(adminPane,e1);
				}
			}
		});
	    Search2Button.setFont(new Font("Tahoma", Font.BOLD, 15));
	    Search2Button.setBounds(293, 201, 89, 23);
	    adminPane.add(Search2Button);
	    UpSearchButton.setVisible(false);
	    DelSearchButton.setVisible(false);
	    SaveButton.setVisible(false);
	    Del2Button.setVisible(false);
	    Update2Button.setVisible(false);
	    clearButton.setVisible(false);
	    Clear2Button.setVisible(false);
	    Search2Button.setVisible(false);
	    View_admins();
	    
	    StextField = new JTextField();
		StextField.addKeyListener(new KeyAdapter() {
		   	@SuppressWarnings("unlikely-arg-type")
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
		   StextField.setBounds(955, 135, 267, 27);
		   adminPane.add(StextField);
		   StextField.setColumns(10);
		   
		   JLabel lblNewLabel = new JLabel("Search Record");
		   lblNewLabel.setForeground(Color.WHITE);
		   lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		   lblNewLabel.setBounds(831, 135, 114, 26);
		   adminPane.add(lblNewLabel);
		   
		   JLabel lblNewLabel_1 = new JLabel("");
		   lblNewLabel_1.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\search.JPG"));
		   lblNewLabel_1.setBounds(1221, 135, 46, 27);
		   adminPane.add(lblNewLabel_1);
		   
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
						notextField.setText("");
						emailtextField.setText("");
						usertextField.setText("");
						passtextField.setText("");			
						addresstextPane.setText("");
					}
					else {
					String sql = "SELECT * FROM admin WHERE Name = '"+name+"'";
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						IDtextField.setText(rs.getString("ID"));
						NametextField.setText(rs.getString("Name"));
						FnametextField.setText(rs.getString("FatherName"));
						((JTextField) DOBdateChooser.getDateEditor().getUiComponent()).setText(rs.getString("DOB"));
						notextField.setText(rs.getString("ContactNo"));
						emailtextField.setText(rs.getString("Email"));
						usertextField.setText(rs.getString("Username"));
						passtextField.setText(rs.getString("Password"));			
					    addresstextPane.setText(rs.getString("address"));
						}
					}}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(adminPane,e1);
				}

		   	
		   	}});
		   comboBox.setBounds(197, 154, 184, 30);
		   adminPane.add(comboBox);
		   comboBox.addItem("Select Name");
		   comboBox.setSelectedItem("Select Name");
		   
		  /* passwordField = new JPasswordField();
		   passwordField.setBounds(81, 450, 7, 20);
		   adminPane.add(passwordField);*/
		   comboBox.setVisible(false);
		   fill_combo();
		} 
	      
	
	private void View_admins() {
		   try {
			   conn = DB.bdconnect();
			   stmt = conn.createStatement();
			   String sql = "SELECT * FROM admin";
			   rs = stmt.executeQuery(sql);
			   table.setModel(DbUtils.resultSetToTableModel(rs));
			   table.removeColumn(table.getColumnModel().getColumn(6));
			   table.removeColumn(table.getColumnModel().getColumn(6));
			   
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }}
	 @SuppressWarnings("unchecked")
	private void fill_combo() {
		    try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM admin";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("Name");
				comboBox.addItem(name);
			}
				}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(adminPane,e1);
		}
	}
}

