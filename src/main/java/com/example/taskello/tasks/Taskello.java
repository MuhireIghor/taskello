package com.example.taskello.tasks;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity(name = "Task")
@Table(name = "task")
public class Taskello {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"

    )
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )

    private Long id;
    @Column(
            name = "task",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @Size(
            min = 3,
            message = "A task name should be at least 3 characters long"

    )



    private String task;
    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )


    private String description;
    @Column(
            name = "startDate",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private LocalDate startDate;
    @Column(
            name = "endDate",
            nullable = false,
            columnDefinition = "TEXT"
    )

    private LocalDate endDate;
    @Column(
            name = "completed",
            nullable = false,
            columnDefinition = "BOOLEAN",
            length = 40
    )

    private Boolean completed;
    @Column(
            name="setReminder",
            nullable = false,
            columnDefinition = "BOOLEAN"
    )
    private Boolean setReminder;

    public Taskello(String task, String description, LocalDate startDate, LocalDate endDate, Boolean completed, Boolean setReminder) {
        this.task = task;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.completed = completed;
        this.setReminder = setReminder;
    }

    public Taskello() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean getSetReminder() {
        return setReminder;
    }

    public void setSetReminder(Boolean setReminder) {
        this.setReminder = setReminder;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", completed=" + completed +
                ", setReminder=" + setReminder +
                '}';
    }
}
