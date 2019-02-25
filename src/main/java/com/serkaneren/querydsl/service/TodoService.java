package com.serkaneren.querydsl.service;

import com.serkaneren.querydsl.dto.TodoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * Todos service
 *
 * @author eren
 */
public interface TodoService {

    /**
     * Search in todos repository
     *
     * @param startDate start date
     * @param endDate   end date
     * @param status    status
     * @param text      text
     * @param pageable  pageable
     * @return page of todos
     */
    Page<TodoDto> searchTodo(Date startDate, Date endDate, boolean status, String text, Pageable pageable);

    /**
     * Save todos
     * @param todoDto todoDto
     * @return save todoDto
     */
    TodoDto saveTodo(TodoDto todoDto);
}
