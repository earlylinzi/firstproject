package myannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//全局变量
@Retention(RetentionPolicy.RUNTIME)//运行时注解
public @interface FiledAnnoAge {

    int age() default 0;//注解 构造方法无参 必须有默认值
}
