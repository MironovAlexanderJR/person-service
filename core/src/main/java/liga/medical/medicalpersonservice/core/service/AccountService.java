package liga.medical.medicalpersonservice.core.service;

import liga.medical.medicalpersonservice.core.dto.SignUpForm;

public interface AccountService {

    void createAccount(SignUpForm signUpForm);

    void confirmationByEmail(String email);
}
