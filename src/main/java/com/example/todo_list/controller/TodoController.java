package com.example.todo_list.controller;

import com.example.todo_list.dto.*;
import com.example.todo_list.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/todos")
@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse> createTodo(@RequestBody CreateTodoRequest request) {

        todoService.createTodo(request);

        CommonResponse response = new CommonResponse("투두 생성이 완료 되었습니다.");

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{todoId}")
    public ResponseEntity<CommonResponse> updateTodo(@PathVariable Long todoId, @RequestBody UpdateTodoRequest request) throws Exception {

        todoService.updateTodo(todoId, request);

        CommonResponse response = new CommonResponse("투두 수정이 완료 되었습니다.");

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{todoId}")
    public ResponseEntity<CommonResponse> deleteTodo(@PathVariable Long todoId) throws Exception {

        todoService.deleteTodo(todoId);

        CommonResponse response = new CommonResponse("투두 삭제가 완료 되었습니다.");

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/get/{todoId}")
    public ResponseEntity<GetTodoResponse> getTodo(@PathVariable Long todoId) throws Exception {

        GetTodoResponse getTodoResponse = todoService.getTodo(todoId);

        return new ResponseEntity(getTodoResponse, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<GetTodoListResponse> getTodoList() {
        GetTodoListResponse getTodoListResponse = todoService.getTodoList();

        return new ResponseEntity(getTodoListResponse, HttpStatus.OK);
    }
}
