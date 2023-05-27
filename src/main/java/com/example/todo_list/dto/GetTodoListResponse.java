package com.example.todo_list.dto;

import com.example.todo_list.domain.Todo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetTodoListResponse {

    private List<Todo> contents;
}
