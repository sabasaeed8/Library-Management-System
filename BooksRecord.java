package lms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class BooksRecord extends JFrame {

	private JPanel contentPane;
	private JTable Booktable;
	private BookCla book;
	JButton stdBackButton, BackButton;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	private JMenu FileMenu;
	private JMenuItem exitMenuItem;
	private JMenuItem logoutMenuItem;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Record frame = new Record();
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
	public BooksRecord(final String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("Book Record-My Library");
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
		
		Booktable = new JTable();
		Booktable.setEnabled(false);
		scrollPane.setViewportView(Booktable);
		Booktable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Author", "Edition", "Publisher", "Quantity"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 742, 22);
		contentPane.add(menuBar);
		
		FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		FileMenu.add(exitMenuItem);
		
		logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.main(null);
				setVisible(false);
		
			}
		});
		FileMenu.add(logoutMenuItem);
		
		
		
		try {
	           book = new BookCla();
			   Booktable.setModel(DbUtils.resultSetToTableModel(book.View_books()));}
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(contentPane, e);
		   }
		
		BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu ad = new AdminMenu(username);
				ad.setVisible(true);
				setVisible(false);
				
			}
		});
		
		/*stdBackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu ad = new StudentMenu(username);
				ad.setVisible(true);
				setVisible(false);
				
			}
		});*/
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		BackButton.setBounds(338, 458, 89, 23);
		contentPane.add(BackButton);
			
	}
	
	public BooksRecord(final String username, int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("Book Record-My Library");
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
		
		Booktable = new JTable();
		Booktable.setEnabled(false);
		scrollPane.setViewportView(Booktable);
		Booktable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Author", "Edition", "Publisher", "Quantity"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 742, 22);
		contentPane.add(menuBar);
		
		FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		FileMenu.add(exitMenuItem);
		
		logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.main(null);
				setVisible(false);
		
			}
		});
		FileMenu.add(logoutMenuItem);
		
		
		
		try {
	           book = new BookCla();
			   Booktable.setModel(DbUtils.resultSetToTableModel(book.View_books()));}
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(contentPane, e);
		   }
		
		/*BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu ad = new AdminMenu(username);
				ad.setVisible(true);
				setVisible(false);
				
			}
		});*/
		
		stdBackButton = new JButton("Back");
		stdBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu ad = new StudentMenu(username);
				ad.setVisible(true);
				setVisible(false);
				
			}
		});
		stdBackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		stdBackButton.setBounds(338, 458, 89, 23);
		contentPane.add(stdBackButton);
			
	}
	
	
}
