package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor extends Thread {

	private int port = 8888;
	private boolean serverActive = true;
	private ArrayList<String> obyecto;
	private static File file;
	private Scanner sn = new Scanner(System.in);
	private DataInputStream in;
	private DataOutputStream out;

	// constructor with port
	public Servidor(int port) {

		this.port = port;

		file = new File("src/Servidor.txt");
		obyecto = new ArrayList<>();

		try {
			sn = new Scanner(file);

		} catch (FileNotFoundException e) {
			System.out.println("El archivo .txt no fue encontrado.");

		} catch (IOException e) {
			System.out.println("El archivo no pudo ser abierto.");
		}
		while (sn.hasNext()) {
			obyecto.add(sn.nextLine());
		}

		this.port = port;

	}

	public void run(){
    	

    	ServerSocket servidor;
        
            try
            { 
            	servidor = new ServerSocket(this.port);
    			System.out.println("Server started"); 
    	        System.out.println("Waiting for a client ..."); 
    	        
    	        while(serverActive) {
    	        	
    	        	
    	        	System.out.print("1. ¿Cual es tu nombre?\r\n"
					 		+ "2. Dar una breve descripción sobre mí.\r\n"
					 		+ "3. Dime cual es la insignea mas dificil de conseguir en Halo: Reach.\r\n"
					 		+ "4. Dime un dato curioso sobre alguna mision de Halo: Reach.\r\n"
					 		+ "5. ¿Cual es la mejor saga de peliculas para mi?\r\n"
					 		+ "6. ¿Cual es la mejor saga de videojuegos para mi?\r\n"
					 		+ "7. Dime un dato curioso sobre el cuerpo humano.\r\n"
					 		+ "8. Dime un dato curioso sobre animales.\r\n"
					 		+ "9. ¿Cual es la mejor protagonista de videojuegos para mi?\r\n"
					 		+ "10. ¿Que opinas sobre las IA?\r\n" 
					 		+ "11. Dime un dato curioso sobre gatos.\r\n"
					 		+ "12. Dime un dato curioso sobre historia.\r\n"
					 		+ "13. Cuentame un chiste sobre programación.\r\n"
					 		+ "14. Hablame sobre el efecto tetris.\r\n"
					 		+ "15. Dame un dato curioso sobre el espacio.\r\n" 
					 		+ "16. ¿Cual es la empresa mas costosa del mundo?\r\n"
					 		+ "17. ¿A que se debe el nombre de \"Microsoft\"?\r\n" 
					 		+ "18. ¿Cual es el objeto mas pesado del universo?\r\n"
					 		+ "19. ¿Cual es mi fruta favorita?\r\n"
					 		+ "20. Cerrar el programa.\r\n"
					 		 );
    	        	Socket sk = servidor.accept(); 
//        	        System.out.println("Client conected");
        	        System.out.println("Digite la opción que desee elegir");
        	        	
        	        	
        	        DataInputStream in = new DataInputStream(sk.getInputStream());
        	        DataOutputStream out = new DataOutputStream(sk.getOutputStream()); 
        	        int mensajeCliente = in.readInt();
        	        String respuestaBot = pregunta(mensajeCliente);
        	        out.writeUTF(respuestaBot);
        	        
    	        }
    	       
    	        
    	                   	
        
        
            System.out.println("Closing connection");
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
            
            
  
      
            }

	private String pregunta(int mensajeCliente) throws IOException {
		switch (mensajeCliente) {
		case 1: {
			return obyecto.get(0).toString();
		}
		case 2: {
			return obyecto.get(1).toString();
		}
		case 3: {
			return obyecto.get(2).toString();
		}
		case 4: {
			return obyecto.get(3).toString();
		}
		case 5: {
			return obyecto.get(4).toString();
		}
		case 6: {
			return obyecto.get(5).toString();
		}
		case 7: {
			return obyecto.get(6).toString();
		}
		case 8: {
			return obyecto.get(7).toString();
		}
		case 9: {
			return obyecto.get(8).toString();
		}
		case 10: {
			return obyecto.get(9).toString();
		}
		case 11: {
			return obyecto.get(10).toString();
		}
		case 12: {
			return obyecto.get(11).toString();
		}
		case 13: {
			return obyecto.get(12).toString();
		}
		case 14: {
			return obyecto.get(13).toString();
		}
		case 15: {
			return obyecto.get(14).toString();
		}
		case 16: {
			return obyecto.get(15).toString();
		}
		case 17: {
			return obyecto.get(16).toString();
		}
		case 18: {
			return obyecto.get(17).toString();
		}
		case 19: {
			return obyecto.get(18).toString();
		}
		case 20: {
			return obyecto.get(19).toString();
		}
		case 21: {
			serverActive = false;

			return obyecto.get(20).toString();
		}

		default:
			return obyecto.get(0).toString();
		}
	}
}