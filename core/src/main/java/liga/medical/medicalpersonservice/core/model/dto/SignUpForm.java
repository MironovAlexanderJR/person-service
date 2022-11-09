package liga.medical.medicalpersonservice.core.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {

    private String name;

    @Email
    private String email;

    @Size(min = 9)
    private String password;

}
