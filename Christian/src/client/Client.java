package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		try {
		Socket socketCliente = new Socket("localhost", 5000);
		
		//ObjectOutputStream enviar = new ObjectOutputStream(socketCliente.getOutputStream());
		//ObjectInputStream receber = new ObjectInputStream(socketCliente.getInputStream());
		
		PrintStream enviar = new PrintStream(socketCliente.getOutputStream());

        Scanner receber = new Scanner(socketCliente.getInputStream());
		
		//enviando tempo client
		long t1 = System.currentTimeMillis();
		enviar.println(t1);
		System.out.println("Tempo 1: " + t1);
		
		//recebendo tempo do servidor
		long t2 = receber.nextLong();
		System.out.println("Tempo 2: " + t2);
		
		long t3 = receber.nextLong();
		System.out.println("Tempo 3: " + t3);
		
		long t4 = System.currentTimeMillis();
		System.out.println("Tempo 4: " + t4);
		
		//Delay
		t2 += 500;
		t2 += 1000;
		t3 += 1500;
		t4 += 2000;
		
		//RTT
		long rtt = ((t2 - t1) + (t4 - t3))/2;
		long timeChris = t2 + (rtt);
		
		//Conveter para Date e Imprimir
		System.out.println("Tempo de Christian: " + new Date(timeChris));
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
