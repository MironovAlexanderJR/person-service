package liga.medical.medicalpersonservice.core.mapper;

import liga.medical.medicalpersonservice.core.model.PersonData;
import liga.medical.medicalpersonservice.core.model.Signal;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface SignalMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Signal merge(@MappingTarget Signal target, Signal source);
}
