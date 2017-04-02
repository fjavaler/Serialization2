package m5_a2;

import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Controller
{
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
		contactList = deserialize();
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
			JOptionPane.showMessageDialog(null, "An error occurred while opening " + "this file.");
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
	public ArrayList<BusinessContact> deserialize()
	{
		ArrayList<BusinessContact> list = new ArrayList<BusinessContact>();
		try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file.getAbsolutePath())))
		{
			list = (ArrayList<BusinessContact>) inStream.readObject();
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
		return list;
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
