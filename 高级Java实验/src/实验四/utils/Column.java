package 实验四.utils;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {//映射类中的属性成一个行信息
    public String value() default "";
    public boolean nullable() default false;
    public int length() default -1;
}