import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Timer;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.io.FileWriter;   // Import the FileWriter class

public class Main{
	


	public static void main(String[] args)  throws IOException {
		ArrayList<Integer> ascend;
		ArrayList<String> write;		
		FileWriter outputfile;
		ArrayList<Integer> descend;

		write=new ArrayList<>();
		ascend=new ArrayList<Integer>();
		
	
		descend=new ArrayList<Integer>();
		outputfile=new FileWriter(args[2]);

		// TODO Auto-generated method stub
			
		   
				ArrayList<Integer> resultlist=new ArrayList<Integer>();

				


				BufferedReader abc = new BufferedReader(new FileReader(new File(args[2])));
				String []data;
				data = new String[12]; // <= how can I do that? data = new String[lines.size]
				
				for (int i=0; i<12; i++) {
					data[i] = abc.readLine();
				}
				abc.close();
				

			int numberofarms=Integer.valueOf(data[1]);	
			for (int i=100;i<numberofarms;i++){

				int length=String.valueOf(i).length();
				String digits=String.valueOf(i);
				String[] digitsarr=digits.split("");
				int chechvalue=0;
				for(int j=0;j<digitsarr.length;j++) {
					chechvalue=chechvalue+(int)(Math.pow( (int)Integer.valueOf(digitsarr[j]) ,length));


				}
				if(i==chechvalue){
					resultlist.add(i);
					
					outputfile.write(String.valueOf(i) +"\n \t \n");
				
				}

				

				

		}
		
		commands(data,descend,ascend,write);
		for(int k=0;k<write.size();k++){
			outputfile.write(write.get(k));
		}




		
		outputfile.close();
		System.exit(0);
			
		
		
		
		
		}

		static void commands(String[] list,	ArrayList<Integer> descend,	ArrayList<Integer> ascend,ArrayList<String> write){
			for(int i=0;i<list.length;i++){
				
				if(list[i].equals("Ascending order sorting")){

					for(int j=i+1;j<list.length;j++){
						if(! list[j].equals("-1")){
							ascend.add(Integer.valueOf(list[j]));
	
							System.out.println(list[j]);
							
						}
						
						 
						  Collections.sort(ascend);
						  for(int k=0;k<ascend.size();k++ ){
							  write.add(String.valueOf(ascend.get(k)) +" ");

						  }
						  write.add("\n");
						if(list[j].equals("-1") ){
							break;
						}
					

				}
					
				}
				if(list[i].equals("Descending order sorting")){

					for(int j=i+1;j<list.length;j++){
						if(! list[j].equals("-1")){
							descend.add(Integer.valueOf(list[j]));
							System.out.println(list[j]);
						}
						Collections.sort(descend);
						Collections.reverse(descend);

						for(int k=0;k<descend.size();k++ ){
							write.add(String.valueOf(descend.get(k)) +" ");

						}
						write.add("\n");
						
						if(list[j].equals("-1")){
							break;
						}

				}
					
				}
				if(list[i].equals("qdlaösdfasfaslf")){
					
					System.exit(0);
				}
				


			}

		}
			
		}
		
		
		
		
		
		
		
		
