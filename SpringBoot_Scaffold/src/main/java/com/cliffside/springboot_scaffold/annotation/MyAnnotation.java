package com.cliffside.springboot_scaffold.annotation;

import java.lang.annotation.*;

/**
 * @author cliffside
 * @date 2021-04-29 14:18
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

}
