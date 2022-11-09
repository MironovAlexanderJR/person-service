package liga.medical.medicalpersonservice.core.repository;

import liga.medical.medicalpersonservice.core.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
