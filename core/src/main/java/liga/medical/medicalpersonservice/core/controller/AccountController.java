package liga.medical.medicalpersonservice.core.controller;

import liga.medical.medicalpersonservice.core.model.Account;
import liga.medical.medicalpersonservice.core.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/confirmation/{email}")
    public String accountConfirmationByEmail(@PathVariable String email) {
        accountService.confirmationByEmail(email);
        return "аккаунт подтвержден";
    }
}
