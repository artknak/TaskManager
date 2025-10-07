package com.github.artknak.TaskManager.repository;

import com.github.artknak.TaskManager.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
