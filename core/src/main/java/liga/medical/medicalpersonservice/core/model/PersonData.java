package liga.medical.medicalpersonservice.core.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PersonData {

    @Id
    private BigInteger id;

    private String firstName;

    private String lastName;

    private LocalDateTime birthDt;

    private int age;

    private char sex;

    private Contact contactId;

    private MedicalCard medicalCardId;

    private PersonData parentId;

}
