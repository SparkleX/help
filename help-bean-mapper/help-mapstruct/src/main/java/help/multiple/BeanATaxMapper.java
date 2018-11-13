package help.multiple;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeanATaxMapper
{
	BeanATaxMapper MAPPER = Mappers.getMapper( BeanATaxMapper.class );
    @Mapping(source = "tax", target = "tax")
    BeanBLine toBeanB(BeanATax a);

    @InheritInverseConfiguration
    BeanATax fromBeanB(BeanBLine a);
}
