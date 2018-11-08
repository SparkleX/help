package help;


import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class MapperApp 
{
	public static void main(String[] args) 
	{
		Mapper mapper = DozerBeanMapperBuilder
				.create()
				.withMappingFiles("map.xml")
				.build();
		HeaderA a = new HeaderA();
		a.setId(100);
		a.setName("C001");
		List<LineA> lines = new ArrayList<>();
		LineA line1 = new LineA();
		line1.setLineNum(100);				
		lines.add(line1);
		LineA line2 = new LineA();
		line2.setLineNum(101);				
		lines.add(line2);
		
		a.setLines(lines );
		HeaderB b = mapper.map(a, HeaderB.class);		
		System.out.println(b.getUid());
		System.out.println(b.getFullname());
		System.out.println(b.getRows());
		//System.out.println(b.getRows().get(0).getRow());
		//System.out.println(b.getRows().get(1).getRow());
		HeaderA c = mapper.map(b, HeaderA.class);
		System.out.println(c.getId());
		System.out.println(c.getName());		

	}

}
