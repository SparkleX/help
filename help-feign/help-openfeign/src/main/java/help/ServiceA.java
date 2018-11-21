package help;

import feign.Param;
import feign.RequestLine;

public interface ServiceA extends ServiceBase<String>
{
	@Override
	@RequestLine("GET /{test}")
	String call(@Param("test") String type);

	String call1();
}
