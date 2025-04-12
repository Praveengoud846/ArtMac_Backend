package com.artmac.tasktracker.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artmac.tasktracker.dto.TaskDTO;
import com.artmac.tasktracker.entity.Status;
import com.artmac.tasktracker.entity.Task;
import com.artmac.tasktracker.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public Task createTask(Task task) {
		task.setCreatedDate(LocalDateTime.now());
		 return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Optional<Task> updateTask(Long id, TaskDTO dto) {
		Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();

            if (dto.getTitle() != null) {
                task.setTitle(dto.getTitle());
            }

            if (dto.getStatus() != null) {
                task.setStatus(dto.getStatus());
            }

            Task updatedTask = taskRepository.save(task);
            return Optional.of(updatedTask);
        } else {
            return Optional.empty();
        }
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	@Override
	public List<Task> getTasksByStatus(Status status) {
		return taskRepository.findByStatus(status);
	}

}
