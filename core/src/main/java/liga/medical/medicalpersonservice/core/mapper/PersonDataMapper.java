package liga.medical.medicalpersonservice.core.mapper;

import liga.medical.medicalpersonservice.core.model.PersonData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface PersonDataMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    PersonData merge(@MappingTarget PersonData target, PersonData source);
}
