package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import List.PersonList;

public class ServerMain {

	static PersonList list = new PersonList();
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		int port = 9900;
        System.out.println("Server turned on");
        try {
           serverSocket = new ServerSocket(port);
            System.out.println("Waiting for clients on port: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Server server = new Server(clientSocket, list);
                list = server.connect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while reading");
        }finally {
			serverSocket.close();
		}
	}

}
