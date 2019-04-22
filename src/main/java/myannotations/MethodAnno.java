package myannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnno {


    FiledAnnoName setAnnoName() default @FiledAnnoName;

    FiledAnnoAge setAnnoAge() default @FiledAnnoAge;

    String method() default "method";
}
