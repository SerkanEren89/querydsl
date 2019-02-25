package com.serkaneren.querydsl.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.serkaneren.querydsl.model.QTodo;
import com.serkaneren.querydsl.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Todos repository
 *
 * @author eren
 */
public interface TodoRepository extends JpaRepository<Todo, Long>, QuerydslPredicateExecutor<Todo> {

    default Page<Todo> searchTodo(Date startDate, Date endDate, boolean status, String text, Pageable pageable) {
        QTodo todo = QTodo.todo;

        BooleanExpression whereClause = todo.id.isNotNull();
        if (startDate != null) {
            whereClause = whereClause.and(todo.startDate.goe(startDate));
        }
        if (endDate != null) {
            whereClause = whereClause.and(todo.endDate.loe(endDate));
        }
        if (!StringUtils.isEmpty(text)) {
            whereClause = whereClause.andAnyOf(todo.note.like(text), todo.title.like(text));
        }
        whereClause = whereClause.and(todo.active.eq(status));

        return findAll(whereClause, pageable);
    }

}
