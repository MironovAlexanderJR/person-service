package liga.medical.medicalpersonservice.core.repository;

import java.util.Optional;
import liga.medical.medicalpersonservice.core.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByToken(String token);

    Optional<Account> findByEmail(String email);

    Account getByEmail(String email);

}
