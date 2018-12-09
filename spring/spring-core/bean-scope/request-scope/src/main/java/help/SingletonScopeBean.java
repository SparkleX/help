package help;

import org.springframework.stereotype.Component;

@Component
public class SingletonScopeBean 
{
	int test(int a)
	{
		return a+1;
	}
}
