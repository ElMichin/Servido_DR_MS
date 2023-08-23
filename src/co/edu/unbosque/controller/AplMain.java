package co.edu.unbosque.controller;

import co.edu.unbosque.model.Cliente;

public class AplMain {
public static void main(String[] args) {
		
		Servidor server = new Servidor (8888);
		Thread thread = new Thread(server);
		server.start();
		
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
		Cliente client = new Cliente (8888, "127.0.0.1");
		Thread threadClient = new Thread (client);
		threadClient.start();
	}


}

