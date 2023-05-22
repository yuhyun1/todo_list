package com.example.todo_list.controller;

import com.example.todo_list.dto.CommonResponse;
import com.example.todo_list.dto.CreateTodoRequest;
import com.example.todo_list.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/todos")
@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse> createTodo(@Valid @RequestBody CreateTodoRequest request) {

        todoService.createTodo(request);

        CommonResponse response = new CommonResponse("투두 생성이 완료 되었습니다.");

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
