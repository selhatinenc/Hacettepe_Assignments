import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Sport {
	static List<String> allLines;
	 String[][] listofsport;
	private String sportname;
	private String sportcalorie;
	public String result;
	

	public void sport() {
		
		readfile();
		
		
			
		}
	
		
		
	
  void readfile() {
		
		try {
			allLines = Files.readAllLines(Paths.get("sport.txt"));
			listofsport=new String[allLines.size()][3];
			int whilenumber=0;
			while(whilenumber<allLines.size()) {
				String[] lines=allLines.get(whilenumber).trim().split("\t");
				
				listofsport[whilenumber][0]=lines[0];
				listofsport[whilenumber][1]=lines[1];
				listofsport[whilenumber][2]=lines[2];
				whilenumber++;
			
		} }catch (IOException e) {
			e.printStackTrace();
		}
	}
 public void findsportdata(String sportid) {
	  
	  int whilenumber=0;
		while(whilenumber<listofsport.length) {  
			if (sportid.equals(listofsport[whilenumber][0])) {
				
				 sportname=listofsport[whilenumber][1];
				 sportcalorie=listofsport[whilenumber][2];
				
				 result=sportname+","+sportcalorie;
				 whilenumber++;
			}
			 whilenumber++;

			
			
		}
		
		 
		
		
	  
  }

}
