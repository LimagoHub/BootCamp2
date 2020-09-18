package de.math;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


//Stub ist immer auf der Clientseite (Remote)
public class CalculatorStub implements Calculator{
	
	
	private final Socket socket;
	private final PrintWriter out;
	private final BufferedReader in;
	
	
	

	public CalculatorStub() {
		try {
			this.socket = new Socket("127.0.0.1",9000);
			this.out = new PrintWriter(this.socket.getOutputStream());
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			throw new HeadlessException("Upps");
		} 
	}

	@Override
	public double add(double a, double b) throws CalculatorException {
		return sendCommand("add", a, b); 
	}

	
	@Override
	public double sub(double a, double b) throws CalculatorException {
		return sendCommand("sub", a, b); 
	}
	
	private double sendCommand(String command, double a, double b) throws CalculatorException {
		try {
			out.println(command +"\n" + a + "\n" + b);
			out.flush();
			return Double.valueOf(in.readLine());
		} catch (Exception e) {
			throw new CalculatorException(e);
		}
	}

}
