package hu.training360.dto;

import hu.training360.validator.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidEmail
public class CreateUserCommand {

    private String email;
}
