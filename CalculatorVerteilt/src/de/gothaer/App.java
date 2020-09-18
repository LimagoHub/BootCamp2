package de.gothaer;

import de.client.CalcClient;
import de.math.Calculator;
import de.math.CalculatorFactory;

public class App {

	public static void main(String[] args) {
		Calculator calculator = CalculatorFactory.create();
		CalcClient client = new CalcClient(calculator);
		client.go();

	}

}
// RPC = Remote Procedure Call (Procedurale Technik)
// RMI = Remote Methode Invocation (Objectorientiert)