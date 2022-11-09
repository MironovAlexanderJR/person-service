package liga.medical.medicalpersonservice.core.repository;

import liga.medical.medicalpersonservice.core.model.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDataRepository extends JpaRepository<PersonData, Long> {

    boolean existsById(long id);
}
