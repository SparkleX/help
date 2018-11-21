package help;

import feign.RequestLine;

public interface ServiceBase<T_Type> 
{
	@RequestLine("GET /")
	T_Type call(T_Type type);
}
