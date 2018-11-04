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
		BeanA a = new BeanA();
		a.setName("a");
		a.setCode("b");	
		a.setType(BeanType.eTypeA);
		
		List myMappingFiles = new ArrayList();
		myMappingFiles.add("beanMap.xml");

		DozerBeanMapper mapper = new DozerBeanMapper(myMappingFiles);
		List<CustomConverter> customConverters = new ArrayList<CustomConverter>();
		customConverters.add(new EnumCustomMapper());
		mapper.setCustomConverters(customConverters );
		
	

		BeanB b = mapper.map(a,BeanB.class);
		System.out.println(b.getCodeB());
		System.out.println(b.getName());
		System.out.println(b.getType());
	}

}
