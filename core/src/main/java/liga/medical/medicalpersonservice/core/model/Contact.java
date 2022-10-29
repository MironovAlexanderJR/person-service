package liga.medical.medicalpersonservice.core.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Contact {

    @Id
    private long id;

    private String phone_number;

    private String email;

    private String profile_link;

}