	
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	
	public static void savePeople() {
		People people = People.getInstance();
		ArrayList<Person> friends = people.getPeople();
		JSONArray jsonFriends = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< friends.size(); i++) {
			jsonFriends.add(getPersonJSON(friends.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(PEOPLE_FILE_NAME)) {
 
            file.write(jsonFriends.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getPersonJSON(Person person) {
		JSONObject personDetails = new JSONObject();
		personDetails.put(PEOPLE_FIRST_NAME, person.getFirstName());
		personDetails.put(PEOPLE_LAST_NAME, person.getLastName());
		personDetails.put(PEOPLE_PHONE_NUMBER, person.getPhoneNumber());
        
        return personDetails;
	}
}
