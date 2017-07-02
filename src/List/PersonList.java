package List;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList{
	private LinkedList<Person> list;
	
	public PersonList(){
		this.list = new LinkedList<>();
	}
	
	public boolean addPerson(Person person){
		return list.add(person);
	}
	
	public boolean removePerson(Person person){
		Iterator<Person> it = list.iterator();
		
		Person temporaryPerson = null;
		
		while(it.hasNext()){
			temporaryPerson = it.next();
			if(temporaryPerson.getName().equals(person.getName()) && temporaryPerson.getSurname().equals(person.getSurname()) && temporaryPerson.getAddress().equals(person.getAddress())){
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	public boolean editPerson(Person person){
		Iterator<Person> it = list.iterator();
		Scanner input = new Scanner(System.in);
		
		Person temporaryPerson = null;
		
		while(it.hasNext()){
			temporaryPerson = it.next();
			if(temporaryPerson.getName().equals(person.getName()) && temporaryPerson.getSurname().equals(person.getSurname()) && temporaryPerson.getAddress().equals(person.getAddress())){
				System.out.println("Editing a person: ");
				System.out.println("Enter new name: ");
				temporaryPerson.setName(input.nextLine());
				System.out.println("Enter new surname: ");
				temporaryPerson.setSurname(input.nextLine());
				System.out.println("Enter new address: ");
				temporaryPerson.setAddress(input.nextLine());
				//input.close();
				return true;
			}
		}
		input.close();
		return false;
	}
	
	public int listCapacity(){
		return list.size();
	}
	
	public String printList(){
		String result = "";
		int counter = 1;
		
		Iterator<Person> it = list.iterator();
		
		result = "Person List:\n";
		if(it.hasNext()){
			while (it.hasNext()) {
				result += counter + ": " + it.next() + "\n";
				counter++;
			}
		}else
			result += "Person list is empty";
		return result;
	}
}