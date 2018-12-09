package help;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean 
{
	int test(int a)
	{
		return a+1;
	}
}
