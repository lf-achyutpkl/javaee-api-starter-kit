package com.lftechnology.remittance.interceptor;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Logger.getAnonymousLogger().log(Level.INFO, "##>>  Method {0} called with {1} parameters.",
                new Object[] { context.getMethod().getName(), Arrays.deepToString(context.getParameters()) });

        return context.proceed();
    }
}
