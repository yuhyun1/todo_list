package com.example.todo_list.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateTodoRequest {

    @NotNull
    private String contents;
}
