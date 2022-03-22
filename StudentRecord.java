package lms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class StudentRecord extends JFrame {

	private JPanel contentPane;
	private JTable Studenttable;
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
					StudentRecord frame = new StudentRecord();
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
	public StudentRecord(final String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("Student Record-My Library");
		conn = DB.bdconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 531);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 722, 406);
		contentPane.add(scrollPane);
		
		Studenttable = new JTable();
		Studenttable.setEnabled(false);
		scrollPane.setViewportView(Studenttable);
		Studenttable.setModel(new DefaultTableModel(
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
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 742, 22);
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
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu ad = new AdminMenu(username);
				ad.setVisible(true);
				setVisible(false);
				
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		BackButton.setBounds(338, 458, 89, 23);
		contentPane.add(BackButton);
		
		
		  
		View_students();
	}
	
	private void View_students() {
		   try {
			   conn = DB.bdconnect();
			   stmt = conn.createStatement();
			   String sql = "SELECT * FROM students";
			   rs = stmt.executeQuery(sql);
			   Studenttable.setModel(DbUtils.resultSetToTableModel(rs));
			   Studenttable.removeColumn(Studenttable.getColumnModel().getColumn(8));
			   Studenttable.removeColumn(Studenttable.getColumnModel().getColumn(8));
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }
		   }

}
