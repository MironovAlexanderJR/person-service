package liga.medical.medicalpersonservice.core.model;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class MedicalCard {

    @Id
    private long id;

    private char client_status;

    private char med_status;

    private LocalDateTime registry_dt;

    private String comment;

}
