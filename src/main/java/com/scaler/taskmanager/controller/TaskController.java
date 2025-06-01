package com.scaler.taskmanager.controller;

import com.scaler.taskmanager.entities.TaskEntity;
import com.scaler.taskmanager.service.TaskService;
import com.scaler.taskmanager.DTO.CreateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks() {
        var tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTasksById(@PathVariable int id) {
        var task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) {
        try {
            var task = taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
            return ResponseEntity.ok(task);
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build(); // You can return a message if needed
        }
    }
}
