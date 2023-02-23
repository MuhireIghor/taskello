package com.example.taskello.tasks;

import com.example.taskello.tasks.ExceptionHandlers.TaskAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    public final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Taskello addTodo(Taskello task) {
        Optional<Taskello> taskExist = repository.findById(task.getId());
        if (taskExist.isPresent()) {
        throw new TaskAlreadyExists();
        }
        return repository.save(task);
    }
}
