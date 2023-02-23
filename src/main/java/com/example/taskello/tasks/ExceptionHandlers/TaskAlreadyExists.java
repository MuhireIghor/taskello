package com.example.taskello.tasks.ExceptionHandlers;

public class TaskAlreadyExists extends RuntimeException {
    private String message;
    public TaskAlreadyExists(String message){
        super(message);
        this.message = message;
    }
    public TaskAlreadyExists(){
    }
}
