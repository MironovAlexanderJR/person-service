package liga.medical.medicalpersonservice.core.service.impl;

import liga.medical.medicalpersonservice.core.dto.SignUpForm;
import liga.medical.medicalpersonservice.core.mapper.AccountMapper;
import liga.medical.medicalpersonservice.core.model.Account;
import liga.medical.medicalpersonservice.core.model.Role;
import liga.medical.medicalpersonservice.core.model.State;
import liga.medical.medicalpersonservice.core.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final PasswordEncoder passwordEncoder;
    private final AccountMapper accountMapper;

    @Override
    public void createAccount(SignUpForm signUpForm) {
        Account account = Account.builder()
                .name(signUpForm.getName())
                .email(signUpForm.getEmail())
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .role(Role.USER)
                .state(State.NOT_CONFIRMED)
                .build();

        accountMapper.createAccount(account);
    }

    @Override
    public void confirmationByEmail(String email) {
        String state = State.CONFIRMED.toString();
        accountMapper.confirmationByEmail(state, email);
    }

}
