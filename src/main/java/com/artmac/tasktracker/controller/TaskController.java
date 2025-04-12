package com.artmac.tasktracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artmac.tasktracker.dto.TaskDTO;
import com.artmac.tasktracker.entity.Status;
import com.artmac.tasktracker.entity.Task;
import com.artmac.tasktracker.service.TaskService;


@RestController
@RequestMapping("/tasks")
public class TaskController {

	
	@Autowired
	TaskService taskService;
	
	@PostMapping("/addTask")
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		Task newTask= taskService.createTask(task);
		return new ResponseEntity<Task>(newTask, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks(){
		List<Task> tasks = taskService.getAllTasks();
	    return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskDTO dto) {
	    Optional<Task> optionalTask = taskService.updateTask(id, dto);
	    
	    if (optionalTask.isPresent()) {
	        return new ResponseEntity<Task>(optionalTask.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
	    taskService.deleteTask(id);
	    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable Status status) {
	    List<Task> tasks = taskService.getTasksByStatus(status);
	    return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}
}
