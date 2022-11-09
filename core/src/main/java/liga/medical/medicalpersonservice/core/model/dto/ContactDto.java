package liga.medical.medicalpersonservice.core.model.dto;

import lombok.Data;

@Data
public class ContactDto {
    private Long id;

    private String phoneNumber;

    private String email;

    private String profileLink;
}
