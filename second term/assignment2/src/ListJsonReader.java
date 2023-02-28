import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ListJsonReader{
     ArrayList<String> chancelist=new ArrayList<String>();
     ArrayList<String> communitychestlist=new ArrayList<String>();

    
    public ListJsonReader() throws org.json.simple.parser.ParseException{
    	
        JSONParser processor = new JSONParser();
        try (Reader file = new FileReader("list.json")){
            JSONObject jsonfile = (JSONObject) processor.parse(file);
            JSONArray chanceList = (JSONArray) jsonfile.get("chanceList");
            for(Object i:chanceList){
				
                 /*
				 You can reach items by using:
				 ((String)((JSONObject)i).get("item"));
				 And you can add these items to any datastructure (e.g. array, linkedlist, etc.)
				 */
				 
            	chancelist.add((String) (((JSONObject)i).get("item")));
            	
            }
            JSONArray communityChestList = (JSONArray) jsonfile.get("communityChestList");
            for(Object i:communityChestList){

				//You can reach items by using:
				//And you can add these items to any datastructure (e.g. array, linkedlist, etc.) 
            	communitychestlist.add(((String)((JSONObject)i).get("item")));

            }
        }catch (IOException e){
            e.printStackTrace();
        }
     }
    public ArrayList<String> getChanceList() {
    	return chancelist;
    }
    public ArrayList<String> getCommunitychesList() {
    	return communitychestlist;
    }
     //You can add function if you want
}

