
public class Contact  implements Comparable<Contact> {// This class keeps persons informations and has comparteTo method
	private String firstname="";
	private String lastname="";
	private String phonenumber="";
	private String socialsecurtynumber="";

	
	@Override
	public int compareTo(Contact o) {// compare Two Contact objects
		int result= this.getlastname().compareTo(o.getlastname());
		return result;
	}
// getters , setter and toString methods are below
	public String getfirstname() {
		return firstname;
	}
public void setfirstname(String firstname) {
		this.firstname=firstname;
	}
public String getlastname() {
	return lastname;
}
public void setlastname(String lastname) {
	this.lastname=lastname;
}
public String getphonenumber( ) {
	return phonenumber;
}
public void setphonenumber(String phonenumber) {
	this.phonenumber=phonenumber;
}

public String getsocialsecurtynumber( ) {
	return socialsecurtynumber;
}
public void setsocialsecurtynumber(String socialsecurtynumber) {
	this.socialsecurtynumber=socialsecurtynumber;
}
public String toString() {
	return phonenumber+" "+firstname+" "+lastname+" "+socialsecurtynumber+"\n";
}





}
