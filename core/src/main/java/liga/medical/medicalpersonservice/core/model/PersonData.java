package liga.medical.medicalpersonservice.core.model;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PersonData {

    @Id
    private long id;

    private String firstName;

    private String lastName;

    private LocalDateTime birth_dt;

    private int age;

    private char sex;

    private long contact_id;

    private long medical_card_id;

    private long parent_id;

}
