package help;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.dozermapper.core.DozerConverter;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.MapperAware;


public class MapArrayConverter extends DozerConverter<HashMap, ArrayList> implements MapperAware
{
	private Mapper mapper;

	public MapArrayConverter() 
	{
		super(HashMap.class, ArrayList.class);
	}

	@Override
	public ArrayList convertTo(HashMap source, ArrayList destination) 
	{
	    System.out.println(this.getParameter());
	    return new ArrayList();
	}

	@Override
	public HashMap convertFrom(ArrayList source, HashMap destination) 
	{
		System.out.println(this.getParameter());
		return new HashMap();
	}

	@Override
	public void setMapper(Mapper mapper) 
	{
		this.mapper = mapper;
	}
}