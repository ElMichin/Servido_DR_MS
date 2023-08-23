package co.edu.unbosque.model;

	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.IOException;
	import java.net.Socket;
	import java.util.Scanner;

	public class Cliente extends Thread {
		// initialize socket and input output streams
		private int port = 8888;
		private DataInputStream in;
		private DataOutputStream out;
		private String address; 

		
	 
		// constructor to put ip address and port
		public Cliente(int port, String address) {
			// initialize socket and input output streams
			
			this.port = port;
			this.address = address;
			
			


		}

		@Override
		public void run() {
			Scanner sn = new Scanner(System.in);
			

				try {
					
					ciclo1: while(true) {
					Socket sk = new Socket("127.0.0.1", 8888);

					this.out = new DataOutputStream(sk.getOutputStream());
					this.in = new DataInputStream(sk.getInputStream());
					
					String mensajeCliente = sn.nextLine();
					
					this.out.writeUTF(mensajeCliente);
					String respuestaBot = in.readUTF();
					System.out.println("Bot" + respuestaBot);
								
					System.out.println("Received message:");
					}
					
				} catch (IOException i) {
					System.out.println(i);
				}
			
			// close the connection
			try {
				out.close();
				
			} catch (IOException i) {
				System.out.println(i);
			}
					

		}

		
	}

