package hu.training360.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @OneToMany(mappedBy = "user")
    private List<Todo> todoList = new ArrayList<>();

    public void addTodo(Todo todo){
        if (todoList == null){
            todoList = new ArrayList<>();
        }
        todoList.add(todo);
        todo.setUser(this);
    }
}
