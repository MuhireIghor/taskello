package com.example.taskello.tasks.ExceptionHandlers;

public class TaskNotFound extends  RuntimeException {
    private String message;
    public TaskNotFound(String message){
        this.message = message;
    }
    public TaskNotFound(){

    }
}
