package liga.medical.medicalpersonservice.core.mapper;

import liga.medical.medicalpersonservice.core.model.MedicalCard;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface MedicalCardMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    MedicalCard merge(@MappingTarget MedicalCard target, MedicalCard source);
}
