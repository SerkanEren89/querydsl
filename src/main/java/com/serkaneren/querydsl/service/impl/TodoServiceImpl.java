package com.serkaneren.querydsl.service.impl;

import com.serkaneren.querydsl.dto.TodoDto;
import com.serkaneren.querydsl.mapper.TodoMapper;
import com.serkaneren.querydsl.model.Todo;
import com.serkaneren.querydsl.repository.TodoRepository;
import com.serkaneren.querydsl.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Todos service implementation
 *
 * @author eren
 */
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoServiceImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    /**
     * {@inheritDoc}
     */
    public Page<TodoDto> searchTodo(Date startDate, Date endDate, boolean status, String text, Pageable pageable) {
        return todoRepository.searchTodo(startDate, endDate, status, text, pageable).map(todoMapper::toTodoDto);
    }

    public TodoDto saveTodo(TodoDto todoDto) {
        Todo todo = todoMapper.toTodo(todoDto);
        todo.setUuid(UUID.randomUUID());
        return todoMapper.toTodoDto(todoRepository.save(todo));
    }
}
