package com.github.artknak.TaskManager.controller;

import com.github.artknak.TaskManager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    public final TaskService taskService;

}
