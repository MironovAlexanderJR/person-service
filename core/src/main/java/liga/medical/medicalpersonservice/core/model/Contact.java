package liga.medical.medicalpersonservice.core.model;


import java.math.BigInteger;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Contact {

    @Id
    private BigInteger id;

    private String phoneNumber;

    private String email;

    private String profileLink;

}