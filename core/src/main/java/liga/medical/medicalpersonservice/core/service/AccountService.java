package liga.medical.medicalpersonservice.core.service;

import liga.medical.medicalpersonservice.core.dto.SignUpForm;
import liga.medical.medicalpersonservice.core.model.Account;

public interface AccountService {

    void createAccount(SignUpForm signUpForm);

    void confirmationByEmail(String email);

}
