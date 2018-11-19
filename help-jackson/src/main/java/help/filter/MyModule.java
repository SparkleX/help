package help.filter;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

public class MyModule extends SimpleModule 
{
	@Override
	public void setupModule(SetupContext context) 
	{
		super.setupModule(context);
		context.insertAnnotationIntrospector(new MyAnnotationIntrospector());
	}
}
