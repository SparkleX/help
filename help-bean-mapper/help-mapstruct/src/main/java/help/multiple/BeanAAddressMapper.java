package help.multiple;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeanAAddressMapper
{
	BeanAAddressMapper MAPPER = Mappers.getMapper( BeanAAddressMapper.class );
    @Mapping(source = "addr", target = "addr")
    BeanBLine toBean(BeanAAddress a);

    @InheritInverseConfiguration
    BeanAAddress fromBean(BeanBLine a);
}
