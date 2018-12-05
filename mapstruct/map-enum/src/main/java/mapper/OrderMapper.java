package mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import entity.a.OrderA;
import entity.b.OrderB;

@Mapper(componentModel = "spring", uses = { 
		EnumOrderStatusMapper.class })
public interface OrderMapper {
	@Mappings({ @Mapping(source = "status", target = "closed") })
	public OrderB toB(OrderA orderA);

	@InheritInverseConfiguration
	public OrderA fromB(OrderB orderB);
}
