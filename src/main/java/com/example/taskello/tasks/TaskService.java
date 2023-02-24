package com.example.taskello.tasks;

import com.example.taskello.tasks.ExceptionHandlers.TaskAlreadyExists;
import com.example.taskello.tasks.ExceptionHandlers.TaskNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
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
            throw new TaskAlreadyExists("The task with task name " + task.getTask() + " already exists 😓");
        }
        return repository.save(task);
    }

    @Transactional
    public Taskello updateTodo(Long taskId, Taskello updatedTask) {
        Taskello updatableTask = repository.findById(taskId).orElseThrow(() -> new IllegalStateException("The student does not exist "));
        updatableTask.setTask(updatedTask.getTask());
        updatableTask.setDescription(updatedTask.getDescription());


        return updatedTask;
    }
public Taskello deleteTodo(Long taskid) {
    Taskello deletibleTask = repository.findById(taskid).orElseThrow(() -> new TaskNotFound("The task with the id " + taskid + " does not exist"));
    repository.deleteById(taskid);
    System.out.println("The deleted task is "+deletibleTask.getTask());
    return deletibleTask;
}

}
