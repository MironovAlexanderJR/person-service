package liga.medical.medicalpersonservice.core.mapper;

import liga.medical.medicalpersonservice.core.model.Address;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface AddressMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Address merge(@MappingTarget Address target, Address source);
}
