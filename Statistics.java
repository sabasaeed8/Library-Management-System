package lms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import java.awt.Toolkit;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class Statistics extends JFrame {

	private JPanel contentPane;
	private JTable Issuetable, Returntable;
	private JButton reportButton,printButton;
	private JDateChooser FromdateChooser, TodateChooser;
	private JTextPane textArea;
	private  BookCla book;
	
	
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
					Statistics frame = new Statistics();
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
	public Statistics(final String username) {
		conn = DB.bdconnect();
		
		//Toolkit toolkit = getToolkit();
		//Dimension size =Toolkit.getDefaultToolkit().getScreenSize();
		//setLocation((int) (size.getWidth() - getWidth()/2), (int) (size.getHeight() - getHeight()/2));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setResizable(false);
		
		setTitle("Statistics-My Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1340, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1334, 22);
		contentPane.add(menuBar);
		
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
		
		JLabel lblNewLabel = new JLabel("Issue Books");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 72, 126, 22);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 93, 717, 242);
		contentPane.add(scrollPane);
		
		Issuetable = new JTable();
		Issuetable.setEnabled(false);
		scrollPane.setViewportView(Issuetable);
		Issuetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IssueID", "AdminID", "BookID", "BookName", "StudentID", "StudentName", "RollNo", "ContactNo", "IssueDate", "DueDate", "IsReturned"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
			
			//*************************************** View Issue Books*************************
			book = new BookCla();
			book.View_IssueBooks(Issuetable);
			
			JLabel lblNewLabel_1 = new JLabel("Return Books");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(10, 353, 136, 22);
			contentPane.add(lblNewLabel_1);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(2, 375, 715, 280);
			contentPane.add(scrollPane_1);
			
			Returntable = new JTable();
			Returntable.setEnabled(false);
			scrollPane_1.setViewportView(Returntable);
			Returntable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"AdminID", "BookID", "BookName", "StudentID", "StudentName", "RollNo", "ContactNo", "IssueDate", "DueDate", "ReturnDate", "Fine"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});

			//*************************************** View Issue Books*************************
			book = new BookCla();
			book.View_returnBooks(Returntable);
			
			TodateChooser = new JDateChooser();
			TodateChooser.setBounds(436, 54, 176, 28);
			contentPane.add(TodateChooser);
			
			FromdateChooser = new JDateChooser();
			FromdateChooser.setBounds(204, 54, 176, 28);
			contentPane.add(FromdateChooser);
			
			JLabel TolblNewLabel = new JLabel("To:");
			TolblNewLabel.setForeground(Color.WHITE);
			TolblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			TolblNewLabel.setBounds(397, 54, 62, 28);
			contentPane.add(TolblNewLabel);
			
			JLabel FromlblNewLabel = new JLabel("From:");
			FromlblNewLabel.setEnabled(true);
			FromlblNewLabel.setForeground(Color.WHITE);
			FromlblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			FromlblNewLabel.setBounds(134, 54, 65, 28);
			contentPane.add(FromlblNewLabel);
			
			JButton loadButton = new JButton("Find");
			loadButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		    		try {
		    			printButton.setVisible(false);
		    			reportButton.setVisible(true);
						SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		    		    String from = sdf.format(FromdateChooser.getDate());
		    		    String to = sdf.format(TodateChooser.getDate());
		    		    stmt = conn.createStatement();
		    		    String sql = "SELECT * FROM issuebook WHERE IssueDate between '"+from+"' and '"+to+"' ";
		    		    rs = stmt.executeQuery(sql);
		    		    Issuetable.setModel(DbUtils.resultSetToTableModel(rs));
				}
		    		catch(NullPointerException e2){
						JOptionPane.showMessageDialog(contentPane,"Please Enter From and To Dates.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
						}		    		
		    		catch(Exception e1) {
						JOptionPane.showMessageDialog(contentPane,e1);
					}
				}
			});
			loadButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			loadButton.setBounds(622, 54, 89, 28);
			contentPane.add(loadButton);
			
			reportButton = new JButton("Generate Report");
			reportButton.addActionListener(new ActionListener() {
				@SuppressWarnings("unused")
				public void actionPerformed(ActionEvent e) {
					printButton.setVisible(true);
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	    		    String from = sdf.format(FromdateChooser.getDate());
	    		    String to = sdf.format(TodateChooser.getDate());
					textArea.setText(textArea.getText()+"========================================================================================================================================================================================================================\n");
					textArea.setText(textArea.getText()+"\t                                                                                   Report Of Issued Books from "+ from + " to "+to+"                                                                                                        \n");
					textArea.setText(textArea.getText()+"========================================================================================================================================================================================================================\n");
					DefaultTableModel model = (DefaultTableModel) Issuetable.getModel();
					textArea.setText(textArea.getText()+"IssueID"+"\t"+"\t"+"AdminID"+"\t"+"\t"+ "BookID"+"\t"+"\t"+ "BookName"+"\t"+"\t"+ "StudentID"+"\t"+"\t"+ "StudentName"+"\t"+"\t"+ "RollNo"+"\t"+"\t"+ "ContactNo"+"\t"+"\t"+ "IssueDate"+"\t"+"\t"+ "DueDate"+"\t"+"\t"+ "\n");
					for (int i=0; i<Issuetable.getRowCount(); i++) {
						String IssueID = Issuetable.getValueAt(i, 0).toString();
						String AdminID = Issuetable.getValueAt(i, 1).toString();
						String BookID  = Issuetable.getValueAt(i, 2).toString();
						String BookName = Issuetable.getValueAt(i, 3).toString();
						String StudentID = Issuetable.getValueAt(i, 4).toString();
						String StudentName = Issuetable.getValueAt(i, 5).toString();
						String RollNo = Issuetable.getValueAt(i, 6).toString();
						String ContactNo = Issuetable.getValueAt(i, 7).toString();
						String IssueDate = Issuetable.getValueAt(i, 8).toString();
						String DueDate = Issuetable.getValueAt(i, 9).toString();
						textArea.setText(textArea.getText()+IssueID+"\t"+"\t"+ AdminID+"\t"+"\t"+ BookID+"\t"+"\t"+ BookName+"\t"+"\t"+ StudentID+"\t"+"\t"+ StudentName+"\t"+"\t"+"\t"+RollNo+"\t"+"\t"+ ContactNo+"\t"+"\t"+ IssueDate+"\t"+"\t"+ DueDate+"\t"+"\t"+ "\n");
						textArea.setText(textArea.getText()+"\n");
						//textArea.setText(textArea.getText()+"==========================================================================================================================================\n");
						
					}
				}
			});
			reportButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			reportButton.setBounds(528, 346, 183, 23);
			contentPane.add(reportButton);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(735, 94, 589, 522);
			contentPane.add(scrollPane_2);
			
			textArea = new JTextPane();
			scrollPane_2.setViewportView(textArea);
			
			printButton = new JButton("Print");
			printButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					@SuppressWarnings("unused")
					MessageFormat header = new MessageFormat("Printing in progress");
					
					try
					{
						textArea.print();
						
					}
					catch(java.awt.print.PrinterException ev) {
						System.out.println("NoPrinter Found");
					}
				}
			});
		
			printButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			printButton.setBounds(1008, 632, 89, 23);
			contentPane.add(printButton);
			if(FromdateChooser == null && TodateChooser == null) {
				loadButton.setEnabled(false);
			}
			
			reportButton.setVisible(false);
			printButton.setVisible(false);
		
	}
}
