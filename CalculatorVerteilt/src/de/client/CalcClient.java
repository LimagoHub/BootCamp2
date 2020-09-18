package de.client;

import de.math.Calculator;
import de.math.CalculatorException;

public class CalcClient {

	
	private final Calculator calculator;

	public CalcClient(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public void go() {
		
		try {
			System.out.println(calculator.add(3, 4));
		} catch (CalculatorException e) {
			e.printStackTrace();
		}
	}
}
