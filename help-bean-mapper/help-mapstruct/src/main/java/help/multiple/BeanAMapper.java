package help.multiple;
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
    abstract public BeanB toBean(BeanA a);


    @InheritInverseConfiguration
    abstract public BeanA fromBean(BeanB a);

    @AfterMapping
    public void after(BeanA anySource, @MappingTarget BeanB target,@TargetType Class<?> targetType)
    {
    	MapStructMultiSingleUtil.singleToMulti(anySource, target, "tax","lines","help.multiple.BeanATaxMapper","toBeanB");
    	MapStructMultiSingleUtil.singleToMulti(anySource, target, "address","lines","help.multiple.BeanAAddressMapper","toBean");
    }
    @AfterMapping
    public void after(BeanB anySource, @MappingTarget BeanA target,@TargetType Class<?> targetType)
    {
    	MapStructMultiSingleUtil.multiToSingle(anySource, target, "lines","tax","help.multiple.BeanATaxMapper","fromBeanB");
    	MapStructMultiSingleUtil.multiToSingle(anySource, target, "lines","address","help.multiple.BeanAAddressMapper","fromBean");

    }
}
