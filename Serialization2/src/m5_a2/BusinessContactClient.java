package m5_a2;

public class BusinessContactClient
{

	public static void main(String[] args)
	{
		BusinessContact contact = new BusinessContact("Fred", "Javalera", "801-867-0567", "conscientiadivinus@gmail.com", "Adobe");
		System.out.println(contact.toString());
	}

}
