package com.lftechnology.remittance.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Interceptor to log over method invocation.
 *
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
@Logged
@Interceptor
public class LoggingInterceptor {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        System.out.println("heheheheheh");
        // Logger.getAnonymousLogger().log(Level.INFO, "{0} called with {1} parameters",
        // new Object[] { context.getMethod().getName(), Arrays.deepToString(context.getParameters()) });
        return context.proceed();
    }
}
