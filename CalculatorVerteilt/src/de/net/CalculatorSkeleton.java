package de.net;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.math.Calculator;
import de.math.CalculatorImpl;

public class CalculatorSkeleton {

	public static void main(String[] args) {
		new CalculatorSkeleton().go();
	}

	private final ServerSocket serverSocket;

	
	
	
	public CalculatorSkeleton() {
		try {
			this.serverSocket = new ServerSocket(9000);
			System.out.println("Server an port 9000 etabliert..");
		} catch (IOException e) {
			throw new HeadlessException("megaupps");
		}
		
	}



	private void go() {
		ExecutorService service = Executors.newCachedThreadPool();
		try {
			while(true) {
				System.out.println("Warte auf eingehende Verbindung...");
				Socket socket = serverSocket.accept();
				System.out.println("Eingehende Verbindung: " + socket);
				service.execute(new ClientHandler(socket, new CalculatorImpl()));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	class ClientHandler implements Runnable {
		
		private final Socket socket;
		private final PrintWriter out;
		private final BufferedReader in;
		private final Calculator calculator;
		
		public ClientHandler(final Socket socket, final Calculator calculator) {
			try {
				this.calculator = calculator;
				this.socket = socket;
				this.out = new PrintWriter(this.socket.getOutputStream());
				this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("Starte Client-Verarbeitung");
			} catch (IOException e) {
				throw new HeadlessException();
			}
		}


		@Override
		public void run() {
			try {
				while(! socket.isClosed()) {
					
					String command = in.readLine();
					double parameter1 = Double.parseDouble(in.readLine());
					double parameter2 = Double.parseDouble(in.readLine());
					switch (command) {
					case "add": 
						out.println("" + calculator.add(parameter1, parameter2));
						out.flush();
					break;
					case "sub": 
						out.println("" + calculator.sub(parameter1, parameter2));
						out.flush();
					break;

					}
				}
				
			} catch (Exception e) {
				
			} 
			System.out.println("Clientverbindung abgebaut");
		}
		
	}

}
