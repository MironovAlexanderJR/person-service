package liga.medical.medicalpersonservice.core.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import java.util.UUID;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import liga.medical.medicalpersonservice.core.dto.SignInForm;
import liga.medical.medicalpersonservice.core.mapper.AccountMapper;
import liga.medical.medicalpersonservice.core.model.Account;
import liga.medical.medicalpersonservice.core.security.details.AccountUserDetails;
import liga.medical.medicalpersonservice.core.util.LoggingUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final LoggingUtils loggingUtils;

    public static final String TOKEN = "token";

    private final ObjectMapper objectMapper;
    private final AccountMapper accountMapper;

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager, LoggingUtils loggingUtils, ObjectMapper objectMapper, AccountMapper accountMapper) {
        super(authenticationManager);
        this.loggingUtils = loggingUtils;
        this.objectMapper = objectMapper;
        this.accountMapper = accountMapper;
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
            log.info("id: {} time: {} user id: {}",
                    loggingUtils.getLogId(),
                    loggingUtils.getLocalDateTime(),
                    account.getId());
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
        accountMapper.updateTokenByEmail(token, account.getEmail());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        objectMapper.writeValue(response.getWriter(), Collections.singletonMap(TOKEN, token));
    }
}
