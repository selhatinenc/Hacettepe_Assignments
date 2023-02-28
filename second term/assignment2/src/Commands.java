import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Commands   {
	private boolean gamestate;
	private String process;
	public Commands(
			) throws FileNotFoundException, IOException,ParseException {
		 gamestate=true;
	process="";
	}
	public String getProcess() {
		return process;
	}
	public void GO(Banker banker,Player player) {
		player.setMoney(200);
		banker.setmoney(-200);
	}
	public boolean  CommunityChest(Object communityches,Player otherplayer,boolean gamestate,Banker banker,Player player) {
	
		if(communityches.equals("Advance to Go (Collect $200)") ) {
			player.setlocation(1);
			player.setMoney(200);
			banker.setmoney(-200);
			process="  draw  Advance to Go (Collect $200)";

		}
		else if(communityches.equals("Bank error in your favor - collect $75") ) {
			player.setMoney(75);
			banker.setmoney(-75);
			process="Bank error in your favor - collect $75";

		}
	else if(communityches.equals("Doctor's fees - Pay $50") ) {
		if (player.getMoney()<50) {
			process=" Goes to bankpurt";

			gamestate=false;}
	else {
	
		player.setMoney(-50);
		banker.setmoney(50);
		process="Doctor's fees - Pay $50";

	}
		
		}
	else if(communityches.equals("It is your birthday Collect $10 from each player") ) {
		if (otherplayer.getMoney()<10) {
				gamestate=false;
				process=" Goes to bankpurt";
		}
		else {		process="It is your birthday Collect $10 from each player";

			player.setMoney(10);
			otherplayer.setMoney(-10);
			
		}
			
		
	}
	else if(communityches.equals("Grand Opera Night - collect $50 from every player for opening night seats") ) {
		
		if (otherplayer.getMoney()<50)
		{			process=" Goes to bankpurt";

			gamestate=false;
		}	else
		player.setMoney(50);
		otherplayer.setMoney(-50);
		
		process="Grand Opera Night - collect $50 from every player for opening night seats";

}
	
	else if(communityches.equals("Income Tax refund - collect $20") ) {
		player.setMoney(20);
		banker.setmoney(-20);
		process="Income Tax refund - collect $20";

		
	}
	else if(communityches.equals("Life Insurance Matures - collect $100") ) {
		player.setMoney(100);
		banker.setmoney(-100);
		process="Life Insurance Matures - collect $100";

		
	}
	else if(communityches.equals("Pay Hospital Fees of $100") ) {
		if (player.getMoney()<100) {
			process=" Goes to bankpurt";
			gamestate=false;
			
		}
else
		player.setMoney(-100);
		banker.setmoney(100);

		process="Pay Hospital Fees of $100";

		
	}
	else if(communityches.equals("Pay School Fees of $50") ) {
		if (player.getMoney()<50) {
			process=" Goes to bankpurt";

			gamestate=false;
		}	else
		player.setMoney(-50);
		banker.setmoney(50);
	
		process="Pay Hospital Fees of $50";

		
	}
	else if(communityches.equals("You inherit $100")) {
		player.setMoney(100);
		banker.setmoney(-100);
		process="You inherit $100";

	}
	else if(communityches.equals("From sale of stock you get $50") ) {
		player.setMoney(50);
		banker.setmoney(-50);
		process="From sale of stock you get $50";

	}
		return gamestate;
		
	}
	public boolean IncomeTax(boolean gamestate,Banker banker,Player player) {
		if(player.getMoney()<100) {
			gamestate=false;
			process=" Goes to bankpurt";
		}
		else {player.setMoney(-100);
		banker.setmoney(100);

		}
		return gamestate;
	}

	public String Chance(String chance,Banker banker,Player player) {
		if (chance.equals("Advance to Go (Collect $200)") ) {
			player.setlocation(1);
			player.setMoney(200);
			banker.setmoney(-200);
			process="   Advance to Go (Collect $200)";

			
		}
		else if (chance.equals("Advance to Leicester Square") ) {
			if(player.getLocation()>27) {
				banker.setmoney(-200);
				player.setMoney(200);
			}
			player.setlocation(27);
			process="   Advance to Leicester Square";
			
			return "leicester";
			
		}
		else 	if (chance.equals("Go back 3 spaces") ) {
			if(player.getLocation()<4) {
			player.setlocation( (player.getLocation()-3+40));		
			}
			else
				player.setlocation(player.getLocation()-3);
		process="  went back 3 spaces";
	}
		else 	if (chance.equals("Pay poor tax of $15") ) {
			if (player.getMoney()<15) {
				gamestate=false;
				process=" Goes to bankpurt";
			}
		else
			player.setMoney(-15);
			banker.setmoney(15);;
		
			process="Paid poor tax of $15";
			
			
			
	}
		else 	if (chance.equals("Your building loan matures - collect $150") ) {
			player.setMoney(150);
			banker.setmoney(-150);
			process="Your building loan matures - collect $150";
	}
		else 	if (chance.equals("  has won a crossword competition - collect $100") ) {
		banker.setmoney(-100);
		player.setMoney(100);
		process=" has won a crossword competition - collect $100";
	}
		if (gamestate==false)
				return "false";
		else 
			return "true";
			
		
	}

public void GoToJail(Player player) {
	player.setlocation(11);
}


}
