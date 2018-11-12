package help;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BeanATaxMapper.class})
public abstract class EnumAMapper 
{
	//EnumAMapper INSTANCE = Mappers.getMapper( EnumAMapper.class );
    String toString(EnumA test)
    {
        return test.toString().substring(0,1);
    }
    EnumA toEnum(String code)
    {
        return EnumA.TWO;
    }
    
    BeanBTax prices(List<BeanATax> taxs)
    {
    	BeanATaxMapper mapper = Mappers.getMapper(BeanATaxMapper.class);
    	return mapper.to(taxs.get(0));
    }
    
    List<BeanATax> prices(BeanBTax a)
    {
    	BeanATaxMapper mapper = Mappers.getMapper(BeanATaxMapper.class);
    	return  new ArrayList<>(Collections.singleton(mapper.from(a)));
    }
}