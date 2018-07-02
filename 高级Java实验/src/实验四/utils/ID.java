package 实验四.utils;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ID {//映射类此行是否为主键
    public String value() default "";
}