import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class Food {
	public String result;

	static List<String> allLines;
	 String[][] listoffood;
	 People people;
	 String foodname;String foodcalorie;
	public void food() {
		  people=new People();

		readfile();
		
		
			
		}
	
		
		
	
  void readfile() {
		
		try {
			allLines = Files.readAllLines(Paths.get("food.txt"));
			listoffood=new String[allLines.size()][3];

			int whilenumber=0;
			while(whilenumber<allLines.size()) {
				String[] lines=allLines.get(whilenumber).trim().split("\t");
				listoffood[whilenumber][0]=lines[0];
				listoffood[whilenumber][1]=lines[1];
				listoffood[whilenumber][2]=lines[2];
				whilenumber++;
			
		} }catch (IOException e) {
			e.printStackTrace();
		}
	}
  public void findfooddata(String foodid) {
	  
	  int whilenumber=0;
		while(whilenumber<listoffood.length) {  
			if (foodid.equals(listoffood[whilenumber][0])) {
				
				 foodname=listoffood[whilenumber][1];
				 foodcalorie=listoffood[whilenumber][2];
				
				 result=foodname+","+foodcalorie;
				 whilenumber++;
			}
			 whilenumber++;

			
			
		}
		
		 
		
		
	  
  }

}
