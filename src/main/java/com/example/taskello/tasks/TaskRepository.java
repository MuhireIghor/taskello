package com.example.taskello.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Taskello, Long> {
    @Query("SELECT  t from Task t where t.task = ?1")
    Optional<Taskello> findTaskByName(String taskName);
}
