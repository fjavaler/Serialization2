package m5_a2;

import java.io.File;
import java.util.ArrayList;

public class Model
{
	// fields
	private ArrayList<BusinessContact> contactList;
	private File file;

	public Model()
	{
		contactList = new ArrayList<BusinessContact>();
		file = null;
	}

	/*
	 * add button // construct new contact BusinessContact contact = new
	 * BusinessContact(textFieldFirst.getText(), textFieldLast.getText(),
	 * textFieldPhone.getText(), textFieldEmail.getText(),
	 * textFieldCompany.getText()); // add contact to ArrayList
	 * contactList.add(contact); if (file != null) { serialize(); } else { // do
	 * not serialize here. Serialize later or it will fail // because no file
	 * has been chosen yet. // update contactList comboBox updateComboBox(); }
	 * 
	 * // update file status // fileStatus("saved");
	 * 
	 * // deactivate add button btnAdd.setEnabled(false);
	 */ // end add button

	/*
	 * Open JMenuitem selectFileAndOpen(); updateComboBoxOnOpen();
	 * fileStatus("saved");
	 */ // end open

	/*
	 * Save JMenuItem saveFile(); writeFile() update file status
	 */

	/*
	 * New button 
	 * clear text fields textFieldFirst.setText("");
	 * textFieldLast.setText(""); textFieldPhone.setText("");
	 * textFieldEmail.setText(""); textFieldCompany.setText(""); 
	 * // enable add button
	 * button to true btnAdd.setEnabled(true); // update file status
	 */
}
