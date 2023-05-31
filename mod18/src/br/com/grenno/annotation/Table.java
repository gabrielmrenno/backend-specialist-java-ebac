package br.com.grenno.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
// it can be used on Class and its properties
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface Table {
    String value();
}
