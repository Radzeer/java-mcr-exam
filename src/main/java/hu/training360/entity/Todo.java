package hu.training360.entity;

import hu.training360.enums.Importance;
import hu.training360.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate deadline;

    private Importance importance;

    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
