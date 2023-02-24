package com.example.taskello.tasks;

import com.example.taskello.tasks.ExceptionHandlers.TaskAlreadyExists;
import com.example.taskello.tasks.ExceptionHandlers.TaskNotFound;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.List.*;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public final TaskService taskService;

    @GetMapping
    public List<Taskello> getTasks() {
        return of(
                new Taskello("Test", "Testing the get controller", LocalDate.of(2022, Month.APRIL, 12), LocalDate.of(2022, Month.APRIL, 12), false, true)
        );
    }

    @PostMapping
    public ResponseEntity addTodo(@Valid @RequestBody Taskello task) {
        try {
            return new ResponseEntity<>(taskService.addTodo(task), HttpStatus.CREATED);
        } catch (TaskAlreadyExists ex1) {
            System.out.println("message is " + ex1.getMessage());
            return new ResponseEntity(ex1.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity updateTask(@PathVariable Long taskId, @RequestBody Taskello task) {
        try {
            return new ResponseEntity(taskService.updateTodo(taskId, task), HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("the error is "+ex.getMessage());
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping(path="/{taskId}")
    public ResponseEntity deleteTask(@PathVariable Long taskId){
        try{
            return new ResponseEntity(taskService.deleteTodo(taskId),HttpStatus.NO_CONTENT);

        }
        catch (TaskNotFound ex2){
            System.out.println("The error is "+ex2.getMessage());
            return new ResponseEntity(ex2.getMessage(),HttpStatus.CONFLICT);
        }
    }

}
