package com.example.todo.service;

import java.util.*;
import com.example.todo.model.*;
import com.example.todo.repository.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TodoJpaService implements TodoRepository {
    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @Override
    public ArrayList<Todo> getTodos() {
        List<Todo> todoList = todoJpaRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>(todoList);
        return todos;
    }

    @Override
    public Todo addTodo(Todo todo) {
        todoJpaRepository.save(todo);
        return todo;
    }

    @Override
    public Todo getTodoById(int todoId) {
        try {
            Todo todo = todoJpaRepository.findById(todoId).get();
            return todo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo updateTodo(int todoId, Todo todo) {
        try {
            Todo newTodo = todoJpaRepository.findById(todoId).get();
            if (todo.getTodo() != null) {
                newTodo.setTodo(todo.getTodo());
            }
            if ((todo.getPriority() != null) && ((todo.getPriority().equalsIgnoreCase("HIGH"))
                    || (todo.getPriority().equalsIgnoreCase("MEDIUM")) || (todo.getPriority().equalsIgnoreCase("LOW")))) {
                newTodo.setPriority(todo.getPriority());
            }
            if ((todo.getStatus() != null) && ((todo.getStatus().equalsIgnoreCase("TO DO"))
                    || (todo.getStatus().equalsIgnoreCase("IN PROGRESS")) || (todo.getStatus().equalsIgnoreCase("DONE")))) {
                newTodo.setStatus(todo.getStatus());
            }
            todoJpaRepository.save(newTodo);
            return newTodo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int todoId) {
        try {
            todoJpaRepository.deleteById(todoId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}