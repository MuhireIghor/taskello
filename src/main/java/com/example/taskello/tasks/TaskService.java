package com.example.taskello.tasks;

import com.example.taskello.tasks.ExceptionHandlers.TaskAlreadyExists;
import com.example.taskello.tasks.ExceptionHandlers.TaskNotFound;
import jakarta.transaction.Transactional;
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
        Optional<Taskello> taskFound = repository.findTaskByName(task.getTask());
        if (taskFound.isPresent()) {
        throw new TaskAlreadyExists("The task with task name "+task.getTask()+" already exists 😓");
        }
        return repository.save(task);
    }
    @Transactional
    public void updateTodo(Long id,Taskello updatedTask){
        Optional<Taskello> updatableTask = repository.findById(id);
        if(updatableTask.isEmpty()){
            throw new TaskNotFound("The task with id "+ id+" is not found please verify your id ");
        }
    }
}
