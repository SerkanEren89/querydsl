package com.serkaneren.querydsl.mapper;


import com.serkaneren.querydsl.dto.TodoDto;
import com.serkaneren.querydsl.model.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    TodoDto toTodoDto(Todo todo);

    Todo toTodo(TodoDto todo);
}
