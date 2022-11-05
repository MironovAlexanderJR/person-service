package liga.medical.medicalpersonservice.core.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import liga.medical.medicalpersonservice.core.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoggingUtils {

    private final AccountMapper accountMapper;

    private long logId;

    public long getLogId() {
        logId++;
        return logId;
    }

    public String getLocalDateTime() {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()) ;
    }

    public String getUserEmail(String token) {
        if (token.equals("anonymousUser")) {
            return "anonymous";
        }
        return String.valueOf(accountMapper.findByToken(token).get().getId());
    }
}
