package com.artmac.tasktracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.artmac.tasktracker.dto.TaskDTO;
import com.artmac.tasktracker.entity.Status;
import com.artmac.tasktracker.entity.Task;

@Service
public interface TaskService {

	public Task createTask(Task task);
	public List<Task> getAllTasks();
	public Optional<Task> updateTask(Long id, TaskDTO dto);
	public void deleteTask(Long id);
	public List<Task> getTasksByStatus(Status status);
}
