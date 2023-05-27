package com.example.todo_list.service;

import com.example.todo_list.domain.Todo;
import com.example.todo_list.dto.CreateTodoRequest;
import com.example.todo_list.dto.GetTodoListResponse;
import com.example.todo_list.dto.GetTodoResponse;
import com.example.todo_list.dto.UpdateTodoRequest;
import com.example.todo_list.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void createTodo(CreateTodoRequest createTodoRequest) {
        Todo todo = new Todo();
        todo.setContents(createTodoRequest.getContents());
        todoRepository.save(todo);
    }

    public void updateTodo(Long todoId, UpdateTodoRequest request) throws Exception {

        Optional<Todo> findTodo = todoRepository.findById(todoId);

        if (findTodo.isEmpty()) {
            throw new Exception("해당 아이디 값을 가진 유저가 없습니다. 아이디를 다시 한번 확인하세요.");
        }

        Todo todo = findTodo.get();

        todo.setContents(request.getContents());
    }

    public void deleteTodo(Long todoId) throws Exception {
        Optional<Todo> deleteTodo = todoRepository.findById(todoId);

        if (deleteTodo.isEmpty()) {
            throw new Exception("해당 아이디 값을 가진 유저가 없습니다. 아이디를 다시 한번 확인하세요.");
        }

        todoRepository.deleteById(todoId);
    }

    public GetTodoResponse getTodo(Long todoId) throws Exception {
        Optional<Todo> getTodo = todoRepository.findById(todoId);

        if (getTodo.isEmpty()) {
            throw new Exception("해당 아이디 값을 가진 유저가 없습니다. 아이디를 다시 한번 확인하세요.");
        }

        Todo todo = getTodo.get();

        GetTodoResponse getTodoResponse = new GetTodoResponse();
        getTodoResponse.setContents(todo.getContents());

        return getTodoResponse;
    }

    public GetTodoListResponse getTodoList() {

        List<Todo> contents = todoRepository.findAll();

        GetTodoListResponse getTodoListResponse = new GetTodoListResponse();

        getTodoListResponse.setContents(contents);

        return getTodoListResponse;
    }
}
