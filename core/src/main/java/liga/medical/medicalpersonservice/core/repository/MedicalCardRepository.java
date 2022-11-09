package liga.medical.medicalpersonservice.core.repository;

import liga.medical.medicalpersonservice.core.model.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCardRepository extends JpaRepository<MedicalCard, Long> {
}
