package de.math;

public class CalculatorFactory {

	public static Calculator create() {
		return new CalculatorStub();
	}

}
