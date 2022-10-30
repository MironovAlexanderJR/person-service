package liga.medical.medicalpersonservice.core.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Account {

    @Id
    private long id;

    private Role role;

    private State state;

    private String name;

    private String email;
    private String password;

    private String token;
}
