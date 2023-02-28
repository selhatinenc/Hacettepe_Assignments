import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		ContactArrayList contactarraylist=new ContactArrayList(args[0]); //this class get data from contacts.txt and has two get methods (getArrayList and getContactList)
		LastNameComparator lastNameComparator= new LastNameComparator();// this class sorts name respect with lastname
		Sorting sorting=new Sorting(contactarraylist);// Sorting and storing process are performed in this class
		System.exit(0);
	}


}
