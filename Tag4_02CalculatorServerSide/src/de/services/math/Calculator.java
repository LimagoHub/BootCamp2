package de.services.math;


public interface Calculator {
	
	String JNDI_NAME = "CalculatorImpl/remote";
	
	double add(double a, double b);
	double sub(double a, double b);
}
