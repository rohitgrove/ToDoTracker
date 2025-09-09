package com.ToDoTracker.ToDoTracker.entity;

import java.time.LocalDate;

public class Task {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDate localDate;

    public Task(Long id, String title, String description, String status, LocalDate localDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.localDate = localDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
