import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class BeJewweled {
	private ArrayList<String> allLines;// add command datas to this list.
	GameGrid gamergrid;
	private Person[] personlist;
	private int lastelement;
	ArrayList<String> array;
	private String name=" ";
	private FileWriter BeJewweledtxt;
	private String writed="";
	
// Bejewweled class is getting all command and perform action up to command.
	public BeJewweled(String gamegrid,String command) {
		array=new ArrayList<String>();
		
		  try {
			gamergrid=new GameGrid(gamegrid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Command(command);

		 
		
	}
	public void Command(String commandtxtfilename)  {// read command from file and doing task
		try {
			allLines= (ArrayList<String>) Files.readAllLines(Paths.get(commandtxtfilename));
			for (int i=0;i<allLines.size();i++) {
				
				if(allLines.get(i).length()==1) { Exitcommand(allLines.get(i+1)); break;}
				else { ApplyCommand(allLines.get(i)); }
			}} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<String> getCommandList() {
		return allLines;
	}
	private void ApplyCommand(String cmnd) {
		gamergrid.applycordinate(Integer.valueOf( cmnd.split(" ")[0]),Integer.valueOf( cmnd.split(" ")[1]));
		
	}
	
		
	private void Exitcommand(String name) {// when E command encounterted. it works
		
	readleaderboradfile();
	ranking(name);
	WriteLeaderBoarFile(name);
	}	private void ranking(String name) {
		personlist[lastelement]= new Person(name,Integer.valueOf(gamergrid.getScore()));
		Arrays.sort(personlist, new PersonComparator());
		String rankprinted="";
		int score=gamergrid.getScore();
		for (int i = 0; i < personlist.length; i++) {
			if(personlist[i].getName().equals(name)) {
				if(i==0)
				rankprinted=("Your rank is "+(i+1)+"/"+(lastelement+1)+", your score is "+( score-personlist[1].getPoint())+" higher than " +personlist[1].getName());
				else if(i==personlist.length-1)
					rankprinted=("Your rank is "+(i+1)+"/"+(lastelement+1)+", your score is "+(personlist[i-1].getPoint()-score)+" lower than " +personlist[i-1].getName());
				else 
					rankprinted=("Your rank is "+(i+1)+"/"+(lastelement+1)+", your score is "+(personlist[i-1].getPoint()-score)+" lower than " +personlist[i-1].getName()+" and "+(score-personlist[i+1].getPoint())+" higher than " +personlist[i+1].getName());

			}}
		writed+="Select coordinate or enter E to end the game: E\n\n";
		writed+="Total Score: "+gamergrid.getScore()+" points\n\n";
		writed+="Enter name: "+name+"\n\n";
		writed+=rankprinted+"\n\n"+"GoodBye";
		gamergrid.addelementoprintarray(writed); 
		
		
		
	}
	private void WriteLeaderBoarFile(String name) {// leaderboard file is written after all process.
		try {
			BeJewweledtxt=new FileWriter("leaderboard.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String string : array) {
			try {
				BeJewweledtxt.write(string+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			BeJewweledtxt.write(name+" "+gamergrid.getScore());
			BeJewweledtxt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void readleaderboradfile() {// read leaderboardfile
		try {
			array= (ArrayList<String>) Files.readAllLines(Paths.get("leaderboard.txt"));
			
			  lastelement=array.size();
			  personlist=new Person[lastelement+1];
			  

			for (int i = 0; i < array.size(); i++) {
				String name= array.get(i).split(" ")[0];
				Integer Intege=Integer.valueOf(array.get(i).split(" ")[1]);
				personlist[i]=new Person(name,Intege);
				}
		
			
	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
