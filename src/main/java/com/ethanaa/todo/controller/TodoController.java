package com.ethanaa.todo.controller;

import com.ethanaa.todo.model.Todo;
import com.ethanaa.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {

        this.todoService = todoService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<Long> create(@RequestBody Todo todo) {

        Todo newTodo = todoService.create(todo);

        return new ResponseEntity<>(newTodo.getId(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {

        Todo todo = todoService.get(id);

        if (todo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(todo);
    }
}