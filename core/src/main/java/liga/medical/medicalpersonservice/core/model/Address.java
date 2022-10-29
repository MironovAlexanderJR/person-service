package liga.medical.medicalpersonservice.core.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {

    @Id
    private long id;

    private long contact_id;

    private long country_id;

    private String city;

    private int index;

    private String street;

    private String building;

    private String flat;

}