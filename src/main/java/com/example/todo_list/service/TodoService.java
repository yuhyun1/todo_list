package com.example.todo_list.service;

import com.example.todo_list.domain.Todo;
import com.example.todo_list.dto.CreateTodoRequest;
import com.example.todo_list.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
