import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FindTriple {
	 int xMatrix; 
	 int yMatrix;
	 Jewwel[] JewwelList;
	 public static boolean statecordinate=true;
	 public static int score=0;
	 public static int momentarlyscore=0;
	 ArrayList<String> symbollist;
	 String[][] gamegridlist;
	 String pointchoosed="";
		String point2="";
		String point3="";
	 public FindTriple(String[][] gamegridlist,int xMatrix,int yMatrix,Jewwel[] JewweList) {
		
		 this.yMatrix=yMatrix;  this.xMatrix=xMatrix;
		 this.gamegridlist =gamegridlist;
		 symbollist();
		 this.JewwelList=JewweList;
		 
	 }
	 
	 public boolean lookuptodown(int x,int y,String type) {
			if(checkxstart( x, y)) {
				pointchoosed=gamegridlist[x][y];
				point2=gamegridlist[x-1][y];
				point3=gamegridlist[x-2][y];

				//Triangle
				if(type.equals("Triangle")) {
				if(TripleControl()) {
					
					removeJewwel(x-2,y); 	removeJewwel(x-1,y); removeJewwel(x,y);			return true;

				} 
				}
				
			else if(type.equals("Wildcard")) {
				
									if(WildcardStateControl( ))
					{ 				
 removeJewwel(x-2,y); 	removeJewwel(x-1,y); removeJewwel(x,y);			return true;
					}
				}
				
				//Symbol
				else if(SymbolControl(type)) {
					removeJewwel(x-2,y); 	removeJewwel(x-1,y); removeJewwel(x,y);			return true;
				}
			}
			 if(checkXmatrix(x,y)) {
				pointchoosed=gamegridlist[x][y];
				point2=gamegridlist[x+1][y];
				point3=gamegridlist[x+2][y];

				//Triangle
				if(type.equals("Triangle")) {
				if(TripleControl()) {
					
				 removeJewwel(x,y);	removeJewwel(x+1,y);removeJewwel(x+2,y);		return true;

				} 
				} 	

				
				else if(type.equals("Wildcard")) {
									if(WildcardStateControl()==true){	 
						removeJewwel(x,y);	removeJewwel(x+1,y);removeJewwel(x+2,y);		return true;
					}
				}
				
				//Symbol
				else if(SymbolControl(type)) {
					 removeJewwel(x,y);	removeJewwel(x+1,y);removeJewwel(x+2,y);		return true;
				}
				
			}
			else statecordinate=false;
			return false;
			
		}
	public boolean looklefttoright(int x ,int y,String type) {
		

		if(checkystart( x, y)) {
			pointchoosed=gamegridlist[x][y];
			point2=gamegridlist[x][y-1];
			point3=gamegridlist[x][y-2];

			//Triangle
			if(type.equals("Square")) {
			if(TripleControl()) {
				
				removeJewwel(x,y); 	removeJewwel(x,y-1); removeJewwel(x,y-2);			return true;

			} 
			}
			
			//Wildcard
			else if(type.equals("Wildcard")) {
								if(WildcardStateControl( )==true)
				{   removeJewwel(x,y); 	removeJewwel(x,y-1); removeJewwel(x,y-2);			return true;
				}
			}
			
			//Symbol
			else if(SymbolControl(type)) {
				   removeJewwel(x,y); 	removeJewwel(x,y-1); removeJewwel(x,y-2);			return true;
			}
		}
		 if(checkYmatrix(x,y)) {
			pointchoosed=gamegridlist[x][y];
			point2=gamegridlist[x][y+1];
			point3=gamegridlist[x][y+2];

			//Triangle
			if(type.equals("Square")) {
			if(TripleControl()) {
				
				   removeJewwel(x,y); 	removeJewwel(x,y+2); removeJewwel(x,y+1);			return true;

			} 
			}
			
			//Wildcard
			else if(type.equals("Wilcard")) {
				
								if(WildcardStateControl());
				{   removeJewwel(x,y); 	removeJewwel(x,y+2); removeJewwel(x,y+1);			return true;
				}
			}
			
			//Symbol
			else if(SymbolControl(type)) {
				  removeJewwel(x,y); 	removeJewwel(x,y+2); removeJewwel(x,y+1);		return true;
			}
			
		}
		else statecordinate=false;
		return false;}
		
		
	
	
	public boolean lookrighttoleftdiagonal(int x, int y,String type) {
		if(checkrightdiagonalend( x, y)) {
			pointchoosed=gamegridlist[x][y];
			point2=gamegridlist[x-1][y+1];
			point3=gamegridlist[x-2][y+2];

			//Triangle
			if(type.equals("Diamond")) {
			if(TripleControl()) {
				
				removeJewwel(x,y); 	removeJewwel(x-1,y+1); removeJewwel(x-2,y+2);			return true;

			} 
			}
			
			//Wildcard
			else if(type.equals("Wildcard")) {
								if(WildcardStateControl( ))
				{  removeJewwel(x,y); 	removeJewwel(x-1,y+1); removeJewwel(x-2,y+2);		return true;
				}
			}
			
			//Symbol
			else if(SymbolControl(type)) {
				
				removeJewwel(x,y); 	removeJewwel(x-1,y+1); removeJewwel(x-2,y+2);		return true;
			}
		}
		 if(checkleftdiagonalend(x,y)) {
			pointchoosed=gamegridlist[x][y];
			point2=gamegridlist[x+1][y-1];
			point3=gamegridlist[x+2][y-2];

			//Triangle
			if(type.equals("Diamond")) {
			if(TripleControl()) {
				
				removeJewwel(x,y); 	removeJewwel(x+1,y-1); removeJewwel(x+2,y-2);			return true;

			} 
			}
			
			//Wildcard
			else if(type.equals("Wilcard")) {
								if(WildcardStateControl());
				{  	removeJewwel(x,y); 	removeJewwel(x+1,y-1); removeJewwel(x+2,y-2);			return true;
				}
			}
			
			//Symbol
			else if(SymbolControl(type)) {
				removeJewwel(x,y); 	removeJewwel(x+1,y-1); removeJewwel(x+2,y-2);			return true;
			}
			
		}
		
		
		
		
		
		
		else statecordinate=false;
		return false;
		
	}
		
	

	public boolean looklefttorightdiagonal(int x ,int y,String type) {
		
		if(checkleftdiagonalstart( x, y)) {
			pointchoosed=gamegridlist[x][y];
			point2=gamegridlist[x-1][y-1];
			point3=gamegridlist[x-2][y-2];

			//Triangle
			if(type.equals("Diamond")) {
			if(TripleControl()) {
				
				removeJewwel(x,y); 	removeJewwel(x-1,y-1); removeJewwel(x-2,y-2);			return true;

			} 
			}
			
			//Wildcard
			else if(type.equals("Wildcard")) {
								if(WildcardStateControl( ))
				{   removeJewwel(x,y); 	removeJewwel(x-2,y-2); removeJewwel(x-1,y-1);			return true;
				}
			}
			
			//Symbol
			else if(SymbolControl(type)) {
				removeJewwel(x,y); 	removeJewwel(x-1,y-1); removeJewwel(x-2,y-2);		return true;
			}
		}
		 if(checkrightdiagonalstart(x,y)) {
			pointchoosed=gamegridlist[x][y];
			point2=gamegridlist[x+1][y+1];
			point3=gamegridlist[x+2][y+2];

			//Triangle
			if(type.equals("Diamond")) {
			if(TripleControl()) {
				
				removeJewwel(x,y); 	removeJewwel(x-1,y-1); removeJewwel(x-2,y-2);			return true;

			} 
			}
			
			//Wildcard
			else if(type.equals("Wilcard")) {
								if(WildcardStateControl());
				{  	removeJewwel(x,y); 	removeJewwel(x-1,y-1); removeJewwel(x-2,y-2);			return true;
				}
			}
			
			//Symbol
			else if(SymbolControl(type)) {
				removeJewwel(x,y); 	removeJewwel(x-1,y-1); removeJewwel(x-2,y-2);			return true;
			}
			
		}
		
		
		
		
		
		

		if(type.equals("Symbol")) return false;
		else
			return lookrighttoleftdiagonal(x, y, type);}
	 
	 
	

		private boolean TripleControl() {
			if(point3.equals(point2)&point2.equals(pointchoosed)) return true;
			return false;
	}

		
		private boolean SymbolControl(String type) {
		if(	type.equals("Symbol")& isSymbol(point2)&isSymbol(point3)) return true;
		return false;
	}

		private boolean WildcardStateControl() {
			if( point2.equals(point3)||point2.equals(pointchoosed)||point3.equals(pointchoosed))	 {return true;}
			return false;
	}
		private boolean checkleftdiagonalend(int x, int y) {
			if(x>-1&x<xMatrix-2 &y>=2 &y<yMatrix)return true;
			return false;		
	}private boolean checkrightdiagonalend(int x, int y) {
		if(x>1&x<xMatrix &y>=0 &y<yMatrix-2)return true;
		return false;		
}
		private boolean checkleftdiagonalstart(int x, int y) {
			if(x>1&x<xMatrix &y>=2 &y<yMatrix)return true;
			return false;		
	}
		private boolean checkrightdiagonalstart(int x, int y) {
			if(x>-1&x<xMatrix-2 &y>=0 &y<yMatrix-2)return true;
			return false;		
	}


		private boolean checkxstart(int x, int y) {
		if(x>1&x<xMatrix &y>=0 &y<yMatrix)return true;
		return false;
	}
		private boolean checkXmatrix(int x, int y) {
			if(x>=0&x<xMatrix-2 &y>=0 &y<yMatrix) return true;
		return false;
	}

		private boolean checkystart(int x, int y) {
			if(x>-1&x<xMatrix &y>=2 &y<yMatrix)return true;
			return false;
		}
		private boolean checkYmatrix(int x, int y) {
			if(x>=0&x<xMatrix &y>=0 &y<yMatrix-2) return true;
		return false;
	}


		private void removeJewwel(int x, int y) {
			for (int i = 0; i < JewwelList.length; i++) {
				if(JewwelList[i].getName().equals(gamegridlist[x][y]) ) {	score+=JewwelList[i].getPoint(); momentarlyscore+=JewwelList[i].getPoint();}
			}
			gamegridlist[x][y]=" ";
			for(int x2=x; x2>=1;x2--) {
				gamegridlist[x2][y]=gamegridlist[x2-1][y];
				gamegridlist[x2-1][y]=" ";
			}
			
		}
		private boolean isSymbol(String s) {
		
			if(symbollist.contains(s)) { return true;}
			
			return false;
		}
		public String[][] getGameGridList() {
			return gamegridlist;
		}
		private void symbollist(){symbollist=new ArrayList<String>();
		 symbollist.add("-");
		 symbollist.add("/");
		 symbollist.add("\\");
		 symbollist.add("+");
		 symbollist.add("|");}

}
