package io.redick.quarkus.annotation;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * @author Redick01
 */
@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Logged {
}
