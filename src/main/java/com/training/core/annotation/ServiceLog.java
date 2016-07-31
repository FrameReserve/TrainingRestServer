package com.training.core.annotation;

import java.lang.annotation.*;

/**
 * Created by Athos on 2016-07-31.
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLog {
    String description() default "";
}
