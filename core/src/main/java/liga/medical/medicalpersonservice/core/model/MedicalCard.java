package liga.medical.medicalpersonservice.core.model;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class MedicalCard {

    @Id
    private MedicalCard id;

    private char clientStatus;

    private char medStatus;

    private LocalDateTime registryDt;

    private String comment;

}
