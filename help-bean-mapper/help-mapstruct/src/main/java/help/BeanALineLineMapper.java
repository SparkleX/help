package help;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper//(uses = { OrderItemMapper.class })
public interface BeanALineLineMapper
{
	BeanALineLineMapper MAPPER = Mappers.getMapper( BeanALineLineMapper.class );
    @Mapping(source = "a", target = "a2")
    BeanBLineLine to(BeanALineLine a);

    @InheritInverseConfiguration
    BeanALineLine from(BeanBLineLine a);
}
