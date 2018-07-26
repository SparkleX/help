package help;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestController
@RequestMapping
@Scope("prototype")
public @interface MyService 
{
	@AliasFor("path")
	String[] value() default {};

	@AliasFor("value")
	String[] path() default {};
	
	@AliasFor(annotation = RequestMapping.class)
	String[] params() default {};
}
