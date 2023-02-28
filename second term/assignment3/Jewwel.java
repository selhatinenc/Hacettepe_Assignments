import java.util.ArrayList;

public abstract class Jewwel {
	 String name;
	 int point=0;
	 public Jewwel() {
		

		 
	 }
	 public int getPoint() {return point;
	 
	 }
	 
	 public String getName() {return name;}
	public void setName(String name) { this.name=name;}
	
}
class Wildcard extends Jewwel{

	public Wildcard(){point=10;}
	
	
 public int getPoint() {return point;
	 
	 }
	@Override
	public void setName(String name) {
		this.name=name;
	}
	
}
class Triangle extends Jewwel{
	public Triangle() {point=15;}

 public int getPoint() {return point;
	 
	 }

	

	
	
}


class Square extends Jewwel{
	public Square() {point=15;}

 public int getPoint() {return point;
	 
	 }
	
}


class Diamond extends Jewwel{

	public Diamond() {point=30;}
 public int getPoint() {return point;
	 
	 }

}
	

class Symbol extends Jewwel{

	public Symbol() {point=20;}
 public int getPoint() {return point;
	 
	 }




}



