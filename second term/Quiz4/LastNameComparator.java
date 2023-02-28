import java.util.Comparator;
import java.util.List;

public class LastNameComparator  implements Comparator<Contact>{//Sort contacts respect with lastname
	
	
	
	@Override
	public int compare(Contact o1, Contact o2) {
		int result=o1.getlastname().compareTo(o2.getlastname());
		return result;
	}


}
