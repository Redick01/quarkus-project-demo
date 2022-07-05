package io.redick.quarkus.aop;


import io.redick.quarkus.annotation.Logged;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author Redick01
 */
@Logged
@Priority(2020)
@Interceptor
public class LoggingInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @AroundInvoke
    Object logInvocation(InvocationContext context) throws Exception {
        Object[] objects = context.getParameters();
        logger.info("开始处理：{}", objects);
        // ...log before
        Object ret = context.proceed();
        // ...log after
        logger.info("处理完毕：{}", ret);
        return ret;
    }
}
