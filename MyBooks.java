package lms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MyBooks extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String Id;
	
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
					MyBooks frame = new MyBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}/*

	/**
	 * Create the frame.
	 */
	public MyBooks(final String username) {
		conn = DB.bdconnect();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("My Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 505);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Books");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(231, 25, 179, 29);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 593, 22);
		contentPane.add(menuBar);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 65, 593, 360);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IssueId", "AdminId", "BookId", "BookName", "StudentId", "StudentName", "RollNo", "ContactNo", "IssueDate", "DueDate", "IsReturned", "IsReturned"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM students WHERE Username = '"+username+"'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				Id = rs.getString("ID");
			}
			}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
		}
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM issuebook WHERE StudentId = '"+Id+"'";
			rs = stmt.executeQuery(sql);
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
		} 
		
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu std = new StudentMenu(username);
				std.setVisible(true);
				setVisible(false);
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		BackButton.setBounds(265, 436, 89, 23);
		contentPane.add(BackButton);
}
	
	}


