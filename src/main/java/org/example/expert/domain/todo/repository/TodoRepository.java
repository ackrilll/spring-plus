package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoDSLRepository {

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u ORDER BY t.modifiedAt DESC")
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u WHERE t.weather = :weather ORDER BY t.modifiedAt DESC")
    Page<Todo> findByWeatherOrderByModifiedAtDesc(Pageable pageable, @Param("weather") String weather);

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u WHERE t.modifiedAt between :startDate AND :endDate ORDER BY t.modifiedAt DESC")
    Page<Todo> findByPeriodOrderByModifiedAtDesc(Pageable pageable,
                                                 @Param("startDate") LocalDateTime startDate,
                                                 @Param("endDate") LocalDateTime endDate);

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u WHERE t.weather = :weather AND t.modifiedAt between :startDate AND :endDate ORDER BY t.modifiedAt DESC")
    Page<Todo> findByWeatherAndPeriodOrderByModifiedAtDesc(Pageable pageable,
                                                           @Param("weather") String weather,
                                                           @Param("startDate") LocalDateTime startDate,
                                                           @Param("endDate") LocalDateTime endDate);

    @Query("SELECT t FROM Todo t " +
            "LEFT JOIN t.user " +
            "WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);
}
