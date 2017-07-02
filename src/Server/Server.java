package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


import List.*;


public class Server {
    private final Socket client;
    private PersonList list;
    
  
    public Server(Socket client, PersonList l) {
            this.client = client;
            this.list = l;
    }

    
    public PersonList connect() {
            
    		try{
    			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                String request = (String) in.readObject();
                Object objectRequest = in.readObject();
                
               
                if(request.equals("add")){
                	if(list.addPerson((Person)objectRequest))
                		out.writeObject("Adding successfully");
                	else
                		out.writeObject("Adding failed");
    				return list;
    			}
    			if(request.equals("remove")){
    				if(list.removePerson((Person)objectRequest))
    					out.writeObject("Deleted person");
    				else
    					out.writeObject("Removing failed (Person not found)");
    				return list;
    			}
    			if(request.equals("edit")){
    				if(list.editPerson((Person)objectRequest))
    					out.writeObject("Edited person");
    				else
    					out.writeObject("Editing failed (Person not found)");
    				return list;
    			}
    			if(request.equals("print")){
    				String result =	list.printList();
    				out.writeObject(result);
    				return list;
    			}
                
                
            } catch (IOException e) {
                e.printStackTrace();
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
    		return list;

    }
}
