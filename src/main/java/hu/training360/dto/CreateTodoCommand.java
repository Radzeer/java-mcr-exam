package hu.training360.dto;

import hu.training360.enums.Importance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoCommand {


    @NotEmpty
    private String description;

    @Future
    private LocalDate deadline;

    private Importance importance;
}
