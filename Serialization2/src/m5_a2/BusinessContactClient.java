package m5_a2;

public class BusinessContactClient
{

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
	public static void main(String[] args)
	{
		BusinessContact contact = new BusinessContact("Fred", "Javalera", "801-867-0567", "conscientiadivinus@gmail.com", "Adobe");
		System.out.println(contact.toString());
	}

}
