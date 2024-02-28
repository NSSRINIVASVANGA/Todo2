package com.example.todo.model;

import javax.persistence.*;

@Entity
@Table(name = "todolist")
public class Todo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "todo")
    private String todo;
    @Column(name = "priority")
    private String priority;
    @Column(name = "status")
    private String status;

    public Todo() {
    }

    public Todo(int id, String todo, String priority, String status) {
        this.id = id;
        this.todo = todo;
        this.priority = priority;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTodo() {
        return todo;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}