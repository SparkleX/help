package mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;

import entity.a.EnumOrderStatus;
import entity.b.EnumYesNo;

@Mapper(componentModel="spring")
public interface EnumOrderStatusMapper 
{
    @ValueMapping(source = "C", target = "Y")
    @ValueMapping(source = "O", target = "N")
  //  @ValueMapping(source = "X", target = MappingConstants.NULL)
    EnumYesNo toB(EnumOrderStatus a);
    
    @InheritInverseConfiguration
    EnumOrderStatus fromB(EnumYesNo n);
}