import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.parser.ParseException;

public class Player {
	private int money;
	private String name;
	

	private ArrayList<String> propertys;
	private int location;
	private int waittours;
	private int railroadsnumber;
	private ArrayList<String> allsquares;;;
	private String process;
	Commands commands;
	ListJsonReader listJsonReader;
	 PropertiesCommands propertiesCommands;
		Main main;

	boolean gamestate;
	public Player(String name,Banker banker) throws FileNotFoundException, IOException, ParseException {
	main=new Main();
		 listJsonReader=new ListJsonReader();
		 this.name=name;
		  propertiesCommands=new PropertiesCommands(1,banker);
		 allsquares=new Main().readsquares();
		money=15000;
		propertys=new ArrayList<String>();
		location=1;
		waittours=0;
		 commands=new Commands();
		 gamestate=true;

		 
	}   

public void setlocation(int number) {
	
	location=number;
	}    

	public void todice(int number,Player anotherplayer,Banker banker,Properties[] propertieslist) {
		location+=number;
		dolocationtask( anotherplayer,banker,number,propertieslist);

	}
	
	void dolocationtask(Player otherplayer,Banker banker, int number,Properties[] propertieslist) {

		for (Iterator iterator = allsquares.iterator(); iterator.hasNext();) {
			String[] string =  iterator.next().toString().split("  ");
			int id=Integer.valueOf(string[0]);
			String description=string[1];
			if(location>40)
			{				commands.GO(banker,this); ;;; 
			
			location=	location%40;			
			}
			if(location==id) {
	
				
				if (id==1) {
				process="  is in GO square";
				}
				else if (id==3 || id==18	|| id==34) {

					commands.CommunityChest(main.getelementcommunity(),otherplayer,gamestate,banker,this);
					process=" draw Community Chest -"+commands.getProcess();
				}	
			
			else	if (id==11) {
				process="	went  to  jail";
					setwaittour(3);
				}
			else	if (id==21) {
				process= "  is in Free Parking";
				setwaittour(1);

			}
			else	if (id==23|| id==8|| id==37) {
			String	game=commands.Chance(main.getelementchance(),banker,this);
			process="draw chance  -"+commands.getProcess();
				if(game.equals("leicester"))
				{	propertiesCommands.setlocation(27, number, gamestate,banker,this,otherplayer,propertieslist);
				process=propertiesCommands.getprocess();
				gamestate=propertiesCommands.getGamestate();
				}
				else if(game.equals("true"))
					gamestate=true;
			}
			else	if (id==5|| id==39) {
				gamestate=commands.IncomeTax(true, banker,this);
				process="  paid  tax";
				
			}
			else if(id==31) {
				commands.GoToJail(this);
				setwaittour(3);
				process="	went  to  jail";
				if(id==39)
					process="Super tax";
			}
			else {
				propertiesCommands.setlocation(location, number, gamestate,banker,this,otherplayer,propertieslist);
				gamestate=propertiesCommands.getGamestate();
				process=propertiesCommands.getprocess();
				
			}
				
				
			}
		}
	
		
	}


	public int getRailroadsnumber() {
		return railroadsnumber;
	}

	public void setRailroadsnumber(int railroadsnumber) {
		this.railroadsnumber = this.railroadsnumber+railroadsnumber;
	}

	public String getName() {
		return name;
	}
	public boolean getGamestate() {
		return gamestate;
	}
	
	public void setwaittour(int number) {
		waittours=waittours+number;
	}
	public int getwaittour() {
		return waittours;
	}
	
	public int getLocation() {
		return location;
	}
	public int getMoney() {
		
		return money;
	}
	public void setMoney(int x) {
		
		money= money+x;
	}
	public ArrayList<String> getpropertyarray() {
		return propertys;
	}
	public String getpropertyString() {
		String properties="   ";
		for (int i = 0; i < propertys.size(); i++) {
			if(i==0)
				properties=propertys.get(0);
			else
				
			properties=properties+", "+propertys.get(i);
		}
		return properties;
	}
	public void setpropertyarray(String prpry) {
		propertys.add(prpry);
		
	}
	public String getProcess() {
		return process;
	}
	
	

    
}
