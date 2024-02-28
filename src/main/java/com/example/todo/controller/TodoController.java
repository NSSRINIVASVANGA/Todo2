package com.example.todo.controller;

import com.example.todo.service.*;
import com.example.todo.model.*;
import com.example.todo.repository.*;
import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class TodoController {
    @Autowired
    public TodoJpaService todoService;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @GetMapping("/todos/{todoId}")
    public Todo getTodoById(@PathVariable("todoId") int todoId) {
        return todoService.getTodoById(todoId);
    }

    @PutMapping("/todos/{todoId}")
    public Todo updateTodo(@PathVariable("todoId") int todoId, @RequestBody Todo todo) {
        return todoService.updateTodo(todoId, todo);
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable("todoId") int todoId) {
        todoService.deleteTodo(todoId);
    }

}