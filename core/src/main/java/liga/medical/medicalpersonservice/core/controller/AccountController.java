package liga.medical.medicalpersonservice.core.controller;

import javax.validation.Valid;
import liga.medical.medicalpersonservice.core.dto.SignUpForm;
import liga.medical.medicalpersonservice.core.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class AccountController {

    private final AccountServiceImpl accountService;

    @PostMapping("/signUp")
    public String signUp(@Valid @RequestBody SignUpForm signUpForm) {
        accountService.createAccount(signUpForm);
        return "account created";
    }

    @PostMapping("/confirmation/{email}")
    public String accountConfirmationByEmail(@PathVariable String email) {
        accountService.confirmationByEmail(email);
        return "аккаунт подтвержден";
    }
}
