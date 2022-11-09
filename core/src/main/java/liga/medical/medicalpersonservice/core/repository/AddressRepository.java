package liga.medical.medicalpersonservice.core.repository;

import liga.medical.medicalpersonservice.core.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address getAddressByContactId(long contactId);
}
