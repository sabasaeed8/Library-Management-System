package lms;

import java.awt.EventQueue;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


   

public class Login   {

	private JFrame Loginframe;
	private JLabel imgLabel,welcomeLabel,usernameLabel,passwordLabel;
	private JTextField usertextField;
	private JButton LoginButton;
	private JPasswordField passwordField;
	private loginCla log;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.Loginframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	
	public Login() {
		conn = DB.bdconnect();
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Loginframe = new JFrame();
		Loginframe.setResizable(false);
		Loginframe.setTitle("My Library");
		Loginframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		Loginframe.getContentPane().setBackground(Color.DARK_GRAY);
		Loginframe.setBounds(100, 100, 802, 434);
		Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Loginframe.getContentPane().setLayout(null);
		
		imgLabel = new JLabel("");
		imgLabel.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\login.png"));
		imgLabel.setBackground(Color.BLACK);
		imgLabel.setBounds(30, 80, 304, 333);
		Loginframe.getContentPane().add(imgLabel);
		
		LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
				stmt = (Statement) conn.createStatement();
			    String user = usertextField.getText();
			    @SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				
			    log = new loginCla();
			    if(user.equals("") && pass.equals("")) 
		        {
		            JOptionPane.showMessageDialog(Loginframe,"Please enter username and password.");
		        } 

			    else if(user.equals("")) 
		        {
		            JOptionPane.showMessageDialog(Loginframe,"Please enter username");
		            passwordField.setText("");
		        } 
			    else if(pass.equals("")) 
		        {
		            JOptionPane.showMessageDialog(Loginframe,"Please enter password");
		            usertextField.setText("");
		        }
			    else if (user.equals("admin") && pass.equals("admin")) {
					Loginframe.dispose();
					AdminMenu a = new AdminMenu(user);
					a.setVisible(true);
			    }
			    else if (log.std(user, pass).next()) {
					Loginframe.dispose();
					StudentMenu s = new StudentMenu(user);
					s.setVisible(true); 	
					
				}	
				
			    else if (log.admin(user, pass).next()) {
					Loginframe.dispose();
					AdminMenu a = new AdminMenu(user);
					a.setVisible(true); 	
					//JOptionPane.showMessageDialog(Loginframe,"admin frame");
				}
				else {
					JOptionPane.showMessageDialog(Loginframe,"Invalid Email or Password.","Login",JOptionPane.INFORMATION_MESSAGE);
					usertextField.setText("");
					passwordField.setText("");
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 }
		});
		LoginButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		LoginButton.setBackground(Color.WHITE);
		LoginButton.setBounds(390, 290, 129, 39);
		Loginframe.getContentPane().add(LoginButton);
		
		welcomeLabel = new JLabel("Welcome to My Library");
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		welcomeLabel.setBackground(Color.PINK);
		welcomeLabel.setBounds(76, 22, 581, 58);
		Loginframe.getContentPane().add(welcomeLabel);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setBackground(Color.BLACK);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		usernameLabel.setBounds(337, 149, 140, 31);
		Loginframe.getContentPane().add(usernameLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		passwordLabel.setBounds(337, 216, 129, 29);
		Loginframe.getContentPane().add(passwordLabel);
		
		usertextField = new JTextField();
		usertextField.setBounds(487, 151, 217, 31);
		Loginframe.getContentPane().add(usertextField);
		usertextField.setColumns(10);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		ExitButton.setBounds(568, 290, 129, 39);
		Loginframe.getContentPane().add(ExitButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(487, 216, 217, 31);
		Loginframe.getContentPane().add(passwordField);
	}
      
	    
}
