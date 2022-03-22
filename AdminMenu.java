package lms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "unused" })
public class AdminMenu extends JFrame {

	private JPanel FeaturesPane;
	JButton StudentButton;
	private About b;
	private BooksRecord record;
	private ResetPassw pass;
	
	//private String user;
	

	/**
	 * 
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Features frame = new Features();
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
	public AdminMenu(final String username) {
		setTitle("My Library");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 495);
		FeaturesPane = new JPanel();
		FeaturesPane.setBackground(Color.DARK_GRAY);
		FeaturesPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FeaturesPane);
		FeaturesPane.setLayout(null);
		
		StudentButton = new JButton("Student");
		StudentButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		StudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentRegisteration add = new StudentRegisteration(username);
				add.setVisible(true);
				setVisible(false);
			}
		});
		StudentButton.setBounds(263, 190, 121, 33);
		FeaturesPane.add(StudentButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 790, 33);
		FeaturesPane.add(menuBar);
		
		JMenu exitMenu = new JMenu("File");
		menuBar.add(exitMenu);
		
		JMenuItem logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.main(null);
				setVisible(false);
		
			}
		});
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		
		JMenuItem resetPassMenuItem = new JMenuItem("Reset Password");
		resetPassMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetPassw r = new ResetPassw(username);
				r.setVisible(true);
				setVisible(false);
				//pass = new ResetPassw(username);
				//pass.stdBackButton.setVisible(false);
			}
		});
		exitMenu.add(resetPassMenuItem);
		exitMenuItem.setSelected(true);
		exitMenuItem.setEnabled(true);
		exitMenu.add(exitMenuItem);
		logoutMenuItem.setSelected(true);
		exitMenu.add(logoutMenuItem);
		
		JMenu RecordMenu = new JMenu("Record");
		menuBar.add(RecordMenu);
		
		JMenuItem BookMenuItem = new JMenuItem("Books");
		BookMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 BooksRecord r = new BooksRecord(username);
				 r.setVisible(true);
				 setVisible(false);
				
			}
		});
		RecordMenu.add(BookMenuItem);
		
		JMenuItem adminMenuItem = new JMenuItem("Admin");
		adminMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRecord ad = new AdminRecord(username);
				ad.setVisible(true);
				setVisible(false);
			}
		});
		RecordMenu.add(adminMenuItem);
		
		JMenuItem studentNewMenuItem = new JMenuItem("Student");
		studentNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentRecord std = new StudentRecord(username);
				std.setVisible(true);
				setVisible(false);
			}
		});
		RecordMenu.add(studentNewMenuItem);
		
		JMenu aboutMenu = new JMenu("About");
		menuBar.add(aboutMenu);
		
		JMenuItem aboutNewMenuItem = new JMenuItem("About");
		aboutNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About b = new About(username);
				b.setVisible(true);
				setVisible(false);
				//b = new About(username);
				//b.stdbackButton.setVisible(false);
			}
		});
		aboutMenu.add(aboutNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("");
		menuBar.add(menuItem);
		
		JButton adminButton = new JButton("Admin");
		adminButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        AdminRegisteration add = new AdminRegisteration(username);
				add.setVisible(true);
				setVisible(false);
			}
		});
		adminButton.setBounds(55, 190, 121, 33);
		FeaturesPane.add(adminButton);
		
		JButton IssuebookButton = new JButton("Issue Book");
		IssuebookButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		IssuebookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issuebook add = new Issuebook(username);
				add.setVisible(true);
				setVisible(false);
			}
		});
		IssuebookButton.setBounds(55, 375, 121, 33);
		FeaturesPane.add(IssuebookButton);
		
		JButton returnBookButton = new JButton("Return book");
		returnBookButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		returnBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook r = new ReturnBook(username);
				r.setVisible(true);
				setVisible(false);
				
			}
		});
		returnBookButton.setBounds(258, 378, 126, 33);
		FeaturesPane.add(returnBookButton);
		
		JButton statisticsButton = new JButton("Statistics/Report");
		statisticsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistics s = new Statistics(username);
				s.setVisible(true);
				setVisible(false);
			}
		});
		statisticsButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		statisticsButton.setBounds(440, 376, 158, 33);
		FeaturesPane.add(statisticsButton);
		
		JButton BookButton = new JButton("BOOKS");
		BookButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		BookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BooksRegisteration obj = new BooksRegisteration(username);
				obj.setVisible(true);
				setVisible(false);
			}
		});
		BookButton.setBounds(460, 190, 121, 33);
		FeaturesPane.add(BookButton);
		
		JLabel adminLabel = new JLabel("");
		adminLabel.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\admins.png"));
		adminLabel.setBounds(66, 61, 121, 126);
		FeaturesPane.add(adminLabel);
		
		JLabel studentLabel = new JLabel("");
		studentLabel.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\student.png"));
		studentLabel.setBounds(263, 61, 121, 126);
		FeaturesPane.add(studentLabel);
		
		JLabel bookLabel = new JLabel("");
		bookLabel.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\booksss.png"));
		bookLabel.setBounds(472, 75, 126, 111);
		FeaturesPane.add(bookLabel);
		
		JLabel issueBookLabel = new JLabel("");
		issueBookLabel.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\issueBook.png"));
		issueBookLabel.setBounds(66, 254, 121, 111);
		FeaturesPane.add(issueBookLabel);
		
		JLabel returnBookLabel = new JLabel("");
		returnBookLabel.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\returnBook.png"));
		returnBookLabel.setBounds(263, 254, 121, 110);
		FeaturesPane.add(returnBookLabel);
		
		JLabel statsticsLabel = new JLabel("");
		statsticsLabel.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\statistics.png"));
		statsticsLabel.setBounds(470, 254, 121, 111);
		FeaturesPane.add(statsticsLabel);
	}
}
