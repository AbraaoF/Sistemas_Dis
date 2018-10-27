package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serv {
	
	private ServerSocket servidor;
	
	private void createrSocket(int port) throws IOException {
		servidor = new ServerSocket(5000);
	}
	
	
	public static void main(String[] args) {
		try {
		Serv servidor = new Serv();
		servidor.createrSocket(5000);
		
		while(true) {
			Socket sock = servidor.servidor.accept();
			ServRunnable servi = new ServRunnable(sock);
		}
		
		} catch(Exception e) {
			
		}
	}

}