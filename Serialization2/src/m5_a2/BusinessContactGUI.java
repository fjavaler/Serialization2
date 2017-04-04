package m5_a2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

/**
 * This class creates a BusinessContact graphical user interface. A
 * BusinessContactGUI contains a JFrame, JTextFields, a JComboBox, JButtons, an
 * ArrayList, a File, a String and a boolean.
 * 
 * @author Frederick Javalera
 */
public class BusinessContactGUI
{
	// fields
	private JFrame frmBusinessContactManagement;
	private JTextField textFieldFirst;
	private JTextField textFieldLast;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextField textFieldCompany;
	private JComboBox<String> comboBoxContacts;
	private JButton btnNew;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private ArrayList<BusinessContact> contactList;
	private File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			/**
			 * Run the program.
			 */
			public void run()
			{
				try
				{
					BusinessContactGUI window = new BusinessContactGUI();
					window.frmBusinessContactManagement.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BusinessContactGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		// JFrame
		frmBusinessContactManagement = new JFrame();
		frmBusinessContactManagement.setFont(new Font("Droid Serif", Font.BOLD, 13));
		frmBusinessContactManagement.setTitle("Business Contact Management System");
		frmBusinessContactManagement.setBounds(100, 100, 600, 400);
		frmBusinessContactManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusinessContactManagement.getContentPane().setLayout(null);
		frmBusinessContactManagement.setLocationRelativeTo(null);

		// contacts
		JPanel panelContacts = new JPanel();
		panelContacts.setForeground(SystemColor.text);
		panelContacts.setBorder(UIManager.getBorder("Button.border"));
		panelContacts.setBackground(new Color(240, 255, 255));
		panelContacts.setBounds(20, 22, 80, 18);
		frmBusinessContactManagement.getContentPane().add(panelContacts);
		panelContacts.setLayout(null);

		JLabel lblContacts = new JLabel("Contacts");
		lblContacts.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacts.setForeground(Color.ORANGE);
		lblContacts.setFont(new Font("Droid Sans", Font.BOLD, 17));
		lblContacts.setBounds(3, 2, 72, 15);
		panelContacts.add(lblContacts);

		// initialize contact array list
		contactList = new ArrayList<BusinessContact>();

		// first name
		JPanel panelFirstName = new JPanel();
		panelFirstName.setForeground(SystemColor.text);
		panelFirstName.setBorder(UIManager.getBorder("Button.border"));
		panelFirstName.setBackground(new Color(240, 255, 255));
		panelFirstName.setBounds(221, 22, 97, 18);
		frmBusinessContactManagement.getContentPane().add(panelFirstName);
		panelFirstName.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setForeground(Color.ORANGE);
		lblFirstName.setFont(new Font("Droid Sans", Font.BOLD, 17));
		lblFirstName.setBounds(3, 3, 90, 13);
		panelFirstName.add(lblFirstName);

		// last name
		JPanel panelLastName = new JPanel();
		panelLastName.setForeground(SystemColor.text);
		panelLastName.setBorder(UIManager.getBorder("Button.border"));
		panelLastName.setBackground(new Color(240, 255, 255));
		panelLastName.setBounds(374, 22, 97, 18);
		frmBusinessContactManagement.getContentPane().add(panelLastName);
		panelLastName.setLayout(null);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setForeground(Color.ORANGE);
		lblLastName.setFont(new Font("Droid Sans", Font.BOLD, 17));
		lblLastName.setBounds(3, 3, 90, 13);
		panelLastName.add(lblLastName);

		textFieldFirst = new JTextField();
		textFieldFirst.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		textFieldFirst.setBounds(218, 49, 139, 28);
		frmBusinessContactManagement.getContentPane().add(textFieldFirst);
		textFieldFirst.setColumns(10);

		textFieldLast = new JTextField();
		textFieldLast.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		textFieldLast.setBounds(371, 49, 208, 28);
		frmBusinessContactManagement.getContentPane().add(textFieldLast);
		textFieldLast.setColumns(10);

		comboBoxContacts = new JComboBox<String>();
		comboBoxContacts.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// TODO: implement comboBox selection
			}
		});
		comboBoxContacts.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		comboBoxContacts.setBounds(15, 51, 195, 27);
		frmBusinessContactManagement.getContentPane().add(comboBoxContacts);

		// phone
		JPanel panelPhone = new JPanel();
		panelPhone.setForeground(SystemColor.text);
		panelPhone.setBorder(UIManager.getBorder("Button.border"));
		panelPhone.setBackground(new Color(240, 255, 255));
		panelPhone.setBounds(221, 112, 131, 18);
		frmBusinessContactManagement.getContentPane().add(panelPhone);
		panelPhone.setLayout(null);

		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setBackground(new Color(240, 255, 255));
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setForeground(Color.ORANGE);
		lblPhone.setFont(new Font("Droid Sans", Font.BOLD, 17));
		lblPhone.setBounds(0, 3, 130, 13);
		panelPhone.add(lblPhone);

		// email
		JPanel panelEmail = new JPanel();
		panelEmail.setForeground(SystemColor.text);
		panelEmail.setBorder(UIManager.getBorder("Button.border"));
		panelEmail.setBackground(new Color(240, 255, 255));
		panelEmail.setBounds(374, 112, 56, 18);
		frmBusinessContactManagement.getContentPane().add(panelEmail);
		panelEmail.setLayout(null);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBackground(new Color(240, 255, 255));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.ORANGE);
		lblEmail.setFont(new Font("Droid Sans", Font.BOLD, 17));
		lblEmail.setBounds(0, 3, 56, 13);
		panelEmail.add(lblEmail);

		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		textFieldPhone.setBounds(218, 139, 139, 28);
		frmBusinessContactManagement.getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		textFieldEmail.setBounds(371, 139, 208, 28);
		frmBusinessContactManagement.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);

		// company
		JPanel panelCompany = new JPanel();
		panelCompany.setForeground(SystemColor.text);
		panelCompany.setBorder(UIManager.getBorder("Button.border"));
		panelCompany.setBackground(new Color(240, 255, 255));
		panelCompany.setBounds(222, 203, 85, 19);
		frmBusinessContactManagement.getContentPane().add(panelCompany);
		panelCompany.setLayout(null);

		JLabel lblCompany = new JLabel("Company");
		lblCompany.setBackground(new Color(240, 255, 255));
		lblCompany.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompany.setForeground(Color.ORANGE);
		lblCompany.setFont(new Font("Droid Sans", Font.BOLD, 17));
		lblCompany.setBounds(0, 1, 85, 17);
		panelCompany.add(lblCompany);

		textFieldCompany = new JTextField();
		textFieldCompany.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		textFieldCompany.setColumns(10);
		textFieldCompany.setBounds(218, 230, 361, 28);
		frmBusinessContactManagement.getContentPane().add(textFieldCompany);

		// "new" button
		btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// clear text fields
				textFieldFirst.setText("");
				textFieldLast.setText("");
				textFieldPhone.setText("");
				textFieldEmail.setText("");
				textFieldCompany.setText("");
				// set add button to true
				btnAdd.setEnabled(true);
				// update file status
			}
		});
		ImageIcon newIcon = new ImageIcon("src/blueSquareButtonNew.png");
		try
		{
			Image img = newIcon.getImage();
			Image newimg = img.getScaledInstance(117, 39, java.awt.Image.SCALE_SMOOTH);
			newIcon = new ImageIcon(newimg);
			btnNew.setIcon(newIcon);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		btnNew.setForeground(new Color(0, 0, 0));
		btnNew.setBackground(Color.WHITE);
		btnNew.setFont(new Font("Droid Sans", Font.BOLD, 17));
		btnNew.setBounds(47, 283, 117, 39);
		frmBusinessContactManagement.getContentPane().add(btnNew);

		// "add" button
		btnAdd = new JButton("");
		ImageIcon addIcon = new ImageIcon("src/blueSquareButtonAdd.png");
		try
		{
			Image img = addIcon.getImage();
			Image newimg = img.getScaledInstance(117, 39, java.awt.Image.SCALE_SMOOTH);
			addIcon = new ImageIcon(newimg);
			btnAdd.setIcon(addIcon);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// construct new contact
				BusinessContact contact = new BusinessContact(textFieldFirst.getText(), textFieldLast.getText(),
						textFieldPhone.getText(), textFieldEmail.getText(), textFieldCompany.getText());
				// add contact to ArrayList
				contactList.add(contact);
				if (file != null)
				{
					serialize();
				}
				else
				{
					// do not serialize here. Serialize later or it will fail
					// because no file has been chosen yet.
					// update contactList comboBox
					selectFileAndSaveAs();
					updateComboBox();
				}

				// update file status
				// fileStatus("saved");

				// deactivate add button
				btnAdd.setEnabled(false);
			}
		});
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setEnabled(false);
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setFont(new Font("Droid Sans", Font.BOLD, 17));
		btnAdd.setBounds(176, 283, 117, 39);
		frmBusinessContactManagement.getContentPane().add(btnAdd);

		// "delete" button
		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// TODO: implement delete button pressed

				// update file status
			}
		});
		ImageIcon deleteIcon = new ImageIcon("src/blueSquareButtonDelete.png");
		try
		{
			Image img = deleteIcon.getImage();
			Image newimg = img.getScaledInstance(117, 39, java.awt.Image.SCALE_SMOOTH);
			deleteIcon = new ImageIcon(newimg);
			btnDelete.setIcon(deleteIcon);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("Droid Sans", Font.BOLD, 17));
		btnDelete.setBounds(434, 283, 117, 39);
		frmBusinessContactManagement.getContentPane().add(btnDelete);

		// "update" button
		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// TODO: implement update button pressed

				// update file status
			}
		});
		ImageIcon updateIcon = new ImageIcon("src/blueSquareButtonUpdate.png");
		try
		{
			Image img = updateIcon.getImage();
			Image newimg = img.getScaledInstance(117, 39, java.awt.Image.SCALE_SMOOTH);
			updateIcon = new ImageIcon(newimg);
			btnUpdate.setIcon(updateIcon);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setFont(new Font("Droid Sans", Font.BOLD, 17));
		btnUpdate.setBounds(304, 283, 117, 39);
		frmBusinessContactManagement.getContentPane().add(btnUpdate);

		// background image
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 0, 600, 378);
		URL url = BusinessContactGUI.class.getResource("/businessBackground.jpg");
		ImageIcon backgroundImg = new ImageIcon(url);
		lblImage.setIcon(backgroundImg);
		frmBusinessContactManagement.getContentPane().add(lblImage);

		JMenuBar menuBar = new JMenuBar();
		frmBusinessContactManagement.setJMenuBar(menuBar);

		// "file" menu
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		// "open" menu item
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				selectFileAndOpen();
				updateComboBoxOnOpen();
				fileStatus("saved");
			}
		});
		mntmOpen.setIcon(new ImageIcon(BusinessContactGUI.class.getResource("/open.png")));
		fileMenu.add(mntmOpen);

		// "menu" separator
		JSeparator separator = new JSeparator();
		fileMenu.add(separator);

		// "save" menu item
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// TODO: implement "save" menu item pressed
				saveFile();
				// writeFile()
				// update file status
			}
		});
		mntmSave.setIcon(new ImageIcon(BusinessContactGUI.class.getResource("/save.png")));
		fileMenu.add(mntmSave);

		// "save as" menu item
		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mntmSaveAs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// TODO: implement "save as..." menu item pressed
			}
		});
		mntmSaveAs.setIcon(new ImageIcon(BusinessContactGUI.class.getResource("/saveAs.png")));
		fileMenu.add(mntmSaveAs);

		// menu separator
		JSeparator separator_1 = new JSeparator();
		fileMenu.add(separator_1);

		// "exit" menu item
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// exit
				System.exit(0);
			}
		});
		mntmExit.setIcon(
				new ImageIcon(BusinessContactGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		fileMenu.add(mntmExit);

		// "help" menu
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		// "about" menu item
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// TODO: Implement "about" pop-up window
			}
		});
		mntmAbout.setIcon(new ImageIcon(BusinessContactGUI.class.getResource("/about.png")));
		helpMenu.add(mntmAbout);
	}

	protected void fileStatus(String status)
	{
		switch (status)
		{
			case "saved":
			{
				// serialize() directly or indirectly
			}
			case "modified":
			{
				// TODO: implement
			}
		}
	}

	protected void updateComboBox()
	{
		for (BusinessContact contact : contactList)
		{
			comboBoxContacts.addItem(contact.getFirstName() + " " + contact.getLastName());
		}
	}

	protected void updateComboBoxOnOpen()
	{
		deserialize();
		for (BusinessContact contact : contactList)
		{
			comboBoxContacts.addItem(contact.getFirstName() + " " + contact.getLastName());
		}
	}

	protected void selectFileAndOpen()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = 0;
		try
		{
			result = fileChooser.showOpenDialog(null);
		}
		catch (HeadlessException e)
		{
			JOptionPane.showMessageDialog(null, "An error occurred while opening this file.");
		}

		if (result == JFileChooser.CANCEL_OPTION)
		{
			return;
		}

		file = fileChooser.getSelectedFile();
	}

	// For "save as"
	protected void selectFileAndSaveAs()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = 0;
		try
		{
			result = fileChooser.showOpenDialog(null);
		}
		catch (HeadlessException e)
		{
			JOptionPane.showMessageDialog(null, "An error occurred while opening " + "this file.");
		}

		if (result == JFileChooser.CANCEL_OPTION)
		{
			return;
		}

		file = fileChooser.getSelectedFile();
		serialize();
	}

	// "save"
	protected void saveFile()
	{
		int n = comboBoxContacts.getItemCount();
		for (int i = 0; i < n; i++)
		{
			BusinessContact bc = contactList.get(i);
		}
		serialize();
	}

	/****************************************************
	 * Method : deserialize
	 *
	 * Purpose : The deserialize method reads the file located at fileName and
	 * stores its contents in a Person ArrayList which it then returns.
	 *
	 * Parameters : fileName - The name and location of the file to be written.
	 *
	 * Returns : This method returns an ArrayList of Persons.
	 *
	 ****************************************************/
	public void deserialize()
	{
		System.out.println(file.getPath());
		try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file.getPath())))
		{
			contactList = (ArrayList<BusinessContact>) inStream.readObject();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("A problem occurred during de-serialization.");
			System.out.println(e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println("A problem occurred during de-serialization.");
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("A problem occurred during de-serialization.");
			System.out.println(e.getMessage());
		}
	}

	/****************************************************
	 * Method : serialize
	 *
	 * Purpose : The serialize method serializes a list and writes it to a file
	 *
	 * Parameters : None.
	 *
	 * Returns : This method does not return a value.
	 *
	 ****************************************************/
	public void serialize()
	{
		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file.getPath())))
		{
			outStream.writeObject(contactList);
		}
		catch (IOException e)
		{
			System.out.println("A problem occurred during serialization.");
			System.out.println(e.getMessage());
		}
	}
}