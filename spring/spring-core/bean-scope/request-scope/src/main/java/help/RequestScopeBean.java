package help;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestScopeBean 
{
	int test(int a)
	{
		return a+1;
	}
}
