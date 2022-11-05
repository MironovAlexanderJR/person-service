package liga.medical.medicalpersonservice.core.controller;

import io.swagger.annotations.Api;
import javax.validation.Valid;
import liga.medical.medicalpersonservice.core.dto.SignUpForm;
import liga.medical.medicalpersonservice.core.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "API для регистрации аккаунтов")
public class SignInController {

    private final AccountService accountService;

    @PostMapping("/signUp")
    public String signUp(@Valid @RequestBody SignUpForm signUpForm) {
        accountService.createAccount(signUpForm);
        return "account created";
    }
}
