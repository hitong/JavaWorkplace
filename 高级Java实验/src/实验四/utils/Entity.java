package 实验四.utils;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {//映射类中名成为表名
    public String value() default "";
}