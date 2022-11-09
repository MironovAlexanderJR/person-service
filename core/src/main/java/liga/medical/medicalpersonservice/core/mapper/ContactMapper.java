package liga.medical.medicalpersonservice.core.mapper;

import liga.medical.medicalpersonservice.core.model.Contact;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface ContactMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Contact merge(@MappingTarget Contact target, Contact source);

}
