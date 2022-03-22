package lms;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class ResetPassw extends JFrame {

	private JPanel ResetPasswcontentPane;
	private JTextField NametextField, usertextField;
	private JPasswordField passField, ConPassField;
	private Users u;
	JButton stdBackButton, adminBackButton;
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
					ResetPassw frame = new ResetPassw();
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
	public ResetPassw(final String username) {
		conn = DB.bdconnect();
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("Reset Password-My Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 392);
		ResetPasswcontentPane = new JPanel();
		ResetPasswcontentPane.setBackground(Color.DARK_GRAY);
		ResetPasswcontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ResetPasswcontentPane);
		ResetPasswcontentPane.setLayout(null);
		
		JLabel resetPassLabel = new JLabel("Reset Password");
		resetPassLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		resetPassLabel.setForeground(Color.WHITE);
		resetPassLabel.setBounds(113, 37, 216, 47);
		ResetPasswcontentPane.add(resetPassLabel);
		
		JLabel NameLabel = new JLabel("Your Name");
		NameLabel.setForeground(Color.WHITE);
		NameLabel.setBackground(Color.WHITE);
		NameLabel.setEnabled(true);
		NameLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		NameLabel.setBounds(41, 110, 107, 26);
		ResetPasswcontentPane.add(NameLabel);
		
		JLabel usernameLabel = new JLabel("Your Username");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setBounds(41, 156, 155, 26);
		ResetPasswcontentPane.add(usernameLabel);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		passLabel.setBounds(41, 204, 120, 26);
		ResetPasswcontentPane.add(passLabel);
		
		JLabel ConPassLabel = new JLabel("Confirm Password");
		ConPassLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		ConPassLabel.setForeground(Color.WHITE);
		ConPassLabel.setBounds(41, 252, 183, 20);
		ResetPasswcontentPane.add(ConPassLabel);
		
		NametextField = new JTextField();
		NametextField.setBounds(245, 109, 155, 27);
		ResetPasswcontentPane.add(NametextField);
		NametextField.setColumns(10);
		
		usertextField = new JTextField();
		usertextField.setText("");
		usertextField.setBounds(245, 155, 155, 27);
		ResetPasswcontentPane.add(usertextField);
		usertextField.setColumns(10);
		
		passField = new JPasswordField();;
		passField.setText("");
		passField.setBounds(245, 203, 155, 27);
		ResetPasswcontentPane.add(passField);
		passField.setColumns(10);
		
		ConPassField =  new JPasswordField();
		ConPassField.setBounds(245, 245, 155, 27);
		ResetPasswcontentPane.add(ConPassField);
		ConPassField.setColumns(10);
		
		
		NametextField.setEnabled(false);
		usertextField.setEnabled(false);
		usertextField.setText(username);
		u = new Users();
		ResultSet a = u.stdpass(username);
		ResultSet b = u.adminpass(username);	
		try {
			if (a.next()) {
				NametextField.setText(a.getString("Name"));}
			else if (b.next()){
				NametextField.setText(b.getString("Name"));	
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//NametextField.setText(rs.getString("Name"));
		JButton btnNewButton = new JButton("Reset Password");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    @SuppressWarnings("deprecation")
					String pass = passField.getText();
					@SuppressWarnings("deprecation")
					String conpass = ConPassField.getText();
				if (pass.equals(conpass) ) 	{
					if (u.stdpass(username).next()) {		
						u.update_studentpass(username, pass); 
						passField.setText("");
						ConPassField.setText("");
						}
					else {
						u.update_adminpass(username, pass);
						passField.setText("");
						ConPassField.setText("");
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Password do not match; please retype them");
					passField.setText("");
					ConPassField.setText("");
				}}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(67, 301, 167, 35);
		getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(-4, 0, 450, 22);
		ResetPasswcontentPane.add(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		FileMenu.add(exitMenuItem);
		
		JMenuItem logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.main(null);
				setVisible(false);
		
			}
		});
		FileMenu.add(logoutMenuItem);
		
		adminBackButton = new JButton("Back");
		adminBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu ad = new AdminMenu(username);
				ad.setVisible(true);
				setVisible(false);
			}
		});
		adminBackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		adminBackButton.setBounds(281, 301, 89, 35);
		ResetPasswcontentPane.add(adminBackButton);
		
		/*stdBackButton = new JButton("Back");
		stdBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu ad = new StudentMenu(username);
				ad.setVisible(true);
				setVisible(false);
			}
			
		});
		stdBackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		stdBackButton.setBounds(281, 301, 89, 35);
		ResetPasswcontentPane.add(stdBackButton);*/
		
		
	}
	public ResetPassw(final String username, int i) {
		conn = DB.bdconnect();
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("Reset Password-My Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 392);
		ResetPasswcontentPane = new JPanel();
		ResetPasswcontentPane.setBackground(Color.DARK_GRAY);
		ResetPasswcontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ResetPasswcontentPane);
		ResetPasswcontentPane.setLayout(null);
		
		JLabel resetPassLabel = new JLabel("Reset Password");
		resetPassLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		resetPassLabel.setForeground(Color.WHITE);
		resetPassLabel.setBounds(113, 37, 216, 47);
		ResetPasswcontentPane.add(resetPassLabel);
		
		JLabel NameLabel = new JLabel("Your Name");
		NameLabel.setForeground(Color.WHITE);
		NameLabel.setBackground(Color.WHITE);
		NameLabel.setEnabled(true);
		NameLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		NameLabel.setBounds(41, 110, 107, 26);
		ResetPasswcontentPane.add(NameLabel);
		
		JLabel usernameLabel = new JLabel("Your Username");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setBounds(41, 156, 155, 26);
		ResetPasswcontentPane.add(usernameLabel);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		passLabel.setBounds(41, 204, 120, 26);
		ResetPasswcontentPane.add(passLabel);
		
		JLabel ConPassLabel = new JLabel("Confirm Password");
		ConPassLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		ConPassLabel.setForeground(Color.WHITE);
		ConPassLabel.setBounds(41, 252, 183, 20);
		ResetPasswcontentPane.add(ConPassLabel);
		
		NametextField = new JTextField();
		NametextField.setBounds(245, 109, 155, 27);
		ResetPasswcontentPane.add(NametextField);
		NametextField.setColumns(10);
		
		usertextField = new JTextField();
		usertextField.setText("");
		usertextField.setBounds(245, 155, 155, 27);
		ResetPasswcontentPane.add(usertextField);
		usertextField.setColumns(10);
		
		passField = new JPasswordField();;
		passField.setText("");
		passField.setBounds(245, 203, 155, 27);
		ResetPasswcontentPane.add(passField);
		passField.setColumns(10);
		
		ConPassField =  new JPasswordField();
		ConPassField.setBounds(245, 245, 155, 27);
		ResetPasswcontentPane.add(ConPassField);
		ConPassField.setColumns(10);
		
		
		NametextField.setEnabled(false);
		usertextField.setEnabled(false);
		usertextField.setText(username);
		u = new Users();
		ResultSet a = u.stdpass(username);
		ResultSet b = u.adminpass(username);	
		try {
			if (a.next()) {
				NametextField.setText(a.getString("Name"));}
			else if (b.next()){
				NametextField.setText(b.getString("Name"));	
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//NametextField.setText(rs.getString("Name"));
		JButton btnNewButton = new JButton("Reset Password");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    @SuppressWarnings("deprecation")
					String pass = passField.getText();
					@SuppressWarnings("deprecation")
					String conpass = ConPassField.getText();
				if (pass.equals(conpass) ) 	{
					if (u.stdpass(username).next()) {		
						u.update_studentpass(username, pass); 
						passField.setText("");
						ConPassField.setText("");
						}
					else {
						u.update_adminpass(username, pass);
						passField.setText("");
						ConPassField.setText("");
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Password do not match; please retype them");
					passField.setText("");
					ConPassField.setText("");
				}}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(67, 301, 167, 35);
		getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(-4, 0, 450, 22);
		ResetPasswcontentPane.add(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		FileMenu.add(exitMenuItem);
		
		JMenuItem logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.main(null);
				setVisible(false);
		
			}
		});
		FileMenu.add(logoutMenuItem);
		
		/*adminBackButton = new JButton("Back");
		adminBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu ad = new AdminMenu(username);
				ad.setVisible(true);
				setVisible(false);
			}
		});
		adminBackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		adminBackButton.setBounds(281, 301, 89, 35);
		ResetPasswcontentPane.add(adminBackButton);*/
		
		stdBackButton = new JButton("Back");
		stdBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu ad = new StudentMenu(username);
				ad.setVisible(true);
				setVisible(false);
			}
			
		});
		stdBackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		stdBackButton.setBounds(281, 301, 89, 35);
		ResetPasswcontentPane.add(stdBackButton);
		
		
	}
}
