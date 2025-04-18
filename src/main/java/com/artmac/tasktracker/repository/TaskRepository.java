package com.artmac.tasktracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artmac.tasktracker.entity.Status;
import com.artmac.tasktracker.entity.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	
	List<Task> findByStatus(Status status);

}

