package help;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<Bean> beans = new ArrayList<Bean>();
    	Bean e = new Bean();
    	e.setTotal(BigDecimal.valueOf(1));
    	beans.add(e);
    	e = new Bean();
    	e.setTotal(BigDecimal.valueOf(2));
    	beans.add(e);
    	
    	BigDecimal total = BigDecimal.ZERO;
    	
    	List<Bean> a = beans.stream().filter(p->test(p)).collect(Collectors.toList());
    	for(Bean o:a)
    	{
    		System.out.println(o.getTotal());
    	}
        
    }

	private static  boolean test(Bean p) 
	{
		return p.getTotal().compareTo(BigDecimal.ONE)>0;
	}
}
