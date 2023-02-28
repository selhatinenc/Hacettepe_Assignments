import java.util.Comparator;

public class PersonComparator   implements Comparator<Person>{// person Comparator compare a list of person

	@Override
	public int compare(Person o1, Person o2) {//compare method
	return o2.getPoint().compareTo(o1.getPoint());}

}
