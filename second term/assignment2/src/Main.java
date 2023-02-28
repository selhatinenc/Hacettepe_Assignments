import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Main {
	private static Properties[] propertieslist;
	private static ArrayList<ArrayList<String>> properyarray;
	private static ArrayList<String> allLines;
	static Player player1;
	static Player player2;
	public static Banker banker;
	private static boolean gamestate;
	private static String process;
	private static FileWriter fileWriter;
	private static ArrayList<String>communityList;
	private static 	ArrayList <String>chanceList;
	private static ListJsonReader listJsonReader;
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{
		listJsonReader=new ListJsonReader();
		communityList=new ArrayList<String>();
		chanceList=new ArrayList<String>();
		
		getChanceList();
		getCommunityList();
		fileWriter=new FileWriter("output.txt");
		gamestate=true; 
		allLines=new ArrayList<String>();
		 player1=new Player("player1",banker);
		 player2=new Player("player2",banker);
		 banker=new Banker();
		readcommand(args[0]);
		 propertieslist=new Properties[28];
		 properyarray=new PropertyJsonReader().getPropertiesarray();
		 Appling();
			applycommand(allLines);

		
	}
	static void readcommand(String command) {
		try {
			allLines = (ArrayList<String>) Files.readAllLines(Paths.get(command));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	static ArrayList readsquares() throws FileNotFoundException, IOException {
		ArrayList<String>allLinesofsquares = new ArrayList<String>() ;
		try (BufferedReader br = new BufferedReader(new FileReader("squares.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    allLinesofsquares.add(line);
		    }
		}
		 			return allLinesofsquares;

		
		
	}
	static void applycommand(ArrayList linesofcommands) throws NumberFormatException, IOException {
		int countnumber=1;
		int countnumber2=1;
		for (Iterator iterator = linesofcommands.iterator(); iterator.hasNext();) {
			String object = (String) iterator.next();
			if(gamestate==true) {
			if(object.length()==6) {

					show();
			}
			else {
				String[]	objects=object.split(";");
					
					if(objects[0].equals("Player 1")) {
						if(player1.getwaittour()==0) {
						player1.todice(Integer.valueOf(objects[1]),player2,banker,propertieslist);
						process=player1.getProcess();
						fileWriter.write("Player 1\t"+Integer.valueOf(objects[1])+"\t"+player1.getLocation()
						+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player  1  "+process+"\n");
						System.out.println("Player 1\t"+Integer.valueOf(objects[1])+"\t"+player1.getLocation()
						+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player  1  "+process);
						}else
						{
							
							process="Player 1\tin  jail 	(count= "+countnumber+")";
							fileWriter.write("Player 1\t"+Integer.valueOf(objects[1])+"\t"+player1.getLocation()
							+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player  1  "+process+"\n");
							System.out.println("Player 1\t"+Integer.valueOf(objects[1])+"\t"+player1.getLocation()
							+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player  1  "+process);
							player1.setwaittour(-1);
						if(player1.getwaittour()==0)
							countnumber=1;
						else 
							countnumber+=1;
						}
						gamestate=player1.getGamestate();
						}
						
					else if(objects[0].equals("Player 2"))
					{ 
						if(player2.getwaittour()==0) {
							
						player2.todice(Integer.valueOf(objects[1]),player1,banker,propertieslist);
						process=player2.getProcess();	
						process="Player 2\t"+Integer.valueOf(objects[1])+"\t"+player2.getLocation()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player  2  "+process;
						System.out.println(process);
						}

						else {
							process="Player 2\tin  jail  (count="+countnumber2+")";
							process="Player 2\t"+Integer.valueOf(objects[1])+"\t"+player2.getLocation()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player  2  "+process;

							System.out.println(process);
							player2.setwaittour(-1);
							if(player2.getwaittour()==0)
								countnumber2=1;
							else 
								countnumber2+=1;
						}						
						fileWriter.write(process+"\n");

						gamestate=player2.getGamestate();
					}
						
							
					
					
					}
			if(!iterator.hasNext()) {
				show();
				fileWriter.close();
			}
			
		}
			else  {

			show();
			fileWriter.close();
			break;

		}
		
		}
		 
	}
	private static void show() throws IOException {
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.println("Player 1\t"+player1.getMoney()+"   \thave "+player1.getpropertyString());

		System.out.println("Player 2\t"+player2.getMoney()+"\thave "+player2.getpropertyString());
		System.out.println("Banker\t"+banker.getmoney());
		if(player1.getMoney()<player2.getMoney())
			System.out.println("Winner	Player	  2");
		else if(player1.getMoney()==player2.getMoney())
			System.out.println("No\twinner \n");
		else
			System.out.println("Winner	Player 1\n");
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		fileWriter.write("-----------------------------------------------------------------------------------------------------------\n");
		fileWriter.write("Player 1\t"+player1.getMoney()+"\thave "+player1.getpropertyString()+"\n");

		fileWriter.write("Player 2\t"+player2.getMoney()+"\thave "+player2.getpropertyString()+"\n");
		fileWriter.write("Banker\t"+banker.getmoney()+"\n");
		if(player1.getMoney()<player2.getMoney())
			fileWriter.write("Winner	Player  2\n");
		else if(player1.getMoney()==player2.getMoney())
			fileWriter.write("No	winner\n");
		else
			fileWriter.write("Winner	Player 1\n");
		fileWriter.write("-----------------------------------------------------------------------------------------------------------\n");



	}
	private static void Appling() {
//		properies is sending properties class
		int a=-1;
		 for (Iterator iterator = properyarray.iterator(); iterator.hasNext();) {
				ArrayList<String> array =  (ArrayList<String>) iterator.next();
				int id=Integer.valueOf(array.get(0));

				String description=array.get(1);
				int cost=Integer.valueOf(array.get(2));

				String typeproperty=array.get(3);

				a+=1;
				if(typeproperty.equals("1")) {
					Land land=new  Land();
					land.setCost(cost);
					land.setDescription(description);
					land.setid(id);
					land.setpropertype(1);
					propertieslist[a]=land;
					
				}
				if(typeproperty.equals("2")) {
					Railroads railroads = new Railroads();
					railroads.setCost(cost);
					railroads.setDescription(description);
					railroads.setid(id);
					railroads.setpropertype(2);
					propertieslist[a]=railroads;
					
				}
				if(typeproperty.equals("3")) {
					Company company=new  Company();
					company.setCost(cost);
					company.setDescription(description);
					company.setid(id);
					company.setpropertype(3);
					propertieslist[a]=company;
				}
				
				
			}
		
	}
	static void getChanceList() {
		 chanceList= listJsonReader.getChanceList();
	}
	static void getCommunityList() {
		 communityList= listJsonReader.getCommunitychesList();
	}
	
	public String getelementchance() {
		if(chanceList.isEmpty())
			getChanceList();
		String firstelement=chanceList.get(0);

		chanceList.remove(0);
		return firstelement;
	}
public	String getelementcommunity() {
		
		if(communityList.isEmpty())
			getCommunityList();
			
		String firstelement=communityList.get(0);
		communityList.remove(0);
		return firstelement;
	}
	



}
