package hu.training360.service;

import hu.training360.dto.CreateTodoCommand;
import hu.training360.dto.TodoDto;
import hu.training360.enums.Status;
import hu.training360.repository.TodoRepository;
import hu.training360.repository.UserNotFoundException;
import hu.training360.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoService {

    private TodoRepository todoRepository;

    private UserRepository userRepository;

    private TodoMapper todoMapper;

    public TodoDto createTodo(Long userId,CreateTodoCommand command){
        var user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found with id: " + userId));

        var todo = todoMapper.toEntity(command);
        todo.setStatus(Status.NOT_STARTED);
        todo.setUser(user);
        todoRepository.save(todo);
        return todoMapper.toDto(todo);
    }

}
