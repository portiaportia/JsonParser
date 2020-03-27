
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	
	public static ArrayList<Person> loadPeople() {
		ArrayList<Person> people = new ArrayList<Person>();
		
		try {
			FileReader reader = new FileReader(PEOPLE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String firstName = (String)personJSON.get(PEOPLE_FIRST_NAME);
				String lastName = (String)personJSON.get(PEOPLE_LAST_NAME);
				String phoneNumber = (String)personJSON.get(PEOPLE_PHONE_NUMBER);
				
				people.add(new Person(firstName, lastName, phoneNumber));
			}
			
			return people;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
