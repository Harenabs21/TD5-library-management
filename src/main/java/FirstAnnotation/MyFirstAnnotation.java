package FirstAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface MyFirstAnnotation {
    String value() default "Hello World";
}
