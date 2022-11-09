package liga.medical.medicalpersonservice.core.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.medicalpersonservice.core.model.Role;
import liga.medical.medicalpersonservice.core.security.filters.TokenAuthenticationFilter;
import liga.medical.medicalpersonservice.core.security.filters.TokenAuthorizationFilter;
import liga.medical.medicalpersonservice.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    public static final String API = "/api";
    public static final String LOGIN_FILTER_PROCESSES_URL = API + "/login";
    private static final String ADDRESS_API = API + "/addresses";
    private static final String CONTACT_API = API + "/contacts";
    private static final String ILLNESSES_API = API + "/illnesses";
    private static final String MEDICAL_CARD_API = API + "/medical-cards";
    private static final String PERSON_DATA_API = API + "/person-dates";
    private static final String SIGNAL_API = API + "/signals";
    private static final String ADMIN = Role.ADMIN.toString();
    private static final String USER = Role.USER.toString();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserDetailsService accountUserDetailsService;

    @Autowired
    private AccountService accountService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        TokenAuthenticationFilter tokenAuthenticationFilter = new TokenAuthenticationFilter(authenticationManager(),
                objectMapper, accountService);
        tokenAuthenticationFilter.setFilterProcessesUrl(LOGIN_FILTER_PROCESSES_URL);

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(tokenAuthenticationFilter);
        http.addFilterBefore(new TokenAuthorizationFilter(objectMapper, accountService),
                UsernamePasswordAuthenticationFilter.class);
        
        http.authorizeRequests()
                .antMatchers("/api/login/**").permitAll()
                .antMatchers("api/signUp/**").permitAll()
                .antMatchers(HttpMethod.GET, ADDRESS_API).hasAuthority(USER)
                .antMatchers(HttpMethod.GET, CONTACT_API).hasAuthority(USER)
                .antMatchers(HttpMethod.GET, ILLNESSES_API).hasAuthority(USER)
                .antMatchers(HttpMethod.GET, MEDICAL_CARD_API).hasAuthority(USER)
                .antMatchers(HttpMethod.GET, PERSON_DATA_API).hasAuthority(USER)
                .antMatchers(HttpMethod.GET, ILLNESSES_API).hasAuthority(USER)
                .antMatchers(HttpMethod.GET, SIGNAL_API).hasAuthority(USER)
                .antMatchers(HttpMethod.POST, ADDRESS_API).hasAuthority(ADMIN)
                .antMatchers("/actuator/**").hasAuthority(ADMIN);

    }
}
