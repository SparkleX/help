package help;

import java.util.ArrayList;
import java.util.HashMap;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

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
	    return null;
	}

	@Override
	public HashMap convertFrom(ArrayList source, HashMap destination) 
	{
		if(destination==null)
		{
			destination = new HashMap();
		}
		String param = this.getParameter();
		ArrayList list = new ArrayList<>();
		for(Object o:source)
		{
			Object k = mapper.map(o, BDocLine.class);
			list.add(k);
		}
		destination.put(param, list);
		return destination;
	}

	@Override
	public void setMapper(Mapper mapper) 
	{
		this.mapper = mapper;
	}
}