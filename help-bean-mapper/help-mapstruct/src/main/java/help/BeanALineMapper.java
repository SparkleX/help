package help;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BeanALineLineMapper.class })
public interface BeanALineMapper
{
	BeanALineMapper MAPPER = Mappers.getMapper( BeanALineMapper.class );
    @Mapping(source = "lineNum", target = "lineNum2")
    @Mapping(source = "lineLine", target = "lineLine2")
    BeanBLine toBeanBLine(BeanALine a);

    @InheritInverseConfiguration
    BeanALine fromBeanBLine(BeanBLine a);
}
