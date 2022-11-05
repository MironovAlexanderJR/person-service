package liga.medical.medicalpersonservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.medicalpersonservice.core.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "API для работы с аккаунтами")
public class AccountController {

    private final AccountService accountService;

    @ApiOperation(value = "подтверждение аккаунта по email")
    @PostMapping("/confirmation/{email}")
    public String accountConfirmationByEmail(@PathVariable String email) {
        accountService.confirmationByEmail(email);
        return "аккаунт подтвержден";
    }
}
