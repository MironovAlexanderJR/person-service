package liga.medical.medicalpersonservice.core.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class PersonData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private LocalDateTime birthDt;

    private int age;

    private char sex;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contactId;

    @OneToOne
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCardId;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private PersonData parent_id;

}
