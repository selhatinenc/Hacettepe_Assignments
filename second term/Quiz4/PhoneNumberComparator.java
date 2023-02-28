import java.util.Comparator;

public class PhoneNumberComparator implements Comparator<Contact>{ //sort contact objects in order phone number

	@Override
	public int compare(Contact o1, Contact o2) {
		// TODO Auto-generated method stub
		return o1.getphonenumber().compareTo(o2.getphonenumber());
	}

}
