package hu.training360.controller;

import hu.training360.dto.CreateUserCommand;
import hu.training360.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoListControllerIT {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testCreateUser(){
    var result = webTestClient
            .post()
            .uri("/api/users")
            .bodyValue(new CreateUserCommand("test@it.com"))
            .exchange()
            .expectStatus().isCreated()
            .expectBody(UserDto.class).value(e-> assertEquals("test@it.com",e.getUserEmail()))
            .returnResult().getResponseBody();
    }
}
