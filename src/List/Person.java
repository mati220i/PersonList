package List;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable{
	private static final long serialVersionUID = 2815742846179206574L;
	private String name;
	private String surname;
	
	private String address;
	
	public Person(){
		this.name = "";
		this.surname = "";
		this.address = "";
	}
	
	public Person(String n, String s, String a){
		this.name = n;
		this.surname = s;
		this.address = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString(){
		return "Name: " + this.name + ", Surname: " + this.surname + ", Address: " + this.address;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.name);
		out.writeObject(this.surname);
		out.writeObject(this.address);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		setName((String)in.readObject());
		setSurname((String)in.readObject());
		setAddress((String)in.readObject());
	}
	
}
