
public class Person implements Comparable<Person> {// person class was creatted in order to compare person points.
	private String name;
	private Integer point;
	public Person(String name,Integer point) {
		this.name=name; this.point=point;
		
	}
	public String getName() {
		return name;
	}
	public Integer getPoint() {
		return point;
	}
	@Override
	public int compareTo(Person o) {
	return point.compareTo(o.getPoint());
	}
	public String toString() {
		return getName()+" "+getPoint();
		
	}
	

}
