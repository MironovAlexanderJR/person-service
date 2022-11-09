package liga.medical.medicalpersonservice.core.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import java.util.UUID;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import liga.medical.medicalpersonservice.core.model.Account;
import liga.medical.medicalpersonservice.core.model.dto.SignInForm;
import liga.medical.medicalpersonservice.core.security.details.AccountUserDetails;
import liga.medical.medicalpersonservice.core.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String TOKEN = "token";

    private final ObjectMapper objectMapper;
    private final AccountService accountService;

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager, ObjectMapper objectMapper, AccountService accountService) {
        super(authenticationManager);
        this.objectMapper = objectMapper;
        this.accountService = accountService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            SignInForm form = objectMapper.readValue(request.getReader(), SignInForm.class);

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(form.getEmail(),
                    form.getPassword());

            Authentication authentication = super.getAuthenticationManager().authenticate(token);
            AccountUserDetails accountUserDetails = (AccountUserDetails) authentication.getPrincipal();
            Account account = accountUserDetails.getAccount();
            return authentication;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        AccountUserDetails userDetails = (AccountUserDetails) authResult.getPrincipal();
        Account account = userDetails.getAccount();
        String token = UUID.randomUUID().toString();
        accountService.updateTokenByEmail(token, account.getEmail());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        objectMapper.writeValue(response.getWriter(), Collections.singletonMap(TOKEN, token));
    }
}
