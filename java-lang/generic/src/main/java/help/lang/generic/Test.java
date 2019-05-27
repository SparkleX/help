package help.lang.generic;

import org.springframework.core.GenericTypeResolver;

public class Test {

	public static void main(String[] args) {
		ClassA clazz = new ClassA();
        Class<?>[] genericType =  GenericTypeResolver.resolveTypeArguments(clazz.getClass(), BaseClass.class);
        for(Class<?> c:genericType)
        {
        	System.out.println(c);
        }
        
        genericType =  GenericTypeResolver.resolveTypeArguments(genericType[0], BoBase.class);
        for(Class<?> c:genericType)
        {
        	System.out.println(c);
        }
	}
}
