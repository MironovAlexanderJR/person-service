package liga.medical.medicalpersonservice.core.model;

import java.math.BigInteger;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {

    @Id
    private BigInteger id;

    private Contact contactId;

    private BigInteger countryId;

    private String city;

    private Integer index;

    private String street;

    private String building;

    private String flat;

}