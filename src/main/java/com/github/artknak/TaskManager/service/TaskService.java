package com.github.artknak.TaskManager.service;

import com.github.artknak.TaskManager.model.TaskModel;
import com.github.artknak.TaskManager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskModel> getAll() {
        return taskRepository.findAll();
    }

    public TaskModel getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException
                        ("Task with id " + id + " not found."));
    }

    public TaskModel create(TaskModel task) {
        return taskRepository.save(task);
    }

    public TaskModel updateById(Long id, TaskModel newData) {
        TaskModel existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException
                        ("Task with id " + id + " not found."));

        existingTask.setName(newData.getName());
        existingTask.setDueDate(newData.getDueDate());
        existingTask.setResponsible(newData.getResponsible());

        return taskRepository.save(existingTask);
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }

    public void deleteById(Long id) {
        TaskModel task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException
                        ("Task with id " + id + "not found."));

        taskRepository.delete(task);
    }
}
