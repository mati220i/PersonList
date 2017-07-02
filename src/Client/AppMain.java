package Client;

import java.util.Scanner;

import List.*;


class Option{
	
	public Person enterPerson(){
		String name, surname, addres;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the name:");
		name = input.nextLine();
		System.out.println("Enter the surname:");
		surname = input.nextLine();
		System.out.println("Enter address:");
		addres = input.nextLine();
		
		Person person = new Person(name, surname, addres);
		
		//input.close();
		return person;
	}
	
}

public class AppMain {
	
	public static void main(String[] args) {
		boolean runningApp = true;
		int choice;
		Scanner input = new Scanner(System.in);
		Option option = new Option();
		
		do{
			System.out.println("Person List App\n1. Add person\n2. Remove person\n3. Edit person\n4. Print person list\n5. Exit");
			System.out.println("Type number of the function:");
			choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Adding a new person:");
				System.out.println((String)Client.connectToServer("add", option.enterPerson()));
				System.out.println("Press any key to continue");
				input.nextLine();
				break;
			case 2:
				System.out.println("Removing a person [ Enter the person, which you want to remove ] :");
				System.out.println((String)Client.connectToServer("remove", option.enterPerson()));
				System.out.println("Press any key to continue");
				input.nextLine();
				break;
			case 3:
				System.out.println("Editing a person [ Enter the person, which you want to edit ] :");
				System.out.println((String)Client.connectToServer("edit", option.enterPerson()));
				System.out.println("Press any key to continue");
				input.nextLine();
				break;
			case 4:
				System.out.println((String)Client.connectToServer("print", null));
				System.out.println("Press any key to continue");
				input.nextLine();
				break;
			case 5:
				runningApp = false;
				break;

			default:
				System.out.println("Wrong data");
				break;
			}			
			
		}while(runningApp);
		input.close();
	}

}
