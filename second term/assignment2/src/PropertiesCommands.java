import java.util.ArrayList;
import java.util.Iterator;

public class PropertiesCommands {
	private int id;
	private boolean gamestate;
	private String process="";
	int rentprice;
	public PropertiesCommands(int id,Banker banker){
		 gamestate=true;
		this.id=id; 
		PropertyJsonReader propertyjsonreader=new PropertyJsonReader();
	}
	public void setlocation(int location,int dice,boolean gamestate,Banker banker,Player player,Player otherplayer,Properties[] propertieslist) {
		id=location;
		dotask(id,dice,gamestate,banker,player,otherplayer,propertieslist);
	}

	void dotask(int id, int dice,boolean gamestate,Banker banker,Player player,Player otherplayer,Properties[] propertieslist) {

		for (Properties properties:propertieslist) {
			if(properties.getid()==id) {
				if(properties.getowner().equals("null")) {
						if(properties.getpropertype()==2)
							player.setRailroadsnumber(1);
						if(player.getMoney()<properties.getCost())
						{							process="  goes to bankpurt";

							gamestate=false;
						}
						else 
						
							{							
								process="  bought "+properties.getDescription();
							

							properties.setowner(player.getName());
							player.setMoney(-properties.getCost());
							banker.setmoney(properties.getCost());
							player.setpropertyarray(properties.getDescription());
							
							}
						
						
					
					
				}
				else if(properties.getowner().equals(otherplayer.getName())) {
					int propertytype=properties.getpropertype();
					
					int propertycost= properties.getCost();
					Payrent(propertycost,propertytype,dice,otherplayer);
					if(player.getMoney()<rentprice)
					{							process=" goes  to  bankpurt";

							gamestate=false;
					}
					else {
						process=" paid rent for		"+properties.getDescription();
						
						
					
					player.setMoney(-rentprice);
					otherplayer.setMoney(rentprice);

					}
				}
			
			}
			
		}
		this.gamestate=gamestate;
		
	}
	public boolean getGamestate( ) {
		return gamestate;
		
	}
	public String getprocess( ) {
		return process;
	}
	private void Payrent(int propertycost, int propertytype, int dice,Player otherplayer){
		if(propertytype==1) {	
			if(propertycost<=2000)
				 rentprice=(propertycost*40)/(100);
			else if(propertycost<=3000) {
				
				rentprice=(propertycost*(30))/100; }
			else if (propertycost<=4000)
				 rentprice=(propertycost*35)/(100);
		}
		else if(propertytype==2) {			rentprice=25*otherplayer.getRailroadsnumber();			}
		else  if(propertytype==3) {			rentprice=propertycost*((4*dice)/100);			}
	}



}
