package lms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class BooksRegisteration extends JFrame {

	private JPanel BookPane;
	private JTextField IDtextField, nametextField, authortextField, publishertextField, quantitytextField;
	@SuppressWarnings("rawtypes")
	private JComboBox editioncomboBox;
	private JButton SaveButton,clearButton, DelSearchButton, Del2Button, Up2Button, UpButton, UpSearchButton, Search2Button, AddButton, delButton, SearchButton;	
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private BookCla book;

	/**
	 * Launch the application.
	 */
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton Clear2Button;
	private JMenuBar menuBar;
	@SuppressWarnings("unused")
	private JMenu mnNewMenu;
	private JTextField StextField;
	private JLabel lblNewLabel;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooksRegisteration frame = new BooksRegisteration();
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
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public BooksRegisteration(final String username) {
		conn = DB.bdconnect();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Semester 3 Eclipse\\Library Management  System\\images\\logo.png"));
		setResizable(false);
		setTitle("My Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1213, 580);
		
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
		
		BookPane = new JPanel();
		BookPane.setBackground(Color.GRAY);
		BookPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BookPane);
		BookPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 9));
		panel.setBounds(351, 25, 463, 56);
		BookPane.add(panel);
		
		JLabel bookLabel = new JLabel("BOOKS");
		bookLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(bookLabel);
		
		AddButton = new JButton("Add Book");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDtextField.setEnabled(false);
				book = new BookCla();
				IDtextField.setText(book.getBookId()+1 + "");
	    		nametextField.setText("");
				authortextField.setText("");
				editioncomboBox.setSelectedItem("Edition");
				publishertextField.setText("");
				quantitytextField.setText("");
				nametextField.setEnabled(true);
				authortextField.setEnabled(true);
				editioncomboBox.setEnabled(true);
				publishertextField.setEnabled(true);
				quantitytextField.setEnabled(true);
				SaveButton.setVisible(true);
				clearButton.setVisible(true);
				Clear2Button.setVisible(false);
				DelSearchButton.setVisible(false);
				UpSearchButton.setVisible(false);
				Search2Button.setVisible(false);
				AddButton.setEnabled(false);
				delButton.setEnabled(true);
				SearchButton.setEnabled(true);
				UpButton.setEnabled(true);
				comboBox.setVisible(false);
				comboBox.setSelectedItem("Select Name");
				
				
			}
		});
		AddButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddButton.setBounds(23, 99, 114, 35);
		BookPane.add(AddButton);
		
		delButton = new JButton("Delete ");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDtextField.setText("");
	    		nametextField.setText("");
				authortextField.setText("");
				editioncomboBox.setSelectedItem("Edition");
				publishertextField.setText("");
				quantitytextField.setText("");
				IDtextField.setEnabled(true);
				Search2Button.setVisible(false);
				DelSearchButton.setVisible(true);
				UpSearchButton.setVisible(false);
				Del2Button.setVisible(true);
				SaveButton.setVisible(false);
				Up2Button.setVisible(false);
				nametextField.setEnabled(false);
				authortextField.setEnabled(false);
				editioncomboBox.setEnabled(false);
				publishertextField.setEnabled(false);
				quantitytextField.setEnabled(false);
				clearButton.setVisible(false);
				Clear2Button.setVisible(true);
				AddButton.setEnabled(true);
				delButton.setEnabled(false);
				SearchButton.setEnabled(true);
				UpButton.setEnabled(true);
				comboBox.setVisible(true);
				comboBox.setSelectedItem("Select Name");
			}
		});
		delButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		delButton.setBounds(161, 99, 89, 35);
		BookPane.add(delButton);
		
		JLabel booknameLabel = new JLabel("Book Name");
		booknameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		booknameLabel.setForeground(Color.WHITE);
		booknameLabel.setBounds(43, 236, 114, 25);
		BookPane.add(booknameLabel);
		
		JLabel authorLabel = new JLabel("Author");
		authorLabel.setForeground(Color.WHITE);
		authorLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		authorLabel.setBounds(43, 282, 98, 23);
		BookPane.add(authorLabel);
		
		JLabel editionLabel = new JLabel("Edition");
		editionLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		editionLabel.setForeground(Color.WHITE);
		editionLabel.setBounds(43, 329, 97, 31);
		BookPane.add(editionLabel);
		
		JLabel PublisherLabel = new JLabel("Publisher");
		PublisherLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		PublisherLabel.setForeground(Color.WHITE);
		PublisherLabel.setEnabled(true);
		PublisherLabel.setBounds(43, 371, 98, 29);
		BookPane.add(PublisherLabel);
		
		JLabel quantityLabel = new JLabel("Number of Books");
		quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		quantityLabel.setForeground(Color.WHITE);
		quantityLabel.setBounds(43, 419, 179, 25);
		BookPane.add(quantityLabel);
		
		nametextField = new JTextField();
		nametextField.setBounds(245, 235, 160, 35);
		BookPane.add(nametextField);
		nametextField.setColumns(10);
		
		authortextField = new JTextField();
		authortextField.setBounds(245, 280, 160, 35);
		BookPane.add(authortextField);
		authortextField.setColumns(10);
		
		publishertextField = new JTextField();
		publishertextField.setBounds(245, 372, 160, 35);
		BookPane.add(publishertextField);
		publishertextField.setColumns(10);
		
		quantitytextField = new JTextField();
		quantitytextField.addKeyListener(new KeyAdapter() {
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
		quantitytextField.setText("");
		quantitytextField.setBounds(245, 418, 160, 35);
		BookPane.add(quantitytextField);
		quantitytextField.setColumns(10);
		
		editioncomboBox = new JComboBox();
		editioncomboBox.setBounds(245, 326, 158, 35);
		editioncomboBox.addItem("Edition");
		editioncomboBox.addItem("1");
		editioncomboBox.addItem("2");
		editioncomboBox.addItem("3");
		editioncomboBox.addItem("4");
		editioncomboBox.addItem("5");
		editioncomboBox.addItem("6");
		editioncomboBox.addItem("7");
		editioncomboBox.addItem("8");
		editioncomboBox.addItem("9");
		editioncomboBox.addItem("10");
		editioncomboBox.addItem("11");
		editioncomboBox.addItem("12");
		editioncomboBox.addItem("13");
		editioncomboBox.addItem("14");
		editioncomboBox.addItem("15");
		BookPane.add(editioncomboBox);
		
		SearchButton = new JButton("Search");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddButton.setEnabled(true);
				delButton.setEnabled(true);
				SearchButton.setEnabled(false);
				UpButton.setEnabled(true);
				IDtextField.setText("");
	    		nametextField.setText("");
				authortextField.setText("");
				editioncomboBox.setSelectedItem("Edition");
				publishertextField.setText("");
				quantitytextField.setText("");
				IDtextField.setEnabled(true);
				Search2Button.setVisible(true);
				nametextField.setEnabled(false);
				authortextField.setEnabled(false);
				editioncomboBox.setEnabled(false);
				publishertextField.setEnabled(false);
				quantitytextField.setEnabled(false);
				SaveButton.setVisible(false);
				clearButton.setVisible(false);
				Clear2Button.setVisible(true);
				DelSearchButton.setVisible(false);
				UpSearchButton.setVisible(false);
				Del2Button.setVisible(false);
				Up2Button.setVisible(false);
				comboBox.setVisible(true);
				comboBox.setSelectedItem("Select Name");
			}
		});
		SearchButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		SearchButton.setBounds(378, 99, 89, 35);
		BookPane.add(SearchButton);
		
		JLabel IDLabel = new JLabel("Book ID");
		IDLabel.setForeground(Color.WHITE);
		IDLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		IDLabel.setBounds(43, 189, 125, 21);
		BookPane.add(IDLabel);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(245, 186, 86, 35);
		BookPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String name = nametextField.getText();
				String author = authortextField.getText();
				String edition = (String) editioncomboBox.getSelectedItem();
				String publisher = publishertextField.getText();
				int nobooks = Integer.parseInt(quantitytextField.getText());
				if (name.isEmpty() || author.isEmpty() || edition=="Edition" || publisher.isEmpty() ) {
					JOptionPane.showMessageDialog(BookPane,"Please Enter Complete Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
					return;}
				if (nobooks <= 0) {
					JOptionPane.showMessageDialog(BookPane,"Please Enter Valid Number of Books.", "Enter Details", JOptionPane.ERROR_MESSAGE);
					nametextField.requestFocus();
					return;
					}
				book = new BookCla();
				book.already_exist(name,author,publisher,edition,nobooks);
				nametextField.setText("");
				authortextField.setText("");
				editioncomboBox.setSelectedItem("Edition");
				publishertextField.setText("");
				quantitytextField.setText("");
				book = new BookCla();
				IDtextField.setText(book.getBookId()+1 + "");
				
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(BookPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(BookPane,e2);
				}
				View_books();
			}
		});
		SaveButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		SaveButton.setBounds(133, 474, 89, 35);
		BookPane.add(SaveButton);
		
	    clearButton = new JButton("Clear");
	    clearButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		nametextField.setText("");
				authortextField.setText("");
				editioncomboBox.setSelectedItem("Edition");
				publishertextField.setText("");
				quantitytextField.setText("");
	    	}
	    });
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		clearButton.setBounds(296, 474, 89, 35);
		BookPane.add(clearButton);
		
		DelSearchButton = new JButton("Search");
		DelSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int bookID = Integer.parseInt(IDtextField.getText());
					String sql = "SELECT * FROM book WHERE ID = '"+bookID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						nametextField.setText(rs.getString("Name"));
						authortextField.setText(rs.getString("Author"));
						editioncomboBox.setSelectedItem(rs.getString("Edition"));
						publishertextField.setText(rs.getString("Publisher"));
						quantitytextField.setText(rs.getString("Quantity"));
						}
					else {
						JOptionPane.showMessageDialog(BookPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(BookPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(BookPane,e1);
				}
			}
		});
		DelSearchButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		DelSearchButton.setBounds(351, 192, 98, 25);
		BookPane.add(DelSearchButton);
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(488, 104, 694, 400);
		BookPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(3), "saba", "saba", new Integer(2), "saba", new Integer(6)},
				{new Integer(5), "mubeen", "saba", new Integer(1), "saba", new Integer(55)},
				{new Integer(6), "saab", "kjj", new Integer(4), "kkk", new Integer(7)},
				{new Integer(7), "english", "razia", new Integer(3), "samia", new Integer(58)},
				{new Integer(8), "eng", "saba", new Integer(1), "qanita", new Integer(4)},
				{new Integer(9), "eng", "saba", new Integer(1), "qanita", new Integer(4)},
				{new Integer(10), "english", "saba", new Integer(1), "saba", new Integer(4)},
				{new Integer(11), "saba", "jkj", new Integer(1), "jkj", new Integer(8)},
				{new Integer(12), "urdu", "hjkkj", new Integer(1), "gun", new Integer(5)},
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
		
		UpButton = new JButton("Update");
		UpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddButton.setEnabled(true);
				delButton.setEnabled(true);
				SearchButton.setEnabled(true);
				UpButton.setEnabled(false);
				IDtextField.setText("");
	    		nametextField.setText("");
				authortextField.setText("");
				editioncomboBox.setSelectedItem("Edition");
				publishertextField.setText("");
				quantitytextField.setText("");
				IDtextField.setEnabled(true);
				Search2Button.setVisible(false);
				DelSearchButton.setVisible(false);
				UpSearchButton.setVisible(true);
				Up2Button.setVisible(true);
				Del2Button.setVisible(false);
				SaveButton.setVisible(false);
				nametextField.setEnabled(true);
				authortextField.setEnabled(true);
				editioncomboBox.setEnabled(true);
				publishertextField.setEnabled(true);
				quantitytextField.setEnabled(true);
				clearButton.setVisible(false);
				Clear2Button.setVisible(true);
				comboBox.setVisible(true);
				comboBox.setSelectedItem("Select Name");
			}
		});
		UpButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		UpButton.setBounds(260, 99, 89, 35);
		BookPane.add(UpButton);
		
		Del2Button = new JButton("Delete");
		Del2Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		Del2Button.setBounds(133, 474, 89, 35);
		BookPane.add(Del2Button);
		Del2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookID = Integer.parseInt(IDtextField.getText());
				book = new BookCla();
				book.delete_book(bookID);
				IDtextField.setText("");
				nametextField.setText("");
				authortextField.setText("");
				editioncomboBox.setSelectedItem("Edition");
				publishertextField.setText("");
				quantitytextField.setText("");
				View_books();
				//update_fill_combo();
			}
			
		});
		
		
		Up2Button = new JButton("Update");
		Up2Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		Up2Button.setBounds(133, 474, 89, 35);
		BookPane.add(Up2Button);
		Up2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				int ID = Integer.parseInt(IDtextField.getText());
				String name = nametextField.getText();
				String author = authortextField.getText();
				String edition = (String) editioncomboBox.getSelectedItem();
				String publisher = publishertextField.getText();
				int nobooks = Integer.parseInt(quantitytextField.getText());
				if (name.isEmpty() || author.isEmpty() || edition=="Edition" || publisher.isEmpty() ) {
					JOptionPane.showMessageDialog(BookPane,"Please Enter Complete Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);		
					return;}
				if (nobooks <= 0) {
					JOptionPane.showMessageDialog(BookPane,"Please Enter Valid Number of Books.", "Enter Details", JOptionPane.ERROR_MESSAGE);
					nametextField.requestFocus();
					return;
					}
				book = new BookCla();
				book.update_book(ID,name,author,publisher,edition,nobooks);
				IDtextField.setText("");
				nametextField.setText("");
				authortextField.setText("");
				editioncomboBox.setSelectedItem("Edition");
				publishertextField.setText("");
				quantitytextField.setText("");
				nametextField.setEnabled(false);
				authortextField.setEnabled(false);
				editioncomboBox.setEnabled(false);
				publishertextField.setEnabled(false);
				quantitytextField.setEnabled(false);
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(BookPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(BookPane,e2);
				}
				View_books();
				
			}});
		       
		
		
		UpSearchButton = new JButton("Search");
		UpSearchButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		UpSearchButton.setBounds(351, 192, 98, 25);
		UpSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nametextField.setEnabled(true);
					authortextField.setEnabled(true);
					editioncomboBox.setEnabled(true);
					publishertextField.setEnabled(true);
					quantitytextField.setEnabled(true);
					stmt = conn.createStatement();
					int bookID = Integer.parseInt(IDtextField.getText());
					String sql = "SELECT * FROM book WHERE ID = '"+bookID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						nametextField.setText(rs.getString("Name"));
						authortextField.setText(rs.getString("Author"));
						editioncomboBox.setSelectedItem(rs.getString("Edition"));
						publishertextField.setText(rs.getString("Publisher"));
						quantitytextField.setText(rs.getString("Quantity"));
						}
					else {
						JOptionPane.showMessageDialog(BookPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(BookPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(BookPane,e1);
				}
			}
		});
		
		
		BookPane.add(UpSearchButton);
		Search2Button = new JButton("Search");
		Search2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int bookID = Integer.parseInt(IDtextField.getText());
					String sql = "SELECT * FROM book WHERE ID = '"+bookID+"'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						nametextField.setText(rs.getString("Name"));
						authortextField.setText(rs.getString("Author"));
						editioncomboBox.setSelectedItem(rs.getString("Edition"));
						publishertextField.setText(rs.getString("Publisher"));
						quantitytextField.setText(rs.getString("Quantity"));
						}
					else {
						JOptionPane.showMessageDialog(BookPane,"Record not found", "Not found", JOptionPane.ERROR_MESSAGE);
					}}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(BookPane,"Please Enter Valid Information.", "Enter Details", JOptionPane.ERROR_MESSAGE);}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(BookPane,e1);
				}
			}
		});
		Search2Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		Search2Button.setBounds(351, 192, 98, 25);
		BookPane.add(Search2Button);
		
		Clear2Button = new JButton("Clear");
		Clear2Button.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		IDtextField.setText("");
		    		nametextField.setText("");
					authortextField.setText("");
					editioncomboBox.setSelectedItem("Edition");
					publishertextField.setText("");
					quantitytextField.setText("");
		    	}
		    });
		Clear2Button.setFont(new Font("Tahoma", Font.BOLD, 20));
		Clear2Button.setBounds(296, 474, 89, 35);
		BookPane.add(Clear2Button);
		IDtextField.setEnabled(false);
		nametextField.setEnabled(false);
		authortextField.setEnabled(false);
		editioncomboBox.setEnabled(false);
		publishertextField.setEnabled(false);
		quantitytextField.setEnabled(false);
		SaveButton.setVisible(false);
		clearButton.setVisible(false);
		DelSearchButton.setVisible(false);
		UpSearchButton.setVisible(false);
		Del2Button.setVisible(false);
		Up2Button.setVisible(false);
		Clear2Button.setVisible(false);
		Search2Button.setVisible(false);
	
	     //*********************View_Books**************************
		View_books();
		
		StextField = new JTextField();
		StextField.addKeyListener(new KeyAdapter() {
			   	@Override
			   	public void keyReleased(KeyEvent e) {
			   		
			   		DefaultTableModel Table = (DefaultTableModel)table.getModel();
			   		String Search = StextField.getText();
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
			   StextField.setBounds(931, 67, 226, 27);
			   BookPane.add(StextField);
			   StextField.setColumns(10);
			   
			   lblNewLabel = new JLabel("Search Record");
			   lblNewLabel.setForeground(Color.WHITE);
			   lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			   lblNewLabel.setBounds(817, 67, 114, 26);
			   BookPane.add(lblNewLabel);
			   
			   JLabel lblNewLabel_1 = new JLabel("");
			   lblNewLabel_1.setIcon(new ImageIcon("C:\\Semester 3 Eclipse\\Library Management  System\\images\\search.JPG"));
			   lblNewLabel_1.setBounds(1151, 67, 46, 27);
			   BookPane.add(lblNewLabel_1);
			   
			   comboBox = new JComboBox();
			   comboBox.addActionListener(new ActionListener() {
			   	public void actionPerformed(ActionEvent e) {
			   		try {
						stmt = conn.createStatement();
						String name = (String) comboBox.getSelectedItem();
						if (name == "Select Name") {
							nametextField.setText("");
							authortextField.setText("");
							editioncomboBox.setSelectedItem("Edition");
							publishertextField.setText("");
							quantitytextField.setText("");
						}
						else {
						String sql = "SELECT * FROM book WHERE Name = '"+name+"'";
						rs = stmt.executeQuery(sql);
						while (rs.next()) {
							IDtextField.setText(rs.getString("ID"));
							nametextField.setText(rs.getString("Name"));
							authortextField.setText(rs.getString("Author"));
							editioncomboBox.setSelectedItem(rs.getString("Edition"));
							publishertextField.setText(rs.getString("Publisher"));
							quantitytextField.setText(rs.getString("Quantity"));
							}
						}}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(BookPane,e1);
					}

			   	
			   	}});
			   comboBox.setBounds(245, 145, 204, 30);
			   BookPane.add(comboBox);
			   comboBox.addItem("Select Name");
			   comboBox.setSelectedItem("Select Name");
			   comboBox.setVisible(false);
			   fill_combo();
	}
	
	@SuppressWarnings("unchecked")
	 private void fill_combo() {
		    try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM book";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("Name");
				comboBox.addItem(name);
			}
				}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(BookPane,e1);
		}
	}
	 /*private void update_fill_combo() {
		    try {
		    comboBox.removeAllItems();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM book";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("Name");
				comboBox.addItem(name);
			}
				}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(BookPane,e1);
		}
	}*/
	
	
	 private void View_books() {
		   try {
			   conn = DB.bdconnect();
			   stmt = conn.createStatement();
			   String sql = "SELECT * FROM book";
			   rs = stmt.executeQuery(sql);
			   table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
		   catch(Exception e) {
			   JOptionPane.showMessageDialog(null, e);
		   }
		   }
}
	
