package hu.training360.controller;

import hu.training360.repository.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import java.net.URI;

@ControllerAdvice
public class TodolistExceptionHandler  implements ProblemHandling {

    @ExceptionHandler
    ResponseEntity<Problem> handleException(UserNotFoundException exception, NativeWebRequest request) {
        Problem problem =
                Problem.builder()
                        .withType(URI.create("users/user-not-found"))
                        .withTitle("Not found")
                        .withStatus(Status.NOT_FOUND)
                        .withDetail(exception.getMessage())
                        //.with("exceptionId", UUID.randomUUID().toString())
                        .build();
        return this.create(exception, problem, request);
    }
}
