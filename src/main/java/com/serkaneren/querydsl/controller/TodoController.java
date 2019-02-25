package com.serkaneren.querydsl.controller;

import com.serkaneren.querydsl.dto.TodoDto;
import com.serkaneren.querydsl.model.Todo;
import com.serkaneren.querydsl.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/**
 * Todos controller
 *
 * @author eren
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoDto saveTodo(@RequestBody final TodoDto todoDto) {
        return todoService.saveTodo(todoDto);
    }

    @GetMapping
    public Page<TodoDto> searchTodo(@RequestParam(value = "startDate") final Optional<Date> startDate,
                                    @RequestParam(value = "endDate") final Optional<Date> endDate,
                                    @RequestParam(value = "active", defaultValue = "true") final boolean active,
                                    @RequestParam(value = "searchText", defaultValue = "") final String searchText,
                                    @RequestParam(value = "pageNumber", defaultValue = "0") final int pageNumber,
                                    @RequestParam(value = "pageSize", defaultValue = "100") final int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return todoService.searchTodo(startDate.orElse(null), endDate.orElse(null), active, searchText, pageable);
    }
}
