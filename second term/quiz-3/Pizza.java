
public  abstract class Pizza
{
	String description = " x Pizza";

	public String getDescription()
	{
		return description;
	}
	public abstract int getNumber();
	public abstract int getCost();
}


 class NeapolitanPizza extends Pizza
{
	public void FarmHouse() { description = "Neapolitan Pizza"; }
	public int getCost() { return 55; }
	public  int getNumber() {return 0;}
}
//Concrete pizza classes
 class  AmericanPan  extends Pizza
{
	public  int getNumber() {return 0;
	}
	public AmericanPan() { description = "• American Pan Pizza 45 tl"; }
	public int getCost() { return 45; }
}

 abstract class ToppingsDecorator extends Pizza
{
	public abstract String getDescription();{
	}
}


// Concrete toppings classes
class Soudjouk extends ToppingsDecorator
{
	// we need a reference to obj we are decorating
	Pizza pizza;

	public Soudjouk(Pizza pizza) { 
		this.pizza = pizza; }
		
	public String getDescription() {
		if(pizza.getNumber()==3)
			return pizza.getDescription();
		else 
			return pizza.getDescription() + ", Salami ";
			
		
	}

	public int getCost() {
		if(pizza.getNumber()==3)
			return pizza.getCost();
		else
				return 15 + pizza.getCost(); 
	}
}
public  int getNumber() {return 1+pizza.getNumber();
}
class Salami extends ToppingsDecorator
{
	Pizza pizza;
	public  int getNumber() {return 1+pizza.getNumber();
	}
	public Salami(Pizza pizza) { this.pizza = pizza; }
	public String getDescription() {
		
		if(pizza.getNumber()==3)
			return pizza.getDescription();
		else {return pizza.getDescription() + ", Salami ";
			
		}
	}
	public int getCost() {
		if(pizza.getNumber()==3)
			return pizza.getCost();
		else
				return 10 + pizza.getCost(); 
	}
}
class Pepper extends ToppingsDecorator
{
	Pizza pizza;
	
	public  int getNumber() {
		int a=1+pizza.getNumber();
		return a;
	}
	
	public Pepper(Pizza pizza) { this.pizza = pizza; }
	public String getDescription() {
		if(pizza.getNumber()==3)
			return pizza.getDescription();
		else {return pizza.getDescription() + ", Pepper ";
			
		}
		

	}
	public int getCost() {
		
		if(pizza.getNumber()==3)
			return pizza.getCost();
		else
				return 5 + pizza.getCost(); 
}
class onion extends ToppingsDecorator
{
	Pizza pizza;
	
	public  int getNumber() {
		int a=1+pizza.getNumber();
		return a;
	}
	
	public onion(Pizza pizza) { this.pizza = pizza; }
	public String getDescription() {
		if(pizza.getNumber()==3)
			return pizza.getDescription();
		else {return pizza.getDescription() + ", onion ";
			
		}
		
	}
	public int getCost() { 
		if(pizza.getNumber()==3)
			return pizza.getCost();
			else
		return 3 + pizza.getCost(); }
}

class PizzaStore
{
	public void main(String args[])
	{

}
}
}
