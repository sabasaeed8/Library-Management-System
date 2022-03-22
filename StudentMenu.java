package lms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StudentMenu extends JFrame {

	private JPanel contentPane;
	//private BooksRecord back;
	private ResetPassw pass;
	//private About about;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public StudentMenu(final String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("Student-My Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 361);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				ResetPassw r = new ResetPassw(username,0);
				r.setVisible(true);
				setVisible(false);
				pass = new ResetPassw(username);
				pass.adminBackButton.setVisible(false);
			}
		});
		exitMenu.add(resetPassMenuItem);
		exitMenuItem.setSelected(true);
		exitMenuItem.setEnabled(true);
		exitMenu.add(exitMenuItem);
		logoutMenuItem.setSelected(true);
		exitMenu.add(logoutMenuItem);
		
		JMenu aboutMenu = new JMenu("About");
		menuBar.add(aboutMenu);
		
		JMenuItem aboutNewMenuItem = new JMenuItem("About");
		aboutNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About b = new About(username,0);
				b.setVisible(true);
				setVisible(false);
				//about = new About(username);
				//about.adminbackButton.setVisible(false);
			}
		});
		aboutMenu.add(aboutNewMenuItem);
		
		JLabel ViewBooksLabel = new JLabel("");
		ViewBooksLabel.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\View books.png"));
		ViewBooksLabel.setBounds(51, 54, 126, 117);
		contentPane.add(ViewBooksLabel);
		
		JLabel MyBooksLabel = new JLabel("");
		MyBooksLabel.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\myBooks.png"));
		MyBooksLabel.setBounds(225, 54, 126, 117);
		contentPane.add(MyBooksLabel);
		
		JButton ViewBooksButton = new JButton("View Books");
		ViewBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back = new BooksRecord(username);
				//back.BackButton.setVisible(false);
				BooksRecord r = new BooksRecord(username,0);
				r.setVisible(true);
				setVisible(false);
				
			}
		});
		ViewBooksButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		ViewBooksButton.setBounds(51, 182, 126, 33);
		contentPane.add(ViewBooksButton);
		
		JButton MyBooksButton = new JButton("My Books");
		MyBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyBooks b = new MyBooks(username);
				b.setVisible(true);
				setVisible(false);
			}
		});
		MyBooksButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		MyBooksButton.setBounds(225, 182, 126, 33);
		contentPane.add(MyBooksButton);
	}
}
