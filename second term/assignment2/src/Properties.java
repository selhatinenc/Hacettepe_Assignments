
public abstract class Properties {

	String description = " x properity";
	String owner="null";
	int cost=0;
	int id=0;
	int propertytype=0;
	public String getDescription()	{
		return description;
	}
	public abstract void setowner(String name) ;
	public  String getowner() {
		return owner;
	}
	public abstract int getid();
	public abstract int setid(int id);
	public abstract int setCost(int cost);
	
	public abstract void setpropertype(int number);
	public abstract int getpropertype();
	public abstract int getCost();
	public abstract String setDescription(String descript);
	
}
class Land extends Properties{

	@Override
	public void setowner(String name) {
		// TODO Auto-generated method stub
		owner=name;
	}

	@Override
	
	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public int setid(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		return id;
	}

	@Override
	public int setCost(int cost) {
		// TODO Auto-generated method stub
		this.cost=cost;
		return cost;
	}

	@Override
	public String setDescription(String descript) {
		// TODO Auto-generated method stub
		this.description=descript;
		return descript;
	}



	@Override
	public void setpropertype(int number) {
		// TODO Auto-generated method stub
		this.propertytype=number;
	}

	@Override
	public int getpropertype() {
		// TODO Auto-generated method stub
		return propertytype;
	}


	
}
class Railroads extends Properties{
	

	@Override
	public void setowner(String name) {
		// TODO Auto-generated method stub
		owner=name;
	}

	@Override
	
	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public int setid(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		return id;
	}

	@Override
	public int setCost(int cost) {
		// TODO Auto-generated method stub
		this.cost=cost;
		return cost;
	}

	@Override
	public String setDescription(String descript) {
		// TODO Auto-generated method stub
		this.description=descript;
		return descript;
	}

	@Override
	public void setpropertype(int number) {
		// TODO Auto-generated method stub
		propertytype=number;
	}

	@Override
	public int getpropertype() {
		// TODO Auto-generated method stub
		return propertytype;
	}


	
}
class Company extends Properties{

	@Override
	public void setowner(String name) {
		// TODO Auto-generated method stub
		owner=name;
	}

	@Override
	
	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public int setid(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		return id;
	}

	@Override
	public int setCost(int cost) {
		// TODO Auto-generated method stub
		this.cost=cost;
		return cost;
	}

	@Override
	public String setDescription(String descript) {
		// TODO Auto-generated method stub
		this.description=descript;
		return descript;
	}

	@Override
	public void setpropertype(int number) {
		// TODO Auto-generated method stub
		propertytype=number;
	}

	@Override
	public int getpropertype() {
		// TODO Auto-generated method stub
		return propertytype;
	}


	
}