package help;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import feign.Contract;
import feign.MethodMetadata;
import feign.MyMetadata;

public class MyContract  extends Contract.Default
{

    @Override
    protected MethodMetadata parseAndValidateMetadata(Class<?> targetType, Method method)
    {
    	if(method.getAnnotations().length==0)
    	{
    		return MyMetadata.get();
    	}
    	return super.parseAndValidateMetadata(targetType, method);
    }
}
