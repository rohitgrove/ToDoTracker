package com.ToDoTracker.ToDoTracker.controller;

import com.ToDoTracker.ToDoTracker.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private HashMap<Long, Task> tasksDB = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<Task>> getAllTaks() {
        return ResponseEntity.ok(new ArrayList<>(tasksDB.values()));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        tasksDB.put(task.getId(), task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getBookId(@PathVariable Long id) {
        Task task = tasksDB.get(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updatePrice(@PathVariable Long id, @RequestBody String newStatus) {
        Task existing = tasksDB.get(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        existing.setStatus(newStatus);
        tasksDB.put(id, existing);
        return ResponseEntity.ok(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> updatePrice(@PathVariable Long id) {
        Task existing = tasksDB.remove(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.noContent().build();
    }
}
