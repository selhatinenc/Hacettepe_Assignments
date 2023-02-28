import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class People {
	static List<String> allLines;
	public String[][] listofpeople;
	public String peopledata;
	

	public void people() {
		
		readfile();
		
		
			
		}
	
		
		
	
  void readfile() {
		
		try {
			
			allLines = Files.readAllLines(Paths.get("people.txt"));
			listofpeople=new String[allLines.size()][6];

			int whilenumber=0;
			while(whilenumber<allLines.size()) {
				String[] lines=allLines.get(whilenumber).trim().split("\t");
				listofpeople[whilenumber][0]=lines[0];//id
				listofpeople[whilenumber][1]=lines[1];// name
				listofpeople[whilenumber][2]=lines[2];//gender
				listofpeople[whilenumber][3]=lines[3];//weight
				listofpeople[whilenumber][4]=lines[4];//height
				listofpeople[whilenumber][5]=lines[5];//birth day

				
				
				
				whilenumber++;
			
		} }catch (IOException e) {
			e.printStackTrace();
		}
	}
 public void findpersondata(String peopleid) {
	  
	  int whilenumber=0;
		while(whilenumber<listofpeople.length) {  
			if (peopleid.equals(listofpeople[whilenumber][0])) {
				
				 String peoplename = listofpeople[whilenumber][1];
				 String height = null;
				 String weight = null;
				 String name = null;
				 String birthday = null;
				 String gender=null;

				 for(int i=0;i<listofpeople.length;i++) {
					 if (peopleid.equals(listofpeople[i][0])) {
						
						  height=listofpeople[i][4];
						  weight=listofpeople[i][3];
						  gender=listofpeople[i][2];
						  name=listofpeople[i][1];
						  birthday=listofpeople[i][5];
					}
					 
					 
					 
				 }
				 peopledata=name+","+weight+","+height+","+birthday+","+gender;
				 whilenumber++;
			}
			 whilenumber++;

			
			
		}
		
		 
		
		
	  
  }

}
