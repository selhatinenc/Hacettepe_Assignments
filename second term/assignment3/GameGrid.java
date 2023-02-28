import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class GameGrid {
	public static String[][] gamegridlist;
	private ArrayList<String> readfile;
	private Jewwel[] jewwel;
	public static int xMatrix,yMatrix;
	 FindTriple findtriple;
	 Person[] personlist;
	 private  int Score;
	 private boolean gamestate=true;
	 private FileWriter monitoringfile;
	 private ArrayList<String> printarray;


	public GameGrid(String gamegridfilename)  {
		printarray=new ArrayList<String>();
		try {monitoringfile=new FileWriter("monitoring.txt");
		monitoringfile.write("Game grid:\n\n");
		startgame();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
				
			
		readfile=new ArrayList<String>(); 
		setJewwel();
		ReadGameGridFile(gamegridfilename);
		findtriple=new FindTriple(gamegridlist,xMatrix,yMatrix,jewwel);
		showGameGridList();
		

	}
	public GameGrid(int x) {
		setJewwel();
		
	}
	

		
	private void ReadGameGridFile(String gamegridfilename) {
	try {
		readfile= (ArrayList<String>) Files.readAllLines(Paths.get(gamegridfilename));
	} catch (IOException e) {
		e.printStackTrace();
	}
	gamegridlist= new String[readfile.size()][readfile.get(0).split(" ").length];
	xMatrix=readfile.size(); yMatrix=readfile.get(0).split(" ").length;
	for (int i = 0; i < readfile.size(); i++) {
		String[] str=readfile.get(i).split(" ");
		for (int j = 0; j < readfile.size(); j++) {
			gamegridlist[i][j]=str[j];
		}}}
	
	
	// here looking cordinate if it has triple
	public void applycordinate(int x,int y) {
		printarray.add("Select coordinate or enter E to end the game: "+x+" "+y+"\n\n");
		String jewwelcard=gamegridlist[x][y];
		if(x>=0&x<xMatrix&y>=0&y<yMatrix ) {
			if(!gamegridlist[x][y].equals(" ")) {
		
		
		for (int i = 0; i <9; i++) {
			if(jewwelcard.equals(jewwel[0].getName()) ) {
				boolean state=true;
				 state=findtriple.lookuptodown(x, y,"Wildcard");
				 if(state==false) { state=findtriple.looklefttoright(x, y,"Wildcard");}
				if(state==false) { state=findtriple.looklefttorightdiagonal(x, y,"Wildcard");} 
				
				
				
		
			
				showGameGridList();
			break;
			}
			else if(jewwelcard.equals(jewwel[1].getName()) ) {
				boolean state=findtriple.looklefttorightdiagonal(x, y,"Diamond");
			
				showGameGridList();

				break;
			}
			else if(jewwelcard.equals(jewwel[2].getName()) ) { 
				boolean state=findtriple.looklefttoright(x, y,"Square");
				showGameGridList();
break;
			}
			else if(jewwelcard.equals(jewwel[3].getName()) ) {
				boolean state=findtriple.lookuptodown(x, y, "Triangle");
				showGameGridList();
break;
			}
			
		
			else if(jewwelcard.equals(jewwel[4].getName()))  {
				boolean state;
				state=findtriple.looklefttoright(x, y,"Symbol");
				 
				 
				if(state==false) { state=findtriple.lookuptodown(x, y,"Symbol"); ;}
				
				
				
			
				showGameGridList();
break;
			}else if(jewwel[5].getName().equals(jewwelcard)) {
				
				boolean state=findtriple.looklefttoright(x, y,"Symbol");
					
				showGameGridList();
break;

			}
			else if(jewwel[6].getName().equals(jewwelcard)) {
				boolean state;
				state=findtriple.lookuptodown(x, y,"Symbol");
				showGameGridList();
				break;
				
			}
			else if(jewwel[7].getName().equals(jewwelcard)) {
	findtriple.lookrighttoleftdiagonal(x, y, "Symbol");
	showGameGridList();
	break;
}
			else if(jewwel[8].getName().equals(jewwelcard)) {
	
	findtriple.looklefttorightdiagonal(x, y,"Symbol"); showGameGridList();
	break;
}
			
		}}
				
			else
				printarray.add("Please enter validate cordinate\n\n");
				
			
	
		}else printarray.add("Please enter validate cordinate\n\n");
			}
			
			
			
		
		
	
	public void setJewwel() {
		Wildcard wildcard= new Wildcard();
		Diamond diamond=new Diamond();
		Square square=new Square();
		Triangle triangle=new Triangle();
		wildcard.setName("W");
		diamond.setName("D");
		square.setName("S");
		triangle.setName("T");
		Symbol plus=new Symbol();
		plus.setName("+");
		Symbol mines=new Symbol();
		mines.setName("-");
		Symbol middle=new Symbol();
		middle.setName("|");
		Symbol right=new Symbol();
		right.setName("/");
		Symbol left=new Symbol();
		left.setName("\\");
		
		 jewwel=new Jewwel[9];
		jewwel[0]=wildcard;
		jewwel[1]=diamond;
		jewwel[2]=square;
		jewwel[3]=triangle;
		jewwel[4]=plus;
		jewwel[5]=mines;
		jewwel[6]=middle;
		jewwel[7]=right;
		jewwel[8]=left;
	}
	public Jewwel[] getJewwelList() {return jewwel;
	
	}
	private void showGameGridList()  {
		for (String[] string : gamegridlist) {
			for (int i = 0; i < string.length; i++) {
				if(i!=string.length-1){
				printarray.add(string[i]+" ");
				
				}
				else {
					
			
					printarray.add(string[i]+"\n");

				}
			}
		}
		printarray.add("\nscore: "+findtriple.momentarlyscore+" points\n\n");
		
	

		findtriple.momentarlyscore=0;

	}
	public void addelementoprintarray(String element) {
		for (String string : printarray) {
			try {
				monitoringfile.write(string);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			try {
				monitoringfile.write(element);
				monitoringfile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	
	public void startgame() {
		for (String[] string : gamegridlist) {
			for (int i = 0; i < string.length; i++) {
				if(i!=string.length-1){
					try {
						monitoringfile.write(string[i]+" ");
					} catch (Exception e) {
						// TODO: handle exception
					}
				
				}
				else {
					try {
						monitoringfile.write(string[i]+"\n\n");
					} catch (Exception e) {
						// TODO: handle exception
					}
			

				}
			}
		}
	
	
		
	

	}
	public int getScore()
	{return  findtriple.score;
			
	}
}
