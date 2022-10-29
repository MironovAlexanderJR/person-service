package liga.medical.medicalpersonservice.core.model;

import java.sql.Time;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Illness {

    @Id
    private long id;

    private MedicalCard medical_card_id;

    private long type_id;

    private char heaviness;

    private Time appearance_dttm;

    private LocalDateTime recovery_dt;

}
