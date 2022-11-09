package liga.medical.medicalpersonservice.core.service;

import java.util.Optional;
import liga.medical.medicalpersonservice.core.model.dto.SignUpForm;
import liga.medical.medicalpersonservice.core.model.Account;

public interface AccountService {

    void createAccount(SignUpForm signUpForm);

    void updateTokenByEmail(String token, String email);

    Optional<Account> findByToken(String token);
}
