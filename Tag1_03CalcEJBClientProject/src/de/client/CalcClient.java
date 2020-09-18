package de.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import de.services.math.Calculator;



public class CalcClient {
	
	private static final String CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
	private static final String PROVIDER_URL ="jnp://localhost:1099";


	public static void main(String[] args) throws Exception{
		
		Properties props = new Properties();
		props.put(Context.PROVIDER_URL, PROVIDER_URL);
		props.put(Context.INITIAL_CONTEXT_FACTORY, CONTEXT_FACTORY);
		
		
		// RegistryServer (JNDI)
		InitialContext initialContext = new InitialContext(props);
		
	
		Calculator calculator = (Calculator) initialContext.lookup(Calculator.JNDI_NAME);
		
		System.out.println(calculator.sub(3,4));
		System.out.println(calculator.add(3,4));
		System.out.println(calculator.sub(3,4));

	}

}
