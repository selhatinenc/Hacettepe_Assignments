import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Sorting {
	ContactArrayList contactarraylist;
	public Sorting(ContactArrayList contactarraylist) throws IOException{// This class storing, sorting data and writing into the file
		this.contactarraylist=contactarraylist; //this class get data from contacts.txt and has two get methods (getArrayList and getContactList)
		LastNameComparator lastNameComparator= new LastNameComparator();// this class sorts name respect with lastname
		
		
		sortLastNameComparator(contactarraylist, lastNameComparator); // it set order by lastnameComparator
		storeHashSet(contactarraylist);//store and write to hashset file
		storeTreeSet(contactarraylist);//store data in treeset and write to treeset file
		contactsTreeSetOrderByLastName(contactarraylist);// Treeset with using LastNameComparator and write to file.txt
		contactsHashMap(contactarraylist);// store data in the hashmap and write into the file
	}
		
	
	public void storeTreeSet(ContactArrayList contactarraylist) throws IOException {
		FileWriter filewriter=new FileWriter("contactsTreeSet.txt");
		TreeSet<Contact> treeset=new TreeSet<Contact>(new PhoneNumberComparator());
		for (Contact contact : contactarraylist.getcontacts()) {
			treeset.add(contact);
		}
		for (Contact contact : treeset) {
			filewriter.write(contact.toString());
		}filewriter.close();
		
	}
	
	
	public void contactsHashMap(ContactArrayList contactArrayList) throws IOException {
		FileWriter filewriter=new FileWriter("contactsHashMap.txt");
		HashMap<String,Contact> hashmap=new HashMap<String,Contact>();
		for (Contact contact : contactArrayList.getcontacts()) {
			hashmap.put(contact.getphonenumber(), contact);
		}
		for (Contact contact : hashmap.values()) {
			filewriter.write(contact.toString());
		}
filewriter.close();
		
	}
	
	
	public void contactsTreeSetOrderByLastName(ContactArrayList contactarraylist) throws IOException {
	FileWriter filewriter=new FileWriter("contactsTreeSetOrderByLastName.txt");	
	TreeSet<Contact> treeset=new TreeSet<Contact>(new LastNameComparator());
	for (Contact contact : contactarraylist.getcontacts()) {
		treeset.add(contact);
	}
	for (Contact contact : treeset) {
		filewriter.write(contact.toString());
	}filewriter.close();
}

	public void  sortLastNameComparator(	ContactArrayList contactarraylist,LastNameComparator comparator) throws IOException {
		FileWriter filewriter=new FileWriter("contactsArrayListOrderByLastName.txt");
		Arrays.sort(contactarraylist.getcontacts(),comparator);
		for(Contact contact:contactarraylist.getcontacts()) {
filewriter.write(contact.toString());			}filewriter.close();
		
		
	}
	
	
	public void storeHashSet(ContactArrayList contactarraylist) throws IOException {
		HashSet<Contact> hashset=new HashSet<Contact>();
		FileWriter fileWriter=new FileWriter("contactsHashSet.txt");
		for (Contact contact:contactarraylist.getcontacts()) {
			hashset.add(contact);
		}
		for (Contact contact:hashset){
			fileWriter.write(contact.toString());
		}
		fileWriter.close();
	}
}
