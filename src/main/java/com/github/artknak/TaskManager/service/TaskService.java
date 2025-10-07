package com.github.artknak.TaskManager.service;

import com.github.artknak.TaskManager.model.TaskModel;
import com.github.artknak.TaskManager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    // List all tasks
    public List<TaskModel> get() {return taskRepository.findAll();}

    // List by id
    public TaskModel getById(Long id) {return taskRepository.findById(id).orElse(null);}

    // Create task
    public TaskModel create(TaskModel task) {return taskRepository.save(task);}

    // Update task
    public TaskModel updateById(Long id, TaskModel newData) {
        TaskModel existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found in id" + id + "."));

        existingTask.setName(newData.getName());
        existingTask.setDate(newData.getDate());
        existingTask.setResponsible(newData.getResponsible());

        return taskRepository.save(existingTask);
    }

    // Delete all tasks
    public void deleteAll() {taskRepository.deleteAll();}

    // Delete task by id
    public void delete(Long id) {taskRepository.deleteById(id);}
}
