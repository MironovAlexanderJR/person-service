package liga.medical.medicalpersonservice.core.service;

import java.util.List;
import liga.medical.medicalpersonservice.core.model.PersonData;

public interface PersonDataService {
    List<PersonData> getAllPersonDates();

    PersonData getById(Long id);

    void updatePersonDates(Long id, PersonData personData);
}
