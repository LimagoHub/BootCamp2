package de.services.math;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

import de.interceptors.LoggerInterceptor;

@Remote(Calculator.class)
@Local(CalculatorLocal.class)
@Stateless
@Interceptors(LoggerInterceptor.class)
public class CalculatorImpl implements CalculatorLocal{
	

	@Override
	public double add(double a, double b) {
		
		return a + b;
	}

	@Override
	public double sub(double a, double b) {
		
		return a - b;
	}

	@Override
	public double mult(double a, double b) {
		
		return a * b;
	}

	@Override
	public double div(double a, double b) {
		return a / b;
	}

}
