package hu.training360.service;

import hu.training360.dto.CreateTodoCommand;
import hu.training360.dto.CreateUserCommand;
import hu.training360.dto.TodoDto;
import hu.training360.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TodoMapper {

    List<TodoDto> toDto(List<Todo> todos);

    TodoDto toDto(Todo todo);

    Todo toEntity(CreateTodoCommand command);



}
