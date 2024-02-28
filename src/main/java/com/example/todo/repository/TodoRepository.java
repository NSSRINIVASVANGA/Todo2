package com.example.todo.repository;

import com.example.todo.model.*;
import java.util.*;

public interface TodoRepository {
    ArrayList<Todo> getTodos();

    Todo addTodo(Todo todo);

    Todo getTodoById(int totId);

    Todo updateTodo(int todoId, Todo todo);

    void deleteTodo(int todoId);
}