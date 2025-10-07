package com.github.artknak.TaskManager.controller;

import com.github.artknak.TaskManager.dto.ApiResponse;
import com.github.artknak.TaskManager.model.TaskModel;
import com.github.artknak.TaskManager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    public final TaskService taskService;

    // Get all tasks
    @GetMapping
    public ResponseEntity<ApiResponse<List<TaskModel>>> getAll() {
        List<TaskModel> tasks = taskService.getAll();
        return ResponseEntity.ok(
                new ApiResponse<>("Tasks retrieved successfully.", tasks));
    }

    // Get task by id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskModel>> getById(@PathVariable Long id) {
        try {
            TaskModel task = taskService.getById(id);
            return ResponseEntity.ok(
                    new ApiResponse<>("Task retrieved successfully.", task));

        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(
                    new ApiResponse<>(e.getMessage(), null));
        }
    }

    // Create task
    @PostMapping
    public ResponseEntity<ApiResponse<TaskModel>> create(@RequestBody TaskModel task) {
        TaskModel created = taskService.create(task);
        return ResponseEntity.status(201).body(
                new ApiResponse<>("Task created.", created));
    }

    // Update task
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskModel>> updateById(@PathVariable Long id,
                                                             @RequestBody TaskModel task) {
        try {
            TaskModel updated = taskService.updateById(id, task);
            return ResponseEntity.ok(
                    new ApiResponse<>("Task updated successfully.", updated));

        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(
                    new ApiResponse<>(e.getMessage(), null));
        }
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<Void>> deleteAll() {
        taskService.deleteAll();
        return ResponseEntity.ok(
                new ApiResponse<>("All tasks deleted.", null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable Long id) {
        try {
            taskService.deleteById(id);
            return ResponseEntity.ok(
                    new ApiResponse<>("Task deleted successfully.", null));

        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(
                    new ApiResponse<>(e.getMessage(), null));
        }
    }

}
