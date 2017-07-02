package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client{

	public static Object connectToServer(String request, Object object) {
    	try{
    		int port = 9900;
	    	Socket socket = new Socket("localhost",port);
	        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
	        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

	        if(request.equals("add")){
	        	out.writeObject(request);
				out.flush();
				out.writeObject(object);
				out.flush();
				object = in.readObject();
			}
			if(request.equals("remove")){
				out.writeObject(request);
				out.flush();
				out.writeObject(object);
				out.flush();
				object = in.readObject();
			}
			if(request.equals("edit")){
				out.writeObject(request);
				out.flush();
				out.writeObject(object);
				out.flush();
				object = in.readObject();
			}
			if(request.equals("print")){
				out.writeObject(request);
				out.flush();
				out.writeObject(object);
				out.flush();
				object = in.readObject();
			}    
	            
	        in.close();
	        out.close();
	        socket.close();
        }catch (UnknownHostException e) {
            System.err.println("Server is not reachable");
            System.exit(1);
        }catch (IOException e) {
            e.printStackTrace();
            System.err.println("Connection error");
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

}
