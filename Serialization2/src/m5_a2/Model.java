package m5_a2;

import java.io.File;
import java.util.ArrayList;

public class Model
{
//	fields
	private ArrayList<BusinessContact> contactList;
	private File file;
	
	public Model()
	{
		contactList = new ArrayList<BusinessContact>();
		file = null;
	}
}
