package com.lftechnology.remittance.interceptor;

import java.util.Arrays;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

/**
 * Interceptor to log over method invocation.
 *
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
@Logged
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class LoggingInterceptor {

    @Inject
    private Logger log;

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        log.info("Method {} called with {} parameters",
                new Object[] { context.getMethod().getName(), Arrays.deepToString(context.getParameters()) });

        return context.proceed();
    }
}
