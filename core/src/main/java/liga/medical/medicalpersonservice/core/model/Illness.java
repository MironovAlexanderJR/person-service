package liga.medical.medicalpersonservice.core.model;

import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Illness {

    @Id
    private BigInteger id;

    private MedicalCard medicalCardId;

    private BigInteger typeId;

    private char heaviness;

    private Time appearanceDttm;

    private LocalDateTime recoveryDt;

}
