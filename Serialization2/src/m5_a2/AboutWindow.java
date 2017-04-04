package m5_a2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Window.Type;

public class AboutWindow
{

	private JFrame frmAbout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AboutWindow window = new AboutWindow();
					window.frmAbout.setVisible(true);
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
	public AboutWindow()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmAbout = new JFrame();
		frmAbout.setType(Type.POPUP);
		frmAbout.setTitle("About");
		frmAbout.setResizable(false);
		frmAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAbout.getContentPane().setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		frmAbout.getContentPane().setLayout(null);
		frmAbout.setBounds(0, 0, 498, 225);
		
		JLabel lblAboutThisApp = new JLabel("About this App");
		lblAboutThisApp.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblAboutThisApp.setBounds(191, 28, 95, 16);
		frmAbout.getContentPane().add(lblAboutThisApp);
		
		JLabel lblCreatedByFred = new JLabel("Created by: Fred Javalera");
		lblCreatedByFred.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblCreatedByFred.setBounds(149, 79, 197, 16);
		frmAbout.getContentPane().add(lblCreatedByFred);
		
		JLabel lblCsObjectoriented = new JLabel("CS 1410: Object-oriented Programming, Spring Semester 2017.");
		lblCsObjectoriented.setBounds(46, 131, 400, 16);
		frmAbout.getContentPane().add(lblCsObjectoriented);
	}

	public JFrame getFrame()
	{
		return frmAbout;
	}
}