package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static org.example.expert.domain.todo.entity.QTodo.todo;

@Repository
@RequiredArgsConstructor
public class TodoDSLRepositoryImpl implements TodoDSLRepository{

    private final JPQLQueryFactory jpqlQueryFactory;

    @Override
    public Optional<Todo> findByTodoIdDSL(Long id) {
        return Optional.ofNullable(jpqlQueryFactory.select(todo)
                .from(todo)
                .leftJoin(todo.user)
                .where(todo.id.eq(id))
                .fetchOne());
    }
}
