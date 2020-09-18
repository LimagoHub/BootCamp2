package de.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggerInterceptor  {
	
	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {
		System.out.println(ctx.getMethod() + " wurde aufgerufen");
		return ctx.proceed();
	}

}
