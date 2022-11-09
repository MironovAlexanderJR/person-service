package liga.medical.medicalpersonservice.core.model;

import java.sql.Time;
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
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCardId;

    private long typeId;

    private char heaviness;

    private Time appearanceDttm;

    private LocalDateTime recoveryDt;

}
