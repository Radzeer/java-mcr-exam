package hu.training360.controller;

import hu.training360.dto.CreateTodoCommand;
import hu.training360.dto.CreateUserCommand;
import hu.training360.dto.TodoDto;
import hu.training360.dto.UserDto;
import hu.training360.service.TodoService;
import hu.training360.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class TodolistController {

    private UserService service;

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserCommand command,
                                              UriComponentsBuilder uri) {
        var user = service.createUser(command);
        return ResponseEntity
                .created(uri.path("/api/users/{id}").buildAndExpand(user.getId()).toUri())
                .body(user);
    }

    @PostMapping("{id}/todos")
    public ResponseEntity<TodoDto> createTodo(@PathVariable("id") long userId,@Valid @RequestBody CreateTodoCommand command, UriComponentsBuilder uri){
        var todoDto = todoService.createTodo(userId,command);
        return ResponseEntity
                .created(uri.path("{id}/todos").buildAndExpand(userId).toUri())
                .body(todoDto);
    }
}
