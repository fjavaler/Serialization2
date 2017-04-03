/********************************************************
 *
 *  Project :  <Name of project|assignment>
 *  File    :  <Name of source code file>
 *  Name    :  <Name of programmer>
 *  Date    :  <Date created (project due date)>
 *
 *  Description : (Narrative description, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *
 *    2) What data-structures are used.
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *
 *    4) What methods are implemented (optional).
 *
 *  Changes :  <Description|date of modifications>
 *
 ********************************************************/
package m5_a2;

import java.io.Serializable;

import javax.swing.JOptionPane;

/**
 * This class creates BusinessContact objects. A businessContact has a first
 * name, last name, phone number, email address, and a company.
 * 
 * @author Frederick Javalera
 */
public class BusinessContact implements Serializable
{
	// fields
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private String company;

	/****************************************************
	 * Method     : BusinessContact (constructor)
	 *
	 * Purpose    : The Sort method sorts an array of
	 *              integers using a standard bubble sort.
	 *              The array is sorted in place.
	 *
	 * Parameters : array              - an array of integers
	 *              number_of_elements - the number of elements
	 *                                   in the array
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	public BusinessContact(String _firstName, String _lastName, String _phoneNumber, String _emailAddress,
			String _company)
	{
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.company = _company;
		if(!validatePhone(_phoneNumber))
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid phone number...", 
					"Invalid Phone Number Entered", JOptionPane.ERROR_MESSAGE);
		}
		if(!validateEmail(_emailAddress))
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid email address...", 
					"Invalid Email Address Entered", JOptionPane.ERROR_MESSAGE);
		}
	}

	/****************************************************
	 * Method     : Sort
	 *
	 * Purpose    : The Sort method sorts an array of
	 *              integers using a standard bubble sort.
	 *              The array is sorted in place.
	 *
	 * Parameters : array              - an array of integers
	 *              number_of_elements - the number of elements
	 *                                   in the array
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	private boolean validatePhone(String _phoneNumber)
	{
		if(_phoneNumber.matches("[ -(]*\\d{3}[ -).]*[ -.]*\\d{3}[ -.]*\\d{4}"))
		{
			if(_phoneNumber.charAt(0) == '1')
			{
				_phoneNumber = _phoneNumber.substring(1, _phoneNumber.length()-1);
			}
			for(int i = 0; i < _phoneNumber.length(); i++)
			{
				if(Character.isDigit(_phoneNumber.charAt(i)))
				{
					if(phoneNumber == null)
					{
						phoneNumber = "";
						phoneNumber += _phoneNumber.charAt(i);
					}
					else
					{
						phoneNumber += _phoneNumber.charAt(i);
					}
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	/****************************************************
	 * Method     : Sort
	 *
	 * Purpose    : The Sort method sorts an array of
	 *              integers using a standard bubble sort.
	 *              The array is sorted in place.
	 *
	 * Parameters : array              - an array of integers
	 *              number_of_elements - the number of elements
	 *                                   in the array
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	private boolean validateEmail(String _emailAddress)
	{
		if(_emailAddress.matches(".*[.]*.\\@.*\\.[A-Za-z]{3}"))
		{
			emailAddress = _emailAddress;
			return true;
		}
		return false;
	}
	
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	/****************************************************
	 * Method     : Sort
	 *
	 * Purpose    : The Sort method sorts an array of
	 *              integers using a standard bubble sort.
	 *              The array is sorted in place.
	 *
	 * Parameters : array              - an array of integers
	 *              number_of_elements - the number of elements
	 *                                   in the array
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	@Override
	public String toString()
	{
		return "BusinessContact [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", company=" + company + "]";
	}
}