package help;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BoBase<T>
{
	public void printType()
	{
		Type t = this.getClass().getGenericSuperclass();
		System.out.println(t);
		ParameterizedType p = (ParameterizedType)t;
		Type clazz = p.getActualTypeArguments()[0];		
		System.out.println(clazz.getTypeName());
	}
}
