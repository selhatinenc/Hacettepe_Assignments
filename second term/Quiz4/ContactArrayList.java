import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ContactArrayList {	Contact[] contacts;
	private ArrayList<String> allLines;
	public ContactArrayList(String txtfilename) throws IOException {//this class get data from contacts.txt and set arraylist and Contact list.

		ArrayList(txtfilename);
		 contacts=new Contact[allLines.size()];

		writeoutput();
		arraycontacts();
		
	}
	public void ArrayList(String txtfilename) {
		try {
			allLines = (ArrayList<String>) Files.readAllLines(Paths.get(txtfilename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void writeoutput() throws IOException {
		FileWriter filewriter=new FileWriter("contactsArrayList.txt");
		
		for (int i = 0; i < allLines.size(); i++) {
			filewriter.write(allLines.get(i));
		}
		filewriter.close();
	}
	public  ArrayList<String> getarraylist(){
		return allLines;
	}
	private void arraycontacts() {
		for (int i = 0; i < allLines.size(); i++) {
			Contact contact=new Contact();
			String[] AllLines=allLines.get(i).split(" ");
			String phonenumber=AllLines[0];
			String firstname=AllLines[1];
			String lastname=AllLines[2];
			String socialsecuritynumber=AllLines[3];
		
			contact.setphonenumber(phonenumber);
			contact.setfirstname(firstname);
			contact.setlastname(lastname);
			contact.setsocialsecurtynumber(socialsecuritynumber);;
			contacts[i]=contact;;
		}
	
	}	public Contact[] getcontacts() {
		return contacts;
	}
	

}
