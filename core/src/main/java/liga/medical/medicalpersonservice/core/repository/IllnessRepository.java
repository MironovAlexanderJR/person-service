package liga.medical.medicalpersonservice.core.repository;

import liga.medical.medicalpersonservice.core.model.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepository extends JpaRepository<Illness, Long> {
}
