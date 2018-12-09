package help;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName= "thread",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ThreadScopeBean 
{
	int test(int a)
	{
		return a+1;
	}
}
