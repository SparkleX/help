package help.multiple;
import java.util.ArrayList;

import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

@Mapper(uses= {BeanAAddressMapper.class,BeanATaxMapper.class})
public abstract class BeanAMapper 
{
    static BeanAMapper MAPPER = Mappers.getMapper( BeanAMapper.class );
    @Mapping(source = "id", target = "id")
   // @Mapping(source = "address", target = "lines")
   // @Mapping(source = "tax", target = "lines")    
    abstract public BeanB toBeanB(BeanA a);


    @InheritInverseConfiguration
    abstract public BeanA fromBeanB(BeanB a);

    @AfterMapping
    public void after(BeanA anySource, @MappingTarget BeanB target,@TargetType Class<?> targetType) 
    {
    	target.lines = new ArrayList<>();
    	BeanBLine o = BeanAAddressMapper.MAPPER.toBeanAAddress(anySource.address);
    	target.lines.add(o);
    	o = BeanATaxMapper.MAPPER.toBeanB(anySource.tax);
    	target.lines.add(o);
    }
    @AfterMapping
    public void after(BeanB anySource, @MappingTarget BeanA target,@TargetType Class<?> targetType) 
    {
    	target.address = BeanAAddressMapper.MAPPER.fromBeanB(anySource.lines.get(0));
    	target.tax = BeanATaxMapper.MAPPER.fromBeanB(anySource.lines.get(0));

    }
}
