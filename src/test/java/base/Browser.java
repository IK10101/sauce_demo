package base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Put @Browser("edge") on a test method to run that test in Microsoft Edge.
 * Tests without it run in Chrome (the default).
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Browser {
    String value();
}
