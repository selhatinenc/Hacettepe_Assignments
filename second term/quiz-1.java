import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class quiz-1 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		String in = "path";
	
			File file=new File("operation.txt");
			
			Scanner input;
			try {
				input = new Scanner(file.getCanonicalPath());
				in=input.nextLine();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileReader filereader=new FileReader(file.getCanonicalPath());
			int  filedata=filereader.read();
			while (filedata!=-1) {
				System.out.println(filedata);
			} 
			
}
}