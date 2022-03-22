package lms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class About extends JFrame {

	private JPanel contentPane;
	JButton stdbackButton, adminbackButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About(final String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("About-My Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 256);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		lblNewLabel.setBounds(99, 57, 140, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Management System");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(21, 81, 299, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Developed By : SABA SAEED");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(21, 133, 403, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\about.png"));
		lblNewLabel_3.setBounds(330, 37, 97, 91);
		contentPane.add(lblNewLabel_3);
		
		/*stdbackButton = new JButton("Back");
		stdbackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu s = new StudentMenu(username);
				s.setVisible(true);
				setVisible(false);
				
			}
		});
		stdbackButton.setBackground(Color.LIGHT_GRAY);
		stdbackButton.setHorizontalAlignment(SwingConstants.LEFT);
		stdbackButton.setBounds(0, 0, 434, 23);
		contentPane.add(stdbackButton);*/
		
		adminbackButton = new JButton("Back");
		adminbackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu s = new AdminMenu(username);
				s.setVisible(true);
				setVisible(false);
				
			}
		});
		adminbackButton.setBackground(Color.LIGHT_GRAY);
		adminbackButton.setHorizontalAlignment(SwingConstants.LEFT);
		adminbackButton.setBounds(0, 0, 434, 23);
		contentPane.add(adminbackButton);
	}
	public About(final String username, int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setTitle("About-My Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 256);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		lblNewLabel.setBounds(99, 57, 140, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Management System");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(21, 81, 299, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Developed By : SABA SAEED");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(21, 133, 403, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\about.png"));
		lblNewLabel_3.setBounds(330, 37, 97, 91);
		contentPane.add(lblNewLabel_3);
		
		stdbackButton = new JButton("Back");
		stdbackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu s = new StudentMenu(username);
				s.setVisible(true);
				setVisible(false);
				
			}
		});
		stdbackButton.setBackground(Color.LIGHT_GRAY);
		stdbackButton.setHorizontalAlignment(SwingConstants.LEFT);
		stdbackButton.setBounds(0, 0, 434, 23);
		contentPane.add(stdbackButton);
		
		/*adminbackButton = new JButton("Back");
		adminbackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu s = new AdminMenu(username);
				s.setVisible(true);
				setVisible(false);
				
			}
		});
		adminbackButton.setBackground(Color.LIGHT_GRAY);
		adminbackButton.setHorizontalAlignment(SwingConstants.LEFT);
		adminbackButton.setBounds(0, 0, 434, 23);
		contentPane.add(adminbackButton);*/
	}
}
