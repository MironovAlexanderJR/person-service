package liga.medical.medicalpersonservice.core.mapper;

import liga.medical.medicalpersonservice.core.model.Illness;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface IllnessMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Illness merge(@MappingTarget Illness target, Illness source);
}
