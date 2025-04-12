package com.artmac.tasktracker.dto;

import com.artmac.tasktracker.entity.Status;

import jakarta.validation.constraints.NotBlank;

public class TaskDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private Status status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}