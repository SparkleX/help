package help;

import java.util.ArrayList;
import java.util.List;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class App 
{

	public static void main(String[] args) 
	{
		ADocHeader a = new ADocHeader();
		a.setName("a");
		a.setCode("b");	
		a.setType(BeanType.eTypeA);
		
		List<ADocLine> lines =new ArrayList<ADocLine>();
		ADocLine line = new ADocLine();
		line.setLineNum(100);
		lines.add(line );
		lines.add(line );
		a.setLines(lines);
		
		List<String> myMappingFiles = new ArrayList<String>();
		myMappingFiles.add("beanMap.xml");

		DozerBeanMapper mapper = new DozerBeanMapper(myMappingFiles);
		List<CustomConverter> customConverters = new ArrayList<CustomConverter>();
		customConverters.add(new EnumCustomMapper());
		mapper.setCustomConverters(customConverters );
		
		BDocHeader b = mapper.map(a,BDocHeader.class);
		System.out.println(b.getCodeB());
		System.out.println(b.getName());
		System.out.println(b.getType());
		
		System.out.println(b.getTables().get("RDR1"));
		//ADocLine bline = (ADocLine) ((List)b.getTables().get("RDR1")).get(1);
		//System.out.println(bline.getLineNum());

		
	}

}
