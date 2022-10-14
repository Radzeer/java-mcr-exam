package hu.training360.dto;

import hu.training360.enums.Importance;
import hu.training360.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TodoDto {

    private Long id;

    private String description;

    private LocalDate deadline;

    private Importance importance;

    private Status status;

}
