package liga.medical.medicalpersonservice.core.service.impl;

import java.util.List;
import java.util.Optional;
import liga.medical.medicalpersonservice.core.mapper.MedicalCardMapper;
import liga.medical.medicalpersonservice.core.mapper.PersonDataMapper;
import liga.medical.medicalpersonservice.core.model.PersonData;
import liga.medical.medicalpersonservice.core.repository.MedicalCardRepository;
import liga.medical.medicalpersonservice.core.repository.PersonDataRepository;
import liga.medical.medicalpersonservice.core.service.PersonDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonDataServiceImpl implements PersonDataService {

    private final PersonDataRepository personDataRepository;
    private final PersonDataMapper personDataMapper;

    @Override
    public List<PersonData> getAllPersonDates() {
        return personDataRepository.findAll();
    }

    @Override
    public PersonData getById(Long id) {
        return personDataRepository.findById(id).get();
    }

    @Override
    public void updatePersonDates(Long id, PersonData personData) {
        Optional.of(id)
                .map(this::getById)
                .map(current -> personDataMapper.merge(current, personData))
                .map(personDataRepository::save)
                .orElseThrow();
    }
}
