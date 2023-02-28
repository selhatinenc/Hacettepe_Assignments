import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class PropertyJsonReader{
     private ArrayList<ArrayList<String>> array=new ArrayList<ArrayList<String>>();
	 
     public PropertyJsonReader(){

         JSONParser processor = new JSONParser();
         try (Reader file = new FileReader("property.json")){
             JSONObject jsonfile = (JSONObject) processor.parse(file);
             JSONArray Land = (JSONArray) jsonfile.get("1");
             for(Object i:Land){
				 
				 //You can reach items by using statements below:
				 //And you can add these itemsa to any dstata structure (e.g. array, linkedlist etc.
				 ArrayList<String> propertyarray=new ArrayList<String>();
				propertyarray.add((String) ((JSONObject)i).get("id"));
				propertyarray.add((String) ((JSONObject)i).get("name"));
				propertyarray.add((String) ((JSONObject)i).get("cost"));
				propertyarray.add("1");
				 array.add(	propertyarray);
				 
                 
             }
             JSONArray RailRoad = (JSONArray) jsonfile.get("2");
             for(Object i:RailRoad){
				 //You can reach items by using statements below:
                Integer.parseInt((String) ((JSONObject)i).get("id"));
				((JSONObject)i).get("name");
				Integer.parseInt((String)((JSONObject)i).get("cost"));
				//And you can add these items to any data structure (e.g. array, linkedlist etc.
				ArrayList<String> propertyarray=new ArrayList<String>();
				propertyarray.add((String) ((JSONObject)i).get("id"));
				propertyarray.add((String) ((JSONObject)i).get("name"));
				propertyarray.add((String) ((JSONObject)i).get("cost"));
				propertyarray.add("2");
				 array.add(	propertyarray);
             
             }
			 
             JSONArray Company = (JSONArray) jsonfile.get("3");
             for(Object i:Company){
				 //You can reach items by using statements below:
                 Integer.parseInt((String)((JSONObject)i).get("id"));
				 ((JSONObject)i).get("name");
				 Integer.parseInt((String)((JSONObject)i).get("cost"));
             
				 ArrayList<String> propertyarray=new ArrayList<String>();
					propertyarray.add((String) ((JSONObject)i).get("id"));
					propertyarray.add((String) ((JSONObject)i).get("name"));
					propertyarray.add((String) ((JSONObject)i).get("cost"));
					propertyarray.add("3");
					 array.add(	propertyarray);
             }
             
         } catch (IOException e){
             e.printStackTrace();
         } catch (ParseException e){
             e.printStackTrace();
         }
     }

public ArrayList<ArrayList<String>> getPropertiesarray() {
	return array;
}
     //You can add function(s) if you want
}