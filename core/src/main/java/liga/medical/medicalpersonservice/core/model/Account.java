package liga.medical.medicalpersonservice.core.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(STRING)
    private Role role;

    @Enumerated(STRING)
    private State state;

    private String name;

    private String email;
    private String password;

    private String token;
}
