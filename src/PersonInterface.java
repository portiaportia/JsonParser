import java.util.ArrayList;
import java.util.Scanner;

public class PersonInterface {
	private Scanner scanner;
	
	public PersonInterface() {
		scanner = new Scanner(System.in);
	}

	public void play() {
		People people = People.getInstance();
		
		System.out.println("***** Your current friends *******");
		displayPeople();
		
		while(addPerson()) {
			String firstName = getField("First Name");
			String lastName = getField("Last Name");
			String phoneNumber = getField("Phone Number");
			
			people.addPerson(firstName, lastName, phoneNumber);
		}
		
		System.out.println("***** Your updated list of friends *******");
		displayPeople();
		people.logout();
		
		System.out.println("\nHave a good day!");
	}
	
	private String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}
	
	private boolean addPerson() {
		System.out.print("Would you like to add a friend? (Y or N): ");
		
		String input = scanner.nextLine();
		
		if(input.toLowerCase().trim().equals("y")) return true;
		return false;
	}
	
	public void displayPeople() {
		People people = People.getInstance();
		ArrayList<Person> friends = people.getPeople();
		
		for(Person person : friends) {
			System.out.println(person.getFirstName() + " " + person.getLastName() + ": " + person.getPhoneNumber());
		}
	}
	
	public static void main(String[] args) {
		PersonInterface pi = new PersonInterface();
		pi.play();
	}

}
