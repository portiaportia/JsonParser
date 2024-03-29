import java.util.ArrayList;

public class People {
	private static People people = null;
	private static ArrayList<Person> personList = new ArrayList<>();
	
	private People() {
		personList = DataLoader.loadPeople();
	}
	
	public static People getInstance() {
		if(people == null) {
			people = new People();
		}
		
		return people;
	}
	
	public ArrayList<Person> getPeople() {
		return personList;
	}
	
	public void addPerson(String firstName, String lastName, String phoneNumber) {
		personList.add(new Person(firstName, lastName, phoneNumber));
	}

	public void logout(){
		DataWriter.savePeople();
	}
}
