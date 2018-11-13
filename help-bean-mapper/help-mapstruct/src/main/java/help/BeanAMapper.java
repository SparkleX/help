package help;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { BeanALineMapper.class ,EnumAMapper.class})
public interface BeanAMapper 
{
    BeanAMapper MAPPER = Mappers.getMapper( BeanAMapper.class );
    @Mapping(source = "id", target = "id2")
    @Mapping(source = "name", target = "name2")
    @Mapping(source = "enum1", target = "enum2")    
    @Mapping(source = "lines", target = "lines2")
    @Mapping(source = "taxs", target = "tax")
    BeanB toBeanB(BeanA a);

    @InheritInverseConfiguration
    BeanA fromBeanB(BeanB a);

}
