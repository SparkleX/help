package help;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeanATaxMapper 
{
    BeanATaxMapper MAPPER = Mappers.getMapper( BeanATaxMapper.class );
    @Mapping(source = "tax", target = "tax")
    BeanBTax to(BeanATax a);

    @InheritInverseConfiguration
    BeanATax from(BeanBTax a);
}
