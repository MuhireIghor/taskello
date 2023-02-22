package com.example.taskello.tasks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.List.*;

@RestController
@RequestMapping(path="/api/v1/students")
public class TaskController {
    @GetMapping
    public List<Task> getTasks(){
        return of(
                new Task("Test","Testing the get controller", LocalDate.of(2022, Month.APRIL,12), LocalDate.of(2022, Month.APRIL,12),false,true)
        );
    }

}
