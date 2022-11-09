package liga.medical.medicalpersonservice.core.service.impl;

import java.util.Optional;
import javax.transaction.Transactional;
import liga.medical.medicalpersonservice.core.model.dto.SignUpForm;
import liga.medical.medicalpersonservice.core.model.Account;
import liga.medical.medicalpersonservice.core.model.Role;
import liga.medical.medicalpersonservice.core.model.State;
import liga.medical.medicalpersonservice.core.repository.AccountRepository;
import liga.medical.medicalpersonservice.core.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public void createAccount(SignUpForm signUpForm) {

        Account account = new Account();
        account.setName(signUpForm.getName());
        account.setEmail(signUpForm.getEmail());
        account.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
        account.setRole(Role.USER);
        account.setState(State.CONFIRMED);

        accountRepository.save(account);
    }

    @Override
    @Transactional
    public void updateTokenByEmail(String token, String email) {
        Account account = accountRepository.getByEmail(email);
        Account secondAccount = accountRepository.getById(account.getId());
        secondAccount.setToken(token);
        accountRepository.save(secondAccount);
    }

    @Override
    public Optional<Account> findByToken(String token) {
        return accountRepository.findByToken(token);
    }

}
