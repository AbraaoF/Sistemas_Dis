package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ServRunnable implements Runnable {
	private Socket socketCliente;
	
	public ServRunnable(Socket soc) {
		this.socketCliente = soc;
		Thread th = new Thread(this);
		th.start();
	}
	
	public void run() {
		
		try {
                    PrintStream enviar = new PrintStream(socketCliente.getOutputStream());

                    Scanner receber = new Scanner(socketCliente.getInputStream());

                    long timeIn = System.currentTimeMillis();
                    System.out.println("time in: " + timeIn);

                    long timeServ = System.currentTimeMillis();
                    long timeOut = System.currentTimeMillis();

                    enviar.println(timeIn);
                    
                    enviar.println(timeServ);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}